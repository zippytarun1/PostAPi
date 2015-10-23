package MockServerService.PostApi;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Saveobject {
	
	
	public String saveobjecttofile(String data,String filename) throws IOException
	
	
	{

		 Readfile a1=new Readfile();
		 String filenames=a1.readpropertyvariable("files","c://PostApi//test.properties")+"/"+filename+".txt";
		
		 File file = new File(filenames);
		 
	FileWriter fr=new FileWriter(file);	
	fr.write(data);
	fr.close();
	
	return "hello";
		
	}

}
