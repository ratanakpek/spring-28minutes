package ratanak.pek.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ratanak.pek.restful.dao.UserDaoService;
import ratanak.pek.restful.model.User;

import java.net.URI;
import java.util.List;

/**
 * Created by r.pek on 12/21/2017.
 */
@RestController
public class UserController {

    @Autowired
    private UserDaoService service;

    @GetMapping(path = "/users")
    public List<User> findAllUsers() {
        return service.findAll();
    }

    @GetMapping(path = "/users/{id}")
    public User findOne(@PathVariable Integer id) {
        return service.findOne(id);
    }

    @PostMapping(path = "/users")
    public ResponseEntity<Object> save(@RequestBody User user) {
        User saveUser = service.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saveUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

}
