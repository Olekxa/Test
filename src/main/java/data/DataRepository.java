package data;

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
        if (validate(text)) {
            return source.putData(text);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean validate(String text) {
        return text != null && !text.isEmpty();
    }
}

