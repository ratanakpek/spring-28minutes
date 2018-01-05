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
    public PersonV1 v1() {
        return new PersonV1("Pek Ratanak");
    }

    @GetMapping("/v2/person")
    public PersonV2 v2() {
        return new PersonV2(new Name("Pek", "Ratanak"));
    }

    @GetMapping(value = "/person/param", params = "version=1")
    public PersonV1 paramv1() {
        return new PersonV1("Pek Ratanak");
    }

    @GetMapping(value = "/person/param", params = "version=2")
    public PersonV2 paramv2() {
        return new PersonV2(new Name("Pek", "Ratanak"));
    }

    @GetMapping(value = "/person/header", headers = "version=1")
    public PersonV1 headerv1() {
        return new PersonV1("Pek Ratanak");
    }

    @GetMapping(value = "/person/header", headers = "version=2")
    public PersonV2 headerv2() {
        return new PersonV2(new Name("Pek", "Ratanak"));
    }

    @GetMapping(value = "/person/produce", produces = "application/rtk.pk1+json")
    public PersonV1 producev1() {
        return new PersonV1("Pek Ratanak");
    }

    @GetMapping(value = "/person/produce", produces = "application/rtk.pk2+json")
    public PersonV2 producev2() {
        return new PersonV2(new Name("Pek", "Ratanak"));
    }
}