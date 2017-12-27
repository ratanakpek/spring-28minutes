package ratanak.pek.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

/**
 * Created by r.pek on 12/21/2017.
 */

@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

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

    @GetMapping(path ="/locale")
    public String internationalize()
    {
        return messageSource.getMessage("customer.name", null, Locale.US);
    }
}
