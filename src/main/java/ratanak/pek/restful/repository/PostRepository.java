package ratanak.pek.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ratanak.pek.restful.model.version.Post;

/**
 * Created by r.pek on 1/26/2018.
 */
public interface PostRepository extends JpaRepository<Post, Integer> {

}
