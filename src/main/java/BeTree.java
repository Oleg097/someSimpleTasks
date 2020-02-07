public class BeTree {
    Node root;

    public BeTree(Node root) {
        this.root = root;
    }

    public BeTree() {
    }

    public Node getRoot() {
        return root;
    }

    public int getFreequance(){
       return root.getFreeq();
    }
}
