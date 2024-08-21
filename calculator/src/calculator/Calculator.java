package calculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{
	//setup?
	JFrame frame;
	JTextField textfield;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[9];
	JButton addButton, subButton, multiButton, divButton;
	JButton decButton, equalsButton, delButton, clrButton, negButton;
	JPanel panel;
	
	Font myFont = new Font("Times New Roman", Font.BOLD, 30);
	
	double num1=0, num2=0, result=0;
	char operator;
	
	Calculator() {
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 550);
		frame.setLayout(null);
		
		//where the answer pops up
		textfield = new JTextField();
		textfield.setBounds(50, 25, 300, 50);
		textfield.setFont(myFont);
		textfield.setEditable(false);
		
		//setting up function buttons
		addButton = new JButton("+");
		subButton = new JButton("-");
		multiButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equalsButton = new JButton("=");
		delButton = new JButton("DEL");
		clrButton = new JButton("A/C");
		negButton = new JButton("(-)");
		
		//setting function buttons equal to an index
		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = multiButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equalsButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;
		functionButtons[8] = negButton;
		
		//give properties to each function button index through for loop
		for(int i = 0; i < 9; i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
		}
		
		//give properties to each number button index through for loop
		for(int i = 0; i < 10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
		}
		
		//set up delete, negative, and clear buttons
		negButton.setBounds(50, 430, 100, 50);
		delButton.setBounds(150, 430, 100, 50);
		clrButton.setBounds(250, 430, 100, 50);
		
		//some background panel or something idk
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4, 4, 10, 10));
		
		//setting up the buttons to appear on the calculator
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(multiButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equalsButton);
		panel.add(divButton);
		
		//adding the panels to the frame
		frame.add(panel);
		frame.add(negButton);
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(textfield);
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator calc1 = new Calculator();

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//gives number buttons functionality of adding a number to the top box; max 10 digits
		for(int i = 0; i < 10; i++) {
			if(e.getSource() == numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		//gives decimal button functionality
		if(e.getSource() == decButton) {
			textfield.setText(textfield.getText().concat("."));
		}
		//gives add, subtract, multiply, and divide buttons functionality
		if(e.getSource() == addButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '+';
			textfield.setText(" ");
		}
		if(e.getSource() == subButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '-';
			textfield.setText(" ");
		}
		if(e.getSource() == multiButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '*';
			textfield.setText(" ");
		}
		if(e.getSource() == divButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '/';
			textfield.setText(" ");
		}
		//gives equals button functionality
		if(e.getSource() == equalsButton) {
			num2 = Double.parseDouble(textfield.getText());
			switch(operator) {
			case '+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case '*':
				result = num1 * num2;
				break;
			case '/':
				result = num1 / num2;
				break;
			}
			textfield.setText(String.valueOf(result));
			num1 = result;
		}
		//gives clear button functionality
		if(e.getSource() == clrButton) {
			textfield.setText(" ");
		}
		//gives delete button functionality
		if(e.getSource() == delButton) {
			String string1 = textfield.getText();
			textfield.setText(" ");
			for(int i = 0; i < string1.length() - 1; i++) {
				textfield.setText(textfield.getText() + string1.charAt(i));
			}
		}
		//gives negative button functionality
		if(e.getSource() == negButton) {
			double tempNum = Double.parseDouble(textfield.getText());
			tempNum *= -1;
			textfield.setText(String.valueOf(tempNum));
		}
	}
}
