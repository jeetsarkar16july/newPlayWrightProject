package htmltables;

import java.util.List;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HtmlTable1 {
	
	private final Page page;
	private final String PLIERS = "Pliers";
	
	public HtmlTable1(Page page) {
		
		this.page = page;	
	}
	
	public void fetchFirstRowOfSemanticallyCorrectTable() {
		

		int size = page.locator("//table[@class='table table-bordered']/tbody/tr").count();
				
		for(int i=1;i<=size;i++) {
		 String name = page.locator("table[class='table table-bordered'] tbody  tr:nth-of-type("+i+")").locator(" td:nth-of-type(2)").textContent();	
//		 String name = page.locator("//table[@class='table table-bordered']/tbody/tr["+i+"]/td[2]").textContent();
		 
		 
		 System.out.println(name);	
		}
		
	}
	
	

}
