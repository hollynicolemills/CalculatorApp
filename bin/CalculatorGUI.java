/** 
Author: Holly Mills
Creation Date: Feb. 14, 2015
Last Edited: Feb. 16, 2015
Description: Ver. 3 uses CreateButton class and Calculator class to simplify code and
		also uses getActionEvent() to identify button being pressed
		can accept multiple inputs
		still doesn't know order of operations

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

public class CalculatorGUI {

    CreateButton one, two, three, four, five, six, seven, 
	eight, nine, dot, zero, addition, subtract,
	multiply, divide, equals, clear,
	sine, cosine, tangent, sqrt;
	 	
    Calculator evaluator;

    JTextField textBox, displayBox;
	
    double nextNum = 0.0;
    double result = 0.0;
    boolean first = true;
    char assign = 'n';
    String numHolder = "0";
    String button = ""; 
    
    DecimalFormat formater = new DecimalFormat("0.##########");
	
    public static void main(String[] args) {
	CalculatorGUI gui = new CalculatorGUI();
	gui.go();
    }

    public void go() {
	JFrame frame = new JFrame("Calculator");
	JPanel centerPane = new JPanel();
	JPanel leftPane = new JPanel();
	JPanel bottomPane = new JPanel();
		
	//Set Layouts 
	centerPane.setLayout(new GridLayout(4,4,2,2));
	leftPane.setLayout( new GridLayout(4,2,2,2));
	bottomPane.setLayout( new GridLayout(1,1,2,2));
		
	//Create TextBox
	displayBox = new JTextField(20);
		
	evaluator = new Calculator();

	one = new CreateButton("1", new NumberButton(), centerPane);
	two = new CreateButton("2", new NumberButton(), centerPane);
	three = new CreateButton("3", new NumberButton(), centerPane);
	four = new CreateButton("4", new NumberButton(), centerPane);
	five = new CreateButton("5", new NumberButton(), centerPane);
	six = new CreateButton("6", new NumberButton(), centerPane);
	seven = new CreateButton("7", new NumberButton(), centerPane);
	eight = new CreateButton("8", new NumberButton(), centerPane);
	nine = new CreateButton("9", new NumberButton(), centerPane);
	dot = new CreateButton(".", new NumberButton(), centerPane);
	zero = new CreateButton("0", new NumberButton(), centerPane);
	equals = new CreateButton(" = ", new EqualsButton(), centerPane);
	addition = new CreateButton(" + ", new OperationButton(), leftPane);
	sine = new CreateButton("sin(x)", new OperationButton(), leftPane);
	subtract = new CreateButton(" - ", new OperationButton(), leftPane);
	cosine = new CreateButton("cos(x)", new OperationButton(), leftPane);
	multiply = new CreateButton(" * ", new OperationButton(), leftPane);
	tangent = new CreateButton("tan(x)", new OperationButton(), leftPane);
	divide = new CreateButton("/", new OperationButton(), leftPane);
	sqrt = new CreateButton("sqrt", new OperationButton(), leftPane);
	clear = new CreateButton("clear", new ClearButton(), bottomPane);
		
	//Create layout
	frame.getContentPane().add(BorderLayout.NORTH, displayBox);
	frame.getContentPane().add(BorderLayout.CENTER, centerPane);
	frame.getContentPane().add(BorderLayout.EAST, leftPane);
	frame.getContentPane().add(BorderLayout.SOUTH, bottomPane);
		
	//Set sizes and defaults
	frame.setSize(350,225);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
		
    class NumberButton implements ActionListener {		
	public void actionPerformed(ActionEvent event) {
	    button = event.getActionCommand();
	    numHolder = numHolder + button;
	    displayBox.setText(displayBox.getText() + button);
	}
    }
	
    class OperationButton implements ActionListener {
	public void actionPerformed(ActionEvent event) {
	    nextNum = Double.parseDouble(numHolder);
	    numHolder = "0";
	    button = event.getActionCommand();
	    result = evaluator.evaluate(result, nextNum, assign);
	
	    if (button == " + ") {
		displayBox.setText(displayBox.getText() + button);
		assign = 'a';
	    } else if (button == " - ") {
		displayBox.setText(displayBox.getText() + button);
		assign = 's';
	    } else if (button == " * ") {
		displayBox.setText(displayBox.getText() + button);
		assign = 'm';
	    } else if (button == " / ") {
		displayBox.setText(displayBox.getText() + button);
		assign = 'd';
	    } else if (button == "sin(x)") {
		displayBox.setText(displayBox.getText() + "sin(");
		assign = 'S';	
	    } else if (button == "cos(x)") {
		displayBox.setText(displayBox.getText() + "cos(");
		assign = 'C';	
	    } else if (button == "tan(x)") {
		displayBox.setText(displayBox.getText() + "tan(");
		assign = 'T';	
	    } else if (button == "sqrt") {
		displayBox.setText(displayBox.getText() + "sqrt(");
		assign = 'r';				
	    } else 
		assign = 'n';	
	}
    }

    class EqualsButton implements ActionListener {
	public void actionPerformed(ActionEvent event) {
	    nextNum = Double.parseDouble(numHolder);	
	    numHolder = "0";
	    button = event.getActionCommand();
	    result = evaluator.evaluate(result, nextNum, assign);
	    displayBox.setText(displayBox.getText() + button + formater.format(result));	
	}
    }
	
    class ClearButton implements ActionListener {
	public void actionPerformed(ActionEvent event) {
	    displayBox.setText("");
	    numHolder = "0";
	    first = true;
	}
    }
}


