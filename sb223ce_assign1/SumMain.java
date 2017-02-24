package sb223ce_assign1;

public class SumMain {

	public static void main(String[] args) {

		/* Method call */
		int n = 100;
		System.out.println("Sum: " + sum(n));
		System.out.println("Sum: " + newSum(n)); //alternative method
		
		
	}

	public static int sum(int number) {
		if (number == 1) { // Base case
			return 1;
		} else {
			int num = number / 2;
			return firstHalf(1, num) + secondHalf(num + 1, number); // Give the
																	// value to
																	// further
																	// methods
		}
	}

	private static int firstHalf(int begin, int half) { // From 1 to n/2
		if (half == 1) { // Base case
			return 1;
		} else
			return half + firstHalf(half, half - 1); // add half and decrement
														// it by 1.
	}

	private static int secondHalf(int halfPlus, int end) { // from n/2 to n

		if (end == halfPlus) { // Base case
			return halfPlus;
		} else
			return end + secondHalf(halfPlus, end - 1); // add n and decrement
														// it by 1.
	}

	/*
	 * For me, it is a good strategy because it immediately divide the input in two cases just
	 * as merge sort algorithm (I think so). So it is fast and good for big integers. I made the simple
	 * recursion method to compare with this and I realized that the alternative methods sometimes through
	 * stack over flow error for big integers. So I think it is good strategy, however it is not easy
	 * to understand and implement. Below is how this method work
	 * 
	 * 								            4
	 *			            --------------------|-------------------			
	 		                |       	 						   |
	 						2				                       4
	 						 \		                              /	
	 				   	      1							         3	  	
	 *
	 */						
	 	
	/*Alternative method*/
	public static int newSum(int a){
		   if(a == 1)
		   	return 1;
		   else
		   	return a + newSum(a - 1);
		   }

	 /*
	  * How alternative method work, it is quite simple just like s running for loop
	  * 
	  * 											4
	  *						     				   /
	  *											  3
	  *											 /
	  *											2
	  *										   /
	  *										  1
	  *								
	  */
	 	
	 	
	 	
	 	
	 	
	 	
}