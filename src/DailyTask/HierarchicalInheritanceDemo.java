package DailyTask;

class Product {

    int productId;
    String productName;
    double productPrice;

    Product(int productId, String productName, double productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    void displayProduct() {
        System.out.println("Product ID    : " + productId);
        System.out.println("Product Name  : " + productName);
        System.out.println("Product Price : " + productPrice);
    }
}


class Electronics extends Product {

    int warranty;

    Electronics(int productId, String productName, double productPrice, int warranty) {
        super(productId, productName, productPrice);
        this.warranty = warranty;
    }

    @Override
    void displayProduct() {
        System.out.println("\n--- Electronics Product ---");
        super.displayProduct();
        System.out.println("Warranty      : " + warranty + " Years");
    }
}

class Clothing extends Product {

    String size;

    Clothing(int productId, String productName, double productPrice, String size) {
        super(productId, productName, productPrice);
        this.size = size;
    }

    @Override
    void displayProduct() {
        System.out.println("\n--- Clothing Product ---");
        super.displayProduct();
        System.out.println("Size          : " + size);
    }
}


class Food extends Product {

    String expiryDate;

    Food(int productId, String productName, double productPrice, String expiryDate) {
        super(productId, productName, productPrice);
        this.expiryDate = expiryDate;
    }

    @Override
    void displayProduct() {
        System.out.println("\n--- Food Product ---");
        super.displayProduct();
        System.out.println("Expiry Date   : " + expiryDate);
    }
}

public class HierarchicalInheritanceDemo {

    public static void main(String[] args) {

        Electronics e = new Electronics(101, "Laptop", 65000, 2);
        Clothing c = new Clothing(102, "T-Shirt", 1200, "L");
        Food f = new Food(103, "Chocolate", 150, "31-12-2026");

        e.displayProduct();
        c.displayProduct();
        f.displayProduct();
    }
}