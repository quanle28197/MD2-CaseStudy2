package account.productList_runbyuser.service;

import java.util.List;

public interface IProductManagement {
    List<Product> showAll();

    Product findProductById(int index);

    List<Product> readFile;

    void writeToFile();

    void removeProduct(int index);
}
