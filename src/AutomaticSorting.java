import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class AutomaticSorting {

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
						        
				int i = 0;
				
				float lowercase = 0.0f, uppercase = 0.0f, lower_case = 0.0f, upper_case = 0.0f;
		        
		        while ((line = buffer.readLine()) != null) {		        	
		            
		        	line = line.trim();		            
		        	
		            // Process line of input Here		        	
		        	i = line.length();
		        	
		        	for (int z = 0; z < i; z++){
		        		
		        		char c = line.charAt(z);
		        		
		        		if (Character.isLowerCase(c)){
		        			
		        			lowercase++;
		        			
		        		} else {
		        			
		        			uppercase++;
		        			
		        		}
		        	}
		        	
		        	lower_case = ((lowercase/(lowercase + uppercase)) * 100);
		        	
		        	upper_case = ((uppercase/(lowercase + uppercase)) * 100);	        	
      	
		        	System.out.println("lowercase: "+lower_case+" uppercase: "+upper_case);	        		        	
		        	
		        	lowercase = 0;
		        	uppercase = 0;
		        	
		        }
			}
		}
	}
}

