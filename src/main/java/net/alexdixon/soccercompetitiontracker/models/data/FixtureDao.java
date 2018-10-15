package net.alexdixon.soccercompetitiontracker.models.data;




import net.alexdixon.soccercompetitiontracker.models.forms.Fixture;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface FixtureDao extends CrudRepository<Fixture, Integer> {

    @Query(value = "SELECT * FROM fixture WHERE match_date LIKE ('2018-10%')", nativeQuery = true)
    List<Fixture> findByDateOct();

    @Query(value = "SELECT * FROM fixture WHERE match_date LIKE ('2018-11%') ", nativeQuery = true)
    List<Fixture> findByDateNov();

    @Query(value = "SELECT * FROM fixture WHERE CURDATE() < match_date ORDER BY match_date LIMIT 4 ", nativeQuery = true)
    List<Fixture> findByDateCur();

    @Query(value = "SELECT * FROM fixture WHERE CURDATE() > match_date ORDER BY match_date DESC LIMIT 4", nativeQuery = true)
    List<Fixture> findByDatePast();


}
