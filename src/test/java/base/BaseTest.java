package base;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import io.restassured.RestAssured;
import tests.UI_Tests;
import utils.Log;

public class BaseTest {
	protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;
    
    private static Properties properties = new Properties();


    static {
    	InputStream input = BaseTest.class.getClassLoader().getResourceAsStream("config.properties");
		try {
			properties.load(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
	@BeforeClass
    public void setup() {
		
		if(this.getClass().getSimpleName().contains("UI") || this instanceof UI_Tests) {
		 	
		  Log.info("........UI tests ON.......");	
			 playwright = Playwright.create();
		     browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		     context = browser.newContext();
		     page = context.newPage();
		     
		} else {
			Log.info("........API tests ON.......");			

	        // Set default request specification
	        RestAssured.requestSpecification = RestAssured.given()
	                .header("Content-Type", "application/json")
	                .header("Accept", "application/json") 
	                .auth().basic("Jeet", "Jeets111$")
	                .log().all(); // Log requests for debugging
			
		}
       
    }
	
	@AfterClass
    public void tearDown() {
		
		if(this.getClass().getSimpleName().contains("UI") || this instanceof UI_Tests) {
	        if (page != null) page.close();
	        if (context != null) context.close();
	        if (browser != null) browser.close();
	        if (playwright != null) playwright.close();
		}
	    
    }
	
	public static String getBaseUrl() {
        return properties.getProperty("base.url").trim();
    }
}
