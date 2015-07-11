import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LCS {

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
		        
		        while ((line = buffer.readLine()) != null) {		        	
		            
		        	line = line.trim();		 
		        	
		        	if (line != null &&  !line.isEmpty()){
		        		
		        		String[] multiple = line.split(";", 2);
			        	
			        	String first_string = multiple[0];
			        	
			        	String second_string = multiple[1];
			        	
			        	Character[] string_one = new Character[first_string.length() + 1];
			        	
			        	Character[] string_two = new Character[second_string.length() + 1];
			        	
			        	string_one[0] = ' ';
			        	
			        	string_two[0] = ' ';
			        	
			        	for (int i = 0; i < first_string.length(); i++){
			        		
			        		string_one[i+1] = first_string.charAt(i);
			        		
			        	}
			        	
			        	for (int i = 0; i < second_string.length(); i++){
			        		
			        		string_two[i+1] = second_string.charAt(i);
			        		
			        	}
			        	
			        	String[][] direction = new String[first_string.length()][second_string.length()];
			        	
			        	Integer[][]	data = new Integer[first_string.length() + 1][second_string.length() + 1];
			        	
			        	for (int i = 0; i <= first_string.length(); i++){
			        		
			        		for (int j = 0; j <= second_string.length(); j++){
			        			
			        			data[i][j] = 0;
			        			
			        		}		        		
			        		
			        		
			        	}
			        	
			        	for (int i = 1 ; i <= first_string.length(); i++){
			        		
			        		for(int j = 1; j <= second_string.length(); j++){
			        			
			        			if (string_one[i] == string_two[j]){
			        				
			        				data[i][j] = data[i - 1][j - 1] + 1;
			        				
			        				direction[i - 1][j - 1] = "side";
			        				
			        			} else if (data[i - 1][j] >= data[i][j - 1]){
			        				
			        				data[i][j] = data[i - 1][j];
			        				
			        				direction[i - 1][j - 1] = "up";
			        				
			        			} else if (data[i][j] < data[i][j - 1]){
			        				
			        				data[i][j] = data[i][j - 1];
			        				
			        				direction[i - 1][j - 1] = "left";
			        				
			        			}			        			
			        			
			        		}
			        		
			        	}
			        	
			        	print_lcs(direction, first_string, first_string.length() - 1, second_string.length() - 1);
			        	
			        	System.out.println("");
			        	
		        	}    		        	
		        	
		        }
		        
		        
			}
		}
	}
	
	private static void print_lcs(String[][] direction, String string, int first_length, int second_length){
		
		if ( first_length == -1 || second_length == -1){
			
			return;
			
		}
		
		if (direction[first_length][second_length] == "side"){
			
			print_lcs(direction,string,first_length - 1, second_length - 1);
			
			System.out.print(string.charAt(first_length));
			
		} else if (direction[first_length][second_length] == "up"){
			
			print_lcs(direction, string, first_length - 1, second_length);
			
		} else {
			
			print_lcs(direction, string, first_length , second_length - 1);
			
		}		
		
	}
}

