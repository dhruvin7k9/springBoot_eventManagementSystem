package springBoot.ems.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springBoot.ems.Entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
