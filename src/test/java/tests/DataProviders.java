package tests;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "DataForPost")
    public Object[][] dataForPost() {
        return new Object[][] {
                {"Albert", "Einstein", 2},
                {"Thomas", "Edison", 1}
        };
    }

    @DataProvider(name = "DataForDelete")
    public Object[][] dataForDelete() {
        return new Object[][] {
                {4}, {5}
        };
    }
}
