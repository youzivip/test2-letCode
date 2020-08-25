package structure.list;

public class TwoListSort {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node temp = node1;
        for(int i = 2;i<10;i++){
            Node node = new Node(i);
            temp.next = node;
            temp = node;
        }


        Node node2 = new Node(5);
        temp = node2;
        for(int i = 2;i<10;i++){
            Node node = new Node(i+5);
            temp.next = node;
            temp = node;
        }

        Node n = merge(node1,node2);
        while(n!=null){
            System.out.print(n.value+"<");
            n = n.next;
        }

    }

    public static Node merge1( Node list1, Node list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        Node mergeHead = null;
        Node current = null;
        while(list1!=null && list2!=null){
            if(list1.value <= list2.value){
                if(mergeHead == null){
                    mergeHead = current = list1;
               /*
               刚开始第一步就是将第一个最小的数赋予mergeHead，这是很重要的一步，这样mergeHead                     就可以代表合并后的整个链表，这里有个概念需要说明一下，无论是list1,list2,current,mergehead，他们都是一个对象，那么例如mergeHead = current，他们操作的都是同一个对象
               */
                }else{
                    current.next = list1;//将current指向的下个地址设为list1
                    current = current.next;// current 往后移动一位
                }
                list1 = list1.next; //list1往后移动一位
            }else{
                if(mergeHead == null){
                    mergeHead = current = list2;
                }else{
                    current.next = list2;
                    current = current.next;
                }
                list2 = list2.next;
            }
        }
        if(list1 == null){
            current.next = list2;
        }else{
            current.next = list1;
        }
        return mergeHead;
    }



    //假设小的为node1
    public static Node merge(Node node1,Node node2){
         Node root = null  ;
         Node node = null  ;
        Node pre1 = null;
        Node pre2 = null;
        //  while(node1!=null){
        while(node1!=null && node2!=null){
            if(node1.value<=node2.value){
               if(root == null) root = node = node1;
               else {
                   node.next = node1;
                   node = node.next;
               }
               node1 = node1.next;
            }else{
                if(root == null) root =node =  node2;
                else {
                    node.next  = node2;
                    node = node.next;
                }
                node2 = node2.next;
            }
        }
        //    }
        if(node1 == null){
            node.next = node2;
        }else{
            node.next = node1;
        }

        return root;
    }

    static class Node{
        Node next;
        int value;

        public Node(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}


