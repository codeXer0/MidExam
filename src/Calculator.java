import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 기본적인 사칙연산을 할 수 있는 계산기 클래스입니다.
 * 
 * @author 2021011939 이동재
 * @version
 * 
 * @created 2024-10-18
 * @lastModified 2024-10-19
 * 
 */
public class Calculator extends JFrame {
	JTextField result; // North

	public Calculator() {
		this.setTitle("계산기");
		this.setLayout(new BorderLayout());
		this.setSize(400, 600);

		showNorth();
		showCenter();
		showSouth();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	void showNorth() {
		JPanel panel = new JPanel();
		result = new JTextField("0.xxx", 38);
		result.setEditable(false);
		panel.add(result);
		add(panel, BorderLayout.NORTH);

	}

	void showCenter() {
		JPanel panel = new JPanel();

	}

	void showSouth() {
		JPanel panel = new JPanel();

	}

	public static void main(String[] args) {
		new Calculator();
	}

}
