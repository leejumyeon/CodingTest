package intern09;

public class Tree {

    

    public Node root; // Tree의 root노드 생성
    
    public void setRoot(Node node) { // 루트노드 생성
        this.root = node;
    }

    public Node createNode(Node left, int data, Node right) { // 노드 생성
        Node node = new Node();
        node.data = data;
        node.left = left;
        node.right = right;
        return node;
    }

    // 순회 메소드 구현 //

    // 중위 순회(left -> root -> right)
    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.data);
            inOrder(node.right);
        }
    }

    // 전위 순회(root -> left -> right)
    public void preOrder(Node node) {
        if(node != null) {
            System.out.println(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    
    // 후위 순회(left -> right -> root)
    public void postOrder(Node node) {
        if(node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.data);   
        }
    }
    
    
}


