import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class ReverseGroups {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String filedirectory = new File("").getAbsolutePath();
		
		File file = null;
		file = new File(filedirectory);
		String[] paths = file.list();
		String extension;
		String new_extension = "txt";
		String filedirectory_temp;				
		
		for (String path: paths){
			
			extension = path.substring(path.lastIndexOf(".") + 1, path.length());
			
			if (extension.equals(new_extension)){
				
				filedirectory_temp = filedirectory + "\\" + path;
				file = new File(filedirectory_temp);
				@SuppressWarnings("resource")
				BufferedReader buffer = new BufferedReader(new FileReader(file));
		        
				String line;	
				
				int count = 0 ;
		        
		        while ((line = buffer.readLine()) != null) {
		        	
		        	count = 0;
		            
		        	line = line.trim();		 
		        	
		        	int divisor = 0;
		        	
		        	String string = null;
		        	
		        	StringTokenizer stringtokenizer = new StringTokenizer(line, ",;");
		        	
		        	int number_length = stringtokenizer.countTokens() - 1;
		        	
		        	String string_distribution[] = new String[number_length];
		        	
		        	while (stringtokenizer.hasMoreElements()){	 
		        		
		        		string = stringtokenizer.nextToken();
		        		
		        		if (count < number_length){
		        			
		        			string_distribution[count] = string;
			        		
		        			count++;
		        			
		        		} else{
		        			
		        			divisor = Integer.parseInt(string);
		        			
		        		}
		        		
		        	} 	 
		        	
		        	int remainder = number_length % divisor ;
		        	
		        	int temp = divisor;
		        	
		        	if (remainder == 0){	        		
		        		
		        		
		        		while (number_length >= divisor){
		        			
		        			for (int i = divisor - 1; i >= divisor - temp; i--){		        				
		        				
		        				if (number_length == divisor && i == divisor - temp){
		        					
		        					System.out.print(string_distribution[i]);
		        					
		        				} else{
		        					
		        					System.out.print(string_distribution[i]+",");
		        					
		        				}
		        				
		        			}
		        			
		        			divisor = divisor + temp;
		        			
		        		}
		        		
		        	} else {
		        		
		        		int multiple_of_divisor = number_length - remainder;
		        		
		        		while (multiple_of_divisor >= divisor){
		        			
		        			for (int i = divisor - 1; i >= divisor - temp; i--){	        				
		        			        					
		        					System.out.print(string_distribution[i]+",");	        				
		        				
		        			}
		        			
		        			divisor = divisor + temp;
		        			
		        		}
		        		
		        		for (int i = multiple_of_divisor; i < number_length; i++){
		        			
		        			if (i == number_length - 1){
		        				
		        				System.out.print(string_distribution[i]);
		        				
		        			} else {
		        				
		        				System.out.print(string_distribution[i]+",");
		        				
		        			}
		        			
		        		}		        		
		        		
		        	}
		        	
		        	System.out.println("");
		        	
		        }
			}
		}
	}
}

