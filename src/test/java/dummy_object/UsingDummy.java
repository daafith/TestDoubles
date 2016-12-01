package dummy_object;

import static data_fixtures.ValuePatterns.getUniqueNumber;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import app.dummy_object.CheckInSheet;
import app.dummy_object.Product;

public class UsingDummy {
  
  /**
   * This test uses two dummy objects.<br>
   * Now we don't need as much setup.<br>
   * The first dummy object is "Dummy Product Name" which is a self-describing value.<br>
   * The second is new DummyCustomer().
   */

  @Test
  public void expect_check_in_sheet_to_add_line_item_using_dummy() {
    final int QUANTITY = 1;
    Product product = new Product("Dummy Product Name", getUniqueNumber());      
    CheckInSheet checkInSheet = new CheckInSheet(new DummyCustomer());     
    
    checkInSheet.add(product, QUANTITY);
    
    List<Product> lineItems = checkInSheet.getLineItems();
    assertEquals("number of items on the check in sheet", QUANTITY, lineItems.size());
    assertEquals("the right item on the check in sheet", product, lineItems.get(0));
  }

}
