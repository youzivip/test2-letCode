package structure.list;

import lombok.Data;

public class MySkipListMap<T extends Comparable<T>> {
    Node<T> node;


    public void add(T t){
        if(node == null) {
            node = new Node<T>(t,0);
        }
        // 找到层级 修改位置
        int level;
        Node<T> comNode = node;
        while (comNode != null && comNode.value.compareTo(t)<0 ){
            comNode  = node.up;
            level = comNode.level;
        }
        // 找哪个层在的位置
         // 怎么限定有多少层
    }

    public void get(){

    }


    @Data
    class Node<T >{

        public Node(T value, int level) {
            this.value = value;
            this.level = level;
        }

        T value;
        int level;
        //   Node<T> up;
        Node<T> up;
        Node<T> right;
    }


}
