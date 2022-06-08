package mock;

public class DataRepository implements Repository {
    private final Source source;

    public DataRepository(Source source) {
        this.source = source;
    }

    @Override
    public String getData() {
        return source.getData();
    }

    @Override
    public boolean putData(String text) {
        return source.putData(text);
    }
}
