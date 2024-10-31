import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

	// 연산버튼 생성을 위한 'buttons' 배열
	String[] buttons = { "AC", "%", "←", "÷", "7", "8", "9", "×", "4", "5", "6", "-", "1", "2", "3", "+", "±", "0", ".",
			"=" };

	String operator = ""; // 연산자 저장을 위한 변수 선언
	BigDecimal num1 = BigDecimal.ZERO; // 첫 번째 입력 숫자 저장
	BigDecimal num2 = BigDecimal.ZERO; // 두 번째 입력 숫자 저장
	boolean startNewNumber = true; // 새로 입력된 숫자 확인

	// 계산 기록 저장을 위한 리스트
	ArrayList<String> history = new ArrayList<>();

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

	/**
	 * 계산기 상단의 `display` 텍스트 필드를 설정하고 배치하는 메서드입니다.
	 * 
	 * display는 계산기의 결과를 보여주는 역할을 하며, 기본값은 "0"으로 설정됩니다. 사용자가 편집할 수 없고, 폰트, 색상, 정렬 등
	 * 스타일이 지정되어 있습니다.
	 */
	void showNorth() {
		JPanel panel = new JPanel(new BorderLayout());
		display = new JTextField("0");
		display.setEditable(false);
		display.setBorder(null);
		display.setFont(new Font("Dialog", Font.PLAIN, 50));
		display.setHorizontalAlignment(SwingConstants.RIGHT);
		display.setBackground(Color.BLACK);
		display.setForeground(Color.WHITE);
		panel.add(display);
		add(panel, BorderLayout.NORTH);
	}

	/**
	 * 각 연산 버튼을 생성 & 버튼에 따라 기본 색상을 설정한 후 마우스를 올리면 색상이 짙어지도록 설정하는 메서드입니다.
	 * 
	 * 연산 기능은 ActionListener로 연결되고, 색상 효과는 MouseListener로 구현됩니다.
	 */
	void showCenter() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(5, 4, 7, 7));
		panel.setBackground(Color.black);

		/**
		 * for 루프를 이용하여 버튼 배열에 있는 text를 사용하여 `JButton`을 생성
		 * 
		 * 각 버튼에 기본 색상과 글꼴 스타일을 적용합니다.
		 * 
		 * 생성된 버튼들은 GridLayout으로 패널에 추가됩니다.
		 */
		for (String text : buttons) {
			JButton button = new JButton(text);
			button.setFocusPainted(false);
			button.setBorderPainted(false);
			button.setFont(new Font("Dialog", Font.PLAIN, 25));
			button.addActionListener(l); // 각 버튼에 ActionListener 추가

			// 기본 버튼 색상 설정
			Color defaultColor;
			if (text.equals("=") || text.equals("÷") || text.equals("×") || text.equals("+") || text.equals("-")) {
				defaultColor = Color.ORANGE;
				button.setForeground(Color.WHITE);
			} else if (text.equals("AC") || text.equals("%") || text.equals("←")) {
				defaultColor = Color.LIGHT_GRAY;
				button.setForeground(Color.WHITE);
			} else {
				defaultColor = Color.DARK_GRAY;
				button.setForeground(Color.WHITE);
			}
			button.setBackground(defaultColor);

			// 마우스를 올렸을 때만 색이 짙어지게 설정
			Color rolloverColor = defaultColor.darker(); // 마우스를 올렸을 때 색

			/**
			 * 버튼에 마우스를 올렸을 때 배경색을 rolloverColor로 설정하고, 마우스가 버튼을 벗어나면 기본 색상으로 되돌립니다.
			 */
			button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					button.setBackground(rolloverColor);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					button.setBackground(defaultColor);
				}
			});

			panel.add(button);
		}
		add(panel, BorderLayout.CENTER);
	}

	/**
	 * 계산 기록을 볼 수 있는 historyButton을 생성하고, 버튼에 마우스를 올릴 때 색이 짙어지는 효과를 추가합니다. 클릭 시
	 * showHistory() 메서드를 통해 기록 창이 표시됩니다.
	 */
	void showSouth() {
		JPanel panel = new JPanel(new BorderLayout());
		historyButton = new JButton("🕘");
		historyButton.setFocusPainted(false);
		historyButton.setBorderPainted(false);
		historyButton.setFont(new Font("Dialog", Font.BOLD, 30));
		historyButton.setBackground(Color.DARK_GRAY);
		historyButton.setForeground(Color.WHITE);

		// 기본 색상 및 상태에 따른 색상 변경 설정
		Color defaultColor = Color.DARK_GRAY;
		Color rolloverColor = defaultColor.darker();

		/**
		 * historyButton에 마우스를 올렸을 때 rolloverColor로 배경색이 바뀌며, 마우스를 벗어나면 기본 색상으로 되돌아갑니다.
		 * 
		 * @see <a href ="https://movefast.tistory.com/48">마우스 이벤트 처리 참고 링크</a>
		 * @see <a href="https://movefast.tistory.com/69">MouseEvent 참고 링크</a>
		 */
		historyButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				historyButton.setBackground(rolloverColor);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				historyButton.setBackground(defaultColor);
			}
		});

		// historyButton 클릭 시 계산 기록 창 표시
		historyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showHistory();
			}
		});

		panel.add(historyButton);
		add(panel, BorderLayout.SOUTH);
	}

	/**
	 * 계산 기록을 팝업 창에 표시하는 메소드입니다.
	 * 
	 * 만약 기록이 없다면 "계산 기록이 없습니다." 메시지를 표시합니다. 기록이 존재할 경우, StringBuilder를 사용하여 기록을 한
	 * 줄씩 추가하여 JOptionPane을 통해 보여줍니다.
	 * 
	 * @see <a href="https://movefast.tistory.com/69">JOptionPane 참고 링크</a>
	 * @see ChatGPT
	 */
	private void showHistory() {
		if (history.isEmpty()) {
			JOptionPane.showMessageDialog(this, "아직 기록이 없습니다.");
		} else {
			StringBuilder sb = new StringBuilder();
			for (String record : history) {
				sb.append(record).append("\n");
			}
			JOptionPane.showMessageDialog(this, sb.toString(), "계산 기록", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	/**
	 * 계산기의 각 연산버튼 클릭 이벤트를 처리하는 ActionListener입니다.
	 * 
	 * 사용자가 누른 연산버튼에 따라 숫자 입력, 사칙연산(+, -,×, ÷), 부호 변경(±), 소수점 입력, 나머지 연산(%), 초기화(AC)
	 * 등의 기능을 수행합니다.
	 * 
	 * @param e 버튼 클릭 이벤트를 나타내며, 클릭된 버튼의 텍스트를 통해 기능을 결정합니다.
	 * 
	 *          버튼 기능 설명: - "AC": 모든 값을 초기화하고 display를 "0"으로 설정합니다. - "←": 현재 입력된
	 *          숫자의 마지막 문자를 삭제합니다. 한글자만 남으면 "0"으로 설정됩니다. - "±": 현재 display에 표시된 숫자의
	 *          부호를 변경합니다. - "%": 나머지 연산을 준비하고 첫 번째 숫자(num1)에 현재 값을 저장합니다. - "÷",
	 *          "×", "-", "+": 해당 연산자에 따라 사칙연산을 수행하기 위해num1에 현재 값을 저장하고 operator를
	 *          설정합니다. - "=": 설정된 연산자에 따라 num1과 display에 입력된 두번째 숫자(num2)를 연산하여 결과를
	 *          display에 표시합니다. - ".": 소수점이 없는 경우 현재 숫자에 소수점을 추가합니다. - 기본 숫자: 숫자 버튼을
	 *          눌렀을 때 display에 숫자를 추가합니다. 새로운 숫자입력이 시작되면 display를 새 숫자로 대체하고, 그렇지
	 *          않으면 기존 숫자 뒤에 이어붙입니다.
	 * 
	 * @see <a href="https://firstblog912.tistory.com/137">버튼 이벤트 참고 링크</a>
	 * @see ChatGPT
	 */
	ActionListener l = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			switch (command) {
			case "AC": // 초기화
				display.setText("0");
				num1 = BigDecimal.ZERO;
				num2 = BigDecimal.ZERO;
				operator = "";
				startNewNumber = true;
				break;
			case "←": // 삭제
				String currentText = display.getText();
				display.setText(currentText.length() > 1 ? currentText.substring(0, currentText.length() - 1) : "0");
				break;
			case "±": // 부호 변경
				BigDecimal value = new BigDecimal(display.getText());
				display.setText(value.negate().toString());
				break;
			case "%": // 나머지 연산
				num1 = new BigDecimal(display.getText());
				operator = "%";
				startNewNumber = true;
				break;
			case "÷":
			case "×":
			case "-":
			case "+": // 사칙연산
				num1 = new BigDecimal(display.getText());
				operator = command;
				startNewNumber = true;
				break;
			case "=": // 계산 수행
				num2 = new BigDecimal(display.getText());
				String result = calculateResult();
				display.setText(result);
				history.add(num1 + " " + operator + " " + num2 + " = " + result); // 기록 저장
				startNewNumber = true;
				break;
			case ".": // 소수점 입력
				if (!display.getText().contains(".")) {
					display.setText(display.getText() + ".");
				}
				break;
			default: // 숫자 입력
				if (startNewNumber) {
					display.setText(command);
					startNewNumber = false;
				} else {
					display.setText(display.getText().equals("0") ? command : display.getText() + command);
				}
				break;
			}
		}
	};

	/**
	 * 연산자(operator)에 따라 입력받은 num1과 num2에 대한 사칙연산을 수행하여 결과를 반환하는 메소드입니다.
	 * 
	 * - 덧셈("+"), 뺄셈("-"), 곱셈("×"), 나눗셈("÷"), 나머지("%") 연산을 지원합니다. - 부동 소수점 계산 오류를
	 * 방지하기 위해 `BigDecimal`을 사용하여 정밀한 계산을 수행합니다. - 나눗셈 연산의 경우, 0으로 나누려 할 때에는 "잘못된
	 * 입력입니다."라는 메시지를 반환합니다. - 결과 반환 시 `stripTrailingZeros().toPlainString()`을 사용하여
	 * 불필요한 소수점을 제거합니다.
	 *
	 * @return 연산 결과를 '문자열'로 반환하며, 나눗셈에서 0으로 나누려 할 경우 오류 메시지를 반환합니다.
	 * @see <a href="https://kcasey.tistory.com/7">계산기 작성 시 switch,if문 참고 링크</a>
	 */
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
