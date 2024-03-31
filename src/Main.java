import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        try {
            File file = new File("input.txt");
            file.createNewFile();
            File file2 = new File("output.txt");
            file2.createNewFile();
            FileReader reader = new FileReader(file);
            Scanner input = new Scanner(reader);
            String[] expression = input.nextLine().split(" +");
            input.close();
            reader.close();
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
            // System.out.println(result);
            FileWriter fileWriter = new FileWriter(file2);
            fileWriter.write(String.valueOf(result));
            fileWriter.close();
        } catch (NumberFormatException num) {
            System.out.println("Error! Not number");
        } catch (Exception operation) {
            System.out.println(operation.getMessage());
        }
    }
}
