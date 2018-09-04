package net.alexdixon.soccercompetitiontracker.models.data;


import net.alexdixon.soccercompetitiontracker.models.forms.Team;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface TeamDao extends CrudRepository<Team, Integer> {

    @Query(value = "SELECT * FROM team ORDER BY points DESC, goal_difference DESC  ", nativeQuery = true)
    List<Team> findByPoints();

}
