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
public class ImageController {
	
	@Autowired
	 private ImageService service;
	
	 // handler methods...
 @RequestMapping("/image")
 public String viewHomePage(Model model) {
     List<Image> listImage = service.listAll();
     model.addAttribute("listImage", listImage);
      
     return "image_index";
 }
 
 @RequestMapping("/newImage")
 public String showNewImagePage(Model model) {
	 Image image = new Image();
     model.addAttribute("image", image);
      
     return "new_Image";
 }
 @RequestMapping(value = "/saveImage", method = RequestMethod.POST)
 public String saveImage(@ModelAttribute("image") Image image,Model model) {
     service.save(image);
    List<Image> listImage = service.listAll();
     model.addAttribute("image", image);
     return "redirect:/";
 }
 @RequestMapping(value = "/updateImage", method = RequestMethod.POST)
 public String updateImage(@ModelAttribute("image") Image image,Model model) {
    
	 Image i=service.get(image.getImageId());
	  i.setImageName(image.getImageName());
 	//c.setLastName(customer.getLastName());
 	service.save(i);
 	 List<Image> listImage = service.listAll();
     model.addAttribute("listImage", listImage);
     return "redirect:/";
 }
 
 @RequestMapping("/editFarmer/{id}")
 public ModelAndView showEditFarmerPage(@PathVariable(name = "id") int id) {
     ModelAndView mav = new ModelAndView("edit_farmer");
     Image image = service.get(id);
     mav.addObject("image", image);
      
     return mav;
 }
 @RequestMapping("/deleteImage/{id}")
 public String deleteImage(@PathVariable(name = "id") int id) {
     service.delete(id);
     return "redirect:/";

}


}
