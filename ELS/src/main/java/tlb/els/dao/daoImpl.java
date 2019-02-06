package tlb.els.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import tlb.els.model.Customer;
import tlb.els.model.Equipment;
import tlb.els.model.Lease;

/**
 *
 * @author tylerbates
 */
public class daoImpl implements dao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    private static final class statements {
        
        private static final String SQL_SELECT_EQUIPMENT_BY_ID
            = "SELECT * FROM Equipment WHERE idEquipment = ?";
        
        private static final String SQL_SELECT_ALL_EQUIPMENT
            = "SELECT * FROM Equipment";
        
        private static final String SQL_INSERT_EQUIPMENT
            = "INSERT INTO Equipment (Make, Model, Year, VinNum, "
                + "PurchaseDate, Available, Active, GPSNum, Tag)"
                + "VALUES (?,?,?,?,?,?,?,?,?)";
        
        private static final String SQL_UPDATE_EQUIPMENT
            = "UPDATE Equipment SET make = ?, model = ?, year = ?,"
                + "VinNum = ?, PurchaseDate = ?, Available = ?, "
                + "Active = ?, GPSNum = ?, Tag = ? WHERE idEquipment = ?";
        
        private static final String SQL_DELETE_EQUIPMENT_BY_ID
            = "DELETE FROM Equipment WHERE idEquipment = ?";
    }

    @Override
    public Equipment getEquipmentById(int idEquip) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Equipment> getAllEquipment() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addEquipment(Equipment equipment) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateEquipment(Equipment equipment) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteEquipmentById(int idEquip) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
    
    
    @Override
    public Lease getLeaseById(int idLease) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Lease> getAllLeases() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addLease(Lease lease) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateEquipment(Lease lease) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteLeaseById(int idLease) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
    
    
    @Override
    public Customer getCustomerById(int idCustomer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Customer> getAllCustomers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addCustomer(Customer customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateCustomer(Customer customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteCustomerById(int idCustomer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class mappers {

        private static final class EquipmentMapper implements RowMapper<Equipment> {

            @Override
            public Equipment mapRow(ResultSet rs, int i) throws SQLException {
                Equipment equipment = new Equipment();
                equipment.setIdEquip(rs.getInt("idEquipment"));
                equipment.setMake(rs.getString("Make"));
                equipment.setModel(rs.getString("Model"));
                equipment.setYear(rs.getInt("Year"));
                equipment.setVinNum(rs.getString("VinNum"));
                equipment.setAvailable(rs.getBoolean("Available"));
                equipment.setActive(rs.getBoolean("Active"));
                equipment.setPurchaseDate(rs.getString("PurchaseDate"));
                equipment.setGpsNum(rs.getString("GPSNum"));
                equipment.setTagNum(rs.getString("Tag"));
                return equipment;
            }

        }
        
        private static final class LeaseMapper implements RowMapper<Lease> {

            @Override
            public Lease mapRow(ResultSet rs, int i) throws SQLException {
                Lease lease = new Lease();
                lease.setIdLease(rs.getInt("idLease"));
                lease.setBegDate(rs.getString("BeginningRent"));
                lease.setEndDate(rs.getString("EndRent"));
                lease.setHasRecInsurance(rs.getBoolean("InsuranceRecieved"));
                return lease;
            }

        }
        
        private static final class CustomerMapper implements RowMapper<Customer> {

            @Override
            public Customer mapRow(ResultSet rs, int i) throws SQLException {
                Customer customer = new Customer();
                customer.setIdCustomer(rs.getInt("idCustomer"));
                customer.setName(rs.getString("Name"));
                customer.setAddress(rs.getString("Address"));
                customer.setCity(rs.getString("City"));
                customer.setState(rs.getString("State"));
                customer.setZip(rs.getString("Zip"));
                customer.setInsurance(rs.getString("InsuranceCarrier"));
                customer.setPolicyNum(rs.getString("PolicyNum"));
                customer.setPolicyExp(rs.getString("PolicyExpiration"));
                return customer;
            }

        }
    }
}
