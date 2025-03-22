package tests;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.annotations.Test;

import base.BaseTest;
import htmltables.HtmlTable1;
import pages.ToolshopHomePage;
import utils.Log;

public class UI_Tests extends BaseTest{
	
	@Test
    public void testOpenPlierInfo() {
//        page.navigate("https://practicesoftwaretesting.com/");
		System.out.println("My url : " + getBaseUrl());
		
		page.navigate(getBaseUrl());
	
        ToolshopHomePage toolsPage = new ToolshopHomePage(page);
        toolsPage.openPliersSkuInfo();
    }
	
	@Test
    public void testCountPlierTypes() {
        page.navigate("https://practicesoftwaretesting.com/");
        ToolshopHomePage toolsPage = new ToolshopHomePage(page);
        System.out.println("Number of Pliers SKU : " + toolsPage.countSkuPliers()) ;
    }
	
	@Test
	public void testToInteractWithCheckBox() {
		Log.info("Test Started");
		
		page.navigate("https://practicesoftwaretesting.com/");
		ToolshopHomePage toolsPage = new ToolshopHomePage(page);
		toolsPage.selectCategoryCheckBox();
		
		Log.error("Test Ended");
	}
	
		
	@Test
	public void htmlTableTest() {
			Log.info("Test Started");
			
			page.navigate("https://webscraper.io/test-sites/tables/tables-semantically-correct");
			HtmlTable1 table = new HtmlTable1(page);
			table.fetchFirstRowOfSemanticallyCorrectTable();
			
			Log.error("Test Ended");
		}
	
	public static void main(String[] args) {
		
		Properties prop = new Properties();


	    	InputStream input = UI_Tests.class.getClassLoader().getResourceAsStream("config.properties");
			try {
				prop.load(input);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			System.out.print("My url : "+prop.getProperty("base.url"));
    	}


}
