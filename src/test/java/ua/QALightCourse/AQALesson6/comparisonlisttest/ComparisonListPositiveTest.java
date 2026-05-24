package ua.QALightCourse.AQALesson6.comparisonlisttest;

import ua.QALightCourse.AQALesson6.basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import ua.QALightCourse.AQALesson6.pages.HomePage;
import ua.QALightCourse.AQALesson6.pages.SearchResultPage;
import ua.QALightCourse.AQALesson6.pages.ComparisonListPage;
import java.util.List;

public class ComparisonListPositiveTest extends BaseTest {

    @Test
    public void shouldAddProductsToComparisonList() {
        String selectedProduct = "iPhone 17 Pro Max";
        List<String> listOfSelectedProductModels = List.of("256GB Silver", "512GB Silver");

        HomePage homePage = new HomePage(getDriver());
        homePage.searchProduct(selectedProduct);

        SearchResultPage searchResultPage = new SearchResultPage(getDriver());
        searchResultPage.addSelectedProductToComparisonList(listOfSelectedProductModels);
        searchResultPage.openComparisonListDetails();

        ComparisonListPage comparisonListPage = new ComparisonListPage(getDriver());
        List<String> addedProducts = comparisonListPage.getListOfAddedProducts();

        listOfSelectedProductModels
                .forEach(model ->
                        Assert.assertTrue(addedProducts.stream().anyMatch(p -> p.contains(model)),
                                "Product not found: " + model
                        )
                );
    }
}
