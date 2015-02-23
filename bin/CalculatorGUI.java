/** 
Author: Holly Mills
Creation Date: Feb. 14, 2015
Last Edited: Feb. 22, 2015
Description: Ver. 4 uses CreateButton class and OrderOfOperations class to simplify code and
		also uses getActionEvent() to identify button being pressed
		Can accept multiple inputs and uses order of operations to calculate currect answer

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
    	sqrt, close, open, exp;
    
    OrderOfOperations evaluator;
	
    JTextField displayBox;
	
    double num = 0.0;
    double result = 0.0;
    boolean squareroot = false;
    String numHolder = "0";
    String button = "";
    String input = "";
    
    DecimalFormat formater = new DecimalFormat("0.##########");
	
    public static void main(String[] args) {
	CalculatorGUI gui = new CalculatorGUI();
	gui.go();
    }

    public void go() {
	JFrame frame = new JFrame("Calculator");
	JPanel centerPane = new JPanel();
	JPanel bottomPane = new JPanel();
		 
	centerPane.setLayout(new GridLayout(5,4));
	bottomPane.setLayout( new GridLayout(1,1,2,2));
		
	displayBox = new JTextField(20);
	evaluator = new OrderOfOperations();

    	sqrt = new CreateButton("sqrt", new OperationButton(), centerPane);
    	exp = new CreateButton("^", new OperationButton(), centerPane);
    	open = new CreateButton("(", new OperationButton(), centerPane);
    	close = new CreateButton(")", new OperationButton(), centerPane);
    	seven = new CreateButton("7", new NumberButton(), centerPane);
    	eight = new CreateButton("8", new NumberButton(), centerPane);
    	nine = new CreateButton("9", new NumberButton(), centerPane);
    	addition = new CreateButton(" + ", new OperationButton(), centerPane);
    	four = new CreateButton("4", new NumberButton(), centerPane);
    	five = new CreateButton("5", new NumberButton(), centerPane);
    	six = new CreateButton("6", new NumberButton(), centerPane);
    	subtract = new CreateButton(" - ", new OperationButton(), centerPane);
    	one = new CreateButton("1", new NumberButton(), centerPane);
    	two = new CreateButton("2", new NumberButton(), centerPane);
    	three = new CreateButton("3", new NumberButton(), centerPane);
    	multiply = new CreateButton(" * ", new OperationButton(), centerPane);
    	dot = new CreateButton(".", new NumberButton(), centerPane);
	zero = new CreateButton("0", new NumberButton(), centerPane);
    	equals = new CreateButton(" = ", new EqualsButton(), centerPane);
    	divide = new CreateButton(" / ", new OperationButton(), centerPane);
	clear = new CreateButton("clear", new OperationButton(), bottomPane);
		
	frame.getContentPane().add(BorderLayout.NORTH, displayBox);
	frame.getContentPane().add(BorderLayout.CENTER, centerPane);
	frame.getContentPane().add(BorderLayout.SOUTH, bottomPane);
		
	frame.setSize(250,300);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
		
    class NumberButton implements ActionListener {		
        public void actionPerformed(ActionEvent event) {
            button = event.getActionCommand();
            numHolder = numHolder + button;
            displayBox.setText(displayBox.getText() + button);
            if (!squareroot)
                input = input + button;
        }
    }
	
    class OperationButton implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            num = Double.parseDouble(numHolder);
            numHolder = "0";
            button = event.getActionCommand();
            
            if (button == " + "|| button == " - "|| button == " * "|| button == " / "|| button == " ^ "){
                displayBox.setText(displayBox.getText() + button);
                input = input + button;
            } else if (button == "sqrt"){
                displayBox.setText(displayBox.getText() + "sqrt(");
                squareroot = true;
            } else if (button == "("){
                displayBox.setText(displayBox.getText() + button);
                input = input + "( "; //extra space makes string readable to OrderOfOperations class
            } else if (button == "^"){
                displayBox.setText(displayBox.getText() + button);
                input = input + " ^ ";
            } else if (button == ")"){
                if (squareroot){
                    num = Math.sqrt(num);
                    input = input + Double.toString(num);
                    squareroot = false;
                }else{
                    input = input + " )";
                }
                displayBox.setText(displayBox.getText() + button);
            } else{
                displayBox.setText("");
                input = "";
            }
        }
    }
    
    class EqualsButton implements ActionListener {
    	public void actionPerformed(ActionEvent event){
    		button = event.getActionCommand();
    		result = evaluator.readInput(input);
    		displayBox.setText(displayBox.getText() + button + formater.format(result));
    	}
    }
}
