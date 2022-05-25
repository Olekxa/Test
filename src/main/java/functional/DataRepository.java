package functional;

public class DataRepository implements Repository {
    private final Source source;

    public DataRepository(Source source) {
        this.source = source;
    }

    @Override
    public void insertItem(Data data) {
        this.source.insert(data);
    }

    @Override
    public boolean deleteItem() {
        return this.source.delete();

    }

    @Override
    public Data fetchItem() {
        return source.getItem();
    }
}
