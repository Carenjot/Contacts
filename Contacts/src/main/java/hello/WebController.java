package hello;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Controller
public class WebController implements WebMvcConfigurer {
	
	@Autowired
	private CustomerRepository customerRepository;
	
    @ModelAttribute(name = "customers")
    public Iterable<Customer> getCustomers(){
    	return customerRepository.findAll();
    }

    @GetMapping("/results")
    public String results() {
    	return "results";
    }
    
    @GetMapping("/addcustomer")
    public String addPersonForm(PersonForm personForm) {
    	return "form";
    }
    
    @GetMapping("/updateperson/{id}")
    public String updatePersonForm(@PathVariable Long id, Model model) {
    	Customer c=customerRepository.findById(id).get();
    	if(c==null) 
    		c=new Customer();
    	model.addAttribute("personForm", c.getPersonForm());
    	return "form";
    }
    		
    @PostMapping("/form")
    public String checkCustomerInfo(@Valid PersonForm personForm, BindingResult bindingResult) {
    	if(bindingResult.hasErrors()) {
    		return "form";
    	}
    	customerRepository.save(personForm.getPerson());
    	
    	return "redirect:/results";
    }
    
}