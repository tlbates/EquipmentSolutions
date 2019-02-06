
package tlb.els.model;

import java.util.List;
import lombok.Data;

/**
 *
 * @author tylerbates
 */
@Data
public class Lease {

    private int idLease;
    private String begDate;
    private String endDate;
    private boolean hasRecInsurance;
    private List<Equipment> equipment;
    private Customer customer;
    
}
