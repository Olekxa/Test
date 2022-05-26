package functional;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DataRepositoryTest {
    Repository repository;

    @BeforeEach
    void init() {
        repository = new DataRepository(new FileSource("data.txt"));
    }

    @Test
    @Order(1)
    void insertItem() {
        repository.insertItem(new Data(1, ""));
    }

    @Test
    @Order(2)
    void fetchItemSuccess() {
        var data = repository.fetchItem();
        assertEquals(new Data(1, ""), data);
    }

    @Test
    @Order(3)
    void deleteItemSuccess() {
        var res = repository.deleteItem();
        assertTrue(res);
    }

    @Test
    @Order(4)
    void deleteItemFail() {
        var res = repository.deleteItem();
        assertFalse(res);
    }

    @Test
    @Order(5)
    void fetchItemFail() {
        assertThrows(RuntimeException.class, () -> repository.fetchItem());
    }

    @AfterEach
    void tearDown() {
        repository = null;
    }
}