package springBoot.ems.Controller;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
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
		// TODO Auto-generated constructor stub
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
			modelMap.addAttribute("student", studentService.getStudentByStudentId(studentId));
			request.getSession().setAttribute("student", studentService.getStudentByStudentId(studentId));
			ongoingEvents(request, modelMap);
			return "studentDashboard";
		}
		modelMap.addAttribute("msg", "credentials are wrong or student does not exist");
		return "studentSignIn";
	}
	
	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	
	public String addStudent(@RequestParam String studentId, @RequestParam String studentName, @RequestParam String studentPassword, @RequestParam String studentBranch, @RequestParam int studentSem, ModelMap modelMap){
//		System.out.println(studentId);
//		System.out.println(studentService.findByStudentId(studentId));
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
	
	@RequestMapping(value = "/ongoingEvents", method = RequestMethod.GET)
	@Scope("session")
	public String ongoingEvents(HttpServletRequest request, ModelMap modelMap) {
		System.out.println(LocalDate.now());
		modelMap.addAttribute("student", (Student)request.getSession().getAttribute("student"));
		Student student = (Student) request.getSession().getAttribute("student");
//		System.out.println();
		Set<Event> s1 = new HashSet<>(studentService.getParticipatedEvents(student.getsId()));
		Set<Event> s2 = new HashSet<>(eventService.getAllLiveEvents());
		modelMap.addAttribute("date",LocalDate.now());
		s2.removeAll(s1);
//		System.out.println("=====================================");
//		System.out.println(s2);
//		System.out.println(s1);
//		System.out.println("=====================================");
		modelMap.addAttribute("liveEvents",s2);
		modelMap.addAttribute("expiredEvents",eventService.getAllExpiredEvents());
		return "studentDashboard";
	}
	
	@RequestMapping(value = "/participate/{eId}", method = RequestMethod.GET)
	@Scope("session")
	public String participate(HttpServletRequest request, ModelMap modelMap, @PathVariable String eId) {
		Student student = (Student)request.getSession().getAttribute("student");
		studentService.participateInEvent(student.getsId(), eventService.getEventById(Integer.valueOf(eId)));
		return "redirect:/student/ongoingEvents";
	}
	
	@RequestMapping(value = "/participatedEvents", method = RequestMethod.GET)
	@Scope("session")
	public String participatedEvents(HttpServletRequest request, ModelMap modelMap) {
		Student student = (Student)request.getSession().getAttribute("student");
//		Set<Event> liveEvents = new HashSet<>(eventService.getAllLiveEvents());
//		Set<Event> expiredEvents = new HashSet<>(eventService.getAllExpiredEvents());
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
}
