import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class StringMask {

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
		        
		        String string = "crap", number = "crap";
		        
		        while ((line = buffer.readLine()) != null) {
		        	
		        	line = line.trim();
		        	
		        	// Process line of input Here
		        	stringtokenizer = new StringTokenizer(line, " ");
		        	
		        	while(stringtokenizer.hasMoreElements()){
		        		
		        		if (string == "crap"){
		        			string = stringtokenizer.nextToken();
		        		} else {
		        			number = stringtokenizer.nextToken();
		        		}
		        				        	
		        	}
		        	
		        	StringBuilder stringbuilder = new StringBuilder(string);
		        	
		        	for (int i = 0; i < number.length(); i++){
		        		
		        		char digit = number.charAt(i);
		        		
		        		char single = string.charAt(i);
		        		
		        		char one = '1';
		        		
		        		if( digit == one ){	        			
		        			
		        			stringbuilder.setCharAt(i, Character.toUpperCase(single));
		        		
		        		} else {
		        			
		        			stringbuilder.setCharAt(i, Character.toLowerCase(single));
		        			
		        		}		        		
		        		
		        	}
		        	
		        	System.out.println(stringbuilder.toString());
		        	
		        	string = "crap";
		        	
		        	number = "crap";
		        }
			}
			
		}	
		
	}

}
