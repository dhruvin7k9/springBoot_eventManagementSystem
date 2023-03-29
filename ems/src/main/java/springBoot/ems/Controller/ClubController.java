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
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
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
	
	@RequestMapping(value = "/createClubForm")
	public String createClubForm() {
		return "createClubForm";
	}
	
	@RequestMapping(value = "/createClub", method = RequestMethod.POST)
	public String createClub(@RequestParam String clubName, @RequestParam String clubPassword) {
		clubService.addClub(new Club(clubName, clubPassword));
		return "clubSignIn";
	}
	
	@RequestMapping(value = "/showClubDashboard")
	public String showClubDashboard() {
		return "clubDashboard";
	}
}
