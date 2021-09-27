package tictactoe.player.bot;

import tictactoe.grid.GameGrid;
import tictactoe.grid.GridCoordinate;

import java.util.Random;

class RandomMoveMaker {

    private static final Random random = new Random();

    public static GridCoordinate moveRandom(GameGrid grid) {
        GridCoordinate coordinate;
        do {
            coordinate = getRandomGridCoordinate();
        } while (grid.isBusy(coordinate));

        return coordinate;
    }

    private static GridCoordinate getRandomGridCoordinate() {
        return new GridCoordinate(random.nextInt(GameGrid.SIZE) + 1, random.nextInt(GameGrid.SIZE) + 1);
    }
}
