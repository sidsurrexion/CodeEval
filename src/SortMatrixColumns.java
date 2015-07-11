/* This code is still under review. The problem description is not clear*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class SortMatrixColumns {

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
				
				Map<Integer, Integer> columns = new TreeMap<Integer, Integer>();
				
				int count = 0, token_count = 0;
		        
		        while ((line = buffer.readLine()) != null) {	
		        	
		        	count = 0;
		        	
		        	token_count = 0;
		            
		        	line = line.trim();		            
		        	
		        	stringtokenizer = new StringTokenizer(line, " ");
		        	
		        	while(stringtokenizer.hasMoreElements()){	        		
		        		
		        		string = stringtokenizer.nextToken();		        		
		        		
		        		token_count++;
		        		
		        		if (string == "|"){
		        			
		        			for (int key: columns.keySet()){
		        				
		        				System.out.print(key+" ");
		        				
		        			}
		        			
		        			columns = new TreeMap<Integer, Integer>();
		        			
		        			System.out.println(" | ");
		        			
		        			count = 0;
		        			
		        		} else {
		        			
		        			count++;
		        			
		        			columns.put(Integer.parseInt(string), count);
		        			
		        			if (token_count == stringtokenizer.countTokens()){
		        				
		        				count = 0;
		        				
		        				for (int key: columns.keySet()){
		        					
		        					if (count == columns.size()){
		        						
		        						System.out.print(key);
		        						
		        					} else {
		        						
		        						System.out.print(key+" ");
		        						
		        					}
		        					
		        				}
		        				
		        			} 		        			
		        			
		        		}
		        		
		        	}
		        	
		        	System.out.println();
		        	
		        }
			}
		}
	}
}

