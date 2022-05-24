package functional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DataRepositoryTest {
    @Mock
    Service service;
    Repository repository;
    @Mock
    Data data;

    @BeforeEach
    void init() {
        repository = new DataRepository(service);
        Mockito.lenient().when(service.delete(data)).thenReturn(true);
    }

    @Test
    void deleteItem() {
        repository.deleteItem(data);
        Mockito.verify(service).delete(data);
    }
    
}