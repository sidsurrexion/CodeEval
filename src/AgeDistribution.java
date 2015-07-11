import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class AgeDistribution {

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
				
				int i = 0;
		        
		        while ((line = buffer.readLine()) != null) {		        	
		            
		        	line = line.trim();		            
		        	
		            // Process line of input Here		       
		        	i = Integer.parseInt(line);
		        	
		        	if ( i < 0 || i > 100){
		        		System.out.println("This program is for humans");
		        	} else if (i>=0 && i <= 2){
		        		System.out.println("Still in Mama's arms");
		        	} else if ( i ==3 || i == 4){
		        		System.out.println("Preschool Maniac");
		        	} else if (i>=5 && i<=11){
		        		System.out.println("Elementary school");
		        	} else if (i>=12 && i<=14){
		        		System.out.println("Middle school");
		        	}  else if (i>=15 && i<=18){
		        		System.out.println("High school");
		        	} else if (i>=19 && i<=22){
		        		System.out.println("College");
		        	} else if (i>=23 && i<=65){
		        		System.out.println("Working for the man");
		        	} else if (i>=66 && i<=100){
		        		System.out.println("The Golden Years");
		        	}
		        	
		        }
			}
		}
	}
}

