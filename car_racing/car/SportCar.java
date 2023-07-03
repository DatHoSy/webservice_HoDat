package car_racing.car;

public class SportCar extends Car{
    private int carCool;
    public int getCarCool() {
        return carCool;
    }

    public SportCar(String type) {
        super(type);
        this.carCool = 20;
    }

    @Override
    public int specialMethod() {
        if (super.getType().equals("VIP")) {
            System.out.println("Sport Car is Flying!");
            return 1;
        }
        System.out.println("Sport Car can not Flying! Car Not VIP");
        return -1;
    }
}