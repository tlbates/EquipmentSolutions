package tlb.els.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import tlb.els.model.Customer;
import tlb.els.model.Equipment;
import tlb.els.model.Lease;

/**
 *
 * @author tylerbates
 */
public class DaoImpl implements Dao {

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
                + "PurchaseDate, Available, Active, GPSNum, Tag) "
                + "VALUES (?,?,?,?,?,?,?,?,?)";
        
        private static final String SQL_UPDATE_EQUIPMENT
            = "UPDATE Equipment SET make = ?, model = ?, year = ?,"
                + "VinNum = ?, PurchaseDate = ?, Available = ?, "
                + "Active = ?, GPSNum = ?, Tag = ? WHERE idEquipment = ?";
        
        private static final String SQL_DELETE_EQUIPMENT_BY_ID
            = "DELETE FROM Equipment WHERE idEquipment = ?";
        
        
        private static final String SQL_SELECT_LEASE_BY_ID
            = "SELECT * FROM Lease WHERE idLease = ?";
        
        private static final String SQL_SELECT_ALL_LEASES
            = "SELECT * FROM Lease";
        
        private static final String SQL_INSERT_LEASE
            = "INSERT INTO Lease (BeginningRent, EndRent, InsuranceRecieved,"
                + "CustomerNum) VALUES (?,?,?,?)";
        
        private static final String SQL_UPDATE_LEASE
            = "UPDATE Equipment SET BeginningRent = ?, EndRent = ?,"
                + "InsuranceRecieved = ?, CustomerNum = ? WHERE idLease = ?";
        
        private static final String SQL_DELETE_LEASE
            = "DELETE FROM Lease WHERE idLease = ?";
        
        private static final String SQL_SELECT_CUSTOMER_BY_ID
            = "SELECT * FROM Customer WHERE idCustomer = ?";
        
        private static final String SQL_SELECT_ALL_CUSTOMERS
            = "SELECT * FROM Customer";
        
        private static final String SQL_INSERT_CUSTOMER
            = "INSERT INTO Customer (Name, Address, City, State, Zip, "
                + "InsuranceCarrier, PolicyNum, PolicyExpiration) "
                + "VALUES (?,?,?,?,?,?,?,?)";
        
        private static final String SQL_UPDATE_CUSTOMER
            = "UPDATE Customer SET Name = ?, Address = ?, City = ?, State = ?, "
                + "Zip = ?, InsuranceCarrier = ?, PolicyNum = ?, "
                + "PolicyExpiration = ? WHERE idCustomer = ?";
        
        private static final String SQL_DELETE_CUSTOMER
            = "DELETE FROM Customer WHERE idCustomer = ?";
    }

    @Override
    public Equipment getEquipmentById(int idEquip) {
        try {
            Equipment equipment = jdbcTemplate.queryForObject(
                    statements.SQL_SELECT_EQUIPMENT_BY_ID,
                    new mappers.EquipmentMapper(),
                    idEquip);
            return equipment;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Equipment> getAllEquipment() {
        try {
            List<Equipment> equipmentList = jdbcTemplate.query(statements.SQL_SELECT_ALL_EQUIPMENT,
                    new mappers.EquipmentMapper());
            return equipmentList;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void addEquipment(Equipment equipment) {
        jdbcTemplate.update(statements.SQL_INSERT_EQUIPMENT,
                equipment.getMake(),
                equipment.getModel(),
                equipment.getYear(),
                equipment.getVinNum(),
                equipment.getPurchaseDate(),
                equipment.isAvailable(),
                equipment.isActive(),
                equipment.getGpsNum(),
                equipment.getTagNum());
        equipment.setIdEquip(getLastInsertId());
    }

    @Override
    public void updateEquipment(Equipment equipment) {
        jdbcTemplate.update(statements.SQL_UPDATE_EQUIPMENT,
                equipment.getMake(),
                equipment.getModel(),
                equipment.getYear(),
                equipment.getVinNum(),
                equipment.getPurchaseDate(),
                equipment.isAvailable(),
                equipment.isActive(),
                equipment.getGpsNum(),
                equipment.getTagNum(),
                equipment.getIdEquip());
    }

    @Override
    public void deleteEquipmentById(int idEquip) {
        jdbcTemplate.update(statements.SQL_DELETE_EQUIPMENT_BY_ID,
                idEquip);
    }

    
    
    
    
    
    
    @Override
    public Lease getLeaseById(int idLease) {
        try {
            Lease lease = jdbcTemplate.queryForObject(
                    statements.SQL_SELECT_LEASE_BY_ID,
                    new mappers.LeaseMapper(),
                    idLease);
            return lease;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Lease> getAllLeases() {
        try {
            List<Lease> leaseList = jdbcTemplate.query(statements.SQL_SELECT_ALL_LEASES,
                    new mappers.LeaseMapper());
            return leaseList;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void addLease(Lease lease) {
        jdbcTemplate.update(statements.SQL_INSERT_LEASE,
                lease.getBegDate(),
                lease.getEndDate(),
                lease.isHasRecInsurance(),
                lease.getCustomer().getIdCustomer());
        lease.setIdLease(getLastInsertId());
    }

    @Override
    public void updateEquipment(Lease lease) {
        jdbcTemplate.update(statements.SQL_UPDATE_LEASE,
                lease.getBegDate(),
                lease.getEndDate(),
                lease.isHasRecInsurance(),
                lease.getCustomer().getIdCustomer(),
                lease.getIdLease());
    }

    @Override
    public void deleteLeaseById(int idLease) {
        jdbcTemplate.update(statements.SQL_DELETE_LEASE, idLease);
    }

    
    
    
    
    
    
    @Override
    public Customer getCustomerById(int idCustomer) {
        try {
            Customer customer = jdbcTemplate.queryForObject(
                    statements.SQL_SELECT_CUSTOMER_BY_ID,
                    new mappers.CustomerMapper(),
                    idCustomer);
            return customer;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        try {
            List<Customer> customerList = jdbcTemplate.query(statements.SQL_SELECT_ALL_CUSTOMERS,
                    new mappers.CustomerMapper());
            return customerList;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void addCustomer(Customer customer) {
        jdbcTemplate.update(statements.SQL_INSERT_CUSTOMER,
                customer.getName(),
                customer.getAddress(),
                customer.getCity(),
                customer.getState(),
                customer.getZip(),
                customer.getInsurance(),
                customer.getPolicyNum(),
                customer.getPolicyExp());
    }

    @Override
    public void updateCustomer(Customer customer) {
        jdbcTemplate.update(statements.SQL_UPDATE_CUSTOMER,
                customer.getName(),
                customer.getAddress(),
                customer.getCity(),
                customer.getState(),
                customer.getZip(),
                customer.getInsurance(),
                customer.getPolicyNum(),
                customer.getPolicyExp(),
                customer.getIdCustomer());
    }

    @Override
    public void deleteCustomerById(int idCustomer) {
        jdbcTemplate.update(statements.SQL_DELETE_CUSTOMER, idCustomer);
    }

    
    
    public List<Equipment> getEquipmentForLease(Lease lease){
        
        return null;
    }
    
    public int getLastInsertId() {
        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
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
