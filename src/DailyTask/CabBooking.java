package DailyTask;

// Interface
interface CabBooking {
    void bookRide();
    void calculateFare();
}

// Abstract Class
abstract class Cab {

    String customerName;
    double distance;

    Cab(String customerName, double distance) {
        this.customerName = customerName;
        this.distance = distance;
    }
}

// Mini Cab
class MiniCab extends Cab implements CabBooking {

    MiniCab(String customerName, double distance) {
        super(customerName, distance);
    }

    public void bookRide() {
        System.out.println("Mini Cab booked successfully.");
    }

    public void calculateFare() {
        double fare = distance * 12;
        System.out.println("Customer Name : " + customerName);
        System.out.println("Distance      : " + distance + " km");
        System.out.println("Mini Cab Fare : ₹" + fare);
    }
}

// Auto Cab
class AutoCab extends Cab implements CabBooking {

    AutoCab(String customerName, double distance) {
        super(customerName, distance);
    }

    public void bookRide() {
        System.out.println("Auto Cab booked successfully.");
    }

    public void calculateFare() {
        double fare = distance * 10;
        System.out.println("Customer Name : " + customerName);
        System.out.println("Distance      : " + distance + " km");
        System.out.println("Auto Cab Fare : ₹" + fare);
    }
}

// Sedan Cab
class SedanCab extends Cab implements CabBooking {

    SedanCab(String customerName, double distance) {
        super(customerName, distance);
    }

    public void bookRide() {
        System.out.println("Sedan Cab booked successfully.");
    }

    public void calculateFare() {
        double fare = distance * 18;
        System.out.println("Customer Name : " + customerName);
        System.out.println("Distance      : " + distance + " km");
        System.out.println("Sedan Cab Fare: ₹" + fare);
    }
}