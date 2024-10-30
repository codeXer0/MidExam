import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Calculator extends JFrame {
	JTextField display;
	JButton button, historyButton;
	String[] buttons = { "AC", "%", "←", "÷", "7", "8", "9", "×", "4", "5", "6", "-", "1", "2", "3", "+", "±", "0", ".",
			"=" };
	String operator = ""; // 연산자 저장을 위한 변수 선언
	BigDecimal num1 = BigDecimal.ZERO; // 첫 번째 입력 숫자 저장
	BigDecimal num2 = BigDecimal.ZERO; // 두 번째 입력 숫자 저장
	boolean startNewNumber = true; // 새로 입력된 숫자 확인
	ArrayList<String> history = new ArrayList<>(); // 계산 기록 저장

	public Calculator() {
		this.setTitle("계산기");
		this.setSize(350, 500);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		showNorth();
		showCenter();
		showSouth();

		// KeyListener 추가
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				KeyBoardPress(e);
			}
		});
		this.setFocusable(true);

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

			if (text.equals("=") || text.equals("÷") || text.equals("×") || text.equals("+") || text.equals("-")) {
				button.setBackground(Color.ORANGE);
				button.setForeground(Color.WHITE);
			} else if (text.equals("AC") || text.equals("%") || text.equals("←")) {
				button.setBackground(Color.LIGHT_GRAY);
				button.setForeground(Color.WHITE);
			} else {
				button.setBackground(Color.DARK_GRAY);
				button.setForeground(Color.WHITE);
			}

			panel.add(button);
		}
		add(panel, BorderLayout.CENTER);
	}

	void showSouth() {
		JPanel panel = new JPanel(new BorderLayout());
		historyButton = new JButton("🖩");
		historyButton.setFocusPainted(false);
		historyButton.setFont(new Font("Dialog", Font.BOLD, 40));
		historyButton.setBackground(Color.BLACK);
		historyButton.setForeground(Color.WHITE);

		historyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showHistory();
			}
		});

		panel.add(historyButton);
		add(panel, BorderLayout.SOUTH);
	}

	private void showHistory() {
		if (history.isEmpty()) {
			JOptionPane.showMessageDialog(this, "계산 기록이 없습니다.");
		} else {
			StringBuilder sb = new StringBuilder();
			for (String record : history) {
				sb.append(record).append("\n");
			}
			JOptionPane.showMessageDialog(this, sb.toString(), "History", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	ActionListener l = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			processInput(e.getActionCommand());
		}
	};

	// 키 입력 처리 메소드
	private void KeyBoardPress(KeyEvent e) {
		String command = switch (e.getKeyCode()) {
		case KeyEvent.VK_0, KeyEvent.VK_NUMPAD0 -> "0";
		case KeyEvent.VK_1, KeyEvent.VK_NUMPAD1 -> "1";
		case KeyEvent.VK_2, KeyEvent.VK_NUMPAD2 -> "2";
		case KeyEvent.VK_3, KeyEvent.VK_NUMPAD3 -> "3";
		case KeyEvent.VK_4, KeyEvent.VK_NUMPAD4 -> "4";
		case KeyEvent.VK_5, KeyEvent.VK_NUMPAD5 -> "5";
		case KeyEvent.VK_6, KeyEvent.VK_NUMPAD6 -> "6";
		case KeyEvent.VK_7, KeyEvent.VK_NUMPAD7 -> "7";
		case KeyEvent.VK_8, KeyEvent.VK_NUMPAD8 -> "8";
		case KeyEvent.VK_9, KeyEvent.VK_NUMPAD9 -> "9";
		case KeyEvent.VK_PERIOD, KeyEvent.VK_DECIMAL -> ".";
		case KeyEvent.VK_ADD -> "+";
		case KeyEvent.VK_SUBTRACT -> "-";
		case KeyEvent.VK_MULTIPLY -> "×";
		case KeyEvent.VK_DIVIDE -> "÷";
		case KeyEvent.VK_EQUALS, KeyEvent.VK_ENTER -> "=";
		case KeyEvent.VK_BACK_SPACE -> "←";
		case KeyEvent.VK_ESCAPE -> "AC";
		default -> null;
		};
		if (command != null) {
			processInput(command);
		}
	}

	// 입력 처리 메소드
	private void processInput(String command) {
		switch (command) {
		case "AC":
			display.setText("0");
			num1 = BigDecimal.ZERO;
			num2 = BigDecimal.ZERO;
			operator = "";
			startNewNumber = true;
			break;
		case "←":
			String currentText = display.getText();
			display.setText(currentText.length() > 1 ? currentText.substring(0, currentText.length() - 1) : "0");
			break;
		case "±":
			BigDecimal value = new BigDecimal(display.getText());
			display.setText(value.negate().toString());
			break;
		case "%":
			num1 = new BigDecimal(display.getText());
			operator = "%";
			startNewNumber = true;
			break;
		case "÷":
		case "×":
		case "-":
		case "+":
			num1 = new BigDecimal(display.getText());
			operator = command;
			startNewNumber = true;
			break;
		case "=":
			num2 = new BigDecimal(display.getText());
			String result = calculateResult();
			display.setText(result);
			history.add(num1 + " " + operator + " " + num2 + " = " + result);
			startNewNumber = true;
			break;
		case ".":
			if (!display.getText().contains(".")) {
				display.setText(display.getText() + ".");
			}
			break;
		default:
			if (startNewNumber) {
				display.setText(command);
				startNewNumber = false;
			} else {
				display.setText(display.getText().equals("0") ? command : display.getText() + command);
			}
			break;
		}
	}

	String calculateResult() {
		BigDecimal result;
		switch (operator) {
		case "+":
			result = num1.add(num2);
			break;
		case "-":
			result = num1.subtract(num2);
			break;
		case "×":
			result = num1.multiply(num2);
			break;
		case "÷":
			if (num2.compareTo(BigDecimal.ZERO) != 0)
				result = num1.divide(num2, 10, RoundingMode.HALF_UP);
			else
				return "Error";
			break;
		case "%":
			result = num1.remainder(num2);
			break;
		default:
			return display.getText();
		}
		return result.stripTrailingZeros().toPlainString();
	}

	public static void main(String[] args) {
		new Calculator();
	}
}
