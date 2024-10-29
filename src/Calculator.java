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

public class Calculator extends JFrame {
	JTextField display;
	JButton button, historyButton;
	String[] buttons = { "AC", "%", "←", "÷", "7", "8", "9", "×", "4", "5", "6", "-", "1", "2", "3", "+", "±", "0", ".",
			"=" };

	//double firstNum = 0; // 첫 번째 숫자 저장
	//double secondNum = 0; // 두 번째 숫자 저장

	//String operator = ""; // 연산자 저장

	//boolean startNewNumber = true; // 새로운 숫자 입력 확인

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
	public static void main(String[] args) {
		new Calculator();
	}
}
