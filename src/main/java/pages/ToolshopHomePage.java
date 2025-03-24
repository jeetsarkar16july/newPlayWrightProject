package pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;

public class ToolshopHomePage {
	
	private final Page page;
	private final String PAGE_TITLE = "//h2[@data-test='page-title']";
	private final String PLIERS = "Pliers";
	private final String COMBINATION_PLIERS = "Combination Pliers";
	private final String SEARCH_FIELD = "Search";
	private final String SEARCH_BTN = "search-submit";
	private final String CATEGORIES_DROPDOWN ="Categories";
	private final String PLIER_IDENTIFIER  = ".card-body";
	private final String HAMMER_CHECKBOX = "//label/input[@type='checkbox']/ancestor::label[contains(text(),'Hammer')]";
	
	public ToolshopHomePage(Page page) {
        this.page = page;
    }
	
	public void openPliersSkuInfo() {
		
		page.getByText(COMBINATION_PLIERS);
		
	}
	
	public int countSkuPliers() {
		page.getByPlaceholder(SEARCH_FIELD).fill("Pliers");
//		page.locator("button:has-text('Search')").click();

		page.locator("//button[text()='Search']").click();
		page.waitForLoadState(LoadState.NETWORKIDLE);
		
		return page.locator(PLIER_IDENTIFIER).count();
		
	}
	
	
	public void selectCategoryCheckBox() {
		
		page.check(HAMMER_CHECKBOX);
		page.waitForLoadState(LoadState.NETWORKIDLE);
		PlaywrightAssertions.assertThat(page.getByText("Claw Hammer with Shock Reduction Grip")).isVisible();
		
		page.getByText("Claw Hammer with Shock Reduction Grip").click();
		page.locator("//span[@aria-label=\"unit-price\"]").textContent();
		
		PlaywrightAssertions.assertThat(page.locator("//span[@aria-label=\"unit-price\"]")).containsText("13.41");
		
				
	}
	
	public String selectCategories() {
		
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(CATEGORIES_DROPDOWN)).click();
		page.locator("a[data-test*='power-tools']").click();
		return page.locator(PAGE_TITLE).innerText();
	}
	
}
