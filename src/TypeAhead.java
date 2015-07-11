import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class TypeAhead {

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
				
				String paragraph = "Mary had a little lamb its fleece was white as snow; "
						+ "And everywhere that Mary went, the lamb was sure to go. "
						+"It followed her to school one day, which was against the rule; "
						+"It made the children laugh and play, to see a lamb at school. "
						+"And so the teacher turned it out, but still it lingered near, "
						+"And waited patiently about till Mary did appear. "
						+"Why does the lamb love Mary so? the eager children cry; Why, Mary "
						+"loves the lamb, you know the teacher did reply.";
				
					        
				String line, temp_string = null, parent_string = null, child_string = null;		
				
				int count = 0, gram = 0, total_count = 0;						
				
		        while ((line = buffer.readLine()) != null) {	
		        	
		        	gram = 0;
		        	
		        	StringTokenizer stringtokenizer_one = new StringTokenizer(paragraph, " .;,");
		        	
		        	Map<String, Map<String, Integer>> word_count = new HashMap<String, Map<String, Integer>>();
		            
		        	line = line.trim();	
		        	
		        	StringTokenizer stringtokenizer = new StringTokenizer(line, " ,");
		        	
		        	while(stringtokenizer.hasMoreElements()){
		        		
		        		temp_string = stringtokenizer.nextToken();
		        		
		        		if (gram == 0){
		        			
		        			gram = Integer.parseInt(temp_string);
		        			
		        		}		        		
		        		
		        	}  	
		        	
		        	while(stringtokenizer_one.hasMoreElements()){	        	
			        	
		        		parent_string = stringtokenizer_one.nextToken();
		        		
			        	if (parent_string.equals(temp_string)){
			        		
			        		while (count < gram - 1){
			        			
			        			count++;	
			        			
			        			total_count++;
			        			
			        			Map<String, Integer> word_item = new HashMap<String, Integer>();
			        					        			
			        			if (word_count.isEmpty()){	 
			        				
			        				child_string = stringtokenizer_one.nextToken();
			        				
			        				word_item.put(child_string , count);
			        				
			        				word_count.put(temp_string, word_item);
			        				
				        		} else {
				        			
				        			word_item = word_count.get(temp_string);
				        			
				        			child_string = stringtokenizer_one.nextToken();
				        			
				        			if (word_item.containsKey(child_string)){
				        				
				        				word_item.put(child_string, word_item.get(child_string) + 1);
				        				
				        				word_count.put(temp_string, word_item);
				        				
				        			} else {
				        				
				        				word_item.put(child_string, 1);
				        				
				        				word_count.put(temp_string, word_item);
				        				
				        			}
				        			
				        		}		        			
			        			
			        		}    
			        		
			        		count = 0;
			        		
			        	}
			        	
			        }
		        	
		        	Map<String, Integer> word_item = new HashMap<String, Integer>();
		        	
		        	word_item = word_count.get(temp_string);
		        	
		        	Map<Double,TreeMap<String,Integer>> probability_word = new TreeMap<Double, TreeMap<String, Integer>>(Collections.reverseOrder());       	
		        	
		        	for (String key: word_item.keySet()){
		        		
		        		TreeMap<String, Integer> word_distribution = new TreeMap<String, Integer>();
		        		
		        		Double probability = ((double)word_item.get(key) / (double)total_count);
		        		
		        		if (probability_word.isEmpty()){
		        			
		        			word_distribution.put(key, word_item.get(key));
		        			
		        			probability_word.put(probability, word_distribution);
		        			
		        		} else {
		        			
		        			if (probability_word.containsKey(probability)){
		        				
		        				word_distribution = probability_word.get(probability);
		        				
		        				word_distribution.put(key, word_item.get(key));
		        				
		        			} else {
		        				
		        				word_distribution.put(key, word_item.get(key));
			        			
			        			probability_word.put(probability, word_distribution);
			        			
		        			}
		        			
		        		}		        		
		        		
		        	}
		        	
		        	count = 0;
		        	
		        	total_count = 0;
		        	
		        	for (Double duo: probability_word.keySet()){
		        		
		        		count++;
		        		
		        		String key_value = String.valueOf(duo);
		        		
		        		int length = key_value.length();
		        		
		        		if (length != 5){
		        			
		        			if (length < 5){
		        				
		        				for (int i = 0; i < 5 - length; i++){
		        					
		        					key_value = key_value + "0";
		        					
		        				}
		        				
		        			} else {
		        				
		        				key_value = key_value.substring(0, 5);
		        				
		        			}
		        			
		        		}
		        		
		        		TreeMap<String, Integer> word_distribution = new TreeMap<String, Integer>();
		        		
		        		word_distribution = probability_word.get(duo);
		        		
		        		for (String string: word_distribution.keySet()){
		        			
		        			total_count++;
		        			
		        			if (count == probability_word.size() && total_count == word_distribution.size()){
		        				
		        				System.out.print(string+","+key_value);
		        				
		        			} else {
		        				
		        				System.out.print(string+","+key_value+";");
		        				
		        			}	        			
		        			
		        		}
		        		
		        		total_count = 0;	        		
		        		
		        	}
		        	
		        	System.out.println("");
		        	
		        	count = 0;
		        	
		        }
		        
		        
			}
		}
	}
}

