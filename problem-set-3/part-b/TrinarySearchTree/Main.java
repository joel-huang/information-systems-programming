package TrinarySearchTree;

public class Main {
    public static void main(String[] args) {
        // String S = "the quick brown fox jumps over the lazy dog";
        // String S = "SUTD ISTD ASD ESD EPD";

        int[] num = {100, 200, 590, 70, 80, 360, 110, 105, 102, 107};

        TrinarySearchTree t = new TrinarySearchTree();

        for (int i : num) {
            t.insert(i);
        }

        System.out.println("\nPreOrder Traversal: ");
        t.preOrderWalk(t.root);
        System.out.println("\nInOrder Traversal: ");
        t.inOrderWalk(t.root);
        System.out.println("\nPostOrder Traversal: ");
        t.postOrderWalk(t.root);

        System.out.println("\n");
        int a = 100;
        int b = 590;
        int c = 107;
        System.out.println("Found "+a+" at depth " + t.search(t.root, a));
        System.out.println("Found "+b+" at depth " + t.search(t.root, b));
        System.out.println("Found "+c+" at depth " + t.search(t.root, c));

        System.out.println("");
        System.out.println("Minimum value: " + t.findMin(t.root));
        System.out.println("Maximum value: " + t.findMax(t.root));



    }
}
