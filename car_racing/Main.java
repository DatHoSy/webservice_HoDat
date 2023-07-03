package car_racing;

import java.util.ArrayList;
import java.util.List;

import car_racing.car.PickUpCar;
import car_racing.car.SportCar;
import car_racing.player.Player;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("DatBike", new SportCar("VIP"));
        Player player2 = new Player("BaoBike", new SportCar("Normal"));
        Player player3 = new Player("NamBike", new PickUpCar("VIP"));

        Game game1 = new Game(new ArrayList<>(List.of(player1, player2, player3)));

        System.out.println("===============Game Start===============");
        // player1
        System.out.println("Player1:");
        player1.setFirstTimePurchase(true);
        player1.pickUpHeadAndHandsOff();
        // player1.driff();
        // player1.pickUpHead();
        System.out.println("===============");

        // player2
        System.out.println("Player2:");
        player2.pickUpHeadAndHandsOff();
        //player2.handsOff();
        // player2.collide(player1);
        //player2.special();
        // player2.pickUpHeadAndHandsOff();
        System.out.println("===============");

        // player3
        System.out.println("Player3:");
        // player3.pickUpHeadAndHandsOff();
        //player3.special();
        System.out.println("===============");

        System.out.println("List Player: ");
        for (Player player : game1.getPlayer()) {
            System.out.println(
                    "player: " + player.getName() + " Power: " + player.getPower() + " Cool: " + player.getCool());
        }

        Player winPlayer = game1.winGame();
        System.out.println(
                "Winer: " + winPlayer.getName() + " Power: " + winPlayer.getPower() + " Cool: " + winPlayer.getCool());
    }
}
