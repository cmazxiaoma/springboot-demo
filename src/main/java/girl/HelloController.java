package girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cmazxiaoma on 2017/10/27.
 * everyday is mayday.
 */
@RestController
public class HelloController {
    @Value("${cupSize}")
    private String cupSize;

    @Value("${height}")
    private String height;

    @Value("${content}")
    private String content;

    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String say() {
        return "Hello, Spring Boot!";
    }

    @RequestMapping(value = "/display", method = RequestMethod.GET)
    public String display() {
       return "cupSize=" + cupSize + ", height=" + height;
    }

    @RequestMapping(value = "/content", method = RequestMethod.GET)
    public String displayContent() {
        return content;
    }

    @RequestMapping(value = "/properties", method = RequestMethod.GET)
    public String displayProperties() {
        return girlProperties.getCupSize() + girlProperties.getHeight();
    }
}
