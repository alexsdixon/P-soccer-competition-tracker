package net.alexdixon.soccercompetitiontracker.models.data;




import net.alexdixon.soccercompetitiontracker.models.forms.Fixture;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface FixtureDao extends CrudRepository<Fixture, Integer> {

}
