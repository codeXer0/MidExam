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
 * @version Eclipse 2022-03
 * 
 * @created 2024-10-18
 * @lastModified 2024-10-26
 * 
 */
public class Calculator extends JFrame {
	// 각 연산버튼 변수 멤버필드로 선언
	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20;
	JTextField result;
	JButton button;

	// 연산버튼 생성을 위한 buttons 배열 생성
	String[] buttons = { "CE", "C", "←", "/", "7", "8", "9", "*", "4", "5", "6", "-", "1", "2", "3", "+", "±", "0", ".",
			"=" };

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
		/**
		 * JFrame의 NORTH 영역에 panel을 배치
		 */
		add(panel, BorderLayout.NORTH);

	}

	void showCenter() {
		// 버튼 판넬 생성
		JPanel panel = new JPanel();
		// 5행 4열 좌우 7, 상하 간격 7인 그리드아웃을 panel에 생성
		panel.setLayout(new GridLayout(5, 4, 7, 7));
		// panel의 배경색을 black으로 변경
		panel.setBackground(Color.black);

		/**
		 * buttons 배열과 for반복문을 사용하여 연산버튼을 생성
		 */
		for (int i = 0; i < buttons.length; i++) {
			JButton button = new JButton(buttons[i]);
			/**
			 * 포커스 테두리 제거
			 */
			button.setFocusPainted(false);
			/**
			 * 패널에 버튼 배치
			 */
			panel.add(button);
		}
		/**
		 * JFrame의 CENTER 영역에 panel을 배치
		 */
		add(panel, BorderLayout.CENTER);

	}

	void showSouth() {
		/**
		 * 남쪽영역 패널 생성
		 */
		JPanel panel = new JPanel();
		/**
		 * 계산기록 버튼 생성
		 */
		JButton historyButton = new JButton("History");
		/**
		 * 포커스 테두리 제거
		 */
		historyButton.setFocusPainted(false);
		/**
		 * 패널에 기록버튼 배치
		 */ // 패널에 기록버튼 배치
		panel.add(historyButton);

		/**
		 * JFrame의 SOUTH 영역에 panel을 배치
		 */
		add(panel, BorderLayout.SOUTH);

	}

	public static void main(String[] args) {
		new Calculator();
	}

}
