import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidation {

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
				
				Pattern pattern;
				Matcher matcher;
			 
				final String EMAIL_PATTERN = 
					"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
					+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		        
				
				pattern = Pattern.compile(EMAIL_PATTERN);
				
		        while ((line = buffer.readLine()) != null) {		        	
		            
		        	line = line.trim();		            
		        	
		        	stringtokenizer = new StringTokenizer(line, " ");
		        	
		        	if (stringtokenizer.countTokens() > 1){
		        		
		        		System.out.println("false");
		        		
		        	} else{
		        		
		        		matcher = pattern.matcher(line);
		        		
		        		if (matcher.matches()){
		        			
		        			System.out.println("true");
		        			
		        		} else {
		        			
		        			System.out.println("false");
		        			
		        		}
		        		
		        	}
		        	
		        }
			}
		}
	}
}

