package DailyTask;

import java.util.Scanner;

class Patient {

   
    private int patientId;
    private String patientName;
    private String disease;
    private double billAmount;


    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getDisease() {
        return disease;
    }

    public double getBillAmount() {
        return billAmount;
    }
}

public class HospitalPatientRecord {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of patients: ");
        int n = sc.nextInt();
        sc.nextLine();

        Patient[] patients = new Patient[n];

       
        for (int i = 0; i < n; i++) {

            patients[i] = new Patient();

            System.out.println("\nEnter details for Patient " + (i + 1));

            System.out.print("Patient ID: ");
            patients[i].setPatientId(sc.nextInt());
            sc.nextLine();

            System.out.print("Patient Name: ");
            patients[i].setPatientName(sc.nextLine());

            System.out.print("Disease: ");
            patients[i].setDisease(sc.nextLine());

            System.out.print("Bill Amount: ");
            patients[i].setBillAmount(sc.nextDouble());
            sc.nextLine();
        }

        System.out.println("\n----- Patient Records -----");

        for (int i = 0; i < n; i++) {

            System.out.println("\nPatient " + (i + 1));
            System.out.println("Patient ID   : " + patients[i].getPatientId());
            System.out.println("Patient Name : " + patients[i].getPatientName());
            System.out.println("Disease      : " + patients[i].getDisease());
            System.out.println("Bill Amount  : ₹" + patients[i].getBillAmount());
        }

        sc.close();
    }
}