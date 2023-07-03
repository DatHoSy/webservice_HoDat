package shop;

import java.util.List;

public class Order {
    private List<Product> listProduct;

    public Order(List<Product> listProduct) {
        this.listProduct = listProduct;
    }

    public List<Product> getListProduct() {
        return listProduct;
    }
}
