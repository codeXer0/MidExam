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
 * @version 2022-03
 * 
 * @created 2024-10-18
 * @lastModified 2024-10-19
 * 
 */
public class Calculator extends JFrame {
	JTextField result;
	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20;

	public Calculator() {
		this.setTitle("계산기"); // "계산기"로 제목 설정
		this.setLayout(new BorderLayout());
		this.setSize(400, 600); // 가로 400, 세로 600픽셀 설정

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
		// 버튼 판넬 생성
		JPanel panel = new JPanel();
		// 5행 4열 좌우 7, 상하 간격 7인 그리드아웃을 panel에 생성
		panel.setLayout(new GridLayout(5, 4, 7, 7));
		// panel의 배경색을 black으로 변경
		panel.setBackground(Color.black);

		// 계산기 연산 버튼 각각 생성
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

		// panel에 연산버튼 배치
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

		// Center영역에 패널 배치
		add(panel, BorderLayout.CENTER);

	}

	void showSouth() {
		// 남쪽영역 패널 생성
		JPanel panel = new JPanel();
		// 계산기록 버튼 생성
		JButton historyButton = new JButton("History");
		// 포커스 테두리 표시안함
		historyButton.setFocusPainted(false);
		// 패널에 기록버튼 배치
		panel.add(historyButton);

		// South영역에 패널 배치
		this.add(panel, BorderLayout.SOUTH);

	}

	public static void main(String[] args) {
		new Calculator();
	}

}
