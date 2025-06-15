package dataprovider;

import org.testng.annotations.DataProvider;

public class BookingDataProvider {

    @DataProvider(name = "bookingData")
    public Object[][] bookingData() {
        return new Object[][] {
            {"Ravi", "Kumar"},
            {"Priya", "Sharma"},
            {"John", "Doe"},
            {"Alice", "Wonder"}
        };
    }
}
