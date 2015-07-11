
public class Multiple_Twelve {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 1; i <= 12; i++){
			
			for ( int j = 1; j <= 12; j++){
				
				String string = String.valueOf(i*j);
				
				if (string.length() == 1){
					
					System.out.print("   "+string);
					
				} else if (string.length() == 2){
					
					System.out.print("  "+string);
					
				} else if (string.length() == 3){
					
					System.out.print(" "+string);
					
				}
				
				
			}
			
			System.out.println("");
		}
		
	}

}
