package functional;

public interface Service {

    void insert(Data data);

    boolean delete(Data data);

    Data getItem(int id);

}
