package springBoot.ems.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sId;

	@Column(unique = true)
	private String studentId;

	@Column
	private String studentName;

	@Column
	private String studentBranch;

	@Column
	private int studentSem;

	@Column
	private String studentPassword;

	@ManyToMany(mappedBy = "students", cascade = CascadeType.REFRESH)
	private List<Event> events;

	public Student() {
		super();
	}

	public Student(String studentId, String studentName, String studentBranch, int studentSem, String studentPassword) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentBranch = studentBranch;
		this.studentSem = studentSem;
		this.studentPassword = studentPassword;
	}

	public Student(int sId, String studentId, String studentName, String studentBranch, int studentSem,
			String studentPassword) {
		super();
		this.sId = sId;
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentBranch = studentBranch;
		this.studentSem = studentSem;
		this.studentPassword = studentPassword;
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentBranch() {
		return studentBranch;
	}

	public void setStudentBranch(String studentBranch) {
		this.studentBranch = studentBranch;
	}

	public int getStudentSem() {
		return studentSem;
	}

	public void setStudentSem(int studentSem) {
		this.studentSem = studentSem;
	}

	public String getStudentPassword() {
		return studentPassword;
	}

	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	@Override
	public String toString() {
		return "Student [sId=" + sId + ", studentId=" + studentId + ", studentName=" + studentName + ", studentBranch="
				+ studentBranch + ", studentSem=" + studentSem + ", studentPassword=" + studentPassword + "]";
	}
}