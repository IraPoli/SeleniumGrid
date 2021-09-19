package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    @FindBy(xpath = "//a[contains(@class, 'btn btn-scnd')]")
    private WebElement addToCartButton;


    private WebElement continueToCartButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

}
