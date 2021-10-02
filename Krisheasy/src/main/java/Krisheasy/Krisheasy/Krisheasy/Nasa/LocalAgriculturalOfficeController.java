package Krisheasy.Krisheasy.Krisheasy.Nasa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class LocalAgriculturalOfficeController {
	
	
	
	@Autowired
	 private LocalAgriculturalOfficeService service;
	
	 // handler methods...
   @RequestMapping("/localAgriculturalOffice")
   public String viewHomePage(Model model) {
       List<LocalAgriculturalOffice> listLocalAgriculturalOffice = service.listAll();
       model.addAttribute("listLocalAgriculturalOffice", listLocalAgriculturalOffice);
        
       return "localAgriculturalOfficer_index";
   }
   
   @RequestMapping("/newLocalAgriculturalOffice")
   public String showNewLocalAgriculturalOfficePage(Model model) {
	   LocalAgriculturalOffice localAgriculturalOffice = new LocalAgriculturalOffice();
       model.addAttribute("localAgriculturalOffice", localAgriculturalOffice);
        
       return "new_Customer";
   }
   @RequestMapping(value = "/saveLocalAgriculturalOffice", method = RequestMethod.POST)
   public String saveCustomer(@ModelAttribute("localAgriculturalOffice") LocalAgriculturalOffice localAgriculturalOffice,Model model) {
       service.save(localAgriculturalOffice);
      List<LocalAgriculturalOffice> listLocalAgriculturalOffice = service.listAll();
       model.addAttribute("listLocalAgriculturalOffice", listLocalAgriculturalOffice);
       return "redirect:/";
   }
   @RequestMapping(value = "/updateLocalAgriculturalOffice", method = RequestMethod.POST)
   public String updateLocalAgriculturalOffice(@ModelAttribute("localAgriculturalOffice") LocalAgriculturalOffice localAgriculturalOffice,Model model) {
      
	   LocalAgriculturalOffice lao=service.get(localAgriculturalOffice.getLaoId());
	   //lao.setFirstName(localAgriculturalOffice.getFirstName());
   	//c.setLastName(customer.getLastName());
   	service.save(lao);
   	 List<LocalAgriculturalOffice> listLocalAgriculturalOffice = service.listAll();
       model.addAttribute("listLocalAgriculturalOffice", listLocalAgriculturalOffice);
       return "redirect:/";
   }
   
   @RequestMapping("/editLocalAgriculturalOffice/{id}")
   public ModelAndView showEditLocalAgriculturalOfficePage(@PathVariable(name = "id") int id) {
       ModelAndView mav = new ModelAndView("edit_localAgriculturalOffice");
       LocalAgriculturalOffice localAgriculturalOffice = service.get(id);
       mav.addObject("localAgriculturalOffice", localAgriculturalOffice);
        
       return mav;
   }
   @RequestMapping("/deleteLocalAgriculturalOffice/{id}")
   public String deleteLocalAgriculturalOffice(@PathVariable(name = "id") int id) {
       service.delete(id);
       return "redirect:/";

}
}
