import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class NonRepeatingCharacter {

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
		        	
		        	Map<Character, Integer> ch_map = new LinkedHashMap<Character, Integer>();
		            
		        	line = line.trim();		            
		        	
		        	for ( int i = 0; i < line.length(); i++){
		        		
		        		if (ch_map.isEmpty()){
		        			
		        			ch_map.put(line.charAt(i), 1);
		        			
		        		} else {
		        			
		        			if (ch_map.containsKey(line.charAt(i))){
		        				
		        				count = ch_map.get(line.charAt(i));
		        				
		        				count++;
		        				
		        				ch_map.put(line.charAt(i), count);
		        				
		        			} else {
		        				
		        				ch_map.put(line.charAt(i), 1);		        				
		        				
		        			}
		        			
		        		}
		        		
		        	}
		        	
		        	for (char ch_key: ch_map.keySet()){
		        		
		        		if (ch_map.get(ch_key) == 1){
		        			
		        			System.out.println(ch_key);
		        			
		        			break;
		        			
		        		}
		        		
		        	}
		        	
		        }
			}
		}
	}
}

