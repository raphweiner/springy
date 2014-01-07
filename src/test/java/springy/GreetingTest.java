package springy;

import org.junit.Test;
import static org.fest.assertions.Assertions.assertThat;

public class GreetingTest {
    @Test
    public void testGreeting() {
        Greeting greeting = new Greeting(1, "Bonjour");

        assertThat(greeting.getId()).isEqualTo(1);
        assertThat(greeting.getContent()).isEqualTo("Bonjour");
    }
}