package functional;

import java.io.*;

public class FileService implements Service {
    private String fileName;

    public FileService(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void insert(Data data) {
        try {
            Utils.serialize(data, fileName);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public boolean delete() {
        File file = new File(fileName);
        return file.delete();
    }

    @Override
    public Data getItem() {
        try {
            return (Data) Utils.deserialize(fileName);
        } catch (IOException e) {
            throw new RuntimeException();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException();
        }
    }
}
