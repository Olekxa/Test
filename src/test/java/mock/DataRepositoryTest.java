package mock;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class DataRepositoryTest {
    Repository repository;
    Source source;

    @BeforeEach
    void init() {
        this.source = mock(Source.class);
        this.repository = new DataRepository(source);
    }

    @Test
    void getData() {
        String expected = "text";
        Mockito.when(source.getData()).thenReturn(expected);
        String result = repository.getData();
        verify(source, times(1)).getData();
        assertEquals(expected, result);
    }

    @Test
    void putData() {
        boolean expected = true;
        Mockito.when(source.putData(anyString())).thenReturn(expected);
        boolean result = repository.putData("a");
        verify(source, times(1)).putData(anyString());
        assertEquals(expected, result);
    }
}