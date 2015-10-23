package MockServerService.PostApi;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.mysql.jdbc.Statement;






public class App 
{

    public static void main( String[] args ) throws Exception
    
    
    {
/*
        Boolean result=false;
        String statuscode=null;
    	Readfile r1=new Readfile();
    	
       FeatureMapAPI a1=new FeatureMapAPI();
     
       String propertyfolderpath="c://PostApi//test.properties";
        String baseapiresponsefolderpath="F://apiresponses/";
        String newapiresponsepath="f://newapiresponsepath/";

	
        statuscode=a1.postapiadapter(r1.readpropertyvariable("featureURL",propertyfolderpath),r1.readpropertyvariable("featureparam",propertyfolderpath));
        statuscode=statuscode.substring(0,13);
        comparejsondata c1=new comparejsondata();
        result=c1.comparejsonData("getApiFeatureMap",baseapiresponsefolderpath,newapiresponsepath);

        Reporter.initialize(); 
        if (result.equals(true)) 
        {
        	
            Reporter.report("getApiFeatureMap","success",statuscode);   
    		

        }
        
        if (result.equals(false)) 
        {
        	
            Reporter.report("getApiFeatureMap","fail",statuscode);   
    	

        }
        
        a1.postapiadapter(r1.readpropertyvariable("pushbyemail",propertyfolderpath),r1.readpropertyvariable("pushbyemailparam",propertyfolderpath));
      
        result=c1.comparejsonData("pushbyemail",baseapiresponsefolderpath,newapiresponsepath);

        if (result.equals(true)) 
        {
        	
            Reporter.report("pushbyemail","success",statuscode);   
    		

        }
        
        if (result.equals(false)) 
        {
        	
            Reporter.report("pushbyemail","fail",statuscode);   
    	

        }
       */
        SSHManager sh = new SSHManager();
		sh.myStart("52.74.109.177","tk5674","20.0.0.65",3306,3307);
		commondbmanager cdbm=new commondbmanager();
		Connection conn=cdbm.initiateDbconnection("com.mysql.jdbc.Driver","jdbc:mysql://127.0.0.1:3306/snapdealmobileapi","tk5674IU","tk@5674");
		cdbm.datafetchfromquery(conn,"snapdeal_property","name","");
		
        
    }
}

    
