package MockServerService.PostApi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;


public class comparejsondata {

	
	public boolean comparejsonData(String filename,String baseapiresponsefilepath,String newapiresponsefilepath) throws IOException
	{
		
		Readfile r1=new Readfile();
		boolean status=false;
		
		//base api response//

		String baseapiresponse=r1.Readfiledata(filename,baseapiresponsefilepath);
		String newapiresponse=r1.Readfiledata(filename,newapiresponsefilepath);
		
		
		status=newapiresponse.equals(baseapiresponse);
		return status;
		
	}
		
	
	
	
		}
		
		
		
		

