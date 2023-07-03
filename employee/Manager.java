package employee;

public class Manager extends Employee{

    @Override
    public void task() {
        System.out.println("Task is estimate time.");
    }

    public void presented() {
        System.out.println("Presentation every friday.");
    }
}
