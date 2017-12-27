package ratanak.pek.restful.dao;

import org.springframework.stereotype.Component;
import ratanak.pek.restful.controller.UserNotFoundExceiption;
import ratanak.pek.restful.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by r.pek on 12/21/2017.
 */
@Component
public class UserDaoService {

    private static List<User> users= new ArrayList<>();
    private static int usersCount=3;

    static{
        users.add(new User(1, "Ratanak", new Date()));
        users.add(new User(2, "Chivorn", new Date()));
        users.add(new User(3, "Makara", new Date()));
    }

    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        if(user.getId()==null){
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id){
        for(User user:users){
            if(user.getId()==id){
                return user;
            }
        }
        return null;
    }
    public User deleteUserById(int id){
        if(users!=null){
            return users.remove(id);
        }else{
            throw new UserNotFoundExceiption("User not found!");
        }
    }

}
