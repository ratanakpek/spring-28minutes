package ratanak.pek.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ratanak.pek.restful.dao.UserDaoService;
import ratanak.pek.restful.model.User;
import ratanak.pek.restful.model.version.Post;
import ratanak.pek.restful.repository.PostRepository;
import ratanak.pek.restful.repository.UserRepository;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

/**
 * Created by r.pek on 12/21/2017.
 */
@RestController
public class UserJpaController {



    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @GetMapping(path = "/jpa/users")
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/jpa/users/{id}")
    public Resource<User> findOne(@PathVariable Integer id) {
        Optional<User> user =userRepository.findById(id);
        if(!user.isPresent()){
            throw new UserNotFoundExceiption("ID : "+ id);
        }

        Resource<User> resource = new Resource<User>(user.get());
        ControllerLinkBuilder linkTo= ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).findAllUsers());
        resource.add(linkTo.withRel("all-users"));
        return resource;
    }

    @PostMapping(path = "/jpa/users")
    public ResponseEntity<Object> save(@Valid @RequestBody User user) {
        User saveUser = userRepository.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saveUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path="/jpa/users/{id}")
    public void removeUserById(@PathVariable Integer id) {
        userRepository.deleteById(id);

    }

    @GetMapping(path = "/jpa/users/{id}/posts")
    public List<Post> findAllUsers(@PathVariable int id) {
        Optional<User> userOptional = userRepository.findById(id);
        if(!userOptional.isPresent()){
            throw new UserNotFoundExceiption("id-"+id);
        }
        return userOptional.get().getPosts();
    }

    @PostMapping(path="jpa/users/{id}/posts")
    public ResponseEntity<Object> createPost(@PathVariable int id, @RequestBody Post post){
        Optional<User> userOptional = userRepository.findById(id);

        if(!userOptional.isPresent()){
            throw new UserNotFoundExceiption("Not found id : "+ id);
        }

        User user = userOptional.get();

        post.setUser(user);
        postRepository.save(post);


        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("").buildAndExpand(post.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
