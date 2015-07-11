import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class Lowercase {

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
						
				Boolean bool = false;
				
				int count = 0;
				
				String string, output_string = null;
		        
		        while ((line = buffer.readLine()) != null) {		        	
		            
		        	line = line.trim();		            
		        	
		        	bool = false;
		        	
		            // Process line of input Here		       
		        	stringtokenizer = new StringTokenizer(line, " ");
		        	
		        	int spring = stringtokenizer.countTokens();
		        	
		        	while(stringtokenizer.hasMoreElements()){
		        		
		        		count++;
		        		
		        		string = stringtokenizer.nextToken();
		        		
		        		StringBuilder stringbuilder = new StringBuilder(string);
		        		
		        		for (int z = 0; z < string.length(); z++){
		        			
		        			char c = string.charAt(z);
		        			
		        			if (Character.isAlphabetic(c)){
		        				
		        				if (Character.isUpperCase(c)){
		        					
		        					stringbuilder.setCharAt(z, Character.toLowerCase(c));
		        					
		        				}
		        			}
		        		}
		        		
		        		if ( bool == false){
		        			
		        			if (count == spring){
		        				
		        				output_string = stringbuilder.toString();
		        				
		        			} else {
		        			
		        				output_string = stringbuilder.toString() + " ";
		        				
		        			}	        			
		        			
		        			bool = true;
		        			
		        		} else {
		        			
		        			if (count == spring){
		        				
		        				output_string = output_string + stringbuilder.toString();
		        						
		        			} else {
		        				
		        				output_string = output_string + stringbuilder.toString() + " ";
		        				
		        			}       			
		        			
		        			
		        		}	   		
		        		
		        		
		        	}
		        	
		        	count = 0;
		        	
		        	System.out.println(output_string);
		        	
		        }
			}
		}
	}
}

