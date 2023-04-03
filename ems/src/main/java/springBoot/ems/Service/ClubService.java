package springBoot.ems.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBoot.ems.Entity.Event;
import springBoot.ems.Entity.Club;
import springBoot.ems.Repository.ClubRepository;
import springBoot.ems.Repository.EventRepository;

@Service
public class ClubService {
	private ClubRepository clubRepository;
	private EventRepository eventRepository;
	
	@Autowired
	public ClubService(ClubRepository clubRepository, EventRepository eventRepository) {
		this.clubRepository = clubRepository;
		this.eventRepository = eventRepository;
	}
	
//	@Autowired // setter based
//	public void EventService(EventRepository eventRepository) {
//		this.eventRepository = eventRepository;
//	}

	public void addClub(Club club) {
		clubRepository.save(club);
	}

	public List<Club> getAllClubs() {
		return clubRepository.findAll();
	}

	public Club findClubById(int cId) {
		Club club = clubRepository.findById(cId).orElse(null);
		return club;
	}

	public void addEvent(int cId, Event event) {
		Club club = findClubById(cId);
		if (club != null) {
			club.getEvents().add(event);
			clubRepository.save(club);
		}
	}

	public void removeEvent(int cId, Event event) {
		Club club = findClubById(cId);
		if (club != null) {
//			List<Event> events = club.getEvents();
//			ListIterator<Event> li = events.listIterator();
//			while (li.hasNext()) {
//				if (li.next().geteId() == event.geteId()) {
//					li.remove();
//				}
//			}
			eventRepository.delete(event);
//			club.setEvents(events);
//			clubRepository.save(club);
		}
	}

	public void updateClub(Club club) {
		Club c = findClubById(club.getcId());
		if (c != null) {
			c.setClubName(club.getClubName());
			c.setClubPassword(club.getClubPassword());
			c.setEvents(c.getEvents());
		}
	}

	public void deleteClub(int cId) {
		clubRepository.deleteById(cId);
	}
	
	public boolean validateClub(String clubName, String clubPassword) {
		return clubRepository.findByClubNameAndClubPassword(clubName, clubPassword).size() == 1;
	}
	
	public boolean findByClubName(String clubName) {
		return clubRepository.findByClubName(clubName).size() == 1;
	}
	
	public Club findByClubName(String clubName, boolean status) {
		return clubRepository.findByClubName(clubName).get(0);
	}
	
	public List<Event> getEventsByClubName(String clubname) {
		List<Club> c = clubRepository.findByClubName(clubname);
		int CId = c.get(0).getcId(); // as unique name per club so only one object
		return eventRepository.findBycId(CId);
	}

	public Event getEventByeId(int eId) {
		return eventRepository.findByeId(eId);
	}	
}


