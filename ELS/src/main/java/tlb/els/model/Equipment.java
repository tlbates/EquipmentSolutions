
package tlb.els.model;

import lombok.Data;

/**
 *
 * @author tylerbates
 */
@Data
public class Equipment {
    
    private int idEquip;
    private String make;
    private String model;
    private int year;
    private String vinNum;
    private String purchaseDate;
    private boolean available;
    private boolean active;
    private String gpsNum;
    private String tagNum;
    
}
