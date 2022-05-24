package functional;

public class DataRepository implements Repository {
    private Service service;

    public DataRepository(Service service) {
        this.service = service;
    }

    @Override
    public void insertItem(Data data) {
        this.service.insert(data);
    }

    @Override
    public boolean deleteItem(Data data) {
        return this.service.delete(data);

    }

    @Override
    public Data fetchItem(int id) {
        return service.getItem(id);
    }
}
