package ratanak.pek.restful.controller;

import org.springframework.web.bind.annotation.*;

/**
 * Created by r.pek on 12/21/2017.
 */

@RestController
public class HelloWorldController {

    @GetMapping(path ="/hello")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping(path ="/hello-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World bean!");
    }
    @GetMapping(path ="/hello-bean/{name}")
    public HelloWorldBean helloWorldPath(@PathVariable String name){
        return new HelloWorldBean("Hello World bean!"+ name
        );
    }
}
