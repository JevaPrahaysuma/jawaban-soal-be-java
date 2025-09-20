import java.util.*;

// Jawaban soal nomer 2
public class ValidateJson {

    public static boolean isValidJson(Object input) {
        
        if (input == null) return true;

        if (input instanceof String || 
            input instanceof Number || 
            input instanceof Boolean) {
            return true;
        }

        if (input instanceof Map) {
            Map<?, ?> map = (Map<?, ?>) input;
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                if (!(entry.getKey() instanceof String)) {
                    return false; // Key bukan String
                }
                if (!isValidJson(entry.getValue())) {
                    return false; // Value tidak valid
                }
            }
            return true;
        }

        if (input instanceof List) {
            List<?> list = (List<?>) input;
            for (Object item : list) {
                if (!isValidJson(item)) {
                    return false;
                }
            }
            return true;
        }

        if (input.getClass().isArray()) {
            Object[] array = (Object[]) input;
            for (Object item : array) {
                if (!isValidJson(item)) {
                    return false;
                }
            }
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Map<String, Object> validJson = Map.of(
            "user", Map.of(
                "name", "A",
                "age", 30,
                "isActive", true,
                "roles", List.of("admin", "editor")
            )
        );

        Map<Object, Object> invalidJson = new HashMap<>();
        invalidJson.put(123, "wrongKey");

        System.out.println(isValidJson(validJson));   // true
        System.out.println(isValidJson(invalidJson)); // false
    }
}