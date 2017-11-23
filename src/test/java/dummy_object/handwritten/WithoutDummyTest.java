package dummy_object.handwritten;

import static data_fixtures.TestLiteralUtil.getUniqueText;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import app.dummy_object.Address;
import app.dummy_object.CheckInSheet;
import app.dummy_object.City;
import app.dummy_object.Pawner;
import app.dummy_object.Asset;
import app.dummy_object.Province;

public class WithoutDummyTest {

  @Test
  public void check_in_sheet_should_add_line_item() {
    final int NUMBER_OF_ITEMS = 1;
    Asset asset = new Asset(getUniqueText());      
    // four lines of unnecessary setup
    Province province = new Province("Zuid Holland", "ZH");      
    City city = new City("The Hague", province);
    Address address = new Address("Spui 138", city, "2525 TT");
    Pawner pawner = new Pawner(getUniqueText(), getUniqueText(), address);
    
    CheckInSheet checkInSheet = new CheckInSheet(pawner);     

    checkInSheet.add(asset);

    List<Asset> lineItems = checkInSheet.getLineItems();
    assertEquals("number of items on the check in sheet", NUMBER_OF_ITEMS, lineItems.size());
    assertEquals("the right item on the check in sheet", asset, lineItems.get(0));
  }

}
