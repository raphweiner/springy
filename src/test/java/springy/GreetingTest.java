package springy;

import org.junit.Test;
import static org.fest.assertions.Assertions.assertThat;

public class GreetingTest {
    @Test
    public void testGreeting() {
        Greeting greeting = new Greeting("Bonjour");

        assertThat(greeting.getContent()).isEqualTo("Bonjour");
    }
}