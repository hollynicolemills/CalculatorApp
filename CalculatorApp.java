/** 
Author: Holly Mills
Creation Date: Feb. 14, 2015
Description: Basic calculator using add, subtract, multiply and divide 
Notes: First GUI program using Swing
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorApp {

	JButton one, two, three, four, five, six, seven, 
		eight, nine, zero, addition, subtract, multiply, divide, equals, clear;
	
	JTextField textBox;
	
	int num1 = 0;
	int num2 = 0;
	double result = 0.0;
	char operation = 'n';
	
	public static void main(String[] args) {
		CalculatorApp gui = new CalculatorApp();
		gui.go();
	}
	
	public void go() {
		JFrame frame = new JFrame("Calculator");
		JPanel pane = new JPanel();
				
		//Create TextBox
		textBox = new JTextField(20);
		
		//Create Buttons
		one = new JButton("1");
		two = new JButton("2");
		three = new JButton("3");
		four = new JButton("4");
		five = new JButton("5");
		six = new JButton("6");
		seven = new JButton("7");
		eight = new JButton("8");
		nine = new JButton("9");
		zero = new JButton("0");
		addition = new JButton(" + ");//create addition Button
		subtract = new JButton(" - ");
		multiply = new JButton(" * ");
		divide = new JButton(" / ");
		equals = new JButton(" = "); 
		clear = new JButton("clear");

		//create active listeners
		one.addActionListener(new ButtonOne());
		two.addActionListener(new ButtonTwo());
		three.addActionListener(new ButtonThree());
		four.addActionListener(new ButtonFour());
		five.addActionListener(new ButtonFive());
		six.addActionListener(new ButtonSix());
		seven.addActionListener(new ButtonSeven());
		eight.addActionListener(new ButtonEight());
		nine.addActionListener(new ButtonNine());
		zero.addActionListener(new ButtonZero());
		addition.addActionListener(new AdditionButton());//Add active listener 
		subtract.addActionListener(new SubtractButton());
		multiply.addActionListener(new MultiplyButton());
		divide.addActionListener(new DivideButton());
		equals.addActionListener(new EqualsButton());
		clear.addActionListener(new ClearButton());
		
		//Create layout
		frame.getContentPane().add(BorderLayout.NORTH, textBox);
		frame.getContentPane().add(BorderLayout.CENTER, pane);
		
		//Set layout to BoxLayout
		//pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		
		//Add content to panel
		pane.add(one);
		pane.add(two);
		pane.add(three);
		pane.add(four);
		pane.add(five);
		pane.add(six);
		pane.add(seven);
		pane.add(eight);
		pane.add(nine);
		pane.add(zero);
		pane.add(addition); //Add addition button to the panel
		pane.add(subtract);
		pane.add(multiply);
		pane.add(divide);
		pane.add(equals);
		pane.add(clear);
		
		//Set sizes and defaults
		frame.setSize(260, 290);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
		
		//Create inner classes for active listeners
	class ButtonOne implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			textBox.setText(textBox.getText() + "1");
		}
	}
		
	class ButtonTwo implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			textBox.setText(textBox.getText() + "2");
		}
	}
		
	class ButtonThree implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			textBox.setText(textBox.getText() + "3");
		}
	}
		
	class ButtonFour implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			textBox.setText(textBox.getText() + "4");
		}
	}
	
	class ButtonFive implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			textBox.setText(textBox.getText() + "5");
		}
	}
	
	class ButtonSix implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			textBox.setText(textBox.getText() + "6");
		}
	}
	
	class ButtonSeven implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			textBox.setText(textBox.getText() + "7");
		}
	}
	
	class ButtonEight implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			textBox.setText(textBox.getText() + "8");
		}
	}
	
	class ButtonNine implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			textBox.setText(textBox.getText() + "9");
		}
	}
	
	class ButtonZero implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			textBox.setText(textBox.getText() + "0");
		}
	}
	
	//Create action for addition button 
	class AdditionButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			num1 = Integer.parseInt(textBox.getText());
			textBox.setText("");
			operation = 'a';
		}
	}
	
	class SubtractButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			num1 = Integer.parseInt(textBox.getText());
			textBox.setText("");
			operation = 's';
		}
	}
	
	class MultiplyButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			num1 = Integer.parseInt(textBox.getText());
			textBox.setText("");
			operation = 'm';
		}
	}
	
	class DivideButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			num1 = Integer.parseInt(textBox.getText());
			textBox.setText("");
			operation = 'd';
		}
	}

	class EqualsButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			num2 = Integer.parseInt(textBox.getText());
				if(operation == 'a') {
					result = num1 + num2;
				} else if(operation == 's'){
					result = num1 - num2;
				} else if(operation == 'm'){
					result = num1 * num2;
				} else if(operation == 'd'){
					result = num1 / num2;
				} else
					result = 0;
			textBox.setText(Double.toString(result));
		}
	}
	
	class ClearButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			textBox.setText("");
		}
	}
}
