package TrinarySearchTree;


/* Answer to Q2:
*  For the Trinary search tree, the in-order traversal is the same.
*  The post- and pre-order traversals depend on the structure of the
*  tree, while in-order traversal carries out a in-order tree walk
*  through the nodes in sorted order.
*/

public class TrinarySearchTree {

    // Define the Trinode class to replace the binary Node class.
    public class Trinode {

        int value;
        int value2 = -1;

        Trinode left;
        Trinode middle;
        Trinode right;

        public Trinode(int data) {
            this.value = data;
            this.left = null;
            this.middle = null;
            this.right = null;
        }

        public void nodeInsert(int data) {
            if (data > this.value) {
                this.value2 = data;
                return;
            }

            if (data < this.value) {
                this.value2 = this.value;
                this.value = data;
            }
        }
    }

    Trinode root;

    public TrinarySearchTree() {
        this.root = null;
    }

    public void insert(int data) {

        // Generate the new node to be added
        Trinode n = new Trinode(data);

        // If the tree is empty, well done! return.
        if (root == null) {
            root = n;
            return;
        }

        // If not, it is a little more complicated.
        Trinode currentNode = root;
        Trinode parent;

        while (true) {
            parent = currentNode;

            // If the current value2 = -1, insert the data at the current node.
            if (currentNode.value2 == -1) {
                currentNode.nodeInsert(data);
                return;
            }

            // Go to the children. 3 possible assignments:
            if (data > currentNode.value && data < currentNode.value2) {
                currentNode = currentNode.middle;
                if (currentNode == null) {
                    parent.middle = n;
                    return;
                }

            } else if (data < currentNode.value) {
                currentNode = currentNode.left;
                if (currentNode == null) {
                    parent.left = n;
                    return;
                }

            } else if (data > currentNode.value2) {
                currentNode = currentNode.right;
                if (currentNode == null) {
                    parent.right = n;
                    return;
                }
            }
        }
    }

    public int search(Trinode root, int searchValue) {

        Trinode rootNode;
        rootNode = root;
        int depth = 0;

        while (rootNode != null) {

            // if searchValue hits the correct value, break and return depth.
            if (searchValue == rootNode.value || searchValue == rootNode.value2) {
                return depth;
            }
            
            if (searchValue < rootNode.value) {
                // if searchValue is less than the node value, go left.
                // since the searchValue is less than the node value, it must
                // be in the left. But if the left child is null, then the value
                // cannot exist, so return -1.
                depth++;
                rootNode = rootNode.left;
                if (rootNode == null) return -1;

            }

            // if searchValue between value1 and value2, go middle.
            else if (searchValue > rootNode.value && searchValue < rootNode.value2) {
                depth++;
                rootNode = rootNode.middle;
                if (rootNode == null) return -1;

            }

            // if searchValue greater than value2, go right.
            else if (searchValue > rootNode.value2) {
                depth++;
                rootNode = rootNode.right;
                if (rootNode == null) return -1;
            }
        }
        return depth;
    }

    public int findMin(Trinode root) {
        Trinode rootNode = root;

        while (true) {
            if (rootNode.left == null) {
                return rootNode.value;
            } else {
                rootNode = rootNode.left;
            }
        }
    }

    public int findMax(Trinode root) {
        Trinode rootNode = root;

        while (true) {
            if (rootNode.right == null) {
                return rootNode.value2;
            } else {
                rootNode = rootNode.right;
            }
        }
    }

    public void preOrderWalk(Trinode root) {
        if (root != null) {
            System.out.print(" "+root.value+" "+root.value2+" :");
            preOrderWalk(root.left);
            preOrderWalk(root.middle);
            preOrderWalk(root.right);
        }
    }

    public void inOrderWalk(Trinode root) {
        if (root != null) {
            inOrderWalk(root.left);
            System.out.print(" "+root.value+" :");
            inOrderWalk(root.middle);
            System.out.print(" "+root.value2+" :");
            inOrderWalk(root.right);

        }
    }

    public void postOrderWalk(Trinode root) {
        if (root != null) {
            postOrderWalk(root.left);
            postOrderWalk(root.middle);
            postOrderWalk(root.right);
            System.out.print(" "+root.value+" "+root.value2+" :");
        }
    }
}
