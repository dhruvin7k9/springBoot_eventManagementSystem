package springBoot.ems.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Club {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cId;

	@Column(unique = true)
	private String clubName;

	@Column
	private String clubPassword;

	@OneToMany(mappedBy = "club", cascade = CascadeType.ALL)
	private List<Event> events;

	public Club() {
		super();
	}

	public Club(String clubName, String clubPassword) {
		super();
		this.clubName = clubName;
		this.clubPassword = clubPassword;
	}

	public Club(int cId, String clubName, String clubPassword) {
		super();
		this.cId = cId;
		this.clubName = clubName;
		this.clubPassword = clubPassword;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	public String getClubPassword() {
		return clubPassword;
	}

	public void setClubPassword(String clubPassword) {
		this.clubPassword = clubPassword;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	@Override
	public String toString() {
		return "Club [cId=" + cId + ", clubName=" + clubName + ", clubPassword=" + clubPassword + "]";
	}
}