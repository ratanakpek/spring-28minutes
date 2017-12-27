package ratanak.pek.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ratanak.pek.restful.dao.UserDaoService;
import ratanak.pek.restful.model.User;

import javax.validation.Valid;
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
    public Resource<User> findOne(@PathVariable Integer id) {
        User user =service.findOne(id);
        if(user==null){
            throw new UserNotFoundExceiption("ID : "+ id);
        }

        Resource<User> resource = new Resource<>(user);
        ControllerLinkBuilder linkTo= ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).findAllUsers());
        resource.add(linkTo.withRel("all-users"));
        return resource;
    }

    @PostMapping(path = "/users")
    public ResponseEntity<Object> save(@Valid @RequestBody User user) {
        User saveUser = service.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saveUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path="/users/{id}")
    public ResponseEntity<Object> removeUserById(@PathVariable Integer id) {
        User saveUser = service.deleteUserById(id);
        if(saveUser==null) throw new UserNotFoundExceiption("id -"+ id);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saveUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
