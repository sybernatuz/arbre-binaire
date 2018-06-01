package arbre;

import java.util.Scanner;

public class Launcher {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Node<Integer> nodes = initialize();
		
//		Node<Integer> nodes = new Node<Integer>(2);
//        Node<Integer> n11 = new Node<Integer>(7);
//        Node<Integer> n12 = new Node<Integer>(5);
//        Node<Integer> n21 = new Node<Integer>(2);
//        Node<Integer> n22 = new Node<Integer>(6);
//        Node<Integer> n23 = new Node<Integer>(9);
//        Node<Integer> n31 = new Node<Integer>(5);
//        Node<Integer> n32 = new Node<Integer>(8);
//        Node<Integer> n33 = new Node<Integer>(4);
//        n22.setLeft(n31);
//        n22.setRight(n32);
//        n23.setLeft(n33);
//        n11.setLeft(n21);
//        n11.setRight(n22);
//        n12.setRight(n23);
//        nodes.setLeft(n11);
//        nodes.setRight(n12);
        
		boolean end = false;
		while (!end) {
			end = processMenu(nodes);
			BinaryTreePrinter.printNode(nodes);
		}
	}

	private static boolean processMenu(Node<Integer> nodes) {
		System.out.println("1) Prefix");
		System.out.println("2) Hauteur");
		System.out.println("3) Taille");
		System.out.println("4) Equilibré");
		System.out.println("5) Rotation gauche");
		System.out.println("6) Quitter");
		sc.nextLine();
		switch (sc.nextInt()) {
		case 1:
			nodes.prefix();
			break;
		case 2:
			System.out.println(nodes.height());
			break;
		case 3:
			System.out.println(nodes.size());
			break;
		case 4:
			System.out.println(nodes.isBalanced());
			break;
		case 5:
			nodes = nodes.leftRotation();
			break;
		default:
			return true;
		}
		return false;
	}

	
	
	public static Node<Integer> initialize() {
		System.out.println("Entez la valeur du noeud");
		Node<Integer> nodes = new Node<Integer>(sc.nextInt());
		System.out.println("Noeud gauche ? Y/N\n");
		if (sc.next().equals("Y")) {
			nodes.setLeft(initialize());
		}
		System.out.println("Noeud droit ? Y/N");
		if (sc.next().equals("Y")) {
			nodes.setRight(initialize());
		}
		return nodes;
	}
}
