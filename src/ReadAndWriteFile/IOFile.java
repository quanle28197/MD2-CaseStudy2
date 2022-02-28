package ReadAndWriteFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class IOFile<E> {
    public void writerFileData(List<E> arrayData, String pathname) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(pathname);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.write(arrayData);
            fileOutputStream.close();
            objectOutputStream.close();
        }catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public List<E> readFileData(String pathname) {
        List<E> userList = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(pathname);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileInputStream);
            userList = (List<E>) objectOutputStream.readObject();
            fileInputStream.close();
            objectOutputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return userList;
    }

    public void clearFileData(List<E> arrayData, String pathname) throws IOException {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(pathname);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(FileOutputStream);
            objectOutputStream.writeObject(arrayData);
            fileOutputStream.close();
            objectOutputStream.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
