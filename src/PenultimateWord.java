import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class PenultimateWord {

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
				
				int count = 0, i = 0;
		        
		        while ((line = buffer.readLine()) != null) {	
		        	
		        	count = 0;
		            
		        	line = line.trim();		            
		        	
		        	stringtokenizer = new StringTokenizer(line, " ");
		        	
		        	i = stringtokenizer.countTokens() - 1;
		        	
		        	while (stringtokenizer.hasMoreElements()){
		        		
		        		count++;
		        		
		        		string = stringtokenizer.nextToken();
		        		
		        		if (count == i){    	
		        			
		        			System.out.println(string);
		        			
		        		}
		        		
		        	}
		        	
		        }
			}
		}
	}
}

