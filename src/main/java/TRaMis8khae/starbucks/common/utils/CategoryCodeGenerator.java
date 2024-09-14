package TRaMis8khae.starbucks.common.utils;

import java.util.UUID;

public class CategoryCodeGenerator {

    public static String generateCategoryCode() {
        return UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

}
