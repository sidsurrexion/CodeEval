import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReverseAndAdd {

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
				
				long a = 0, b = 0;
				
				int iterator = 0, value = 1;
				
				int count = 0, old = 0;
				
				Boolean bool = false;
		        
		        while ((line = buffer.readLine()) != null) {			        	
		            
		        	line = line.trim();		
		        	
		        	iterator = 0;
		        	
		        	while (value > 0){
		        	
		        		bool = false;
		        		
		        		count = 0;
		        		
		        		StringBuilder stringbuilder = new StringBuilder(line);
		        		
		        		for (int i = line.length() - 1; i >=0; i-- ){
			        		
			        		char ch = line.charAt(i);
			        		
			        		stringbuilder.setCharAt(count, ch);
			        		
			        		count++;
			        		
			        	}
			        	
		        		a = Long.parseLong(line);
			        	
			        	b = Long.parseLong(stringbuilder.toString());
			        	
			        	iterator++;
			        	
			        	a = a + b;
			        	
			        	old = String.valueOf(a).length()-1;
			        	
			        	for (int w = 0; w < String.valueOf(a).length()-1; w++){
			        		
			        		if (old > w){
			        			
			        			char digit = String.valueOf(a).charAt(w);
								
								char last_digit = String.valueOf(a).charAt(old);
								
								if ( digit != last_digit){
									
									bool = true;
									break;
									
								}	
								
								old = old - 1;
			        			
			        		}
			        		
			        	}
			        	
			        	if (bool == false){
			        		
			        		System.out.println(iterator+" "+a);
			        		
			        		break;
			        		
			        		
			        	} else {
			        		
			        		line = String.valueOf(a);
			        		
			        	}
		        	}
		        	
		        	
		        	
		        }
			}
		}
	}
}

