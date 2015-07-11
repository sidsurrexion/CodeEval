import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class CapitalizeWords {

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
		        
				String line, string, output = null;
				
				StringBuilder stringbuilder;
				
				Boolean bool = false;
				
				StringTokenizer stringtokenizer;
		        
		        while ((line = buffer.readLine()) != null) {		        	
		            
		        	line = line.trim();
		        	
		        	bool = false;
		        	
		        	stringtokenizer = new StringTokenizer(line, " ");
		        	
		        	while (stringtokenizer.hasMoreElements()){
		        		
		        		string = stringtokenizer.nextToken();
		        		
		        		stringbuilder = new StringBuilder(string);
		        			
		        		if (Character.isAlphabetic(string.charAt(0))){
		        				
		        			stringbuilder.setCharAt(0, Character.toUpperCase(string.charAt(0)));
		        				
		        		}
		        		
		        		if (bool == false){
		        			
		        			output = stringbuilder.toString();
		        			
		        			bool = true;
		        			
		        		} else {
		        			
		        			output = output + " " + stringbuilder.toString();
		        			
		        		}
		        		
		        	}
		        	
		        	System.out.println(output);
		        	
		        }
			}
		}
	}
}

