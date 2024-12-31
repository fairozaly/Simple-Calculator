import java.util.Scanner;
import java.math.BigDecimal;
public class Calculator{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        while (true) {
        System.out.println("Enter the operation you wish to execute or enter \"exit\" to exit: ");
        String operation = input.nextLine();

        if (operation.toLowerCase().equals("exit")) {
            System.out.println("Exiting...");
            break;
        }

        int operatorPos = -1;
        String operator = "";
        
        String[] operators = {"+", "-", "/", "*", "^"};
        for (String op : operators) {
            int pos = operation.indexOf(op);
            if (pos != -1) {
                operatorPos = pos;
                operator = op;
                break;
            }
        }

        if (operatorPos == -1) {
            System.out.println("Error: Invalid operator");
            return;
        }

        String num1 = operation.substring(0, operatorPos);
        String num2 = operation.substring(operatorPos + 1);
        
        try {
            double number1 = Double.parseDouble(num1.trim());
            double number2 = Double.parseDouble(num2.trim());
        
            if (operator.equals("/") && number2 == 0) {
                System.out.println("Error: Division by zero is undefined.");
                continue;
            }
        BigDecimal result;
        switch (operator) {
            case "+":
                result = BigDecimal.valueOf(number1 + number2);
                break;
            case "-":
                result = BigDecimal.valueOf(number1 - number2);
                break;
            case "/":
                result = BigDecimal.valueOf(number1 / number2);
                break;
            case "*":
                result = BigDecimal.valueOf(number1 * number2);
                break;
            case "^":
                result = BigDecimal.valueOf(Math.pow(number1, number2));
                break;
            default:
                System.out.println("Error");
                return;
        }
        System.out.println("Result: " + result);
        }  catch (NumberFormatException e) {
            System.out.println("Error: Invalid numeric input.");
            continue;
        }
    }
    input.close();
}
}