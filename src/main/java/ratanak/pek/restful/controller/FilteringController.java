package ratanak.pek.restful.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
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
    public MappingJacksonValue hello(){
        Book book =new Book("01", "The Power of Love", "Ratanak");
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("bookName", "author");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(book);
        mappingJacksonValue.setFilters(filters);
    return mappingJacksonValue;

    }
}
