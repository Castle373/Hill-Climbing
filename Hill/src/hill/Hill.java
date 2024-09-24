/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hill;

/**
 *
 * @author diego
 */
import java.util.ArrayList;
import java.util.List;


public class Hill {

    public static void main(String[] args) {
        // Crear el árbol
        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node8 = new Node(8);
        Node node1 = new Node(1);
        Node node2D5 = new Node(2);
        Node node2D2 = new Node(2);
        Node node9 = new Node(9);

        root.left = node2;
        root.right = node6; 
        
        node2.left = node8; 
        node2.right = node3; 
        
        node3.left = node4;
        node4.left = node9; 
        node3.right = node2D2;
        
        node8.left = node5; 
        node8.right = node6; 
        
        node6.left = node1;
        node6.right = node5; 
        
        node5.left = node2D5; 
        node5.right = node2D2;
        
        List<Node> path = new ArrayList<>();
        boolean found = hillClimbing(root, 9, path);
        
        
        if (found) {
            System.out.print("Camino hacia el nodo con valor 9: ");
            for (Node node : path) {
                System.out.print(node.value + " ");
            }
            System.out.println("\nNodo encontrado: " + path.get(path.size() - 1).value);
        } else {
            System.out.println("Nodo con valor 9 no encontrado.");
        }
    }

    public static boolean hillClimbing(Node currentNode, int targetValue, List<Node> path) {
        if (currentNode == null) {
            return false;
        }

        path.add(currentNode);

        if (currentNode.value == targetValue) {
            return true;
        }

        boolean foundInLeft = hillClimbing(currentNode.left, targetValue, path);
        if (foundInLeft) {
            return true;
        }

        boolean foundInRight = hillClimbing(currentNode.right, targetValue, path);
        if (foundInRight) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }
}

