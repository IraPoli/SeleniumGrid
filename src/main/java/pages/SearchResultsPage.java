package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage {
    @FindBy(xpath = "//ul[contains(@class,'fake-tabs')]//a[contains(@href,'BIN=1')]")
    private WebElement buyItNowButton;

    @FindBy(xpath = "//img[contains(@class,'s-item')]")
    private List<WebElement> productList;

    @FindBy(xpath = "//input[@aria-label='Minimum Value in $']")
    private WebElement minimumPriceLimit;

    @FindBy(xpath = "//input[@aria-label='Maximum Value in $']")
    private WebElement maxPriceLimit;

    @FindBy(xpath = "//button[@aria-label='Submit price range']")
    private WebElement submitPriceRangeButton;

    @FindBy(xpath = "//a[@_sp='p2351460.m43632.l8566']")
    private WebElement priceRangeButton;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void clickBuyItNowButton() {
        buyItNowButton.click();
    }

    public void selectFirstProduct() {
        productList.get(0).click();
    }

    public void setMinPriceLimit(final String minimumPrice) {
        minimumPriceLimit.clear();
        minimumPriceLimit.sendKeys(minimumPrice);
    }

    public void setMaxPriceLimit(final String maxPrice) {
        maxPriceLimit.clear();
        maxPriceLimit.sendKeys(maxPrice);
    }

    public void clickSubmitPriceRangeButton() {
        submitPriceRangeButton.click();
    }

    public int getProductListLength() {
        return productList.size();
    }

    public WebElement getPriceRangeButton() {
        return priceRangeButton;
    }


}
