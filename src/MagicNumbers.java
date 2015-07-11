import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class MagicNumbers {

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
		        	
		        	Boolean first_case = false;
		        	
		        	Boolean any_magic = false;
		        	
		        	count = 0;
		        	
		        	int range_source = 0;
		        	
		        	int range_destination = 0;
		            
		        	line = line.trim();		            
		        	
		        	StringTokenizer stringtokenizer = new StringTokenizer(line, " ");
		        	
		        	while (stringtokenizer.hasMoreElements()){
		        		
		        		if (range_source == 0){
		        			
		        			range_source = Integer.parseInt(stringtokenizer.nextToken());
		        			
		        		} else {
		        			
		        			range_destination = Integer.parseInt(stringtokenizer.nextToken());
		        			
		        		}		        		
		        		
		        	}
		        	
		        	for (int i = range_source; i <= range_destination; i++){
		        		
		        		count = 0;
		        		
		        		Boolean bool = false;       		
		        		        		
		        		
		        		
		        		String number_of_digits = String.valueOf(i);
		        		
		        		if (number_of_digits.length() == 1){
		        			
		        			if ( first_case == false ){
		        				
		        				System.out.print(i);
		        				
		        				first_case = true;
		        				
		        				if (any_magic == false){
		        					
		        					any_magic = true;
		        					
		        				}		        				
		        				
		        				
		        			} else {
		        			
		        				System.out.print(" "+i);
		        				
		        				if (any_magic == false){
		        					
		        					any_magic = true;
		        					
		        				}
		        				
		        			}  
		        			
		        			continue;
		        			
		        		}
		        		
		        		Map<Character, Integer> map_string = new HashMap<Character, Integer>();
		        		
		        		for (int j = 0; j < number_of_digits.length(); j++){
		        			
		        			if (map_string.isEmpty()){
		        				
		        				map_string.put(number_of_digits.charAt(j), 0);
		        				
		        			} else {
		        				
		        				if (map_string.containsKey(number_of_digits.charAt(j))){
		        					
		        					bool = true;
			        				
			        				break;
		        					
			        			} else {
			        				
			        				map_string.put(number_of_digits.charAt(j), 0);
			        				
			        			}
		        				
		        			}	        			
		        			
		        		}
		        		
		        		if (bool == false){
		        			
		        			int length = number_of_digits.length();
			        		
			        		int index = 0;
			        		
			        		while (count < length){
			        			
			        			int digit = Character.getNumericValue(number_of_digits.charAt(index));
			        			
			        			if (digit < length){
			        				
			        				if ( index == 0){
			        					
			        					index = index + digit;
				        				
				        				if (map_string.get(number_of_digits.charAt(index))  == 0 ){
				        					
				        					map_string.put(number_of_digits.charAt(index), 1);
				        			
				        					count++;
				        					
				        				} else {
				        					
				        					bool = true;
				        					
				        					break;
				        					
				        				}
				        				
			        				} else {
			        					
			        					index = index + digit;
			        					
			        					if (index <= length - 1){
			        						
			        						if (map_string.get(number_of_digits.charAt(index))  == 0 ){
					        					
					        					map_string.put(number_of_digits.charAt(index), 1);
					        			
					        					count++;
					        					
					        				} else {
					        				
					        					bool = true;
					        					
					        					break;
					        					
					        				}
			        						
			        					} else {
			        						
			        						index = index - length;
			        						
			        						if (map_string.get(number_of_digits.charAt(index))  == 0 ){
					        					
					        					map_string.put(number_of_digits.charAt(index), 1);
					        			
					        					count++;
					        					
					        				} else {
					        					
					        					bool = true;
					        					
					        					break;
					        					
					        				}
			        					}
			        					
			        				}
			        				
			        				
			        			} else if (digit > length){
			        				
			        				index = calculate_index(digit,length,index);			        				
			        							        				
			        				if (map_string.get(number_of_digits.charAt(index))  == 0 ){
			        					
			        					map_string.put(number_of_digits.charAt(index), 1);
			        			
			        					count++;
			        					
			        				} else {
			        					
			        					bool = true;
			        					
			        					break;
			        					
			        				}
			        				
			        			} else {
			        				
			        				if (map_string.get(number_of_digits.charAt(index))  == 0 ){
			        					
			        					map_string.put(number_of_digits.charAt(index), 1);
			        			
			        					count++;
			        					
			        				} else {
			        					
			        					bool = true;
			        					
			        					break;
			        					
			        				}
			        				
			        			}
			        			
			        		}
		        			
		        		}  		
		        		
		        		
		        		if (bool == false){
		        			
		        			if (first_case == false){
		        				
		        				System.out.print(i);
		        				
		        				first_case = true;
		        				
		        				if (any_magic == false){
		        					
		        					any_magic = true;
		        					
		        				}
		        				
		        			} else {
		        			
		        				System.out.print(" "+i);
		        				
		        				if (any_magic == false){
		        					
		        					any_magic = true;
		        					
		        				}
		        				
		        			}	 			
		        			
		        			
		        		}
		        		
		        	}
		        	
		        	if (any_magic == false){
		        		
		        		System.out.print("-1");
		        		
		        	}
		        	
		        	System.out.println("");
		        	
		        }
			}
		}
	}
	
	private static int calculate_index(int digit, int length, int index){ 
		
		int new_index = 0;
		
		if (length == 2){
			
			if (index == 0){
				
				if (digit % 2 == 0){
					
					new_index = 0;
					
				} else {
					
					new_index = 1;
					
				}
				
				
			} else {
				
				if (digit % 2 == 0){
					
					new_index = 1;
					
				} else {
					
					new_index = 0;
					
				}
			}		
			
		} else {
			
			index = index - (length - 1);
			
			digit = digit + index;
			
			if (digit % length != 0){				
				
				new_index = digit % length - 1;
				
			} else {
				
				new_index = length - 1;
				
			}
			
		}
		
		return new_index;
		
	}
}

