import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class RollerCoaster {

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
				
		        StringTokenizer stringtokenizer = null;
		        
		        String str;
		        
		        Boolean bool = false;
		        
		        while ((line = buffer.readLine()) != null) {
		        	
		        	line = line.trim();
		        	
		        	// Process line of input Here
		        	stringtokenizer = new StringTokenizer(line, " ");
		        	
		        	while(stringtokenizer.hasMoreElements()){
		        		
		        		str = stringtokenizer.nextToken();
		        		
		        		StringBuilder stringbuilder = new StringBuilder(str);
		        		
		        		for (int i = 0; i < str.length(); i++){
		        			
		        			char digit = str.charAt(i);
		        			
		        			if (bool == false){
		        				
		        				if (Character.isAlphabetic(digit)){
		        					
		        					if (Character.isLowerCase(digit)){
			        					
			        					stringbuilder.setCharAt(i, Character.toUpperCase(digit));			        				
				        				
			        				}
		        					
		        					bool = true;
		        				}	        				
		        						        				
		        				
		        			} else {
		        						        					        				
		        				if (Character.isAlphabetic(digit)){
		        					
		        					if (Character.isUpperCase(digit)){
			        					
			        					stringbuilder.setCharAt(i, Character.toLowerCase(digit));
				        				
			        				}
		        					
		        					bool = false;
		        				}
		        				
		        			}
		        			
		        		}
		        		
		        		System.out.print(stringbuilder.toString()+" ");	 
		        		
		        	}
		        	
		        	bool = false;
		        	
		        	System.out.println("");
		        	
		        }
			}
			
		}	
		
	}

}
