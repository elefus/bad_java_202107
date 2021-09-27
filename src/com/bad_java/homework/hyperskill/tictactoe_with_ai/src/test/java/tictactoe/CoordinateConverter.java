package tictactoe;

import lombok.val;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import tictactoe.grid.GridCoordinate;

public class CoordinateConverter extends SimpleArgumentConverter {

    @Override
    public GridCoordinate convert(Object o, Class<?> aClass) {
        val split = ((String) o).split("\\s");

        return new GridCoordinate(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
    }
}
