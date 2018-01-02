package ratanak.pek.restful.controller;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ratanak.pek.restful.model.Book;

/**
 * Created by r.pek on 12/28/2017.
 */
@RestController
public class FilteringController {

    @GetMapping("/filter")
    public Book hello(){


//        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(new Book("01", "The Power of Love", "Ratanak"));

    return new Book("01", "The Power of Love", "Ratanak");

    }
}
