import java.io.*;

public class Main {
    public static void main(String[] args) {
        File file = new File("input.txt");
        File outFile = new File("output.txt");
        BufferedReader br = null;

        String result = "";
        try {

            if(!file.exists()) {
                file.createNewFile();
            }
            if(!outFile.exists()) {
                outFile.createNewFile();
            }
            FileReader reader = new FileReader(file);
            br = new BufferedReader(reader);
            FileWriter writer = new FileWriter(outFile);

            double numberOne;
            double numberTwo;
            while (br.ready()) {
                String tmp = br.readLine();
                String[] expression = tmp.split(" +");

                result += tmp + " = ";

                try {
                    numberOne = Double.parseDouble(expression[0]);
                    numberTwo = Double.parseDouble(expression[2]);
                } catch (NumberFormatException num){
                    result += "Error! Not number\n";
                    continue;
                }


                if (expression[1].length() > 1) {
                    result += "Operation Error!\n";
                } else {

                    char sign = expression[1].charAt(0);
                    switch (sign) {
                        case '+':
                            result += (numberOne + numberTwo) + "\n";
                            break;
                        case '-':
                            result += (numberOne - numberTwo) + "\n";
                            break;
                        case '/':
                            if (numberTwo == 0) {
                                result +=  "Error! Division by zero\n";

                            } else {
                                result += (numberOne / numberTwo) + "\n";
                            }
                            break;
                        case '*':
                            result += (numberOne * numberTwo) + "\n";
                            break;
                        default:
                            result += "Operation Error!\n";

                    }

                }
            }
            writer.write(result);
            reader.close();
            writer.close();

        } catch (IOException ex){
            ex.getStackTrace();
        } finally {
            try {
                br.close();
            }catch (IOException ex){
                ex.getStackTrace();
            }
        }
    }
}
