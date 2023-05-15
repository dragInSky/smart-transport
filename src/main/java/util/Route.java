package util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author draginsky
 * @since 15.05.2023
 */
public class Route {
    public static HashMap<Integer, String> route = (HashMap<Integer, String>) Map.ofEntries(
            Map.entry(1, "Контур"),
            Map.entry(2, "Митина"),
            Map.entry(3, "Моя"),
            Map.entry(4, "Маша")
    );
}
