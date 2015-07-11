import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class FacebookBeautifulString {

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
				
				int count = 0, line_count = 0;			
				
				Boolean bool = false;
				
				StringTokenizer stringtokenizer;
				
				while ((line = buffer.readLine()) != null) {
					
					Map<Character, Integer> alphabet_count = new HashMap<Character, Integer>();
					Map<Integer, String>  sentences = new LinkedHashMap<Integer, String>();
					Map<Integer, HashSet<Character>> sorting = new TreeMap<Integer, HashSet<Character>>(Collections.reverseOrder());
					Map<Character, Integer> final_data = new HashMap<Character, Integer>();
					
					bool = false;
					
					line = line.trim();
					
					sentences.put(line_count, line);
		        	
		        	line_count++;
		        	
		        	stringtokenizer = new StringTokenizer(line, " ");
		        	
		        	while (stringtokenizer.hasMoreElements()){
		        		
		        		string = stringtokenizer.nextToken();
		        		
		        		for (int i = 0; i < string.length(); i++){
		        			
		        			count = 0;
		        			
		        			if (Character.isAlphabetic(string.charAt(i))){
		        				
		        				if ( bool == false){
		        					
		        					bool = true;
			        				
			        				count++;		        				
			        				
			        				if(Character.isUpperCase(string.charAt(i))){		        					
			        					
			        					alphabet_count.put(Character.toLowerCase(string.charAt(i)), count);
			        					
			        				} else {
			        					
			        					alphabet_count.put(string.charAt(i), count);
			        					
			        				}
			        				
			        			} else {
			        				
			        				if(Character.isUpperCase(string.charAt(i))){
			        					
			        					if (alphabet_count.containsKey(Character.toLowerCase(string.charAt(i)))){
			        						
			        						count = alphabet_count.get(Character.toLowerCase(string.charAt(i)));
			        						
			        						count++;
			        						
			        						alphabet_count.put(Character.toLowerCase(string.charAt(i)), count);
			        						
			        					} else {
			        						
			        						count++;
			        						
			        						alphabet_count.put(Character.toLowerCase(string.charAt(i)), count);
			        						
			        					}
			        					
			        				} else {
			        					
			        					if (alphabet_count.containsKey(string.charAt(i))){
			        						
			        						count = alphabet_count.get(string.charAt(i));
			        						
			        						count++;
			        						
			        						alphabet_count.put(string.charAt(i), count);
			        						
			        					} else {
			        						
			        						count++;
			        						
			        						alphabet_count.put(string.charAt(i), count);
			        						
			        					}
			        				}
			        				
			        			}
		        				
		        			} 
		        			
		        		}
		        	}
		        	
		        	for (char ch: alphabet_count.keySet()){
				    	 
				    	 if (sorting.isEmpty()){
				    		 
				    		 Set<Character> set = new HashSet<Character>();
				    		 
				    		 set.add(ch);
				    		 
				    		 sorting.put(alphabet_count.get(ch), (HashSet<Character>) set);
				    		 
				    	 } else {
				    		 
				    		 if(sorting.containsKey(alphabet_count.get(ch))){
				    			 
				    			 Set<Character> set = new HashSet<Character>();
				    			 
				    			 set = sorting.get(alphabet_count.get(ch));
				    			 
				    			 set.add(ch);
				    			 
				    			 sorting.put(alphabet_count.get(ch), (HashSet<Character>) set);
				    			 
				    		 } else {
				    			 
				    			 Set<Character> set = new HashSet<Character>();
					    		 
					    		 set.add(ch);
					    		 
					    		 sorting.put(alphabet_count.get(ch), (HashSet<Character>) set);		    			 
				    			 
				    		 }
				    		 
				    	 }				    	 
				    	 
				     }
		        	
		        	count = 26;
				     
				     for (int key: sorting.keySet()){
				    	 
				    	 Set<Character> set = new HashSet<Character>();
				    	 
				    	 set = sorting.get(key);
				    	 
				    	 for (Character alphabet: set){
				    		 
				    		 final_data.put(alphabet, count);
				    		 
				    		 count--;
				    		 
				    	 }
				    	 
				     }
				     
				     count = 0;
				     
				     for (int key: sentences.keySet()){
				    	 
				    	 stringtokenizer = new StringTokenizer(sentences.get(key), " ");
				    	 
				    	 while(stringtokenizer.hasMoreElements()){
				    		 
				    		 string = stringtokenizer.nextToken();
				    		 
				    		 for (int i = 0; i < string.length(); i++){
				    			 
				    			 if(Character.isAlphabetic(string.charAt(i))){
				    				 
				    				 count = count + final_data.get(Character.toLowerCase(string.charAt(i)));
				    				 
				    			 }
				    			 
				    		 }		    			 
				    		 
				    	 }
				    	 
				    	 System.out.println(count);
				    	 
				    	 count = 0;
				    	 
				     }
					
				}
			}
		}
	}

}
