package sb223ce_assign4.BinaryIntHeap;

import java.util.Random;

public class Main {

	public static void main(String[]args){
		BinaryIntHeap a = new BinaryIntHeap();
		Random ran = new Random();
		System.out.println("Size: " + a.size());
		System.out.println("Empty: " + a.isEmpty());
		
		/*Add positive and negative integers*/
		for(int i = 0; i < 10; i++){
			if(i % 2 == 0){
			a.insert(ran.nextInt((i + 1) * 2));
			}
			
			else{
				int s = ran.nextInt((i + 1) * 2);
				a.insert(-s);
		}
		}
		System.out.println("Size: " + a.size());
		System.out.println(a.toString());
		System.out.println("Empty: " + a.isEmpty());
		System.out.println("Pull highest: " + a.pullHighest());
		System.out.println("Size: " + a.size());
		System.out.println(a.toString());
		
	}
}
