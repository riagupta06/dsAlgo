import java.util.ArrayList;
import java.util.List;

public class NArrayTree {

    // Class for the node of the tree
    static class Node {
        int data;

        // List of children
        Node children[];

        Node(int n, int data)
        {
            children = new Node[n];
            this.data = data;
        }
    }

    // Function to print the inorder traversal
    // of the n-ary tree
    static void inorder(Node node, List list)
    {
        if (node == null)
            return;

        // Total children count
        int total = node.children.length;
        // All the children except the last
        for (int i = 0; i < total - 1; i++)
            inorder(node.children[i], list);

        // Print the current node's data
        //System.out.print("" + node.data + " ");
        list.add(node.data);

        // Last child
        inorder(node.children[total - 1], list);
    }

    // Driver code
    public static void main(String[] args)
    {

    /* Create the following tree
               1
            /
           2
         /   \
        3     4
       /
    */
        int n = 3;
        Node root = new Node(n, 1);
        root.children[0] = new Node(n, 2);
        root.children[0].children[0] = new Node(n, 3);
        root.children[0].children[1] = new Node(n, 4);
        root.children[0].children[0].children[0] = new Node(n, 5);
        root.children[0].children[0].children[1] = new Node(n, 6);
        root.children[0].children[0].children[2] = new Node(n, 7);
        root.children[0].children[1].children[0] = new Node(n, 8);

        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        int processNumber = 6;
        for (int i=0; i<list.size(); i++) {
            if(processNumber == list.get(i)) {
                while(list.get(i) >= processNumber) {
                    i++;
                }
                System.out.println(list.get(i));
                break;
            }
        }

    }

}
