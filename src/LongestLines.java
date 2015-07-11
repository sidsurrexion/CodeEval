import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class LongestLines {

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
				
				Map<Integer, String> words = new TreeMap<Integer, String>(Collections.reverseOrder());
				
				int count = 0, countdown = 0;
				
				Boolean bool = false;
		        
		        while ((line = buffer.readLine()) != null) {		        	
		            
		        	line = line.trim();		            
		        	
		        	if (bool == false){
		        		
		        		count = Integer.parseInt(line);
		        		
		        		bool = true;
		        		
		        	} else {
		        		
		        		words.put(line.length(), line);	        		
		        		
		        	}
		        	
		        }
		        
		        for( int key: words.keySet()){
		        	
		        	if (countdown == count){
		        		
		        		break;
		        	
		        	}
		        	
		        	countdown++;
		        	
		        	System.out.println(words.get(key));
		        	
		        }
			}
		}
	}
}

