import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class HappyNumbers {

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
		        String string;
		        Boolean bool = true, key_used = false;
		        int i = 0, j = 0, sum = 0;		        
		        
		        while ((line = buffer.readLine()) != null) {
		        	
		        	Map<Integer, Integer> container = new HashMap<Integer, Integer>();
		        	
		        	bool = true;		        	
		        	       	
		        	key_used = false;
		            
		        	line = line.trim();		            
		        	
		            // Process line of input Here
		        	stringtokenizer = new StringTokenizer(line, "; ");
		        	
		        	while (stringtokenizer.hasMoreElements()){
		        				
		        		string = stringtokenizer.nextToken();
		        		
		        		j = string.length();
		        		
		        		while (bool == true){
		        			
		        			sum = 0;
		        			
		        			for (int z = 0; z < j; z++){
		        				
		        				char c = string.charAt(z);
		        				
		        				i = Character.getNumericValue(c);
		        				
		        				sum = sum + i*i;
		        				
		        			}        			
		        			
		        			
		        			if ( sum == 1){
		        				
		        				bool = false;
		        			
		        			} else {
		        				
		        				if (key_used == false){
		        					
		        					key_used = true;
		        					
		        					container.put(sum, (int)(Math.random() * 1000));
		        					
		        				} else {
		        					
		        					if (container.containsKey(sum)){
			        					
			        					break;
			        					
			        				} else {
			        					
			        					container.put(sum, (int)(Math.random() * 1000));
			        					
			        				}
		        					
		        				}		        				
		        				
		        				string = String.valueOf(sum);
		        				
		        				j = string.length();
		        				
		        			}	        			
		        			
		        			
		        		}
		        		
		        		if ( bool == false){
		        			
		        			System.out.println("1");
		        			
		        		} else {
		        			
		        			System.out.println("0");
		        			
		        		}
		        	
		        	}
		        }
			}
		}
	}
}

