import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class FizzBuzz {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String filedirectory = new File("").getAbsolutePath();
		
		File file = null;
		file = new File(filedirectory);
		String[] paths = file.list();
		String extension;
		String new_extension = "txt";
		String filedirectory_temp;		
		int i = 0;
		
		for (String path: paths){
			
			extension = path.substring(path.lastIndexOf(".") + 1, path.length());
			
			if (extension.equals(new_extension)){
				
				filedirectory_temp = filedirectory + "\\" + path;
				file = new File(filedirectory_temp);
				@SuppressWarnings("resource")
				BufferedReader buffer = new BufferedReader(new FileReader(file));
		        
				String line;
				
		        StringTokenizer stringtokenizer = null;
		        String string;
		        int[] array = new int[3];
		        
		        while ((line = buffer.readLine()) != null) {
		            
		        	line = line.trim();		            
		        	
		            // Process line of input Here
		        	stringtokenizer = new StringTokenizer(line, " ");
		        	
		        	while(stringtokenizer.hasMoreElements()){
		        		
		        		string = stringtokenizer.nextToken();
		        		
		        		array[i] = Integer.parseInt(string);
		        		
		        		i++;
		        		
		        	}
		        	
		        	i = 0;
		        	
		        	for (int j = 1; j <= array[2]; j++){
		        		
		        		if ( (j % array[0] == 0) && (j % array[1] == 0) ){ 
		        			
		        			System.out.print("FB ");
		        			
		        		} else {
		        			
		        			if (j % array[0] == 0){
		        				System.out.print("F ");
			        		}
			        		
		        			else if (j % array[1] == 0){
			        			System.out.print("B ");
			        		}
			        		
		        			else {
		        				System.out.print(j+" ");
		        			}
			        		
		        		}   		        		
		        		
		        	}
		        	
		        	System.out.println("");
		        	
		        }
			}
		}
	}

}
