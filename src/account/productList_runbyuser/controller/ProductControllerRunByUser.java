package account.productList_runbyuser.controller;

import java.util.List;

public class ProductControllerRunByUser {
    ProductManagementImp1 productManagement = new ProductManagementImp1();

    public List<Product> showAll() {
        return productManagement.showAll();
    }

    public Product findProductById (int index) {
        return productManagement.findProductById(index);
    }

    public void writeToFile() {
        productManagement.writeToFile();
    }

    public void removeProduct(int index) {
        productManagement.removeProduct(index);
    }
}
