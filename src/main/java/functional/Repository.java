package functional;

public interface Repository {

    void insertItem(Data data);

    boolean deleteItem();

    Data fetchItem();

}
