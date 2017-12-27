package ratanak.pek.restful.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import ratanak.pek.restful.model.User;

/**
 * Created by r.pek on 12/22/2017.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundExceiption extends RuntimeException {
    public UserNotFoundExceiption(String message) {
        super(message);
    }
}
