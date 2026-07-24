package ProjectTwo;

public class Customer {

    private int customerId;

    private String customerName;

    private int age;

    private String phoneNumber;

    private String password;


    // Constructor

    public Customer(int customerId,
                    String customerName,
                    int age,
                    String phoneNumber,
                    String password) {

        this.customerId = customerId;
        this.customerName = customerName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.password = password;

    }


    // Getter Methods

    public int getCustomerId() {

        return customerId;
    }


    public String getCustomerName() {

        return customerName;
    }


    public int getAge() {

        return age;
    }


    public String getPhoneNumber() {

        return phoneNumber;
    }


    public String getPassword() {

        return password;
    }



    // Display Customer Details

    @Override
    public String toString() {

        return "Customer ID   : " + customerId
                + "\nCustomer Name : " + customerName
                + "\nAge           : " + age
                + "\nPhone Number  : " + phoneNumber;

    }

}