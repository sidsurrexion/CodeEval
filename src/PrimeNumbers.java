import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PrimeNumbers {

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
		        
				String line, string = null;		
				
				int i = 3, j = 3;
				
				Boolean bool = false, more = false;
		        
		        while ((line = buffer.readLine()) != null) {		
		        	
		        	i = 3;
		        	
		        	j = 3;
		        	
		        	bool = false;
		        	
		        	more = false;
		            
		        	line = line.trim();		 
		        	
		        	if ( Integer.parseInt(line) == 1 ){
		        		
		        		System.out.println("0");
		        		
		        	} else if (Integer.parseInt(line) == 2){
		        		
		        		System.out.println("2");
		        		
		        	} else {
		        		
		        		if ( i == 3 ){
		        			
		        			string = "2,";
		        			
		        			more = true;
		        			
		        		}		        		
		        		
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
		    					
		    					string = string + i + ",";
		    					
		    				} else {
		    					
		    					bool = false;
		    				}
		    				
		    				i = i + 2;
		    				
		    				if (i >= Integer.parseInt(line)){
		    					break;
		    				}
		    			
		    			}
		        		
		        	}
		        	
		        	if (more == true){
		        		
		        		for (int y = 0; y <= string.length() - 2; y++){	        		
		        			
		        			System.out.print(string.charAt(y));
		        			
		        		}
		        	}
		        	
		        	System.out.println("");
		        	
		        }
			}
		}
	}
}

