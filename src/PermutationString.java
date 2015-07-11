import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class PermutationString {

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
		            
		        	line = line.trim();		            
		        	
		        	count = 0;
		        	
		        	StringBuilder stringbuilder = new StringBuilder(line);
		        	
		        	Map<String, Integer> tree_value = new TreeMap<String, Integer>();
		        	
		        	permutation(stringbuilder, line.length(), tree_value);
		        	
		        	for (String string: tree_value.keySet()){
		        		
		        		count++;
		        		
		        		if (count == tree_value.size()){
		        			
		        			System.out.print(string);
		        			
		        		} else {
		        		
		        			System.out.print(string+",");
		        			
		        		}
		        		
		        		
		        	}
		        	
		        	System.out.println("");
		        	
		        }
			}
		}
	}
	
	private static void permutation(StringBuilder stringbuilder, int index_value, Map<String, Integer> tree_value){
		
		if (index_value <= 0){
			
			tree_value.put(stringbuilder.toString(), 1);
			
		} else{
			
			permutation(stringbuilder, index_value - 1, tree_value);
			
			int position = stringbuilder.length() - index_value;
			
			for ( int y = position + 1; y < stringbuilder.length(); y++){
				
				swap_characters(stringbuilder, position, y);
				
				permutation(stringbuilder, index_value - 1, tree_value);
				
				swap_characters(stringbuilder, y, position);
				
			}
			
		}
		
	}
	
	private static void swap_characters(StringBuilder stringbuilder, int source_position, int destination_position){
		
		char ch = stringbuilder.charAt(source_position);
		
		stringbuilder.setCharAt(source_position, stringbuilder.charAt(destination_position));
		
		stringbuilder.setCharAt(destination_position, ch);
		
	}
}

