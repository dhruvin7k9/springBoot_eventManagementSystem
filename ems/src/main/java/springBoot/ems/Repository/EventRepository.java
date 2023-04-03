package springBoot.ems.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import springBoot.ems.Entity.Event;
import springBoot.ems.Entity.Club;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer>{
	@Query("SELECT e FROM Event e JOIN Club c WHERE c.cId = ?1")
	public List<Event> findBycId(int CId);
	public Event findByeId(int eId);
}