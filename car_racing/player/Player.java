package car_racing.player;

import car_racing.car.Car;

public class Player implements FeatPlayer {
    private final int BUFF_300 = 300;
    private final int BUFF_200 = 200;
    private final int BUFF_100 = 100;
    private int power;
    private int cool;
    private String name;
    private boolean isFirstTimePurchase;
    private Car car;

    public Player(String name, Car car) {
        this.name = name;
        this.car = car;
        if (car.getType().equals("VIP")) {
            buffPowerAndCool(50, 50, "Car VIP! ");
        }

    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getCool() {
        return cool;
    }

    public void setCool(int cool) {
        this.cool = cool;
    }

    public boolean isFirstTimePurchase() {
        return isFirstTimePurchase;
    }

    public void setFirstTimePurchase(boolean isFirstTimePurchase) {
        if (isFirstTimePurchase) {
            power += 20;
        }
        this.isFirstTimePurchase = isFirstTimePurchase;
    }

    @Override
    public void pickUpHead() {
        if (isFirstTimePurchase) {
            buffPowerAndCool(BUFF_200, BUFF_200, "Pick Up Head! ");
            return;
        }
        System.out.println("Please first time Purchase!");
    }

    @Override
    public void pickUpHeadAndHandsOff() {
        if (isFirstTimePurchase) {
            buffPowerAndCool(BUFF_300, BUFF_300, "Pick Up Head And Hands Off! ");
            return;
        }
        System.out.println("Please first time Purchase!");
    }

    @Override
    public void handsOff() {
        buffPowerAndCool(BUFF_200, BUFF_100, "Hands Off! ");
    }

    @Override
    public void speedUp() {
        power += 50;
        System.out.println("Power + 50!");
    }

    @Override
    public void collide(Player player2) {
        int powerDivide = (this.power / 10);
        player2.setPower(player2.getPower() - powerDivide);
        System.out.println("Collide! Power " + player2.getName() + " - " + powerDivide);
    }

    @Override
    public void driff() {
        if (this.power >= 50) {
            System.out.println("So Cool!");
            buffPowerAndCool(-30, BUFF_100, "Driff! ");
            return;
        }
        System.out.println("Not enough power to use driff!");
    }

    @Override
    public void specialMethod() {
        int type = car.specialMethod();
        if (type == 1) {
            buffPowerAndCool(30, 500, "Flying! ");
            return;
        } else if (type == 0) {
            buffPowerAndCool(200, 30, "Tank! ");
            return;
        }
    }

    private void buffPowerAndCool(int power, int cool, String mess) {
        this.power += power;
        this.cool += cool;
        String str = " + ";
        if (power < 0) {
            str = " ";
        }
        System.out.println(mess + "Power" + str + power + " and Cool + " + cool + "!");
    }

}
