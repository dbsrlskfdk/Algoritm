public class BinarySearchTree {
    Node root = null;
    public void Insert_Node(int data){
        if (root == null){
            root = new Node(data);
            return;
        }else{
            Node head = root;
            Node curNode;

            while(true){
                curNode = head;

                if (data < head.getValue()) {
                    head = head.left;

                    if (head == null){
                        curNode.left = new Node(data);
                        break;
                    }
                }else{
                    head = head.right;

                    if (head == null){
                        curNode.right = new Node(data);
                        break;
                    }
                }
            }
        }


    }

    public void inOrder(Node N){
        if (N != null){
            inOrder(N.left);
            System.out.println(N.getValue());
            inOrder(N.right);
        }
    }

    public void Delete(int data){
        Node delNode = root;
        Node parentDelNode = null;

        while(delNode.getValue() != data){
            parentDelNode = delNode;

            if (data < delNode.getValue()){
                delNode = delNode.left;
            }else if (data > delNode.getValue()){
                delNode = delNode.right;
            }

            if (delNode == null){
                System.out.println("해당 값이 트리에 없습니다.");
            }
        }

        // 1. 자식 노드가 없을 떄 left, right == null
        if(delNode.left == null && delNode.right == null){
            if (delNode == root){
                root = null;
            }else if (delNode == parentDelNode.left){
                parentDelNode.left = null;
            }else{
                parentDelNode.right = null;
            }
        // 2. 자식 노드가 하나 있을 때 left == null or right == null
        }else if(delNode.left == null) { // left가 null이라면, 즉 오른쪽만 존재하면 삭제할 node의 right 노드를 이전 노드에 연결해줘야함.
            if (delNode == root){ // 삭제할 node가 root 였다면, 삭제할 node right 노드를 루트에 연결
                root = delNode.right;
            }else if(delNode == parentDelNode.right){ // 삭제할 노드가 이전 노드의 오른쪽 노드였다면,
                parentDelNode.right = delNode.right;
            }else{
                parentDelNode.left = delNode.right; // 삭제할 노드가 이전 노드의 오른쪽 노드가 아니였으면, 당연히 이전 노드의 왼쪽에다가 삭제할 노드의 오른쪽 연결
            }
        }else if(delNode.right == null){ // right가 null 이라면, 즉 왼쪽만 존재한다면, 삭제할 노드의 left 노드를 이전 노드에 연결해줘야함
            if (delNode == root){
                root = delNode.left;
            }else if (delNode == parentDelNode.right){ // 삭제할 노드가 이전 노드의 오른쪽이엇다면, 이전 노드의 오른쪽과 연결해줘야함
                 parentDelNode.right = delNode.left;
            }else{
                parentDelNode.left = delNode.left;
            }
        }else{
        // 3. 자식 노드가 둘 다 있을 때 left != null, right != null
        /*
        자식 노드가 둘 다 있다면, 노드를 삭제하는 알고리즘은
        (1). 삭제할 노드의 값보다는 크지만 가장 작은 값을 탐색 or 삭제할 노드의 값보다는 작지만, 가장 큰 값을 탐색
        (2). 해당 노드를 삭제할 노드의 자리로 올려주고, 삭제할 노드는 삭제
        (3). 그 후 해당 노드의 서브 트리를 그 노드의 parent 노드와 연결 시켜줌.
         */

        }


    }
}
