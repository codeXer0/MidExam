import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * 기본적인 사칙연산을 할 수 있는 계산기 클래스입니다.
 * 
 * @author 2021011939 이동재
 * @version Eclipse 2022-03
 * 
 * @created 2024-10-18
 * @lastModified 2024-10-29
 * 
 */
public class Calculator extends JFrame {
	JTextField result;
	JButton button;
	/**
	 * 연산버튼 생성을 위한 buttons 배열 생성
	 */
	String[] buttons = { "AC", "±", "←", "÷", "7", "8", "9", "×", "4", "5", "6", "-", "1", "2", "3", "+", "🖩", "0",
			".", "=" };

	public Calculator() {
		this.setTitle("계산기");
		/**
		 * Frame 사이즈 설정
		 * 
		 * @param 폭  350
		 * @param 넓이 500
		 */
		this.setSize(350, 500);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		showNorth();
		showCenter();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		showNorth();
		showCenter();

	}

	void showNorth() {
		/**
		 * North 영역 panel 배치관리자 변경
		 * 
		 * FlowLayout -> BorderLayout
		 */
		JPanel panel = new JPanel(new BorderLayout());

		result = new JTextField("0");
		result.setEditable(false);
		/**
		 * 계산결과창 폰트 설정
		 * 
		 * 폰트이름 = "Dialog", 폰트스타일 = PLAIN, 폰트크기 = 40픽셀
		 * 
		 * (** 결과창 문자열 우측 정렬 **) 실제 계산기처럼!!
		 * 
		 * 패널의 배경색 & 전경색 설정
		 * 
		 * 배경색 -> BLACK / 전경색 -> WHITE
		 */
		result.setFont(new Font("Dialog", Font.PLAIN, 40));
		result.setHorizontalAlignment(SwingConstants.RIGHT);

		result.setBackground(Color.BLACK);
		result.setForeground(Color.WHITE);

		panel.add(result);

		add(panel, BorderLayout.NORTH);

	}

	void showCenter() {
		/**
		 * Center 영역 판넬 생성
		 * 
		 * 배치관리자는 GridLayout
		 * 
		 * @param rows 5
		 * @param cols 4
		 * @param 폭    7
		 * @param 높이   7
		 */
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(5, 4, 7, 7));
		panel.setBackground(Color.black);
		/**
		 * buttons 배열과 for반복문을 사용하여 연산버튼을 생성!!
		 * 
		 * 포커스 테두리 제거
		 */
		for (int i = 0; i < buttons.length; i++) {
			JButton button = new JButton(buttons[i]);
			button.setFocusPainted(false);
			button.setFont(new Font("Dialog", Font.BOLD, 20));
			panel.add(button);
		}
		add(panel, BorderLayout.CENTER);

	}

	public static void main(String[] args) {
		new Calculator();
	}

}
