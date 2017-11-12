package ArrayOfTrees;

public class ArrayOfTrees {

    private BinarySearchTree[] treeArray;

    // Constructor.
    public ArrayOfTrees() {
        this.treeArray = new BinarySearchTree[26];
    }

    // Places the input string into the tree structure.
    public void put(String input) {

        String[] inputArray = input.trim().split("\\s+");

        for (String s : inputArray) {
            char firstLetter = s.toUpperCase().charAt(0);
            if (treeArray[firstLetter-'A'] == null) {
                treeArray[firstLetter-'A'] = new BinarySearchTree();
            }
            treeArray[firstLetter - 'A'].insert(s);
        }

        // Do inorder traversal for all trees
        for (BinarySearchTree bst : treeArray) {
            if (bst != null) {
                System.out.print("Inorder Traversal:");
                bst.inOrder(bst.getRoot());
                System.out.println("");
            }
        }
    }
}