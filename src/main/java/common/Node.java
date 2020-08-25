package common;

import lombok.Data;

@Data
public class Node {
    Node next;
    int value;

    public Node(int value) {
        this.value = value;
    }


}
