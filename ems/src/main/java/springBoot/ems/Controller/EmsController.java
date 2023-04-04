package springBoot.ems.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmsController {

	public EmsController() {
	}

	@RequestMapping("/")
	public String home(ModelMap model) {
		
		model.addAttribute("str", "home page");
		return "home";
	}
}