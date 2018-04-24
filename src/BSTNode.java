public class BSTNode {
    Student std;
    BSTNode parent;
    BSTNode left;
    BSTNode right;

    public BSTNode(Student std)
    {
        this.std=std;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

}
