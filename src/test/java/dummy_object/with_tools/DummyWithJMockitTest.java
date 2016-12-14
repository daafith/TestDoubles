package dummy_object.with_tools;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import app.dummy_object.Asset;
import app.dummy_object.CheckInSheet;
import app.dummy_object.Pawner;
import mockit.FullVerifications;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
public class DummyWithJMockitTest {

  @Mocked
  private Pawner dummyPawner;

  @Test
  public void check_in_sheet_should_add_line_item() {
    final int NUMBER_OF_ITEMS = 1;
    Asset asset = new Asset("Dummy Asset Name");
    CheckInSheet checkInSheet = new CheckInSheet(dummyPawner);

    checkInSheet.add(asset);
    
    List<Asset> lineItems = checkInSheet.getLineItems();
    assertEquals("number of items on the check in sheet", NUMBER_OF_ITEMS, lineItems.size());
    assertEquals("the right item on the check in sheet", asset, lineItems.get(0));

    new FullVerifications(dummyPawner) {};
  }

}
