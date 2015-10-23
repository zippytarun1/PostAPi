package MockServerService.PostApi;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reporter {
	
	private static List<Result> details;
	private static final String resultPlaceholder = "<!-- INSERT_RESULTS -->";
	private static final String templatePath = "C:\\1.html";
			
	public Reporter() {
	}
	
	public static void initialize() {
		
		details = new ArrayList<Result>();
 
	}
	
	public static void report(String apiname,String status,String statuscode) {
		
		
		if(status=="success") {
			Result r = new Result(apiname,status,statuscode);
			details.add(r);
		
			writeResults(apiname,status,statuscode);
			
		} 
		else {
			Result r = new Result(apiname,status,statuscode);
			details.add(r);
			
			writeResults(apiname,status,statuscode);
		}
	}
	
	public static  void writeResults(String apiname,String status,String statuscode) {
		try {
			String reportIn = new String(Files.readAllBytes(Paths.get(templatePath)));
			for (int i = 0; i < details.size();i++) {
				reportIn = reportIn.replaceFirst(resultPlaceholder,"<tr><td>" + Integer.toString(i+1) + "</td><td>"  + details.get(i).apiname(apiname) + "</td><td>" + details.get(i).getResult() + "</td>" + "</td><td>" + details.get(i).getStatuscode() + "</td></tr>" + resultPlaceholder);
			
			}
			
			
			String currentDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
			String reportPath = "C:\\report_" + currentDate + ".html";
			Files.write(Paths.get(reportPath),reportIn.getBytes(),StandardOpenOption.CREATE);
			
		} catch (Exception e) {
			System.out.println("Error when writing report file:\n" + e.toString());
		}
	}
}
