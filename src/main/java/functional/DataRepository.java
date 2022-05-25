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
    public boolean deleteItem() {
        return this.service.delete();

    }

    @Override
    public Data fetchItem() {
        return service.getItem();
    }
}
