package springBoot.ems.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springBoot.ems.Entity.Club;
import springBoot.ems.Service.ClubService;

@Controller
@RequestMapping(value = "/club")
public class ClubController {
	private ClubService clubService;
	
	@Autowired
	public ClubController(ClubService clubService) {
		// TODO Auto-generated constructor stub
		this.clubService = clubService;
	}
	@RequestMapping(value = "/signIn", method = RequestMethod.GET)
	public String signIn() {
		return "clubSignIn";
	}
	
	@RequestMapping(value = "/validateClub", method = RequestMethod.POST)
	public String validateClub(@RequestParam String clubName, @RequestParam String clubPassword, ModelMap modelMap) {
		if(clubService.validateClub(clubName,clubPassword)) {
			return "redirect:showClubDashboard";
		}
		modelMap.addAttribute("msg", "credentials are wrong or club does not exist");
		return "clubSignIn";
	}
	
	@RequestMapping(value = "/registerClub")
	public String registerClub() {
		return "registerClub";
	}
	
	@RequestMapping(value = "/createClub", method = RequestMethod.POST)
	public String createClub(@RequestParam String clubName, @RequestParam String clubPassword, ModelMap modelMap) {
		Club newClub = new Club(clubName, clubPassword);
		if(!clubService.findByClubName(clubName)) {
			clubService.addClub(newClub);
			modelMap.addAttribute("msg", "sign in with the registered credentials");
			return "clubSignIn";
		}
		modelMap.addAttribute("msg", "the club name is already registered\nplease change the club name");
		return "registerClub";
	}
	
	@RequestMapping(value = "/showClubDashboard")
	public String showClubDashboard() {
		return "clubDashboard";
	}
}
