package ua.QALightCourse.AQALesson6.categoriestest;

import ua.QALightCourse.AQALesson6.basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import ua.QALightCourse.AQALesson6.pages.CategoryProductsPage;
import ua.QALightCourse.AQALesson6.pages.CategoryPage;
import ua.QALightCourse.AQALesson6.pages.HomePage;
import ua.QALightCourse.AQALesson6.pages.ProductPage;

public class CategoryNavigationPositiveTest extends BaseTest {

    @Test
    public void shouldFindProductFromCategory() {
        String categoriesSelection = "Авто і Мото";
        String subCategory = "Мотошини";
        String product = "Pirelli Angel GT (180/55R17 73W)";

        HomePage homePage = new HomePage(getDriver());
        homePage.openCategoryFromIcons(categoriesSelection);

        CategoryPage categoryPage = new CategoryPage(getDriver());
        categoryPage.selectSubCategory(subCategory);

        CategoryProductsPage categoryProductsPage = new CategoryProductsPage(getDriver());
        categoryProductsPage.openProduct(product);

        ProductPage productPage = new ProductPage(getDriver());
        Assert.assertTrue(productPage.getProductTitle().contains(product));
    }
}
