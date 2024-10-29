import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	JTextField display;
	JButton button, historyButton;
	String[] buttons = { "AC", "%", "←", "÷", "7", "8", "9", "×", "4", "5", "6", "-", "1", "2", "3", "+", "±", "0", ".",
			"=" };

	String operator = ""; // 연산자 저장을 위한 변수 선언
	double num1 = 0; // 첫 번째 입력 숫자 저장
	double num2 = 0; // 두 번째 입력 숫자 저장

	public Calculator() {
		this.setTitle("계산기");

		this.setSize(350, 500);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		showNorth();
		showCenter();
		showSouth();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	void showNorth() {
		JPanel panel = new JPanel(new BorderLayout());

		display = new JTextField("0");
		display.setEditable(false);

		display.setFont(new Font("Dialog", Font.PLAIN, 40));
		display.setHorizontalAlignment(SwingConstants.RIGHT);

		display.setBackground(Color.BLACK);
		display.setForeground(Color.WHITE);

		panel.add(display);

		add(panel, BorderLayout.NORTH);
	}

	void showCenter() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(5, 4, 7, 7));
		panel.setBackground(Color.black);

		for (String text : buttons) {
			JButton button = new JButton(text);
			button.setFocusPainted(false);
			button.setFont(new Font("Dialog", Font.BOLD, 20));
			button.addActionListener(l); // 각 버튼에 ActionListener 추가
			panel.add(button);
		}
		add(panel, BorderLayout.CENTER);
	}

	void showSouth() {
		JPanel panel = new JPanel(new BorderLayout());
		historyButton = new JButton("🖩");
		historyButton.setFocusPainted(false);
		historyButton.setFont(new Font("Dialog", Font.BOLD, 40));
		panel.add(historyButton);
		add(panel, BorderLayout.SOUTH);

	}

	// 연산버튼 클릭 시 동작을 설정하는 ActionListener입니다.
	ActionListener l = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();

		}
	};

	/**
	 * 연산자(operator)에 따라 입력받은 num1과 num2에 대한 사칙연산을 수행하여 결과를 반환하는 메소드입니다. 연산자는
	 * 덧셈("+"), 뺄셈("-"), 곱셈("×"), 나눗셈("÷") 입니다. 나눗셈에서 0으로 나누려 할 경우, 에러 메시지("잘못된
	 * 입력입니다.")를 출력합니다.
	 * 
	 * @return 연산 결과를 '문자열'로 반환하며, 나눗셈에서 0으로 나누려 할 경우 오류 메시지를 반환합니다.
	 * @see <a href="https://kcasey.tistory.com/7">계산기 작성 시 switch,if문 참고 링크</a>
	 */
	String calculateResult() {
		double result = 0;
		switch (operator) {
		case "+":
			result = num1 + num2;
			break;
		case "-":
			result = num1 - num2;
			break;
		case "×":
			result = num1 * num2;
			break;
		case "÷":
			if (num2 != 0)
				result = num1 / num2;
			else
				return "잘못된 입력입니다."; // 0으로 나눌 때!!
			break;
		}
		return String.valueOf(result); // 연산결과를 문자열로 반환
	}

	public static void main(String[] args) {
		new Calculator();
	}
}
