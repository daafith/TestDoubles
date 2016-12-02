package app.dummy_object;

import java.util.ArrayList;
import java.util.List;

/**
 * Imagine a pawn shop that needs to keep track of what the customer sells to the shop.<br>
 */
public class CheckInSheet {

  private final List<Asset> assets;
  private final Customer customer;
  
  public CheckInSheet(Customer customer) {
    this.customer = customer;
    assets = new ArrayList<>();
  }

  public void add(Asset asset) {
      assets.add(asset);      
  }

  public List<Asset> getLineItems() {
    return assets;
  }
  
  @Override
  /**
   * This will result in a runtime exception if used with the dummy customer.<b>
   */
  public String toString() {
    StringBuilder sb = new StringBuilder();
    assets.forEach(p -> sb.append(p.getAssetDescription()).append("\t")); 
    return String.format("%s checked in the following asset(s) %s", customer.getFullName(), sb.toString());
  }
  
}
