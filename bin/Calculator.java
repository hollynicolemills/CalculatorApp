import java.lang.Math;

public class Calculator {
	
	double number1;
	double number2;
	char operator;
	
	public Calculator () {
	number1 = 0.0;
	number2 = 0.0;
	operator = 'n';
	}
	
	public double evaluate (double num1, double num2, char operation) {
		
		if(operation == 'a') {
			num1 = num1 + num2;
		} else if(operation == 's'){
			num1 = num1 - num2;
		} else if(operation == 'm'){
			num1 = num1 * num2;
		} else if(operation == 'd'){
			num1 = num1 / num2;
		} else if(operation == 'S'){
			num1 = Math.sin(num2);
		} else if(operation == 'C'){
			num1 = Math.cos(num2);
		} else if(operation == 'T'){
			num1 = Math.tan(num2);
		} else if(operation == 'r'){
			num1 = Math.sqrt(num2);
		} else
			num1 = num2;
		
		return num1;
	}
}
