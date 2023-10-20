import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SimpleLexer {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("functions50.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                tokenize(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void tokenize(String line) {
        String[] tokens = line.split("[ \t\n(){}\\[\\].,;]+");

        for (String token : tokens) {
            String alphaBitKeyword = replaceAlphaBitKeywords(token);

            if (isAlphaBitKeyword(alphaBitKeyword)) {
                System.out.println("AlphaBit Keyword: " + alphaBitKeyword);
            } else if (isIdentifier(token)) {
                System.out.println("Identifier: " + token);
            } else if (isConstant(token)) {
                System.out.println("Constant: " + token);
            } else if (isOperator(token)) {
                System.out.println("Operator: " + token);
            }
        }
    }

    private static boolean isAlphaBitKeyword(String token) {
        String[] alphaBitKeywords = {
            "greet", "askName", "convertToMiles", "askAge", "repeat", "until", "check", "otherwise",
        "event", "add", "subtract", "multiply", "divide", "findRemainder", "areSame", "areDifferent",
        "isBigger", "isSmaller", "whisperMessage", "shoutMessage", "currentDate", "currentTime",
        "daysUntilBirthday", "findMax", "findMin", "sumArray", "averageArray", "sortArray",
        "listFiles", "readFile", "writeToFile", "generateRandomNumber", "convertToBinary",
        "convertToHexadecimal", "calculateAreaOfCircle", "calculatePerimeterOfRectangle",
        "calculateAreaOfTriangle", "isLeapYear", "countVowels", "countWords", "convertCelsiusToFahrenheit",
        "convertFahrenheitToCelsius", "doubleNumber", "halfNumber", "isMultiple", "swap",
        "roundToNextWhole", "roundToPreviousWhole", "countUpTo", "countDownFrom","share", "group", "constant", "nothing", "whole", "decimal", "choice", "word",
            "giveback", "check", "otherwise", "repeat", "until", "show", "get", "fresh", "Input", "readnext"
        };

        for (String keyword : alphaBitKeywords) {
            if (keyword.equals(token)) {
                return true;
            }
        }

        return false;
    }

    private static boolean isIdentifier(String token) {
        return token.matches("[a-zA-Z_][a-zA-Z_0-9]*");
    }

    private static boolean isConstant(String token) {
        return token.matches("-?\\d+(\\.\\d+)?");
    }

    private static boolean isOperator(String token) {
        return token.matches("[-+*/%<>=&|^!~.,;{}\\[\\]()#]+");
    }

    private static String replaceAlphaBitKeywords(String token) {
        // Replace Java keywords with AlphaBit keywords
        switch (token) {
            case "public":
                return "share";
            case "class":
                return "group";
            case "static":
                return "constant";
            case "void":
                return "nothing";
            case "int":
                return "whole";
            case "double":
                return "decimal";
            case "boolean":
                return "choice";
            case "String":
                return "word";
            case "return":
                return "giveback";
            case "if":
                return "check";
            case "else":
                return "otherwise";
            case "for":
                return "repeat";
            case "while":
                return "until";
            case "System.out.println":
                return "show";
            case "import":
                return "get";
            case "new":
                return "fresh";
            case "Scanner":
                return "Input";
            case "next":
                return "readnext";
            default:
                return token;
        }
    }
}


