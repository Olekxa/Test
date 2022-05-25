import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class Example4DisableTest {

    @Disabled("Disabled until bug #99 has been fixed")
    class DisabledClassDemo {

        @Test
        void testWillBeSkipped() {
        }

    }
}
