package car_racing.car;

public abstract class Car {
    private String type;

    public Car(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public abstract int specialMethod();

}
