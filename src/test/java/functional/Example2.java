package functional;

import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;

//@ExtendWith(MockitoExtension.class)
public class Example2 {

    @Test
    public void test() {
        DecimalFormat decimalFormat = spy(new DecimalFormat());
        assertEquals("42", decimalFormat.format(42L));
    }
}
