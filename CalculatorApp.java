/** 
Author: Holly Mills
Creation Date: Feb. 14, 2015
Last Edited: Feb. 15, 2015
Description: Basic calculator with GUI

 CalculatorApp
    Copyright (C) 2015  Holly Mills

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License along
    with this program; if not, write to the Free Software Foundation, Inc.,
    51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.lang.Math;

public class CalculatorApp {

	JButton one, two, three, four, five, six, seven, 
		eight, nine, dot, zero, addition, subtract,
	 	multiply, divide, equals, clear;
	
	JTextField textBox;
	
	double num1 = 0.0;
	double num2 = 0.0;
	double result = 0.0;
	char operation = 'n';
	
	DecimalFormat formater = new DecimalFormat("0.##########");
	
	public static void main(String[] args) {
		CalculatorApp gui = new CalculatorApp();
		gui.go();
	}
	
	public void go() {
		JFrame frame = new JFrame("Calculator");
		JPanel pane = new JPanel();
		JPanel topPane = new JPanel();
		JPanel leftPane = new JPanel();
		JPanel bottomPane = new JPanel();
		
		//Set Layouts 
		pane.setLayout(new GridLayout(4,4,2,2));
		leftPane.setLayout( new GridLayout(4,2,2,2));
		bottomPane.setLayout( new GridLayout(1,1,2,2));
		
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
		one.addActionListener(new NumberButton());
		two.addActionListener(new NumberButton());
		three.addActionListener(new NumberButton());
		four.addActionListener(new NumberButton());
		five.addActionListener(new NumberButton());
		six.addActionListener(new NumberButton());
		seven.addActionListener(new NumberButton());
		eight.addActionListener(new NumberButton());
		nine.addActionListener(new NumberButton());
		dot.addActionListener(new NumberButton());
		zero.addActionListener(new NumberButton());
		addition.addActionListener(new OperationButton());
		subtract.addActionListener(new OperationButton());
		multiply.addActionListener(new OperationButton());
		divide.addActionListener(new OperationButton());
		equals.addActionListener(new EqualsButton());
		clear.addActionListener(new ClearButton());
		
		//Add content to panels
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
		pane.add(equals);
		leftPane.add(addition);
		leftPane.add(subtract);
		leftPane.add(multiply);
		leftPane.add(divide);
		bottomPane.add(clear);
		
		//Create layout
		frame.getContentPane().add(BorderLayout.NORTH, textBox);
		frame.getContentPane().add(BorderLayout.CENTER, pane);
		frame.getContentPane().add(BorderLayout.EAST, leftPane);
		frame.getContentPane().add(BorderLayout.SOUTH, bottomPane);
		
		//Set sizes and defaults
		frame.setSize(250,225);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
		
	class NumberButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == one){
			textBox.setText(textBox.getText() + "1");
			} else if (event.getSource() == two){
			textBox.setText(textBox.getText() + "2");
			} else if (event.getSource() == three) {
			textBox.setText(textBox.getText() + "3");
			} else if (event.getSource() == four){
			textBox.setText(textBox.getText() + "4");
			} else if (event.getSource() == five){
			textBox.setText(textBox.getText() + "5");
			} else if (event.getSource() == six){
			textBox.setText(textBox.getText() + "6");
			} else if (event.getSource() == seven){
			textBox.setText(textBox.getText() + "7");
			} else if (event.getSource() == eight){
			textBox.setText(textBox.getText() + "8");
			} else if (event.getSource() == nine){
			textBox.setText(textBox.getText() + "9");
			} else if (event.getSource() == zero){
			textBox.setText(textBox.getText() + "0");
			} else if (event.getSource() == dot){
			textBox.setText(textBox.getText() + ".");
			} else
			textBox.setText("0");
		}
	}
	
	class OperationButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (textBox.getText().length() > 0)
				num1 = Double.parseDouble(textBox.getText());
			else
				num1 = 0;
			
			textBox.setText("");
			
			if (event.getSource() == addition) {
				operation = 'a';
			} else if (event.getSource() == subtract) {
				operation = 's';
			} else if (event.getSource() == multiply) {
				operation = 'm';
			} else if (event.getSource() == divide) {
				operation = 'd';
			} else 
				textBox.setText("0");//need better solution here
		}
	}

	class EqualsButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
				if(textBox.getText().length() > 0)
				num2 = Double.parseDouble(textBox.getText());
				else
				num2 = 0;
				
				if(operation == 'a') {
					result = num1 + num2;
				} else if(operation == 's'){
					result = num1 - num2;
				} else if(operation == 'm'){
					result = num1 * num2;
				} else if(operation == 'd'){
					result = num1 / num2;
				} else if(operation == 'S'){
					result = Math.sin(num1);
				} else
					result = 0.0;
					
			textBox.setText(formater.format(result));
		}
	}
	
	class ClearButton implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			textBox.setText("");
		}
	}
}

