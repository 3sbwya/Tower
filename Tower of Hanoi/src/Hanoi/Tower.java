package Hanoi;

import java.util.Scanner;
import java.util.Stack;
/**
 * Nothing is happening
 * @author Matt
 *
 */
public class Tower {
	Stack<Integer> first = new Stack<>();
	Stack<Integer> second = new Stack<>();
	Stack<Integer> third = new Stack<>();
	private int numOfDisks, moves = 0;
	
	public Tower(int numOfDisks) {
		this.numOfDisks = numOfDisks;
	}

	public void play(){
		buildTower();
		System.out.println(toString());
		solve(numOfDisks, first, third, second);
		System.out.println("Moves: " + moves);
	}
	
	private void buildTower(){
		for(int i = numOfDisks; i > 0; i--){
			first.push(i);
		}
	}
	
	private void solve(int n, Stack<Integer> source, Stack<Integer> dest, Stack<Integer> aux){
		if(n >= 1){
			solve(n-1, source, aux, dest);
			dest.push(source.pop());
			System.out.println(toString());
			solve(n-1, aux, dest, source);
			moves++;
		}
	}

	@Override
	public String toString() {
		return "Peg 1: " + first + "\nPeg 2: " + second + "\nPeg 3:"
				+ third + "\n";
	}
	
	public static void main(String[] args){
		int numOfDisks = 1;
		boolean check = false;
		Scanner k = new Scanner(System.in);
		while(!check){
			System.out.print("Number of disks (1-8): ");
			numOfDisks = k.nextInt();
			if(numOfDisks > 8 || numOfDisks < 1){
				System.err.println("Number must be between 1 and 8");
			}else{
				check = true;
			}
		}
		Tower t = new Tower(numOfDisks);
		t.play();
	}
		
}
