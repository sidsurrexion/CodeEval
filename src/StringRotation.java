import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class StringRotation {

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
		        
				StringTokenizer stringtokenizer;
				
		        while ((line = buffer.readLine()) != null) {
		            
		        	String first_string = null;
		        	
		        	String second_string = null;
		        	
		        	line = line.trim();		    
		        	
		        	Boolean dog = false;
		        	
		        	stringtokenizer = new StringTokenizer(line, ",");
		        	
		        	while(stringtokenizer.hasMoreElements()){
		        		
		        		if(!dog){
		        			
		        			first_string = stringtokenizer.nextToken();
		        			
		        			dog = true;
		        			
		        		} else {
		        			
		        			second_string = stringtokenizer.nextToken();
		        			
		        		}
		        		
		        	}
		        	
		        	dog = false;
		        	
		        	char ch = 'k';
		        	
		        	char chs = 'k';
		        	
		        	if (ch == chs){
		        		
		        		System.out.print("Edge");
		        	}
		        	
		        	
		        	
		        	for (int i = 0; i < second_string.length(); i++){
		        		
		        		count = 0;
		        		
		        		StringBuilder stringbuilder = new StringBuilder(second_string);
		        		
		        		stringbuilder.setCharAt(count, second_string.charAt(i));
		        		
		        		int j = i + 1;
		        		
		        		while (count < second_string.length() - 1){
		        			
		        			count++;
		        			
		        			if (j == second_string.length()){
		        				
		        				j = 0;
		        				
		        			}	        			
		        			
		        			stringbuilder.setCharAt(count, second_string.charAt(j));
		        			
		        			j++;
		        			
		        		}
		        		
		        		if (first_string.equals(stringbuilder.toString())){
		        			
		        			System.out.println("True");
		        			
		        			dog = true;
		        			
		        			break;
		        			
		        		}
		        		
		        	}
		        	
		        	if (!dog){
		        		
		        		System.out.println("False");
		        		
		        	}
		        	
		        }
			}
		}
	}
}

