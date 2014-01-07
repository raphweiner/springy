package springy;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class SpringyController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public
    @ResponseBody
    Greeting greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        return new Greeting((int) counter.incrementAndGet(), String.format(template, name));
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String post() {
        return "You made a post. Congrats!";
    }
}