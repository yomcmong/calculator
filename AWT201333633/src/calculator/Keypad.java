package calculator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Keypad extends Frame {
	
	JLabel label; // ����� ��ºκ�
	JButton bNum[] = new JButton[10]; // ���� ��ư
	JButton plus, minus, multi, div, equal, clear, back, nul, nul2, nul3; // ���� ��ư

	String inputValue; // ���� �Է����� ����
	int result; // �߰� ��� ���
	char lastOp; // ���� ������ ������

	public static void main(String[] args) {
		new Keypad();
	}

	public Keypad() {
		super();
		setBounds(200, 200, 300, 300);
		setResizable(false);
//		setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);

		label = new JLabel("0", JLabel.RIGHT);
		label.setFont(new Font("�ü�", Font.BOLD, 20));

		add(label, BorderLayout.NORTH);

		JPanel p = new JPanel(new GridLayout(5, 2));
		add(p, BorderLayout.CENTER);

		plus = new JButton("+");
		minus = new JButton("-");
		multi = new JButton("*");
		div = new JButton("/");
		equal = new JButton("=");
		clear = new JButton("C");
		back = new JButton("��");
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
		

		// �̺�Ʈ ������ ����
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

	// ���ڹ�ư�� �̺�Ʈ ó��
	class NumberHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String s = e.getActionCommand(); // Ŭ���� ��ư�� ���̺�
			if (inputValue == null) {
				if (s.equals("0"))
					return; // ù �ڸ��̸鼭 0�̸� ����
				else
					inputValue = new String(); // ù �ڸ��̸� String ��ü ����
			}
			if (inputValue.length() >= 9)
				return; // 9�ڸ� ������ ����
			inputValue += s; // �ι�° �����̸� ���� ���� �����̱�
			label.setText(inputValue); // ���� ���� ȭ�鿡 ǥ��
		}
	}

	// ��Ÿ ��� ��ư�� �̺�Ʈ ó��
	class CalcHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton) e.getSource();
			int value;

			// clear�� �����
			if (source == clear) {
				label.setText("0"); // ȭ�� �� �� ���� �ʱ�ȭ
				inputValue = null; // String Ÿ���� ���� ����
				lastOp = 0; // char Ÿ���� ������ ������
				result = 0; // int Ÿ���� �߰� ��� ���
				return;
			}
			// back���� �����
			if (source == back){
				String temp = label.getText();
				temp = temp.substring(0,temp.length()-1);
				label.setText(temp); 
				double result;
			}
			
			// ��Ÿ ��� +,-,*,/
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
