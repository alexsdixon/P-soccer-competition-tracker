package net.alexdixon.soccercompetitiontracker.models.data;


import net.alexdixon.soccercompetitiontracker.models.forms.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TeamDao extends CrudRepository<Team, Integer> {


}
