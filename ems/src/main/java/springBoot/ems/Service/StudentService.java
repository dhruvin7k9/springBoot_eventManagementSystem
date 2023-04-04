package springBoot.ems.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springBoot.ems.Entity.Event;
import springBoot.ems.Entity.Student;
import springBoot.ems.Repository.StudentRepository;

@Service
public class StudentService {
	private StudentRepository studentRepository;

	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public void addStudent(Student student) {
		studentRepository.save(student);
	}

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public Student findStudentById(int sId) {
		Student student = studentRepository.findById(sId).orElse(null);
		return student;
	}

	public void participateInEvent(int sId, Event event) {
		Student student = findStudentById(sId);
		if (student != null) {
			student.getEvents().add(event);
			studentRepository.save(student);
		}
	}

	public void cancelParticipation(int sId, Event event) {
		Student student = findStudentById(sId);
		if (student != null) {
			student.getEvents().remove(event);
			studentRepository.save(student);
		}
	}

	public void updateStudent(Student student) {
		Student s = findStudentById(student.getsId());
		if (s != null) {
			s.setStudentBranch(student.getStudentBranch());
			s.setStudentId(student.getStudentId());
			s.setStudentName(student.getStudentName());
			s.setStudentPassword(student.getStudentPassword());
			s.setStudentSem(student.getStudentSem());
			s.setEvents(student.getEvents());
			studentRepository.save(s);
		}
	}

	public void deleteStudentById(int sId) {
		studentRepository.deleteById(sId);
	}

	public List<Event> getParticipatedEvents(int sId) {
		Student student = findStudentById(sId);
		if (student != null)
			return student.getEvents();
		return null;
	}
	
	public boolean validateStudent(String studentId, String studentPassword) {
		return studentRepository.findByStudentIdAndStudentPassword(studentId, studentPassword).size() == 1;
	}
	
	public boolean findByStudentId(String studentId) {
		return studentRepository.findByStudentId(studentId).size() == 1;
	}

	public Student getStudentByStudentId(String studentId) {
		return studentRepository.findByStudentId(studentId).get(0);
	}
	
	public Student getStudentBysId(int sId) {
		return studentRepository.findBysId(sId).get(0);
	}
}