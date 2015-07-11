import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class UniqueElements {

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
				
				int count = 0;
		        
		        while ((line = buffer.readLine()) != null) {	
		        	
		        	Map<Integer, Integer> sorted_map = new TreeMap<Integer, Integer>();
		        	
		        	count = 0;
		            
		        	line = line.trim();		            
		        	
		        	stringtokenizer = new StringTokenizer(line, ",");
		        	
		        	while(stringtokenizer.hasMoreElements()){
		        		
		        		string = stringtokenizer.nextToken();
		        		
		        		count++;
		        		
		        		if (sorted_map.isEmpty()){
		        		
		        			count++;
		        			
		        			sorted_map.put(Integer.parseInt(string), count);
		        			
		        		} else {
		        			
		        			if (!sorted_map.containsKey(Integer.parseInt(string))){
		        				
		        				count++;
		        				
		        				sorted_map.put(Integer.parseInt(string), count);
		        				
		        			}
		        			
		        		}
		        		
		        	}
		        	
		        	count = 0;
		        	
		        	for (int key: sorted_map.keySet()){
		        		
		        		count++;
		        		
		        		if (count == sorted_map.size()){
		        			
		        			System.out.print(key);
		        			
		        		} else {
		        			
		        			System.out.print(key+",");
		        			
		        		}
		        		
		        	}
		        	
		         System.out.println("");
		        	
		        }
			}
		}
	}
}

