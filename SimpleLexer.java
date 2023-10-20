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
            if (isKeyword(token)) {
                System.out.println("Keyword: " + token);
            } else if (isIdentifier(token)) {
                System.out.println("Identifier: " + token);
            } else if (isConstant(token)) {
                System.out.println("Constant: " + token);
            } else if (isOperator(token)) {
                System.out.println("Operator: " + token);
            }
        }
    }

    private static boolean isKeyword(String token) {
        String[] keywords = {
            "break", "case", "char", "const", "continue", "default", "do",
            "double", "else", "enum", "extern", "float", "for", "goto", "if",
            "int", "long", "register", "return", "short", "signed", "sizeof",
            "static", "struct", "switch", "typedef", "union", "unsigned", "void",
            "while"
        };

        for (String keyword : keywords) {
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
}


