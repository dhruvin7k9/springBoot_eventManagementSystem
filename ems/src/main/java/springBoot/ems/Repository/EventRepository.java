package springBoot.ems.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springBoot.ems.Entity.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer>{
	// live events
	public List<Event> findByEventRegDueGreaterThanEqual(LocalDate eventRegDue);
	
	// expired events
	public List<Event> findByEventRegDueLessThan(LocalDate eventRegDue);
}
