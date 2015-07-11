import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class CountPrimes {

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
				
				StringTokenizer stringtokenizer;
		        
		        while ((line = buffer.readLine()) != null) {	
		        	
		        	int first_digit = 0, second_digit = 0;
		        	
		        	int count = 0;
		        	
		        	Boolean bool = false;	        	
		        	
		        	int j = 3;
		            
		        	line = line.trim();		            
		        	
		        	stringtokenizer = new StringTokenizer(line, ",");
		        	
		        	while (stringtokenizer.hasMoreElements()){
		        		
		        		if (first_digit == 0){
		        			
		        			first_digit = Integer.parseInt(stringtokenizer.nextToken());
		        			
		        		} else {
		        			
		        			second_digit = Integer.parseInt(stringtokenizer.nextToken());
		        		}
		        		
		        	}
		        		
		        		if (first_digit > second_digit){
		        			
		        			int i = second_digit;
		        			
		        			if (i % 2 == 0){
		        				
		        				if (i == 2){
		        					
		        					count++;
		        					
		        				}
		        				
		        				i++;
		        				
		        			}
		        			
		        			while(i <= first_digit){
		        				
		        				if ( i == 1){
		        					
		        					continue;
		        					
		        				} else {
		        					
		        					while( j <= i){
		        						
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
		        					
		        					i = i + 2;		
		        					
		        					j = 3;
		        					
		        					if (bool == false){
		        						
		        						count++;
		        						
		        					} else {
		        						
		        						bool = false;
		        						
		        					}
		        					
		        				}
		        				
		        			}
		        			
		        			
		        		} else if (second_digit > first_digit){
		        			
		        			int i = first_digit;
		        			
		        			if (i % 2 == 0){
		        				
		        				if (i == 2){
		        					
		        					count++;
		        					
		        				}
		        				
		        				i++;
		        				
		        			}
		        			
		        			while(i <= second_digit){
		        				
		        				if ( i == 1){
		        					
		        					continue;
		        					
		        				} else {
		        					
		        					while( j <= i){
		        						
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
		        					
		        					i = i + 2;	
		        					
		        					j = 3;
		        					
		        					if (bool == false){
		        						
		        						count++;
		        						
		        					} else {
		        						
		        						bool = false;
		        						
		        					}
		        					
		        				}
		        				
		        			}
		        			
		        		} else {
		        			
		        			int i = first_digit;
		        			
		        			if (i % 2 == 0){
		        				
		        				i++;
		        				
		        			}
		        			
		        			while( j <= i){
        						
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
		        			
		        			if (bool == false){
        						
        						count++;
        						
        					} 
		        			
		        		}
		        		
		        		System.out.println(count);       	
		        	
		        }
			}
		}
	}
}

