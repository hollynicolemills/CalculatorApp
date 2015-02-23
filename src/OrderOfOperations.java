import java.util.Stack;
import java.util.Scanner;

public class OrderOfOperations {
	String token = "";
	
	public double readInput (String exp){
		Scanner input = new Scanner(exp);
		Stack<Double> num = new Stack<Double>();
		Stack<String> op = new Stack<String>();
		
		while (input.hasNext()){
			token = input.next();
			if(isNumber(token)){
				num.push(Double.parseDouble(token));
			} else if (token.equals("(")){
				op.push(token);
			} else if (token.equals(")")){
				while(!op.peek().equals("("))
					num.push(evaluate(op.pop(), num.pop(), num.pop()));
				op.pop();
			} else {
				while(!op.empty() && hasPrecedence(token, op.peek())){
					num.push(evaluate(op.pop(), num.pop(), num.pop()));
				} op.push(token);
			} 
		}
	
		while (!op.empty()) {
			num.push(evaluate(op.pop(), num.pop(), num.pop())); 
		} return num.pop();
	}
	
	public static boolean isNumber (String exp){
		if (exp.startsWith("0"))
			return true;
		else if (exp.startsWith("1"))
			return true;
		else if (exp.startsWith("2"))
			return true;
		else if (exp.startsWith("3"))
			return true;
		else if (exp.startsWith("4"))
			return true;
		else if (exp.startsWith("5"))
			return true;
		else if (exp.startsWith("6"))
			return true;
		else if (exp.startsWith("7"))
			return true;
		else if (exp.startsWith("8"))
			return true;
		else if (exp.startsWith("9"))
			return true;
		else
			return false;
	}

	public static boolean hasPrecedence(String op1, String op2)
    {
        if (op2.equals("(") || op2.equals(")"))
            return false;
        if ((op1.equals("*") || op1.equals("/")) && (op2.equals("+") || op2.equals("-")))
            return false;
        if (op1.equals("^") && (op2.equals("/") || op2.equals("*")))
            return false;
        if (op1.equals("^") && (op2.equals("-") || op2.equals("+")))
            return false;
        else
            return true;
    }
 
 	public static double evaluate (String operation, double num2, double num1) {
		
		if(operation.equals("+")) {
			num1 = num1 + num2;
		} else if(operation.equals("-")){
			num1 = num1 - num2;
		} else if(operation.equals("*")){
			num1 = num1 * num2;
		} else if(operation.equals("/")){
			num1 = num1 / num2;
    } else if(operation.equals("^")){
      num1 = Math.pow(num1, num2);
		} return num1;
	}
}
                
