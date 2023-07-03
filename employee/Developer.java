package employee;

public class Developer extends Employee {

    @Override
    public void task() {
        System.out.println("Task is Code.");
    }

    public void toolsWork() {
        System.out.println("Macbook, mouse...");
    }
}
