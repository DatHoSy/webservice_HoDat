package employee;

public class Salesperson extends Employee{

    @Override
    public void task() {
        System.out.println("Task is call customer");
    }

    public void callToCustomer() {
        System.out.println("Min 4h/1day.");
    }

}
