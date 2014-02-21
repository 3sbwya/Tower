package Hanoi;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;
/**
 * TOWER OF HAMOI
 * 
 * This version of the program is to help figure out how to 
 * include a javadoc and load everything into a JAR file. 
 * @author Matt
 *
 */
public class Tower {
	private Stack<Integer> first = new Stack<>();
	private Stack<Integer> second = new Stack<>();
	private Stack<Integer> third = new Stack<>();
	private int numOfDisks, moves = 0;
	
	/**
	 * Constructor with defined number of disks.
	 * @param numOfDisks
	 */
	public Tower(int numOfDisks) {
		this.numOfDisks = numOfDisks;
	}
	
	/**
	 * Default constructor
	 */
	public Tower(){
		this(0);
	}
	
	/**
	 * Set number of disks.
	 * @param n
	 */
	public void setDisks(int n){
		this.numOfDisks = n;
	}
	
	/**
	 * Builds starting peg. Runs the solve method.
	 * prints number of moves.
	 */
	public void play(){
		buildTower();
		System.out.println(toString());
		solve(numOfDisks, first, third, second);
		System.out.println("Moves: " + moves + "\n");
	}
	/**
	 * Makes sure all stacks are empty. Loads starting
	 * peg.
	 */
	private void buildTower(){
		first.clear();
		second.clear();
		third.clear();
		moves = 0;
		for(int i = numOfDisks; i > 0; i--){
			first.push(i);
		}
	}
	
	private void solve(int n, Stack<Integer> source, Stack<Integer> dest, Stack<Integer> aux){
		if(n >= 1){
			solve(n-1, source, aux, dest);
			dest.push(source.pop());
			moves++;
			System.out.println(toString());
			solve(n-1, aux, dest, source);
			
		}
	}
	
	public String moves(){
		return numOfDisks + " disk(s) has " + moves + " moves.\n";
	}

	@Override
	public String toString() {
		return "Peg 1: " + first + "\nPeg 2: " + second + "\nPeg 3:"
				+ third + "\n";
	}
	/**
	 * Driver
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException{
		int[] disks = {1,2,3,4,5,6,7,8};
		
		System.out.println("Filename to save moves:");
		Scanner k = new Scanner(System.in);
		String filename = k.nextLine();
		PrintWriter outputFile = new PrintWriter(filename);
		Tower t = new Tower();
		for(int i = 0; i < disks.length; i++){
			t.setDisks(disks[i]);
			t.play();
			outputFile.println(t.moves());
		}
		outputFile.close();
	}
		
}
