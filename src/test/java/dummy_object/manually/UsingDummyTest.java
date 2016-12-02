package dummy_object.manually;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import app.dummy_object.CheckInSheet;
import app.dummy_object.Asset;

public class UsingDummyTest {
  
  /**
   * This test uses two dummy objects.<br>
   * Now we don't need as much setup.<br>
   * The first dummy object is "Dummy Asset Name" which is a self-describing value.<br>
   * The second is new DummyPawner().
   */

  @Test
  public void check_in_sheet_should_add_line_item() {
    final int NUMBER_OF_ITEMS = 1;
    Asset asset = new Asset("Dummy Asset Name");      
    CheckInSheet checkInSheet = new CheckInSheet(new DummyPawner());     
    
    checkInSheet.add(asset);
    
    List<Asset> lineItems = checkInSheet.getLineItems();
    assertEquals("number of items on the check in sheet", NUMBER_OF_ITEMS, lineItems.size());
    assertEquals("the right item on the check in sheet", asset, lineItems.get(0));
  }
  
  
  /**
   * Example of dummy rejection
   * @throws Exception
   */
  
  @Test(expected = RuntimeException.class)
  public void reject_dummy_when_used_in_SUT() throws Exception {
    new CheckInSheet(new DummyPawner()).toString();
  }

}
