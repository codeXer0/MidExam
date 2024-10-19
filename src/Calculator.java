import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Calculator extends JFrame {
	public Calculator() {
		this.setTitle("계산기");
		this.setLayout(new BorderLayout());
		this.setSize(400, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	public static void main(String[] args) {
		new Calculator();
	}

}
