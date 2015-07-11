import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Stack {

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
		        
				String line, string;		
				
				StringTokenizer stringtokenizer;
				
				int count = 0;
				
				Boolean bool = true;
		        
		        while ((line = buffer.readLine()) != null) {		        	
		            
		        	bool = true;
		        	
		        	count  = 0;
		        	
		        	line = line.trim();		            
		        	
		        	stringtokenizer = new StringTokenizer(line, " ");
		        	
		        	int[] stack_array = new int[stringtokenizer.countTokens()];
		        	
		        	while (stringtokenizer.hasMoreElements()){
		        		
		        		string = stringtokenizer.nextToken();
		        		
		        		stack_array[count] = Integer.parseInt(string);
		        		
		        		count++;
		        		
		        	}
		        	
		        	count = count - 1;
		        	
		        	for (int i = count; i >= 0; i--){
		        		
		        		if (bool == true){
		        			
		        			if ( i == 0 || i == 1){
		        				
		        				System.out.print(stack_array[i]);
		        				
		        			} else {
		        				
		        				System.out.print(stack_array[i]+" ");
		        				
		        			}	        			
		        			
		        			bool = false;
		        			
		        		} else {
		        			
		        			bool = true;
		        			
		        		}	        		
		        		
		        	}
		        	
		        	System.out.println("");
		        	
		        }
			}
		}
	}
}

