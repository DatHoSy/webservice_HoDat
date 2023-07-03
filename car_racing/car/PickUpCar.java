package car_racing.car;

public class PickUpCar extends Car{
    private int carPower;
    public int getCarPower() {
        return carPower;
    }

    public PickUpCar(String type) {
        super(type);
        this.carPower = 20;
    }

    @Override
    public int specialMethod() {
        if (super.getType().equals("VIP")) {
            System.out.println("PickUp Car is Tank!");
            return 0;
        }
        System.out.println("PickUp Car can not Tank! Car Not VIP");
        return -1;
    }
}
