package ratanak.pek.restful.model.version;

/**
 * Created by r.pek on 1/5/2018.
 */
public class PersonV2 {
    private Name name;

    public PersonV2(Name name) {
        this.name = name;
    }

    public PersonV2() {
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }
}
