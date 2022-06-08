package data;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    void getData() {
        Source source = mock(Source.class);
        DataRepository repository = new DataRepository(source);
        String expectedResult = "text";
        Mockito.when(source.getData()).thenReturn(expectedResult);

        String result = repository.getData();

        verify(source, times(1)).getData();
        assertEquals(expectedResult, result);
    }

    @Test
    void putData() {
        Source source = mock(Source.class);
        DataRepository repository = new DataRepository(source);
        boolean expectedResult = true;
        Mockito.when(source.putData(anyString())).thenReturn(expectedResult);

        boolean result = repository.putData("test data");

        verify(source, times(1)).putData("test data");
        assertEquals(expectedResult, result);
    }

    @Test
    void putDataValid() {
        Source source = mock(Source.class);
        DataRepository repository = spy(new DataRepository(source));
        when(source.putData(anyString())).thenReturn(true);

        boolean result = repository.putData("info");

        verify(repository).validate(anyString());
        verify(source).putData(anyString());
        assertTrue(result);
    }

    @Test()
    void putDataInvalid() {
        Source source = mock(Source.class);
        DataRepository repository = spy(new DataRepository(source));

        assertThrowsExactly(IllegalArgumentException.class, () -> repository.putData(""));

        verify(repository).validate(anyString());
        verify(source, never()).putData(anyString());
    }
}