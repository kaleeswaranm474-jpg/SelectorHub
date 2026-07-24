package ProjectTwo;

public class Customer {


    private int customerId;
    private String customerName;
    private String phoneNumber;



    // Constructor

    public Customer(int customerId, String customerName,
                    String phoneNumber) {

        this.customerId = customerId;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;

    }



    // Getter Methods

    public int getCustomerId() {

        return customerId;
    }



    public String getCustomerName() {

        return customerName;
    }



    public String getPhoneNumber() {

        return phoneNumber;
    }




    // Display Customer Details

    public String toString() {


        return "Customer ID   : " + customerId +
               "\nCustomer Name : " + customerName +
               "\nPhone Number  : " + phoneNumber;

    }

}