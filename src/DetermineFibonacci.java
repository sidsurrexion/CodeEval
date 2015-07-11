import java.util.Scanner;


public class DetermineFibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		System.out.print("Enter the value: ");
		Scanner scanner = new Scanner(System.in);		
		int next = scanner.nextInt();
		System.out.println("");
		int[] collection = new int[next];
		int current = 0;
		
		// Collecting the integers for whose fibonacci number is to be computed
		for (int i = 0; i < next; i++){
			current = scanner.nextInt();
			collection[i] = compute_fibonacci(current);
		}
		
		System.out.println("");
		
		for (int j = 0; j < next; j++){
			System.out.println(+collection[j]);
		}
		scanner.close();
	}
	
	// Method to compute fibonacci value
	private static int compute_fibonacci(int number){
		if (number == 1){
			return 1;
		} else if(number == 0) {
			return 0;
		} else {
			return (compute_fibonacci(number - 1) + compute_fibonacci(number - 2));
		}
	}

}
