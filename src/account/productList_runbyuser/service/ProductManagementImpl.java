package account.productList_runbyuser.service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ProductManagementImpl implements IProductManagement {
    public static List<Product> productList = new ArrayList<>();
    public static String filePatch = "products.txt";

    @Override
    public List<Product> showAll() {
        return productList = readFile();
    }

    @Override
    public Product findProductById(int index) {
        return productList.get(index);
    }

    @Override
    public List<Product> readFile() {
        List<Product> newProductList = new ArrayList<>();
        try {
            File file;
            FileReader fileReader = new FileReader(filePatch);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String products[] = line.split(",");
                Product newProduct1 = new Product(Integer.parseInt(products[0]), products[1], Integer.parseInt(products[2]), Integer.parseInt(products[3]), products[4]);
                newProductsList.add(newProduct1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newProductList;
    }

    @Override
    public void writeToFile() {
        try {
            FileWriter fileWriter = new FileWriter(filePatch);
            for (Product x : productList) {
                String productLine = x.getId() + ","
                        + x.getName() + ","
                        + x.getPrice() + ","
                        + x.getQuantity() + ","
                        + x.getDescription() + "\n";
                fileWriter.write(productLine);
            }
            fileWriter.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeProduct(int index) {
        showAll();
        productList.remove(index);
        writeToFile();
    }
}
