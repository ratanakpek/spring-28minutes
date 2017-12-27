package ratanak.pek.restful;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;

/**
 * Created by r.pek on 12/27/2017.
 */
public class DEFAULT_API_INFO {
    public static final Contact DEFAULT_CONTACT = new Contact("Ratanak Pek", "http://localhost:8888/", "ratanakpek088@gmail.com");
    public static final ApiInfo DEFAULT;
    static {
        DEFAULT = new ApiInfo("Api Documentation", "Api Documentation", "1.0", "urn:tos", DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
    }
}
