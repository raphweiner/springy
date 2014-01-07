package springy;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api")
public class SpringyController {
    private static final String template = "Hello, %s!";

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public
    @ResponseBody
    Greeting greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        return new Greeting(String.format(template, name));
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String post() {
        return "You made a post. Congrats!";
    }
}