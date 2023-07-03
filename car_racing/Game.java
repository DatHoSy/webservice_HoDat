package car_racing;

import java.util.List;

import car_racing.player.Player;

public class Game {
    public List<Player> player;

    public List<Player> getPlayer() {
        return player;
    }

    public void setPlayer(List<Player> player) {
        this.player = player;
    }

    public Game(List<Player> player) {
        this.player = player;
    }

    public Player winGame() {
        Player playerWin = this.player.get(0);
        int powerHigh = culPowerHigh(this.player.get(0));

        for (Player player : this.player) {
            int powerHighTemp = culPowerHigh(player);
            if (powerHighTemp > powerHigh) {
                playerWin = player;
            }
        }
        return playerWin;
    }

    private int culPowerHigh(Player player) {
        int power = player.getPower();
        int cool = player.getCool();
        return power + (cool / 2);
    }
}
