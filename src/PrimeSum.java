
public class PrimeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int sum = 0;
		sum = sum + 2;
		int i = 3, j = 3;
		int count = 1;
		Boolean bool = false;		
		
				
			while (i > 2){
				
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
				
					sum = sum + i;
					count++;
					
				} else {
					
					bool = false;
				}
				
				i = i + 2;
				
				if (count == 1000){
					break;
				}
			
			}
		System.out.println(sum);
	}

}
