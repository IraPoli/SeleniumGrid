package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SmokeTests extends BaseTest {


    private static final long DEFAULT_WAITING_TIME = 90;
    private static final String EXPECTED_AMOUNT = "1";
    private static final String MIN_PRICE = "500";
    private static final String MAX_PRICE = "500";
    private static final int PRODUCT_AMOUNT = 5;

    @Test
    public void checkMainFunctionsOnHomePage() {
        getHomePage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getHomePage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);
        getHomePage().isHeaderVisible();
        getHomePage().isFooterVisible();
        getHomePage().isSearchFieldVisible();
        getHomePage().isRegisterButtonVisible();
        assertTrue(getHomePage().isSignInVisible());

    }

    @Test
    public void checkAddProductToCart() {
        getHomePage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getHomePage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);
        getHomePage().isSearchFieldVisible();
        getHomePage().enterTextToSearchField("poc helmet");
        getHomePage().clickSearchButton();
        getSearchResultsPage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getSearchResultsPage().clickBuyItNowButton();
        getSearchResultsPage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getSearchResultsPage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);
        getSearchResultsPage().selectFirstProduct();
        getProductPage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getProductPage().waitVisibilityOfElement(DEFAULT_WAITING_TIME, getProductPage().getAddToCartButton());
        getProductPage().clickAddToCartButton();
        getHomePage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getSearchResultsPage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);
        getHomePage().waitVisibilityOfElement(DEFAULT_WAITING_TIME, getHomePage().getCartListProductsCount());
        assertEquals(getHomePage().getAmountOfProductsInCartList(), EXPECTED_AMOUNT);


    }

    @Test
    public void checkFilterProductPage() {
        getHomePage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getHomePage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);
        getHomePage().isSearchFieldVisible();
        getHomePage().enterTextToSearchField("lego robot");
        getHomePage().clickSearchButton();
        getSearchResultsPage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getSearchResultsPage().setMinPriceLimit(MIN_PRICE);
        getSearchResultsPage().setMaxPriceLimit(MAX_PRICE);
        getSearchResultsPage().clickSubmitPriceRangeButton();
        getSearchResultsPage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getSearchResultsPage().waitVisibilityOfElement(DEFAULT_WAITING_TIME, getSearchResultsPage().getPriceRangeButton());
        int ans = getSearchResultsPage().getProductListLength();
        assertEquals(ans, PRODUCT_AMOUNT);
    }

}
