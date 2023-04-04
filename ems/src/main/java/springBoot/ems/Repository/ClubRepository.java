package springBoot.ems.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springBoot.ems.Entity.Club;

@Repository
public interface ClubRepository extends JpaRepository<Club, Integer> {
	public List<Club> findByClubNameAndClubPassword(String clubName, String clubPassword);
	public List<Club> findByClubName(String clubName);
}
