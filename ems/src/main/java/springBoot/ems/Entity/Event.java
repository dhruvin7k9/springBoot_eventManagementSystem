package springBoot.ems.Entity;

import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eId;
	
	@Column
	private String eventName;
	
	@Column
	private String eventDescription;
	
	@Column
	private Timestamp eventRegDue;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "cId")
	private Club club;
	
	@ManyToMany(cascade = CascadeType.REFRESH)
	@JoinTable(name = "Participation", 
				joinColumns = @JoinColumn(name = "eId", referencedColumnName = "eId"),
				inverseJoinColumns = @JoinColumn(name ="sId", referencedColumnName = "sId"))
	private List<Student> students;

	public Event() {
		super();
	}

	public Event(String eventName, String eventDescription, Timestamp eventRegDue, Club club) {
		super();
		this.eventName = eventName;
		this.eventDescription = eventDescription;
		this.eventRegDue = eventRegDue;
		this.club = club;
	}
	
	public Event(int eId, String eventName, String eventDescription, Timestamp eventRegDue, Club club) {
		super();
		this.eId = eId;
		this.eventName = eventName;
		this.eventDescription = eventDescription;
		this.eventRegDue = eventRegDue;
		this.club = club;
	}

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public Timestamp getEventRegDue() {
		return eventRegDue;
	}

	public void setEventRegDue(Timestamp eventRegDue) {
		this.eventRegDue = eventRegDue;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	@Override
	public String toString() {
		return "Event [eId=" + eId + ", eventName=" + eventName + ", eventDescription=" + eventDescription
				+ ", eventRegDue=" + eventRegDue + ", club=" + club + "]";
	}
}