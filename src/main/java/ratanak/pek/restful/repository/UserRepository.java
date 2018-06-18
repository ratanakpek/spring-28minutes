package ratanak.pek.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ratanak.pek.restful.model.User;

/**
 * Created by r.pek on 1/26/2018.
 */
public interface UserRepository extends JpaRepository<User, Integer> {


}
