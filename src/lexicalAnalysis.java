import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class lexicalAnalysis {
    private String output;
    private String dataType;
    private String value;

    public String lexicalAnalysis(String input) {

        HashMap<String, String> tokenMap = new HashMap<>();

        //datatype
        tokenMap.put("int", "DATA_TYPE");
        tokenMap.put("String", "DATA_TYPE");
        tokenMap.put("float", "DATA_TYPE");
        tokenMap.put("char", "DATA_TYPE");
        tokenMap.put("long", "DATA_TYPE");
        tokenMap.put("byte", "DATA_TYPE");
        tokenMap.put("boolean", "DATA_TYPE");
        tokenMap.put("double", "DATA_TYPE");

        //operators
        tokenMap.put("=", "ASSIGNMENT_OPERATOR");
        tokenMap.put("+", "ASSIGNMENT_OPERATOR");
        tokenMap.put("-", "ASSIGNMENT_OPERATOR");
        tokenMap.put("%", "ASSIGNMENT_OPERATOR");
        tokenMap.put("+=", "ASSIGNMENT_OPERATOR");
        tokenMap.put("-=", "ASSIGNMENT_OPERATOR");
        tokenMap.put("*=", "ASSIGNMENT_OPERATOR");
        tokenMap.put("/=", "ASSIGNMENT_OPERATOR");
        tokenMap.put("/", "ASSIGNMENT_OPERATOR");

        //delimiter
        tokenMap.put(";", "DELIMITER");

        ArrayList<String> splitInput = tokenize(input);
        List<String> outputList = new ArrayList<String>();
        for (String lex : splitInput) {
            String tokenType = tokenMap.get(lex);

            if (tokenType != null) {
                switch (tokenType) {
                    case "DATA_TYPE":
                        outputList.add("<data_type>");
                        this.dataType = lex;
                        break;
                    case "ASSIGNMENT_OPERATOR":
                        outputList.add("<assignment_operator>");
                        break;
                    case "DELIMITER":
                        outputList.add("<delimiter>");
                        break;
                    default:
                        return ("Error!");
                }
            } else {
                //identifier
                if (isIdentifier(lex)) {
                    outputList.add("<identifier>");
                }
                //value
                else if (lex.matches("[0-9]+") || lex.startsWith("\"") && lex.endsWith("\"")) {
                    outputList.add("<value>");
                    this.value = lex;
                }
            }
        }
        for (String hold : outputList)
        {
            output += hold;
        }
        return output;
    }


    public static boolean isIdentifier(String lexeme) {
        // Define the regular expression pattern for an identifier
        String identifierPattern = "[a-zA-Z_][a-zA-Z0-9_]*";

        // Check if the lexeme matches the pattern
        return lexeme.matches(identifierPattern);
    }

    public static ArrayList<String> tokenize(String input) {
        ArrayList<String> tokens = new ArrayList<>();
        StringBuilder currentToken = new StringBuilder();
        boolean insideQuotes = false;

        for (char c : input.toCharArray()) {
            if (c == '\"') {
                insideQuotes = !insideQuotes;
            }

            if (Character.isWhitespace(c) && !insideQuotes) {
                if (currentToken.length() > 0) {
                    tokens.add(currentToken.toString());
                    currentToken.setLength(0);
                }
            } else {
                currentToken.append(c);
            }
        }

        if (currentToken.length() > 0) {
            tokens.add(currentToken.toString());
        }

        return tokens;
    }
}