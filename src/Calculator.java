import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
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
		JPanel panel = new JPanel(); // 버튼 판넬
		panel.setLayout(new GridLayout(5, 4, 3, 3));
		panel.setBackground(Color.black);

		// 계산기 연산버튼 각각 생성
		JButton b1 = new JButton("CE");
		JButton b2 = new JButton("C");
		JButton b3 = new JButton("←");
		JButton b4 = new JButton("÷");
		JButton b5 = new JButton("7");
		JButton b6 = new JButton("8");
		JButton b7 = new JButton("9");
		JButton b8 = new JButton("×");
		JButton b9 = new JButton("4");
		JButton b10 = new JButton("5");
		JButton b11 = new JButton("6");
		JButton b12 = new JButton("-");
		JButton b13 = new JButton("1");
		JButton b14 = new JButton("2");
		JButton b15 = new JButton("3");
		JButton b16 = new JButton("+");
		JButton b17 = new JButton("±");
		JButton b18 = new JButton("0");
		JButton b19 = new JButton(".");
		JButton b20 = new JButton("=");

		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(b4);
		panel.add(b5);
		panel.add(b6);
		panel.add(b7);
		panel.add(b8);
		panel.add(b9);
		panel.add(b10);
		panel.add(b11);
		panel.add(b12);
		panel.add(b13);
		panel.add(b14);
		panel.add(b15);
		panel.add(b16);
		panel.add(b17);
		panel.add(b18);
		panel.add(b19);
		panel.add(b20);

		add(panel, BorderLayout.CENTER);

	}

	void showSouth() {
		JPanel panel = new JPanel(); // 남쪽영역 패널 생성

		JButton historyButton = new JButton("History"); // 계산기록 버튼 생성
		historyButton.setFocusPainted(false); // 포커스 테두리 표시안함
		panel.add(historyButton); // 패널에 기록버튼 부착

		this.add(panel, BorderLayout.SOUTH);

	}

	public static void main(String[] args) {
		new Calculator();
	}

}
