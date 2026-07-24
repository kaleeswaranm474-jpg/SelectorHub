package DailyTask;

// Interface
interface FoodDelivery {
    void deliverFood();
    void calculateAmount();
}

// Abstract Class
abstract class Delivery {

    String customerName;
    String address;
    double foodAmount;
    double distance;

    Delivery(String customerName, String address,
             double foodAmount, double distance) {

        this.customerName = customerName;
        this.address = address;
        this.foodAmount = foodAmount;
        this.distance = distance;
    }
}

// Zomato Class
class Zomato extends Delivery implements FoodDelivery {

    Zomato(String customerName, String address,
           double foodAmount, double distance) {

        super(customerName, address, foodAmount, distance);
    }

    public void deliverFood() {
        System.out.println("Food delivery booked through Zomato.");
    }

    public void calculateAmount() {

        double deliveryCharge = distance * 5;
        double total = foodAmount + deliveryCharge;

        System.out.println("Customer Name   : " + customerName);
        System.out.println("Delivery Place  : " + address);
        System.out.println("Food Amount     : ₹" + foodAmount);
        System.out.println("Distance        : " + distance + " km");
        System.out.println("Delivery Charge : ₹" + deliveryCharge);
        System.out.println("Total Amount    : ₹" + total);
    }
}

// Swiggy Class
class Swiggy extends Delivery implements FoodDelivery {

    Swiggy(String customerName, String address,
           double foodAmount, double distance) {

        super(customerName, address, foodAmount, distance);
    }

    public void deliverFood() {
        System.out.println("Food delivery booked through Swiggy.");
    }

    public void calculateAmount() {

        double deliveryCharge = distance * 6;
        double total = foodAmount + deliveryCharge;

        System.out.println("Customer Name   : " + customerName);
        System.out.println("Delivery Place  : " + address);
        System.out.println("Food Amount     : ₹" + foodAmount);
        System.out.println("Distance        : " + distance + " km");
        System.out.println("Delivery Charge : ₹" + deliveryCharge);
        System.out.println("Total Amount    : ₹" + total);
    }
}