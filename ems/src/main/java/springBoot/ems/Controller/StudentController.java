package springBoot.ems.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springBoot.ems.Entity.Student;
import springBoot.ems.Service.StudentService;

@Controller
@RequestMapping(value = "/student")
public class StudentController {
	private StudentService studentService;
	
	@Autowired
	public StudentController(StudentService studentService) {
		// TODO Auto-generated constructor stub
		this.studentService = studentService;
	}
	
	@RequestMapping(value = "/signIn", method = RequestMethod.GET)
	public String signIn() {
		return "studentSignIn";
	}
	
	@RequestMapping(value = "/validateStudent", method = RequestMethod.POST)
	public String validateStudent(@RequestParam String studentId, @RequestParam String studentPassword, ModelMap modelMap) {
		if(studentService.validateStudent(studentId, studentPassword)) {
			return "studentDashboard";
		}
		modelMap.addAttribute("msg", "credentials are wrong or student does not exist");
		return "studentSignIn";
	}
	
	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public String addStudent(@RequestParam String studentId, @RequestParam String studentName, @RequestParam String studentPassword, @RequestParam String studentBranch, @RequestParam int studentSem, ModelMap modelMap){
		System.out.println(studentId);
		System.out.println(studentService.findByStudentId(studentId));
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
	
}
