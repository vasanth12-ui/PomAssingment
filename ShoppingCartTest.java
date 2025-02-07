package TestNG;

import base.BaseTest;
import PageObject.CartPage;
import PageObject.InventoryPage;
import PageObject.loginpage1;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingCartTest extends BaseTest {

    @Test
    public void testAddItemToCart() {
        loginpage1 loginPage = new loginpage1(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        // Verify landing page title
        Assert.assertEquals(loginPage.getPageTitle(), "Swag Labs");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addItemToCart();
        inventoryPage.goToCart();

        CartPage cartPage = new CartPage(driver);
        String cartItemName = cartPage.getCartItemName();

        // Verify that the correct item is added to the cart
        Assert.assertEquals(cartItemName, "Sauce Labs Backpack");
    }
}
