package data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class DataRepositoryTest {
    Source source;

    @BeforeEach
    public void beforeMethod() {
        source = mock(Source.class);
    }

    @Test
    void getData() {
        String expectedResult = "text";
        DataRepository repository = new DataRepository(source);
        when(source.getData()).thenReturn(expectedResult);

        String result = repository.getData();

        verify(source, times(1)).getData();
        assertEquals(expectedResult, result);
    }

    @Test
    void putData() {
        boolean expectedResult = true;
        DataRepository repository = new DataRepository(source);
        Mockito.when(source.putData(anyString())).thenReturn(expectedResult);

        boolean result = repository.putData("test data");

        verify(source, times(1)).putData("test data");
        assertEquals(expectedResult, result);
    }

    @Test
    void putDataValidWithSpy() {
        DataRepository repository = spy(new DataRepository(source));
        when(source.putData(anyString())).thenReturn(true);

        boolean result = repository.putData("info");

        verify(repository).validate(anyString());
        verify(source).putData(anyString());
        assertTrue(result);
    }

    @Test()
    void putDataInvalid() {
        DataRepository repository = spy(new DataRepository(source));

        verify(repository).validate(anyString());
        verify(source, never()).putData(anyString());

        assertThrowsExactly(IllegalArgumentException.class, () -> repository.putData(""));
    }

    @Test()
    void thenReturnConsecutive() {
        DataRepository repository = spy(new DataRepository(source));
        when(source.getData()).thenReturn("a", "z");

        assertEquals("a", repository.getData());
        assertEquals("z", repository.getData());
        assertEquals("z", repository.getData());
    }

    @Test
    public void thenAnswerThrowException() {                                // & change behavior
        DataRepository repository = spy(new DataRepository(source));
        when(repository.putData(""))
                .thenAnswer(invocation -> {
                    throw new IllegalArgumentException();
                });
    }

    @Test
    public void thenThrowException() {
        DataRepository repository = spy(new DataRepository(source));
        when(repository.putData(""))
                //.thenThrow(IllegalArgumentException.class);
        .thenThrow(new IllegalArgumentException());

        verify(source, never()).getData();
    }
}