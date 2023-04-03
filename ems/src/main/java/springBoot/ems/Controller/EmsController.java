package springBoot.ems.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import springBoot.ems.Entity.Student;
import springBoot.ems.Service.StudentService;

@Controller
public class EmsController {
	private StudentService studentService;

	public EmsController() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public EmsController(StudentService studentServices) {
		// TODO Auto-generated constructor stub
		this.studentService = studentServices;
	}

	@RequestMapping("/")
	public String experiments(ModelMap model) {
		
		model.addAttribute("str", "home page");
		return "home";
	}

//	@RequestMapping("/show")
//	public String test() {

//		int sId=2;
//		studentService.deleteStudentById(sId);
//		this.studentService.updateStudent(new Student(sId,"avx", "jnd", "njnjf", 2, "pppp"));
//		System.out.println(studentService.findStudentById(sId));
//		System.out.println(studentService.getAllStudents());
//		return "home";
//	}
}