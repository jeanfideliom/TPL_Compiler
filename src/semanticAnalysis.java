public class semanticAnalysis {
    public String semanticAnalysis(String dataType, String value) {
        try {
            if (dataType.equals("String") && value.startsWith("\"") && value.endsWith("\"")) {
                return "Semantically Correct!";
            } else if (dataType.equals("int") && Integer.parseInt(value) >= Integer.MIN_VALUE && Integer.parseInt(value) <= Integer.MAX_VALUE) {
                return "Semantically Correct!";
            } else if (dataType.equals("long") && (Long.parseLong(value) >= Long.MIN_VALUE && Long.parseLong(value) <= Long.MAX_VALUE)) {
                return "Semantically Correct!";
            } else if (dataType.equals("float") && (Long.parseLong(value) >= Float.MIN_VALUE && Long.parseLong(value) <= Float.MAX_VALUE)) {
                return "Semantically Correct!";
            } else if (dataType.equals("double") && (Double.parseDouble(value) >= Double.MIN_VALUE && Double.parseDouble(value) <= Double.MAX_VALUE)) {
                return "Semantically Correct!";
            } else if (dataType.equals("byte") && (Byte.parseByte(value) >= Byte.MIN_VALUE && Byte.parseByte(value) <= Byte.MAX_VALUE)) {
                return "Semantically Correct!";
            } else if (dataType.equals("short") && (Short.parseShort(value) >= Short.MIN_VALUE && Short.parseShort(value) <= Short.MAX_VALUE)) {
                return "Semantically Correct!";
            } else {
                return "Semantically Incorrect!";
            }
        } catch (NumberFormatException e) {
            return "Semantically Incorrect!";

        }
    }
}
