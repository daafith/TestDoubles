package dummy_object;

import static data_fixtures.ValuePatterns.getUniqueNumber;
import static data_fixtures.ValuePatterns.getUniqueNumberAsString;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import app.dummy_object.Address;
import app.dummy_object.CheckInSheet;
import app.dummy_object.City;
import app.dummy_object.Customer;
import app.dummy_object.Product;
import app.dummy_object.Province;

public class WithoutDummy {

  @Test
  public void expect_check_in_sheet_to_add_line_item() {
    final int QUANTITY = 1;
    Product product = new Product(getUniqueNumberAsString(), getUniqueNumber());      
    Province province = new Province("Zuid Holland", "ZH");      
    City city = new City("The Hague", province);
    Address address = new Address("Spui 138", city, "2525 TT");
    Customer customer = new Customer(getUniqueNumberAsString(), getUniqueNumberAsString(), address);
    CheckInSheet checkInSheet = new CheckInSheet(customer);     
    
    checkInSheet.add(product, QUANTITY);
    
    List<Product> lineItems = checkInSheet.getLineItems();
    assertEquals("number of items on the check in sheet", QUANTITY, lineItems.size());
    assertEquals("the right item on the check in sheet", product, lineItems.get(0));
  }

}
