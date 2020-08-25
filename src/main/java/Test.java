import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.tools.javac.util.StringUtils;

import java.io.File;
import java.math.BigDecimal;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String responseStr = getJsonStr();
        String responseOldStr = getJsonOldStr();
        JSONObject resJson = JSONObject.parseObject(responseStr);
        JSONObject resOldJson = JSONObject.parseObject(responseOldStr);
        String rootKey = "Response";
        //核心比较算法使用迭代方式(递归可能会有栈溢出风险)
        System.out.println(compare(rootKey, resJson, resOldJson));
        System.out.println(String.format("耗时: %d ms", System.currentTimeMillis() - startTime));
    }

    private static Map<String, String> compare(String rootKey, JSONObject resJson, JSONObject resOldJson) {
        Map<String, String> differentMap = new HashMap<>();
        //key
        LinkedList<Object> keys = new LinkedList<>();
        keys.add(rootKey);
        //老响应
        LinkedList<Object> jsonObjectLinkedListOld = new LinkedList<>();
        jsonObjectLinkedListOld.add(resOldJson);
        //响应
        LinkedList<Object> jsonObjectLinkedList = new LinkedList<>();
        jsonObjectLinkedList.add(resJson);
        //jsonObjectLinkedListOld 为准
        while (!jsonObjectLinkedListOld.isEmpty()) {
            Object key = keys.poll();
            Object valOld = jsonObjectLinkedListOld.poll();
            Object val = jsonObjectLinkedList.poll();
            System.out.println("key: " + key + " val: " + val + " valOld:" + valOld);
            if (val == null || valOld == null) {
                differentMap.put(String.valueOf(key), " val: " + val + " valOld:" + valOld);
                continue;
            }
            if (basicType(val)) {
                if (!val.equals(valOld)) {
                    System.out.println("***************************************************");
                    System.out.println("key: " + key + " val: " + val + " valOld:" + valOld);
                    differentMap.put(String.valueOf(key), " val: " + val + " valOld:" + valOld);
                    System.out.println("***************************************************");
                }
            } else {
                getBasicTye(key, valOld, val, keys, jsonObjectLinkedListOld, jsonObjectLinkedList);
            }
        }
        return differentMap;
    }

    public static void getBasicTye(Object keyName, Object objectOld, Object object, LinkedList<Object> keys, LinkedList<Object> jsonObjectLinkedListOld,
                                   LinkedList<Object> jsonObjectLinkedList) {
        //遍历对象每个属性到基本类型为止
        if (objectOld instanceof JSONObject) {
            for (Object key : ((JSONObject) objectOld).keySet()) {
                Object valOld = ((JSONObject) objectOld).get(key);
                Object val = ((JSONObject) object).get(key);
                jsonObjectLinkedListOld.add(valOld);
                jsonObjectLinkedList.add(val);
                keys.add(keyName + "->" + key);
            }
        } else if (objectOld instanceof JSONArray) {
            int i = 0;
            Object[] objectSortOld = getSortObjects((JSONArray) objectOld);
            for (Object val : objectSortOld) {
                jsonObjectLinkedListOld.add(val);
                keys.add(keyName + "->" + i);
                i++;
            }
            Object[] objectSort = getSortObjects((JSONArray) object);
            for (Object val : objectSort) {
                jsonObjectLinkedList.add(val);
            }
        } else {
            System.out.println("val class:" + object.getClass());
        }
    }

    private static Object[] getSortObjects(JSONArray object) {
        Object[] objectSort = object.toArray();
        Arrays.sort(objectSort, (Comparator) new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return o1.hashCode() - o2.hashCode();

            }
        });
        return objectSort;
    }

    private static boolean basicType(Object source) {
        return source instanceof String || source instanceof Byte
                || source instanceof Short || source instanceof Integer
                || source instanceof Long || source instanceof Float
                || source instanceof Double || source instanceof Character
                || source instanceof BigDecimal || source instanceof Date;
    }

    private static String getJsonStr() {
        return "{\"code\":100,\"data\":{\"brandId\":0,\"catId\":12422,\"categorySettingList\":[],\"created\":1591359038000,\"features\":{\"noShow\":\"0\"},\"jWareId\":200123342546,\"logo\":\"jfs/t1/25241/12/4556/24021/5c31c93cEf3dca961/87d7368cbca5e78c.jpg\",\"modified\":1597744828000,\"note\":\"1\",\"operateType\":8,\"price\":999999999,\"quantity\":348000,\"restrictedAddresStr\":\"\",\"shopId\":10194689,\"skus\":[{\"extSetting\":[1,2],\"extSkuSetting\":\"\",\"jSkuId\":200137202479,\"jWareId\":200123342546,\"jmiSkuPrices\":[{\"dateDay\":1597852800000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608770853,\"status\":1,\"stock\":999999},{\"dateDay\":1597939200000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608770854,\"status\":1,\"stock\":999999},{\"dateDay\":1598025600000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608775151,\"status\":1,\"stock\":999999},{\"dateDay\":1598112000000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608779496,\"status\":1,\"stock\":999999},{\"dateDay\":1598198400000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608779497,\"status\":1,\"stock\":999999},{\"dateDay\":1598284800000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608790040,\"status\":1,\"stock\":999999},{\"dateDay\":1598371200000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608790041,\"status\":1,\"stock\":999999},{\"dateDay\":1598457600000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608790042,\"status\":1,\"stock\":999999},{\"dateDay\":1598544000000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608798462,\"status\":1,\"stock\":999999},{\"dateDay\":1598630400000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608798463,\"status\":1,\"stock\":999999},{\"dateDay\":1598716800000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608798464,\"status\":1,\"stock\":999999},{\"dateDay\":1598803200000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608801834,\"status\":1,\"stock\":999999},{\"dateDay\":1598889600000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608806488,\"status\":1,\"stock\":999999},{\"dateDay\":1598976000000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608810816,\"status\":1,\"stock\":999999},{\"dateDay\":1599062400000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608810817,\"status\":1,\"stock\":999999},{\"dateDay\":1599148800000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608816870,\"status\":1,\"stock\":999999},{\"dateDay\":1599235200000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608819019,\"status\":1,\"stock\":999999},{\"dateDay\":1599321600000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608822961,\"status\":1,\"stock\":999999},{\"dateDay\":1599408000000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608829034,\"status\":1,\"stock\":999999},{\"dateDay\":1599494400000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608829035,\"status\":1,\"stock\":999999},{\"dateDay\":1599580800000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608829036,\"status\":1,\"stock\":999999},{\"dateDay\":1599667200000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608832372,\"status\":1,\"stock\":999999},{\"dateDay\":1599753600000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608836760,\"status\":1,\"stock\":999999},{\"dateDay\":1599840000000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608842689,\"status\":1,\"stock\":999999},{\"dateDay\":1599926400000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608842690,\"status\":1,\"stock\":999999},{\"dateDay\":1600012800000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608844792,\"status\":1,\"stock\":999999},{\"dateDay\":1600099200000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608849128,\"status\":1,\"stock\":999999},{\"dateDay\":1600185600000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608854046,\"status\":1,\"stock\":999999}],\"outerId\":\"^a5feb46b513c423d937f1770310746d2\",\"preStock\":0,\"quantity\":348000,\"saleList\":[{\"attrValue\":{\"aliasName\":\"西海水世界·巾口景区\",\"valueObj\":\"3\"},\"fieldId\":\"952\",\"letter\":\"ticketCtgCal\",\"type\":\"box\"},{\"attrValue\":{\"aliasName\":\"景点门票\",\"valueObj\":\"3\"},\"fieldId\":\"953\",\"letter\":\"ticketPkgCal\",\"type\":\"box\"}],\"skuId\":274860,\"skuPrice\":12000,\"status\":1,\"wareId\":173034}],\"status\":1,\"title\":\"西海水世界·巾口景区单人摩托艇票成人票\",\"venderId\":10340824,\"wareId\":173034,\"wareImages\":[{\"created\":1597744828000,\"imgId\":13725056,\"imgPath\":\"jfs/t1/25241/12/4556/24021/5c31c93cEf3dca961/87d7368cbca5e78c.jpg\",\"indexId\":0,\"modified\":1597744828000,\"status\":1,\"wareId\":173034}],\"wareSettingList\":[{\"attrValue\":{\"aliasName\":\"是\",\"valueObj\":\"1\"},\"fieldId\":\"1091\",\"letter\":\"isExpiredRefund\",\"type\":\"box\"},{\"attrValue\":{\"aliasName\":\"改签规则\",\"valueObj\":\"1\"},\"fieldId\":\"966\",\"letter\":\"changeRules\",\"type\":\"textarea\"},{\"attrValue\":{\"aliasName\":\"姓名\",\"valueObj\":\"1\"},\"fieldId\":\"1092\",\"letter\":\"contactInfoNeeded\",\"type\":\"box\"},{\"attrValue\":{\"aliasName\":\"00\",\"valueObj\":\"1\"},\"fieldId\":\"1089\",\"letter\":\"pretimesMin\",\"type\":\"box\"},{\"attrValue\":{\"aliasName\":\"退款规则\",\"valueObj\":\"1\"},\"fieldId\":\"965\",\"letter\":\"refundRules\",\"type\":\"textarea\"},{\"attrValue\":{\"aliasName\":\"14:00\",\"valueObj\":\"1\"},\"fieldId\":\"968\",\"letter\":\"pretimes\",\"type\":\"box\"},{\"attrValue\":{\"aliasName\":\"是\",\"valueObj\":\"1\"},\"fieldId\":\"1090\",\"letter\":\"isRefund\",\"type\":\"box\"},{\"attrValue\":{\"aliasName\":\"入园方式\",\"valueObj\":\"1\"},\"fieldId\":\"964\",\"letter\":\"admissionMethod\",\"type\":\"textarea\"},{\"attrValue\":{\"aliasName\":\"00\",\"valueObj\":\"1\"},\"fieldId\":\"1088\",\"letter\":\"pretimesHour\",\"type\":\"box\"},{\"attrValue\":{\"aliasName\":\"提前预定天数\",\"valueObj\":\"1\"},\"fieldId\":\"967\",\"letter\":\"predays\",\"type\":\"text\"},{\"attrValue\":{\"aliasName\":\"有效期\",\"valueObj\":\"1\"},\"fieldId\":\"963\",\"letter\":\"validity\",\"type\":\"text\"},{\"attrValue\":{\"aliasName\":\"不需要\",\"valueObj\":\"1\"},\"fieldId\":\"1087\",\"letter\":\"travelerNeeded\",\"type\":\"box\"},{\"attrValue\":{\"aliasName\":\"限购规则\",\"valueObj\":\"1\"},\"fieldId\":\"1096\",\"letter\":\"restrictionRules\",\"type\":\"textarea\"}]},\"msg\":\"调用成功\"}";
    }

    private static String getJsonOldStr() {
        return "{\"code\":100,\"data\":{\"brandId\":0,\"catId\":12422,\"categorySettingList\":[],\"created\":1591359038000,\"features\":{\"noShow\":\"0\"},\"jWareId\":200123342546,\"logo\":\"jfs/t1/25241/12/4556/24021/5c31c93cEf3dca961/87d7368cbca5e78c.jpg\",\"modified\":1597744828000,\"note\":\"1\",\"operateType\":8,\"price\":999999999,\"quantity\":348000,\"restrictedAddresStr\":\"\",\"shopId\":10194689,\"skus\":[{\"extSetting\":[12345,12345],\"extSkuSetting\":\"\",\"jSkuId\":200137202479,\"jWareId\":200123342546,\"jmiSkuPrices\":[{\"dateDay\":1597939200000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608770854,\"status\":1,\"stock\":999999},{\"dateDay\":1598025600000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608775151,\"status\":1,\"stock\":999999},{\"dateDay\":1597852800000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608770853,\"status\":1,\"stock\":999999},{\"dateDay\":1598112000000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608779496,\"status\":1,\"stock\":999999},{\"dateDay\":1598198400000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608779497,\"status\":1,\"stock\":999999},{\"dateDay\":1598284800000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608790040,\"status\":1,\"stock\":999999},{\"dateDay\":1598371200000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608790041,\"status\":1,\"stock\":999999},{\"dateDay\":1598457600000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608790042,\"status\":1,\"stock\":999999},{\"dateDay\":1598544000000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608798462,\"status\":1,\"stock\":999999},{\"dateDay\":1598630400000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608798463,\"status\":1,\"stock\":999999},{\"dateDay\":1598716800000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608798464,\"status\":1,\"stock\":999999},{\"dateDay\":1598803200000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608801834,\"status\":1,\"stock\":999999},{\"dateDay\":1598889600000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608806488,\"status\":1,\"stock\":999999},{\"dateDay\":1598976000000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608810816,\"status\":1,\"stock\":999999},{\"dateDay\":1599062400000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608810817,\"status\":1,\"stock\":999999},{\"dateDay\":1599148800000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608816870,\"status\":1,\"stock\":999999},{\"dateDay\":1599235200000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608819019,\"status\":1,\"stock\":999999},{\"dateDay\":1599321600000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608822961,\"status\":1,\"stock\":999999},{\"dateDay\":1599408000000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608829034,\"status\":1,\"stock\":999999},{\"dateDay\":1599494400000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608829035,\"status\":1,\"stock\":999999},{\"dateDay\":1599580800000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608829036,\"status\":1,\"stock\":999999},{\"dateDay\":1599667200000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608832372,\"status\":1,\"stock\":999999},{\"dateDay\":1599753600000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608836760,\"status\":1,\"stock\":999999},{\"dateDay\":1599840000000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608842689,\"status\":1,\"stock\":999999},{\"dateDay\":1599926400000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608842690,\"status\":1,\"stock\":999999},{\"dateDay\":1600012800000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608844792,\"status\":1,\"stock\":999999},{\"dateDay\":1600099200000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608849128,\"status\":1,\"stock\":999999},{\"dateDay\":1600185600000,\"jSkuId\":200137202479,\"preStock\":0,\"price\":12000,\"priceId\":608854046,\"status\":1,\"stock\":999999}],\"outerId\":\"^a5feb46b513c423d937f1770310746d2\",\"preStock\":0,\"quantity\":348000,\"saleList\":[{\"attrValue\":{\"aliasName\":\"西海水世界·巾口景区\",\"valueObj\":\"3\"},\"fieldId\":\"952\",\"letter\":\"ticketCtgCal\",\"type\":\"box\"},{\"attrValue\":{\"aliasName\":\"景点门票\",\"valueObj\":\"3\"},\"fieldId\":\"953\",\"letter\":\"ticketPkgCal\",\"type\":\"box\"}],\"skuId\":274860,\"skuPrice\":12000,\"status\":1,\"wareId\":173034}],\"status\":1,\"title\":\"西海水世界·巾口景区单人摩托艇票成人票\",\"venderId\":10340824,\"wareId\":173034,\"wareImages\":[{\"created\":1597744828000,\"imgId\":13725056,\"imgPath\":\"jfs/t1/25241/12/4556/24021/5c31c93cEf3dca961/87d7368cbca5e78c.jpg\",\"indexId\":0,\"modified\":1597744828000,\"status\":1,\"wareId\":173034}],\"wareSettingList\":[{\"attrValue\":{\"aliasName\":\"是\",\"valueObj\":\"1\"},\"fieldId\":\"1091\",\"letter\":\"isExpiredRefund\",\"type\":\"box\"},{\"attrValue\":{\"aliasName\":\"改签规则\",\"valueObj\":\"1\"},\"fieldId\":\"966\",\"letter\":\"changeRules\",\"type\":\"textarea\"},{\"attrValue\":{\"aliasName\":\"姓名\",\"valueObj\":\"1\"},\"fieldId\":\"1092\",\"letter\":\"contactInfoNeeded\",\"type\":\"box\"},{\"attrValue\":{\"aliasName\":\"00\",\"valueObj\":\"1\"},\"fieldId\":\"1089\",\"letter\":\"pretimesMin\",\"type\":\"box\"},{\"attrValue\":{\"aliasName\":\"退款规则\",\"valueObj\":\"1\"},\"fieldId\":\"965\",\"letter\":\"refundRules\",\"type\":\"textarea\"},{\"attrValue\":{\"aliasName\":\"14:00\",\"valueObj\":\"1\"},\"fieldId\":\"968\",\"letter\":\"pretimes\",\"type\":\"box\"},{\"attrValue\":{\"aliasName\":\"是\",\"valueObj\":\"1\"},\"fieldId\":\"1090\",\"letter\":\"isRefund\",\"type\":\"box\"},{\"attrValue\":{\"aliasName\":\"入园方式\",\"valueObj\":\"1\"},\"fieldId\":\"964\",\"letter\":\"admissionMethod\",\"type\":\"textarea\"},{\"attrValue\":{\"aliasName\":\"00\",\"valueObj\":\"1\"},\"fieldId\":\"1088\",\"letter\":\"pretimesHour\",\"type\":\"box\"},{\"attrValue\":{\"aliasName\":\"提前预定天数\",\"valueObj\":\"1\"},\"fieldId\":\"967\",\"letter\":\"predays\",\"type\":\"text\"},{\"attrValue\":{\"aliasName\":\"有效期\",\"valueObj\":\"1\"},\"fieldId\":\"963\",\"letter\":\"validity\",\"type\":\"text\"},{\"attrValue\":{\"aliasName\":\"不需要\",\"valueObj\":\"1\"},\"fieldId\":\"1087\",\"letter\":\"travelerNeeded\",\"type\":\"box\"},{\"attrValue\":{\"aliasName\":\"限购规则\",\"valueObj\":\"1\"},\"fieldId\":\"1096\",\"letter\":\"restrictionRules\",\"type\":\"textarea\"}]},\"msg\":\"调用成功\"}";
    }
}
