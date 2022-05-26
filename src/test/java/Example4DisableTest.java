import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled("Disabled until bug #99 has been fixed")
public class Example4DisableTest {
    @Disabled("Disabled until bug #99 has been fixed")


    @Test
    void testWillBeSkipped() {
    }

    @Disabled("Disabled until bug #42 has been resolved")
    @Test
    void testWillBeSkip() {
    }
}
