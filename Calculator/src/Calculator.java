import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

	JFrame frame;
	JTextField textfield;
	JButton[] numberBtn = new JButton[10];
	JButton[] ftnBtn = new JButton[9];
	JButton addbtn, subbtn, mulbtn, divbtn;
	JButton decbtn, equbtn, delbtn, clrbtn, negbtn;
	JPanel panel;

	Font myfont = new Font("Ink Free", Font.BOLD, 30);
	double num1 = 0, num2 = 0, res = 0;
	char operator;

	Calculator() {

		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,550);
		frame.setLayout(null);
		textfield = new JTextField();
		textfield.setBounds(50, 25, 300, 50);
		textfield.setFont(myfont);
		textfield.setEditable(false);

		addbtn = new JButton("+");
		subbtn = new JButton("-");
		mulbtn = new JButton("*");
		divbtn = new JButton("/");
		decbtn = new JButton(".");
		equbtn = new JButton("=");
		delbtn = new JButton("Del");
		clrbtn = new JButton("Clr");
		negbtn = new JButton("(-)");

		ftnBtn[0] = addbtn;
		ftnBtn[1] = subbtn;
		ftnBtn[2] = mulbtn;
		ftnBtn[3] = divbtn;
		ftnBtn[4] = decbtn;
		ftnBtn[5] = equbtn;
		ftnBtn[6] = delbtn;
		ftnBtn[7] = clrbtn;
		ftnBtn[8] = negbtn;

		for (int i = 0; i < ftnBtn.length; i++) {
			ftnBtn[i].addActionListener(this);
			ftnBtn[i].setFont(myfont);
			ftnBtn[i].setFocusable(false);
		}

		for (int i = 0; i < numberBtn.length; i++) {
			numberBtn[i] = new JButton(String.valueOf(i));
			numberBtn[i].addActionListener(this);
			numberBtn[i].setFont(myfont);
			numberBtn[i].setFocusable(false);

		}

		negbtn.setBounds(50, 430, 100, 50);
		delbtn.setBounds(150, 430, 100, 50);
		clrbtn.setBounds(250, 430, 100, 50);

		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4,4,10,10));
		//		panel.setBackground(Color.gray);

		panel.add(numberBtn[1]);
		panel.add(numberBtn[2]);
		panel.add(numberBtn[3]);
		panel.add(addbtn);

		panel.add(numberBtn[4]);
		panel.add(numberBtn[5]);
		panel.add(numberBtn[6]);
		panel.add(subbtn);

		panel.add(numberBtn[7]);
		panel.add(numberBtn[8]);
		panel.add(numberBtn[9]);
		panel.add(mulbtn);

		panel.add(decbtn);
		panel.add(numberBtn[0]);
		panel.add(equbtn);
		panel.add(divbtn);

		frame.add(panel);
		frame.add(negbtn);
		frame.add(delbtn);
		frame.add(clrbtn);
		frame.add(textfield);
		frame.setVisible(true);
	}


	public static void main(String[] args) {

		Calculator calc = new Calculator();	
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < numberBtn.length; i++) {
			if(e.getSource()==numberBtn[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}

		if(e.getSource()==decbtn) {
			textfield.setText(textfield.getText().concat("."));
		}

		if(e.getSource()==addbtn) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '+';
			textfield.setText("");
		}

		if(e.getSource()==subbtn) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '-';
			textfield.setText("");
		}

		if(e.getSource()==mulbtn) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '*';
			textfield.setText("");
		}

		if(e.getSource()==divbtn) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '/';
			textfield.setText("");
		}

		if(e.getSource()==equbtn) {
			num2 = Double.parseDouble(textfield.getText());
			switch(operator) {
			case '+':
				res = num1+num2;
				break;

			case '-':
				res = num1-num2;
				break;

			case '*':
				res = num1*num2;
				break;

			case '/':
				res = num1*num2;
				break;
			}
			textfield.setText(String.valueOf(res));
			num1 = res;
		}

		if(e.getSource()==clrbtn) {
			textfield.setText("");
		}

		if(e.getSource()==delbtn) {
			String str = textfield.getText();
			textfield.setText("");
			for (int i = 0; i < str.length()-1; i++) {
				textfield.setText(textfield.getText()+str.charAt(i));
			}
		}
		
		if(e.getSource()==negbtn) {
             double temp = Double.parseDouble(textfield.getText());
             temp*=-1;
             textfield.setText(String.valueOf(temp));
			}
		}
}