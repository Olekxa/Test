package functional;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@Deprecated
public class Example2 {

    @Test
    public void test() {
        List<String> spy = spy(new LinkedList<>());

        //optionally, you can stub out some methods:
        when(spy.size()).thenReturn(2);

        //using the spy calls *real* methods
        spy.add("one");
        spy.add("two");

        //optionally, you can verify
        verify(spy).add("one");
        verify(spy).add("two");

        assertEquals(2, spy.size());
    }
}
