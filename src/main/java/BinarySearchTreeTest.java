
public class BinarySearchTreeTest {
    public static void main(String[] args) {
        BinarySearchTree BST = new BinarySearchTree();
        BST.Insert_Node(55);
        BST.Insert_Node(15);
        BST.Insert_Node(60);
        BST.Insert_Node(8);
        BST.Insert_Node(28);
        BST.Insert_Node(90);
        BST.Insert_Node(3);
        BST.Insert_Node(18);
        BST.Insert_Node(45);
        BST.Insert_Node(41);
        BST.Insert_Node(48);
        BST.Insert_Node(30);
        BST.Insert_Node(50);
        BST.Insert_Node(38);
        BST.Insert_Node(33);
        BST.Insert_Node(32);
        BST.Insert_Node(36);

        BST.inOrder(BST.root);
        System.out.println("==============================");
        /*
        // 1. 자식이 없는 노드를 삭제 했을 떄.
        BST.Delete(18);
        BST.inOrder(BST.root);
        */

        /*
        // 2. 자식이 한쪽에만 있는 노드를 삭제 했을 때.
        BST.Delete(30);
        BST.inOrder(BST.root);
        */

        // 3. 자식이 둘 다 있는 노드를 삭제 했을 떄
        BST.Delete(28);
        BST.inOrder(BST.root);
    }
}
