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
public class FarmerController {
	
	
	@Autowired
	 private FarmerService service;
	
	 // handler methods...
  @RequestMapping("/farmer")
  public String viewHomePage(Model model) {
      List<Farmer> listFarmer = service.listAll();
      model.addAttribute("listFarmer", listFarmer);
       
      return "farmer_index";
  }
  
  @RequestMapping("/newFarmer")
  public String showNewFarmerPage(Model model) {
	  Farmer farmer = new Farmer();
      model.addAttribute("farmer", farmer);
       
      return "new_Farmer";
  }
  @RequestMapping(value = "/saveFarmer", method = RequestMethod.POST)
  public String saveFarmerr(@ModelAttribute("farmer") Farmer farmer,Model model) {
      service.save(farmer);
     List<Farmer> listFarmer = service.listAll();
      model.addAttribute("farmer", farmer);
      return "redirect:/";
  }
  @RequestMapping(value = "/updateFarmer", method = RequestMethod.POST)
  public String updateFarmer(@ModelAttribute("farmer") Farmer farmer,Model model) {
     
	  Farmer f=service.get(farmer.getFarmerid());
	  f.setFarmerName(farmer.getFarmerName());
  	//c.setLastName(customer.getLastName());
  	service.save(f);
  	 List<Farmer> listFarmer = service.listAll();
      model.addAttribute("listFarmer", listFarmer);
      return "redirect:/";
  }
  
  @RequestMapping("/editFarmer/{id}")
  public ModelAndView showEditFarmerPage(@PathVariable(name = "id") int id) {
      ModelAndView mav = new ModelAndView("edit_farmer");
      Farmer farmer = service.get(id);
      mav.addObject("farmer", farmer);
       
      return mav;
  }
  @RequestMapping("/deleteFarmer/{id}")
  public String deleteFarmer(@PathVariable(name = "id") int id) {
      service.delete(id);
      return "redirect:/";

}

}
