package calculator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Keypad extends Frame {
	
	JLabel label; // 계산결과 출력부분
	JButton bNum[] = new JButton[10]; // 숫자 버튼
	JButton plus, minus, multi, div, equal, clear, back, nul, nul2, nul3; // 연산 버튼

	String inputValue; // 현재 입력중인 숫자
	int result; // 중간 계산 결과
	char lastOp; // 이전 선택한 연산자

	public static void main(String[] args) {
		new Keypad();
	}

	public Keypad() {
		super();
		setBounds(200, 200, 300, 300);
		setResizable(false);
//		setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);

		label = new JLabel("0", JLabel.RIGHT);
		label.setFont(new Font("궁서", Font.BOLD, 20));

		add(label, BorderLayout.NORTH);

		JPanel p = new JPanel(new GridLayout(5, 2));
		add(p, BorderLayout.CENTER);

		plus = new JButton("+");
		minus = new JButton("-");
		multi = new JButton("*");
		div = new JButton("/");
		equal = new JButton("=");
		clear = new JButton("C");
		back = new JButton("←");
		nul = new JButton("");
		nul2 = new JButton("");
		nul3 = new JButton("");

		int i;
		for (i = 0; i < bNum.length; i++) {
			bNum[i] = new JButton(Integer.toString(i));
		}
		p.add(back);
		p.add(clear);
		p.add(nul);
		p.add(plus);
		p.add(bNum[7]);
		p.add(bNum[8]);
		p.add(bNum[9]);
		p.add(minus);
		p.add(bNum[4]);
		p.add(bNum[5]);
		p.add(bNum[6]);
		p.add(multi);
		p.add(bNum[1]);
		p.add(bNum[2]);
		p.add(bNum[3]);
		p.add(div);
		p.add(nul2);
		p.add(bNum[0]);
		p.add(nul3);
		p.add(equal);
		

		// 이벤트 리스너 연결
		NumberHandler nh = new NumberHandler();
		for (i = 0; i < bNum.length; i++) {
			bNum[i].addActionListener(nh);
		}

		CalcHandler ch = new CalcHandler();
		plus.addActionListener(ch);
		minus.addActionListener(ch);
		multi.addActionListener(ch);
		div.addActionListener(ch);
		equal.addActionListener(ch);
		clear.addActionListener(ch);
		back.addActionListener(ch);

		setVisible(true);
	}

	private void setDefaultCloseOperation(String exitOnClose) {
		// TODO Auto-generated method stub
		
	}

	// 숫자버튼의 이벤트 처리
	class NumberHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String s = e.getActionCommand(); // 클릭한 버튼의 레이블
			if (inputValue == null) {
				if (s.equals("0"))
					return; // 첫 자리이면서 0이면 무시
				else
					inputValue = new String(); // 첫 자리이면 String 객체 생성
			}
			if (inputValue.length() >= 9)
				return; // 9자리 넘으면 무시
			inputValue += s; // 두번째 이후이면 누른 숫자 덧붙이기
			label.setText(inputValue); // 현재 숫자 화면에 표시
		}
	}

	// 기타 계산 버튼의 이벤트 처리
	class CalcHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton) e.getSource();
			int value;

			// clear로 지우기
			if (source == clear) {
				label.setText("0"); // 화면 및 각 변수 초기화
				inputValue = null; // String 타입의 현재 숫자
				lastOp = 0; // char 타입의 마지막 연산자
				result = 0; // int 타입의 중간 계산 결과
				return;
			}
			// back으로 지우기
			if (source == back){
				String temp = label.getText();
				temp = temp.substring(0,temp.length()-1);
				label.setText(temp); 
				double result;
			}
			
			// 기타 계산 +,-,*,/
			if (inputValue != null) {
				value = Integer.parseInt(inputValue);
				switch (lastOp) {
				case '+':
					result += value;
					break;
				case '-':
					result -= value;
					break;
				case '*':
					result *= value;
					break;
				case '/':
					result /= value;
					break;
				default:
					result = value;
					break;
				}
				label.setText(Integer.toString(result));
			}
			inputValue = null;
			lastOp = source.getText().charAt(0);
		}
	}
}
