package girl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by cmazxiaoma on 2017/10/27.
 * everyday is mayday.
 */
@Controller
public class DemoController {

    @RequestMapping(value = "/saylove", method = RequestMethod.GET)
    public String sayLove() {
        return "index";
    }
}
