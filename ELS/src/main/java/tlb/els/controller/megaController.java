package tlb.els.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tlb.els.dao.Dao;
import org.springframework.stereotype.Controller;
import tlb.els.model.Customer;
import tlb.els.model.Equipment;

@Controller
public class megaController {
        
    Dao dao;
    
    @Inject
    public megaController(Dao dao) {
        this.dao = dao;
    } 
    
    @RequestMapping(value={"/","/index"}, method=RequestMethod.GET)
    public String displayIndex(HttpServletRequest request, Model model) {
        return "index";
    }
    
    @RequestMapping(value={"/manageEquipment"}, method=RequestMethod.GET)
    public String manageEquipment(HttpServletRequest request, Model model) {
        model.addAttribute("equipment", dao.getAllEquipment());
        return "manageEquipment";
    }
    
    @RequestMapping(value={"/addEquipment"}, method=RequestMethod.POST)
    public String addEquipment(HttpServletRequest request, Model model) {
        Equipment newEquipment = new Equipment();
        newEquipment.setMake(request.getParameter("make"));
        newEquipment.setModel(request.getParameter("model"));
        newEquipment.setVinNum(request.getParameter("vinNum"));
        newEquipment.setYear(Integer.parseInt(request.getParameter("year")));
        newEquipment.setPurchaseDate(request.getParameter("purchaseDate"));
        newEquipment.setGpsNum(request.getParameter("gpsNum"));
        newEquipment.setTagNum(request.getParameter("tagNum"));
        
        
        if (request.getParameter("available").equals("yes")){
            newEquipment.setAvailable(true);
        } else {
            newEquipment.setAvailable(false);
        }
        
        if (request.getParameter("active").equals("yes")){
            newEquipment.setActive(true);
        } else {
            newEquipment.setActive(false);
        }
        
        dao.addEquipment(newEquipment);
        return "redirect:manageEquipment";
    }
    
    @RequestMapping(value={"/equipToEdit"}, method=RequestMethod.GET)
    public String equipmentToEdit(HttpServletRequest request,Model model) {
        String idEquip = request.getParameter("idEquip");
        Equipment equipToEdit = dao.getEquipmentById(Integer.parseInt(idEquip));
        model.addAttribute("equipment", equipToEdit);
        return "editEquipment";
    }
    
    @RequestMapping(value={"/editEquipment"}, method=RequestMethod.POST)
    public String editEquipment(HttpServletRequest request,Model model) {
        Equipment editedEquipment = new Equipment();
        String idEquip = request.getParameter("idEquip");
        editedEquipment.setMake(request.getParameter("make"));
        editedEquipment.setModel(request.getParameter("model"));
        editedEquipment.setVinNum(request.getParameter("vinNum"));
        editedEquipment.setYear(Integer.parseInt(request.getParameter("year")));
        editedEquipment.setPurchaseDate(request.getParameter("purchaseDate"));
        editedEquipment.setGpsNum(request.getParameter("gpsNum"));
        editedEquipment.setTagNum(request.getParameter("tagNum"));
        
        
        if (request.getParameter("available").equals("yes")){
            editedEquipment.setAvailable(true);
        } else {
            editedEquipment.setAvailable(false);
        }
        
        if (request.getParameter("active").equals("yes")){
            editedEquipment.setActive(true);
        } else {
            editedEquipment.setActive(false);
        }
        
        editedEquipment.setIdEquip(Integer.parseInt(idEquip));
        
        dao.updateEquipment(editedEquipment);
        
        return "redirect:manageEquipment";
    }
    
    @RequestMapping(value={"/deleteEquipment"}, method=RequestMethod.GET)
    public String deleteEquipment(HttpServletRequest request,Model model) {
        String idEquip = request.getParameter("idEquip");
        dao.deleteEquipmentById(Integer.parseInt(idEquip));
        return "redirect:manageEquipment";
    }
    
    @RequestMapping(value={"/manageCustomers"}, method=RequestMethod.GET)
    public String manageCustomer(HttpServletRequest request, Model model) {
        model.addAttribute("customers", dao.getAllCustomers());
        return "manageCustomers";
    }
    
    @RequestMapping(value={"/addCustomer"}, method=RequestMethod.POST)
    public String addCustomer(HttpServletRequest request, Model model) {
        Customer newCustomer = new Customer();
        
        newCustomer.setName(request.getParameter("name"));
        newCustomer.setAddress(request.getParameter("address"));
        newCustomer.setCity(request.getParameter("city"));
        newCustomer.setState(request.getParameter("state"));
        newCustomer.setZip(request.getParameter("zip"));
        newCustomer.setInsurance(request.getParameter("insurance"));
        newCustomer.setPolicyNum(request.getParameter("policyNum"));
        newCustomer.setPolicyExp(request.getParameter("policyExp"));
        
        dao.addCustomer(newCustomer);
        return "redirect:manageCustomers";
    }
    
    @RequestMapping(value={"/customerToEdit"}, method=RequestMethod.GET)
    public String customerToEdit(HttpServletRequest request,Model model) {
        String idCustomer = request.getParameter("idCustomer");
        Customer customerToEdit = dao.getCustomerById(Integer.parseInt(idCustomer));
        model.addAttribute("customer", customerToEdit);
        return "editCustomer";
    }
    
    @RequestMapping(value={"/editCustomer"}, method=RequestMethod.POST)
    public String editCustomer(HttpServletRequest request, Model model) {
        Customer editedCustomer = new Customer();
        
        editedCustomer.setName(request.getParameter("name"));
        editedCustomer.setAddress(request.getParameter("address"));
        editedCustomer.setCity(request.getParameter("city"));
        editedCustomer.setState(request.getParameter("state"));
        editedCustomer.setZip(request.getParameter("zip"));
        editedCustomer.setInsurance(request.getParameter("insurance"));
        editedCustomer.setPolicyNum(request.getParameter("policyNum"));
        editedCustomer.setPolicyExp(request.getParameter("policyExp"));
        editedCustomer.setIdCustomer(Integer.parseInt(request.getParameter("idCustomer")));
        
        dao.updateCustomer(editedCustomer);
        return "redirect:manageCustomers";
    }
    
    @RequestMapping(value={"/deleteCustomer"}, method=RequestMethod.GET)
    public String deleteCustomer(HttpServletRequest request,Model model) {
        String idCustomer = request.getParameter("idCustomer");
        dao.deleteCustomerById(Integer.parseInt(idCustomer));
        return "redirect:manageCustomers";
    }
}
