/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tlb.els.dao;

import java.util.List;
import tlb.els.model.Customer;
import tlb.els.model.Equipment;
import tlb.els.model.Lease;

/**
 *
 * @author tylerbates
 */
public interface Dao {
    
    //------------Equipment------------------------
    public Equipment getEquipmentById(int idEquip);
    public List<Equipment> getAllEquipment();
    public void addEquipment(Equipment equipment);
    public void updateEquipment(Equipment equipment);
    public void deleteEquipmentById(int idEquip);
    //----------------------------------------------
    
    //---------------Lease--------------------------
    public Lease getLeaseById(int idLease);
    public List<Lease> getAllLeases();
    public void addLease(Lease lease);
    public void updateEquipment(Lease lease);
    public void deleteLeaseById(int idLease);
    //----------------------------------------------
    
    //-------------Customer-------------------------
    public Customer getCustomerById(int idCustomer);
    public List<Customer> getAllCustomers();
    public void addCustomer(Customer customer);
    public void updateCustomer(Customer customer);
    public void deleteCustomerById(int idCustomer);
    //----------------------------------------------
    
    
    //Helper Methods
    public List<Equipment> getEquipmentForLease(Lease lease);
}
