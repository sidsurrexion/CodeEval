import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ArmStrongNumber {

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
				
				int count = 0;
		        
		        while ((line = buffer.readLine()) != null) {		        	
		            
		        	line = line.trim();		            
		        	
		        	for ( int z = 0; z < line.length(); z++){
		        		
		        		char c = line.charAt(z);
		        		
		        		count = count + (int) Math.pow((double)Character.getNumericValue(c), (double)line.length());
		        		
		        	}
		        	
		        	if ( count == Integer.parseInt(line)){
		        		
		        		System.out.println("True");
		        		
		        	} else {
		        		
		        		System.out.println("False");
		        		
		        	}
		        	
		        	count = 0;
		        	
		        }
			}
		}
	}
}

