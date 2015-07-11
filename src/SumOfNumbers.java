import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class SumOfNumbers {

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
						        
				int i = 0, j = 0;
		        
		        while ((line = buffer.readLine()) != null) {		        	
		            
		        	line = line.trim();		            
		        	
		            // Process line of input Here
		        	i = Integer.parseInt(line);
		        	
		        	string = String.valueOf(i);
		        	
		        	j = string.length();
		        	
		        	i = 0;
		        	
		        	for ( int b = 0; b < j; b++){
		        		
		        		char c = string.charAt(b);
		        		
		        		i = i + Character.getNumericValue(c);
		        		
		        	}
		        	
		        	System.out.println(i);
		        	
		        }
			}
		}
	}
}

