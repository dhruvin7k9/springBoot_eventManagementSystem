package springBoot.ems.Service;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springBoot.ems.Entity.Event;
import springBoot.ems.Repository.EventRepository;

@Service
public class EventService {
	private EventRepository eventRepository;
	
	@Autowired
	public EventService(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
		// TODO Auto-generated constructor stub
	}
	
	public List<Event> getAllEvents() {
		return eventRepository.findAll();
	}
	
	public List<Event> getAllLiveEvents() {
		return eventRepository.findByEventRegDueGreaterThanEqual(LocalDate.now());
	}
	
	public List<Event> getAllExpiredEvents() {
		return eventRepository.findByEventRegDueLessThan(LocalDate.now());
	}

	public Event getEventById(int eId) {
		return eventRepository.findById(eId).orElse(null);
	}
}
