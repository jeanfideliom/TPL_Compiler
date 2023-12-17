public class syntaxAnalysis {
    public String syntaxAnalysis(String input) {
        String splitInput[] = input.split(">");
        String output = "";

        for (String in : splitInput) {
            output += in + ">";
        }
        if (output.equals("<data_type><identifier><delimiter>") || output.equals("<data_type><identifier><assignment_operator><value><delimiter>")) {
            return "Result: Syntax is Correct!";
        } else {
            return "Result: Syntax is Incorrect!";
        }

    }
}
