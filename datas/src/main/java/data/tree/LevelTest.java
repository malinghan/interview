package data.tree;

/**
 * @author : linghan.ma
 * @Package data
 * @Description:
 * @date Date : 2019年09月12日 2:15 AM
 *
 *        10
 *      /     \
 *    6         13
 *   / \       /  \
 *  3   9     8    18
 *
 **/
public class LevelTest {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.setLeft(new Node(6));
        root.setRight(new Node(13));
        root.getLeft().setLeft(new Node(3));
        root.getLeft().setRight(new Node(9));
        root.getRight().setLeft(new Node(8));
        root.getRight().setRight(new Node(18));

       preVisit(root); //前序
        System.out.println("=============");
        postVisit(root);
        System.out.println("=============");
        midVisit(root);
    }

    /**
     * 前序遍历二叉树-递归
     *   stack info
     *    node
     *        -> left
     *               -> left
     *                     -> null
     *               -> right <-
     *                     ->null
     *            <-
     *         -> right
     *              -> left
     *                    -> null
     *                    <-
     *              -> right
     *                    -> null
     *   <-
     */
    public static void preVisit(Node node){
        if(node!=null){
            System.out.println(node.getData());
        }
        if(node.getLeft()!=null) {
            preVisit(node.getLeft());
        }
        if(node.getRight()!=null) {
            preVisit(node.getRight());
        }
    }

    /**
     * 后序遍历二叉树-递归
     */
    public static void postVisit(Node node){
        if(node.getLeft()!=null) {
            postVisit(node.getLeft());
        }

        if(node.getRight()!=null) {
            postVisit(node.getRight());
        }

        if(node!=null){
            System.out.println(node.getData());
        }
    }

    /**
     * 后序遍历二叉树-递归
     */
    public static void midVisit(Node node){
        if(node.getLeft()!=null) {
            midVisit(node.getLeft());
        }

        if(node!=null){
            System.out.println(node.getData());
        }

        if(node.getRight()!=null) {
            midVisit(node.getRight());
        }
    }
}
