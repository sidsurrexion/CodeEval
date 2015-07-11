
public class PrimePalidrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 3, j = 3;
		int largest_prime = -1;
		
		Boolean bool = false, prime_palindrome = true;
		
		while (i < 1000){
			
			while (j <= i){
				
				if ( i == j){
					
					break;
					
				} else {
					
					if ( i % j == 0){
						
						bool = true;
						break;
						
					}
					
				}					
				
				j = j + 2;
				
			}
			
			j = 3;
			
			if ( bool == false){
			
				String string_value = String.valueOf(i);
				
				int y = string_value.length() - 1;
				
				for (int z = 0; z < string_value.length(); z++){
					
					if ( y > z ){
						
						char digit = string_value.charAt(z);
						
						char last_digit = string_value.charAt(y);
						
						if ( digit != last_digit){
							
							prime_palindrome = false;
							break;
							
						}
						
					}
					
					y = y - 1;
				
				}
				
				if ( prime_palindrome == true){
					
					if ( largest_prime == -1){
						
						largest_prime = i;
						
					} else {
						
						if ( largest_prime < i){
							largest_prime = i;
						}
						
					}
				}
				
				prime_palindrome = true;
				
			} else {
				
				bool = false;
				
			}
			
			i = i + 2;
		
		}
		
		System.out.println(+largest_prime);
		
	}

}
