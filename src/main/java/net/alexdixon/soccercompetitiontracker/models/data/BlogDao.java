package net.alexdixon.soccercompetitiontracker.models.data;

import net.alexdixon.soccercompetitiontracker.models.forms.Blog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface BlogDao extends CrudRepository<Blog, Integer> {

}