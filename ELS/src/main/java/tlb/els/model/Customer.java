
package tlb.els.model;

import lombok.Data;

/**
 *
 * @author tylerbates
 */
@Data
public class Customer {
    
    private int idCustomer;
    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String insurance;
    private String policyNum;
    private String policyExp;
    
}
