import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class NumberOfOnes {

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
				
				int count = 0;
		        
		        while ((line = buffer.readLine()) != null) {		        	
		            
		        	line = line.trim();		            
		        	
		        	string = Integer.toBinaryString(Integer.parseInt(line));
		        	
		        	for (int i = 0; i < string.length(); i++){
		        		
		        		if (string.charAt(i) == '1'){
		        			
		        			count++;
		        			
		        		}
		        		
		        	}
		        	
		        	System.out.println(count);
		        	
		        	count = 0;
		        	
		        }
			}
		}
	}
}

