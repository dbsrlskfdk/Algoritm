
public class BinarySearchTreeTest {
    public static void main(String[] args) {
        BinarySearchTree BST = new BinarySearchTree();
        BST.Insert_Node(30);
        BST.Insert_Node(20);
        BST.Insert_Node(25);
        BST.Insert_Node(40);
        BST.Insert_Node(10);
        BST.Insert_Node(35);

        BST.inOrder(BST.root);

    }
}
