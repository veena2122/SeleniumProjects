package genericUtility;

import java.util.Arrays;
import java.util.Objects;

public final class StringUtil {

    private StringUtil() {}

    public static boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }

    public static String defaultIfBlank(String value, String defaultValue) {
        return isBlank(value) ? defaultValue : value;
    }

    public static String trimToNull(String value) {
        if (value == null) return null;
        String trimmed = value.trim();
        return trimmed.isEmpty() ? null : trimmed;
    }

    public static String nullSafe(String value) {
        return value == null ? "" : value;
    }

    public static String truncate(String value, int maxLength) {
        if (value == null) return null;
        if (maxLength <= 0) return "";
        return value.length() <= maxLength ? value : value.substring(0, maxLength);
    }

    public static String join(String delimiter, Object... values) {
        if (values == null || values.length == 0) return "";
        return Arrays.stream(values)
                .map(String::valueOf)
                .reduce((a, b) -> a + delimiter + b)
                .orElse("");
    }

    public static String toTitleCase(String value) {
        if (isBlank(value)) return "";
        String[] words = value.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                if (sb.length() > 0) sb.append(" ");
                sb.append(Character.toUpperCase(word.charAt(0)))
                  .append(word.substring(1).toLowerCase());
            }
        }
        return sb.toString();
    }

    public static boolean equalsIgnoreCase(String a, String b) {
        return Objects.equals(a, b) || (a != null && a.equalsIgnoreCase(b));
    }
}

