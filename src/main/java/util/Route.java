package util;

import java.util.HashMap;

/**
 * @author draginsky
 * @since 15.05.2023
 */
public class Route {
    public static HashMap<Integer, String> route = new HashMap<>() {
        {
            put(1, "Контур");
            put(2, "Митина");
            put(3, "Моя");
            put(4, "Маша");
        }
    };
}
