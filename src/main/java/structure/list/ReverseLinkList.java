package structure.list;

import common.Node;

public class ReverseLinkList {

        public static void main(String[] args) {
            Node node1 = new Node(1);
            Node temp = node1;
            for(int i = 2;i<10;i++){
                Node node = new Node(i);
                temp.setNext(node);
                temp = node;
            }
            Node n = node1;
            while(n!=null){
                System.out.print(n.getValue()+" ");
                n = n.getNext();
            }
            Node next = node1.getNext();
            node1.setNext(null);
            System.out.println();
             n = reverse(node1,next);
            while(n!=null){
                System.out.print(n.getValue()+" ");
                n = n.getNext();
            }
    }


    public static Node reverse(Node node,Node next){
        if(next == null) return node;
        Node to = next;
        Node n = next.getNext();
        next.setNext(node);
        return reverse(to,n);
    }
}
