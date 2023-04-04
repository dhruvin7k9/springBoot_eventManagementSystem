package springBoot.ems.Controller;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import springBoot.ems.Entity.Event;
import jakarta.servlet.http.HttpServletRequest;
import springBoot.ems.Entity.Student;
import springBoot.ems.Service.EventService;
import springBoot.ems.Service.StudentService;

@Controller
@RequestMapping(value = "/student")
public class StudentController {
	private StudentService studentService;
	private EventService eventService;
	
	@Autowired
	public StudentController(StudentService studentService, EventService eventService) {
		this.studentService = studentService;
		this.eventService = eventService;
	}
	
	@RequestMapping(value = "/signIn", method = RequestMethod.GET)
	public String signIn() {
		return "studentSignIn";
	}
	
	@RequestMapping(value = "/validateStudent", method = RequestMethod.POST)
	public String validateStudent(HttpServletRequest request, @RequestParam String studentId, @RequestParam String studentPassword, ModelMap modelMap) {
		if(studentService.validateStudent(studentId, studentPassword)) {
			request.getSession().setAttribute("student", studentService.getStudentByStudentId(studentId));
			return "redirect:/student/studentDashboard";
		}
		modelMap.addAttribute("msg", "credentials are wrong or student does not exist");
		return "studentSignIn";
	}
	
	@RequestMapping(value = "/studentDashboard", method = RequestMethod.GET)
	@Scope("session")
	public String showDashboard(HttpServletRequest request, ModelMap modelMap) {
		modelMap.addAttribute("student", (Student)request.getSession().getAttribute("student"));
		Student student = (Student) request.getSession().getAttribute("student");
		Set<Event> s1 = new HashSet<>(studentService.getParticipatedEvents(student.getsId()));
		Set<Event> s2 = new HashSet<>(eventService.getAllLiveEvents());
		modelMap.addAttribute("date",LocalDate.now());
		s2.removeAll(s1);
		modelMap.addAttribute("liveEvents",s2);
		modelMap.addAttribute("expiredEvents",eventService.getAllExpiredEvents());
		return "studentDashboard";
	}
	
	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public String addStudent(@RequestParam String studentId, @RequestParam String studentName, @RequestParam String studentPassword, @RequestParam String studentBranch, @RequestParam int studentSem, ModelMap modelMap){
		if(!studentService.findByStudentId(studentId)) {
			modelMap.addAttribute("msg", "sign in with the registered credentials");
			studentService.addStudent(new Student(studentId, studentName, studentBranch, studentSem, studentPassword));
			return "studentSignIn";
		}
		modelMap.addAttribute("msg", "the student id is already registered\nplease login");	
		return "registerStudent";
	}
	
	@RequestMapping(value = "/registerStudent")
	public String registerStudent() {
		return "registerStudent";
	}
	
	@RequestMapping(value = "/participate/{eId}", method = RequestMethod.GET)
	@Scope("session")
	public String participate(HttpServletRequest request, ModelMap modelMap, @PathVariable String eId) {
		Student student = (Student)request.getSession().getAttribute("student");
		studentService.participateInEvent(student.getsId(), eventService.getEventById(Integer.valueOf(eId)));
		return "redirect:/student/studentDashboard";
	}
	
	@RequestMapping(value = "/participatedEvents", method = RequestMethod.GET)
	@Scope("session")
	public String participatedEvents(HttpServletRequest request, ModelMap modelMap) {
		Student student = (Student)request.getSession().getAttribute("student");
		Set<Event> studentParticipatedLiveEvents = new HashSet<Event>(studentService.getParticipatedEvents(student.getsId()));
		Set<Event> studentParticipatedExpiredEvents = new HashSet<Event>(studentService.getParticipatedEvents(student.getsId()));
		studentParticipatedLiveEvents.retainAll(new HashSet<>(eventService.getAllLiveEvents()));
		studentParticipatedExpiredEvents.retainAll(new HashSet<>(eventService.getAllExpiredEvents()));
		modelMap.addAttribute("participatedEvents", studentParticipatedLiveEvents);
		modelMap.addAttribute("expiredEvents", studentParticipatedExpiredEvents);
		return "participatedEvents";
	}
	
	@RequestMapping(value = "/cancelParticipation/{eId}", method = RequestMethod.GET)
	@Scope("session")
	public String cancelParticipation(HttpServletRequest request, ModelMap modelMap, @PathVariable String eId) {
		Student student = (Student)request.getSession().getAttribute("student");
		studentService.cancelParticipation(student.getsId(), eventService.getEventById(Integer.valueOf(eId)));
		return "redirect:/student/participatedEvents";
	}
	
	@RequestMapping(value = "/logOut")
	@Scope("session")
	public String logOut(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/";
	}
}