package MockServerService.PostApi;


public class Result {
	
	private String status;
	private String apiname;

	private String statuscode;
	
	public Result(String apiname,String status,String statuscode) {
		this.apiname = apiname;
		this.status = status;
		this.statuscode=statuscode;
	}
	
	
	public String getResult() {
		return this.status;
	}
	
	public String apiname(String apiname) {
		return this.apiname;
	}
	
	
	public String getStatuscode() {
		return this.statuscode;
	}
	
		
}
