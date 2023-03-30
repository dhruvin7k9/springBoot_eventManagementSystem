package springBoot.ems.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBoot.ems.Entity.Event;
import springBoot.ems.Entity.Club;
import springBoot.ems.Repository.ClubRepository;

@Service
public class ClubService {
	private ClubRepository clubRepository;

	@Autowired
	public ClubService(ClubRepository clubRepository) {
		this.clubRepository = clubRepository;
	}

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
			List<Event> events = club.getEvents();
			events.forEach((e) -> {
				if (e.geteId() == event.geteId()) {
					events.remove(e);
				}
			});
			club.setEvents(events);
			clubRepository.save(club);
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
	
}
