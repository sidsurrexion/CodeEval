import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class LowestUniqueElement {

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
				
				int count = 0, n = 0;
		        
		        while ((line = buffer.readLine()) != null) {		   
		        	
		        	Map<Integer, Integer> sorted_data = new TreeMap<Integer, Integer>();
		        	
		        	count = 0;
		            
		        	line = line.trim();		            
		        	
		        	stringtokenizer = new StringTokenizer(line, " ");
		        	
		        	n = stringtokenizer.countTokens();
		        	
		        	while (stringtokenizer.hasMoreElements()){
		        		
		        		count++;
		        		
		        		string = stringtokenizer.nextToken();
		        		
		        		if (n == 1){
		        			
		        			System.out.println("1");
		        			
		        		} else {
		        			
		        			if (sorted_data.isEmpty()){
		        				
		        				sorted_data.put(Integer.parseInt(string), count);
		        				
		        			} else {
		        				
		        				if(sorted_data.containsKey(Integer.parseInt(string))){
		        					
		        					sorted_data.put(Integer.parseInt(string), 0);
		        					
		        					
		        				} else {
		        					
		        					sorted_data.put(Integer.parseInt(string), count);
		        					
		        				}		        				
		        				
		        			}
		        			
		        			
		        		}
		        		
		        	}
		        	
		        	if (!sorted_data.isEmpty()){
		        		
		        		for (int key: sorted_data.keySet()){
		        			
		        			if (sorted_data.get(key) !=  0){
		        				
		        				System.out.println(sorted_data.get(key));
		        		
		        				n = -1;
		        				
		        				break;
		        				
		        			}
		        			
		        		}
		        		
		        		if (n != -1){
		        			
		        			System.out.println("0");
		        			
		        		}
		        		
		        	} 		        	
		        }
			}
		}
	}
}

