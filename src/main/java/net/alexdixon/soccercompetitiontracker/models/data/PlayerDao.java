package net.alexdixon.soccercompetitiontracker.models.data;

import net.alexdixon.soccercompetitiontracker.models.forms.Player;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public interface PlayerDao extends CrudRepository<Player, Integer> {

    @Query(value = "SELECT * FROM player ORDER BY goal_scored DESC LIMIT 5 ", nativeQuery = true)
    List<Player> findByGoalScored();

    @Query(value = "SELECT * FROM player ORDER BY assists DESC LIMIT 5 ", nativeQuery = true)
    List<Player> findByAssist();

    @Query(value = "SELECT * FROM player WHERE clean_sheet > 0 AND player_position = 'Goalkeeper' ORDER BY clean_sheet DESC LIMIT 5 ", nativeQuery = true)
    List<Player> findByCleanSheet();


}

