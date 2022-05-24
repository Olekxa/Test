package functional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class DataRepositoryTest {
    @Mock
    Service service;
    Repository repository;


    @BeforeEach
    void init() {
        repository = new DataRepository(service);
    }

    @Test
    void insertItem() {

        repository.insertItem(new Data(1, ""));
        Mockito.verify(service).insert(any());

    }

    @Test
    void deleteItemSuccess() {
        Mockito.lenient().when(service.delete(any())).thenReturn(true);
        var res = repository.deleteItem(new Data(1, ""));
        Mockito.verify(service).delete(any());
        assertTrue(res);
    }

    @Test
    void deleteItemFail() {
        Mockito.lenient().when(service.delete(any())).thenReturn(false);
        var res = repository.deleteItem(new Data(1, "F"));
        Mockito.verify(service).delete(any());
        assertFalse(res);
    }


    @Test
    void fetchItem() {
        repository.fetchItem(1);
        Mockito.verify(service).getItem(1);
    }
}