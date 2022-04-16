public class Node{
    int value;
    Node left;
    Node right;

    public Node(){
        this.left = null;
        this.right = null;
    }
    public Node(int value){
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public int getValue() {
        return value;
    }
}
