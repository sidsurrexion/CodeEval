import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class ReverseWords {

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
		        
		        int i = 0, k = 0;
		        
		        while ((line = buffer.readLine()) != null) {
		        	
		        	line = line.trim();
		        	
		        	// Process line of input Here
		        	stringtokenizer = new StringTokenizer(line, " ");
		        	
		        	k = stringtokenizer.countTokens();
		        	
		        	String[] array = new String[k];
		        	
		        	while(stringtokenizer.hasMoreElements()){
		        		
		        		array[i] = stringtokenizer.nextToken();
		        		
		        		i++;
		        	
		        	}
		        	
		        	i = 0;
		        	
		        	for ( int j = k - 1; j >= 0; j--){
		        		System.out.print(array[j]+" ");
		        	}
		        	
		        	System.out.println("");
		        	
		        }
			}
		}
	}

}
