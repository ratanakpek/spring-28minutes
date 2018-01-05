package ratanak.pek.restful.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ratanak.pek.restful.model.version.Name;
import ratanak.pek.restful.model.version.PersonV1;
import ratanak.pek.restful.model.version.PersonV2;

/**
 * Created by r.pek on 1/5/2018.
 */
@RestController
public class VersionController {
    @GetMapping("/v1/person")
    public PersonV1 v1(){
        return new PersonV1("Pek Ratanak");
    }

    @GetMapping("/v2/person")
    public PersonV2 v2(){
        return new PersonV2(new Name("Pek", "Ratanak"));
    }
}