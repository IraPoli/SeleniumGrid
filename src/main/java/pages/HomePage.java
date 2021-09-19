package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//header")
    private WebElement header;

    @FindBy(xpath = "//footer")
    private WebElement footer;

    @FindBy(xpath = "//input[contains(@class,'input')]")
    private WebElement searchField;

    @FindBy(xpath = "//a[contains(@href, 'reg.ebay')]")
    private WebElement registerButton;

    @FindBy(xpath = "//span[@id='gh-ug']//a[contains(@href, 'signin.ebay')]")
    private WebElement signInButton;

    @FindBy(xpath = "//*[@id='gh-btn']")
    private WebElement searchButton;

    @FindBy(xpath = "//a[contains(@class, 'cart-count')]")
    private WebElement cartIconCount;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void isHeaderVisible() {
        header.isDisplayed();
    }

    public void isFooterVisible() {
        footer.isDisplayed();
    }

    public void isSearchFieldVisible() {
        searchField.isDisplayed();
    }

    public void isRegisterButtonVisible() {
        registerButton.isDisplayed();
    }


    public boolean isSignInVisible() {
        return signInButton.isDisplayed();
    }

    public void enterTextToSearchField(final String searchText) {
        searchField.clear();
        searchField.sendKeys(searchText);
    }

    public void clickSearchButton() {
        searchButton.click();
    }


    public WebElement getCartListProductsCount() {
        return cartIconCount;
    }

    public String getAmountOfProductsInCartList() {
        return cartIconCount.getText();
    }

}
