package springBoot.ems.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springBoot.ems.Entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	public List<Student> findByStudentIdAndStudentPassword(String studentId, String studentPassword);
	public List<Student> findByStudentId(String studentId);
	public List<Student> findBysId(int sId);
}
