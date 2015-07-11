import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class RecurrenceSequence {

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
				
				StringTokenizer stringtokenizer;	
						        
		        while ((line = buffer.readLine()) != null) {	
		        	
		        	Map<String, Integer> number_data = new LinkedHashMap<String, Integer>();
		        	
		        	Boolean frog = false;
		        	
		        	String new_string = null;
		        	
		        	line = line.trim();		            
		        	
		        	stringtokenizer = new StringTokenizer(line, " ");
		        	
		        	while (stringtokenizer.hasMoreElements()){
		        		
		        		String string = stringtokenizer.nextToken();
		        		
		        		if (number_data.isEmpty()){
		        			
		        			number_data.put(string, 1);
		        			
		        			new_string = string;		        		
		        			
		        		} else {
		        			
		        			if (string.equals(new_string)){
		        				
		        				number_data.put(string, number_data.get(string) + 1);		        				
		        				
		        			} else {
		        				
		        				if (!frog){
		        					
		        					System.out.print(number_data.get(new_string)+" "+new_string);
		        					
		        					frog = true;
		        					
		        				} else {
		        					
		        					System.out.print(" "+number_data.get(new_string)+" "+new_string);
		        					
		        				}
		        					
		        				number_data.remove(new_string);
		        					
		        				number_data.put(string, 1);
		        					
		        				new_string = string;      				
		        				
		        			}
		        			
		        		}		        		
		        		
		        	}
		        	
		        	if (!number_data.isEmpty()){
		        		
		        		if (!frog){
		        			
		        			System.out.println(number_data.get(new_string)+" "+new_string);
		        			
		        		} else {
		        			
		        			System.out.print(" "+number_data.get(new_string)+" "+new_string);
		        			
		        		}	        		
		        		
		        	}
		        	
		        	System.out.println("");
		        		
		        }
			}
		}
	}
}

