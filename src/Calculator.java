import java.util.Stack;
import java.util.Scanner;

public class Calculator {
	private String token = "";
    private String exception = "";
    
    public String getException (){
        return exception;
    }
    
    public boolean checkInput (String in){
        int open = 0;
        int closed = 0;
        int opCount = 0;
        int numCount = 0;
        int sqrtCount =0;
        boolean valid = true;
        
        Scanner reader = new Scanner(in);
            
        while (reader.hasNext()){
            token = reader.next();
            if (token.equals("("))
                open++;
            if (token.equals(")"))
                closed++;
            if (isNumber(token))
                numCount++;
            if (isOperator(token))
                opCount++;
            if (token.equals("sqrt"))
                sqrtCount++;
        }
        
        if (open != closed){
            valid = false;
            exception = "Error: unbalanced parenthesis";
        }
        
       if (numCount <= opCount){
            valid = false;
            exception = "Error: too many operators";
        }  

       if (opCount == 0 && sqrtCount == 0){
            valid = false;
            exception = "Error: no operator";
       }return valid;
    }
    
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
                while(!op.peek().equals("(")){
                    if (op.peek().equals("sqrt")){
                        num.push(Math.sqrt(num.pop()));
                        op.pop();
                    } else
                        num.push(evaluate(op.pop(), num.pop(), num.pop()));
                }
				op.pop();
			} else {
				while(!op.empty() && hasPrecedence(token, op.peek())){
                    if (op.peek().equals("sqrt")){
                        num.push(Math.sqrt(num.pop()));
                        op.pop();
                    } else
                        num.push(evaluate(op.pop(), num.pop(), num.pop()));
				} op.push(token);
			} 
		}
	
		while (!op.empty()) {
            if (op.peek().equals("sqrt")){
                num.push(Math.sqrt(num.pop()));
                op.pop();
            } else
                num.push(evaluate(op.pop(), num.pop(), num.pop()));
		} return num.pop();
	}
	
	private static boolean isNumber (String exp){
		if (exp.startsWith("-") && (exp.length() > 1))
			return true;
		else if (exp.startsWith("0"))
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
    
    private static boolean isOperator (String exp){
        if (exp.equals("+"))
            return true;
        else if (exp.equals("-"))
            return true;
        else if (exp.equals("*"))
            return true;
        else if (exp.equals("/"))
            return true;
		else if (exp.equals("^"))
	    	return true;
        else
            return false;
    }

	private static boolean hasPrecedence(String op1, String op2)
    {
        if (op2.equals("(") || op2.equals(")"))
            return false;
        if ((op1.equals("*") || op1.equals("/")) && (op2.equals("+") || op2.equals("-")))
            return false;
        if (op1.equals("^") && (op2.equals("/") || op2.equals("*")))
            return false;
        if (op1.equals("^") && (op2.equals("-") || op2.equals("+")))
            return false;
        if (op1.equals("sqrt") && (op2.equals("/") || op2.equals("*")))
            return false;
        if (op1.equals("sqrt") && (op2.equals("-") || op2.equals("+")))
            return false;
        else
            return true;
    }
 
 	private static double evaluate (String operation, double num2, double num1) {
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
                
