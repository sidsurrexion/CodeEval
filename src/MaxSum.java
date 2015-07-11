import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class MaxSum {

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
		        Boolean bool = false;
		        int i = 0, j = 0;
		        
		        while ((line = buffer.readLine()) != null) {
		            
		        	line = line.trim();		            
		        	
		            // Process line of input Here
		        	stringtokenizer = new StringTokenizer(line, "; ");
		        	
		        	int[] array = new int[stringtokenizer.countTokens() - 1];
		        	
		        	while (stringtokenizer.hasMoreElements()){
		        		
		        		if ( bool == false ){
		        			
		        			i = Integer.parseInt(stringtokenizer.nextToken());		        			
		        			
		        			bool = true;
		        			
		        		} else {
		        			
		        			array[j] = Integer.parseInt(stringtokenizer.nextToken());
		        			
		        			j++;
		        			
		        		}		        		
		        		
		        	}
		        	
		        	bool = false;
		        	
		        	j = 0;
		        	
		        	int count = 1; 
		        	
		        	int k = i;
		        	
		        	i = array.length - k + 1;
		        	
		        	int y = 0;
		        	
		        	int old_value = -9999;
		        	
		        	int new_value = -9999;
		        	
		        	for (int z = 0; z < i; z++){
		        		
		        		y = z;
		        		
		        		while (count < k){
		        			
		        			y++;
		        			
		        			if (old_value == -9999){
		        				
		        				old_value = array[z] + array[y];
		        				
		        			} else {
		        				
		        				old_value = old_value + array[y];
		        				
		        			}		        			
		        			
		        			count++;
		        			
		        		}
		        		
		        		if (new_value == -9999){
		        			
		        			new_value = old_value;
		        		
		        		} else {
		        		
		        			if (old_value >= new_value){
		        				
		        				new_value = old_value;
		        				
		        			}
		        		}
		        		
		        		old_value = -9999;
		        		
		        		count = 1;
		        		
		        	}
		        	
		        	if (new_value <= 0){
		        		new_value = 0;
		        	}
		        	
		        	System.out.println(new_value);
		        	
		        }
			}
		}
	}

}
