import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        File file = new File("input.txt");
        String[] expression = input.nextLine().split(" +");
        input.close();
        try {
            FileReader reader = new FileReader(file);
            double numberOne = Double.parseDouble(expression[0]);
            double numberTwo = Double.parseDouble(expression[2]);
            if (expression[1].length() > 1) {
                throw new Exception("Operation Error!");
            }
            char sign = expression[1].charAt(0);
            double result;
            switch (sign) {
                case '+':
                    result = numberOne + numberTwo;
                    break;
                case '-':
                    result = numberOne - numberTwo;
                    break;
                case '/':
                    if (numberTwo == 0) {
                        throw new Exception("Error! Division by zero");
                    }
                    result = numberOne / numberTwo;
                    break;
                case '*':
                    result = numberOne * numberTwo;
                    break;
                default:
                    throw new Exception("Operation Error!");
            }
            System.out.println(result);

        } catch (NumberFormatException num) {
            System.out.println("Error! Not number");
        } catch (Exception operation) {
            System.out.println(operation.getMessage());
        }
    }
}
