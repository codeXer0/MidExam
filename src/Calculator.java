import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
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
	JTextField result;
	JButton button;
	/**
	 * 연산버튼 생성을 위한 buttons 배열 생성
	 */
	String[] buttons = { "CE", "C", "←", "/", "7", "8", "9", "*", "4", "5", "6", "-", "1", "2", "3", "+", "±", "0", ".",
			"=" };

	public Calculator() {
		this.setTitle("계산기");
		this.setLayout(new BorderLayout());
		/**
		 * 사이즈 설정
		 * 
		 * @param 폭  400
		 * @param 넓이 600
		 */
		this.setSize(400, 600); //

		showNorth();
		showCenter();
		showSouth();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	void showNorth() {
		/**
		 * North 영역 panel 배치관리자 변경
		 * 
		 * FlowLayout -> BorderLayout
		 */
		JPanel panel = new JPanel(new BorderLayout());

		/**
		 * 결과창 JTextField 생성 및 텍스트필드 수정 가능여부 설정
		 */
		result = new JTextField("계산결과창");
		result.setEditable(false);
		/**
		 * 계산결과창 폰트 설정
		 * 
		 * 폰트는 "TimesRoman", 이탤릭 스타일, 크기는 40
		 * 
		 * 추후에 수정
		 */
		result.setFont(new Font("TimesRoman", Font.ITALIC, 40));
		panel.add(result);
		/**
		 * JFrame의 NORTH 영역에 panel을 배치
		 */
		add(panel, BorderLayout.NORTH);

	}

	void showCenter() {
		/**
		 * Center 영역 판넬 생성
		 * 
		 * 배치관리자 = GridLayout
		 * 
		 * @param rows 5
		 * @param cols 4
		 * @param 폭    7
		 * @param 높이   7
		 */
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(5, 4, 7, 7));
		/**
		 * panel의 배경색을 black으로 변경
		 */
		panel.setBackground(Color.black);
		/**
		 * buttons 배열과 for반복문을 사용하여 연산버튼을 생성!!
		 * 
		 * 포커스 테두리 제거
		 */
		for (int i = 0; i < buttons.length; i++) {
			JButton button = new JButton(buttons[i]);
			button.setFocusPainted(false);
			panel.add(button);
		}
		/**
		 * JFrame의 CENTER 영역에 panel을 배치
		 */
		add(panel, BorderLayout.CENTER);

	}

	void showSouth() {
		/**
		 * SOUTH 영역 패널 생성
		 */
		JPanel panel = new JPanel();
		/**
		 * 계산기록 버튼 생성 및 포커스 테두리 제거
		 */
		JButton historyButton = new JButton("History");
		historyButton.setFocusPainted(false);
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
