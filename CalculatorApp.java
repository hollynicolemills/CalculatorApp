/** 
Author: Holly Mills
Creation Date: Feb. 14, 2015
Last Edited: Feb. 14, 2015
Description: Basic calculator using add, subtract, multiply and divide 
Notes: First GUI program using Swing
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class CalculatorApp {

	JButton one, two, three, four, five, six, seven, 
		eight, nine, dot, zero, addition, subtract, multiply, divide, equals, clear;
	
	JTextField textBox;
	
	double num1 = 0.0;
	double num2 = 0.0;
	double result = 0.0;
	char operation = 'n';
	boolean shouldFill = true;
	
	DecimalFormat formater = new DecimalFormat("0.##########");
	
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
		one = new JButton(" 1 ");
		two = new JButton(" 2 ");
		three = new JButton(" 3 ");
		four = new JButton(" 4 ");
		five = new JButton(" 5 ");
		six = new JButton(" 6 ");
		seven = new JButton(" 7 ");
		eight = new JButton(" 8 ");
		nine = new JButton(" 9 ");
		dot = new JButton(" . ");
		zero = new JButton(" 0 ");
		addition = new JButton(" + ");
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
		dot.addActionListener(new DotButton());
		zero.addActionListener(new ButtonZero());
		addition.addActionListener(new AdditionButton());
		subtract.addActionListener(new SubtractButton());
		multiply.addActionListener(new MultiplyButton());
		divide.addActionListener(new DivideButton());
		equals.addActionListener(new EqualsButton());
		clear.addActionListener(new ClearButton());
		
		//Create layout
		frame.getContentPane().add(BorderLayout.NORTH, textBox);
		frame.getContentPane().add(BorderLayout.CENTER, pane);
		
		//Add content to center panel
		pane.add(one);
		pane.add(two);
		pane.add(three); 
		pane.add(four);
		pane.add(five);
		pane.add(six);
		pane.add(seven);
		pane.add(eight);
		pane.add(nine);
		pane.add(dot);
		pane.add(zero);
		pane.add(addition);
		pane.add(subtract);
		pane.add(multiply);
		pane.add(divide);
		pane.add(clear);
		pane.add(equals);
		
		//Set sizes and defaults
		frame.setSize(275, 290);
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
	
	class DotButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			textBox.setText(textBox.getText() + ".");
		}
	}
	
	class ButtonZero implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			textBox.setText(textBox.getText() + "0");
		}
	}
	
	class AdditionButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			num1 = Double.parseDouble(textBox.getText());
			textBox.setText("");
			operation = 'a';
		}
	}
	
	class SubtractButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			num1 = Double.parseDouble(textBox.getText());
			textBox.setText("");
			operation = 's';
		}
	}
	
	class MultiplyButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			num1 = Double.parseDouble(textBox.getText());
			textBox.setText("");
			operation = 'm';
		}
	}
	
	class DivideButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			num1 = Double.parseDouble(textBox.getText());
			textBox.setText("");
			operation = 'd';
		}
	}

	class EqualsButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			num2 = Double.parseDouble(textBox.getText());
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
			
			textBox.setText(formater.format(result));
		}
	}
	
	class ClearButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			textBox.setText("");
		}
	}
}
