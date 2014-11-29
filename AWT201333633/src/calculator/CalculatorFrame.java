package calculator;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorFrame extends Frame 	//FrameÀ» °è½ÂÇØ¼­ CarFrame ¸¸µê
{	
	public static String EXIT_ON_CLOSE;

	public CalculatorFrame()
	{		
		Panel panel = new Panel(new GridLayout(6, 8));
		MyListener listener = new MyListener();
		MyListener2 listener2 = new MyListener2();
		MyListener3 listener3 = new MyListener3();
		
		Button btnback = new Button("¡ç");
		btnback.addActionListener(listener3);
		panel.add(btnback);
		
		Button btnclear = new Button("C");
		btnclear.addActionListener(listener3);
		panel.add(btnclear);
		
		Button btnnull = new Button("");
		panel.add(btnnull);
		
		Button btn7 = new Button("7");
		btn7.addActionListener(listener);
		panel.add(btn7);
		
		Button btn8 = new Button("8");
		btn8.addActionListener(listener);
		panel.add(btn8);
		
		Button btn9 = new Button("9");
		btn9.addActionListener(listener);
		panel.add(btn9);
		
		Button btn4 = new Button("4");
		btn4.addActionListener(listener);
		panel.add(btn4);
		
		Button btn5 = new Button("5");
		btn5.addActionListener(listener);
		panel.add(btn5);
		
		Button btn6 = new Button("6");
		btn6.addActionListener(listener);
		panel.add(btn6);

		Button btn1 = new Button("1");
		btn1.addActionListener(listener);
		panel.add(btn1);
		
		Button btn2 = new Button("2");
		btn2.addActionListener(listener);
		panel.add(btn2);
		
		Button btn3 = new Button("3");
		btn3.addActionListener(listener);
		panel.add(btn3);
		
		Button btn0 = new Button("0");
		btn0.addActionListener(listener);
		panel.add(btn0);
		
		Button btnplus = new Button("+");
		btnplus.addActionListener(listener2);
		panel.add(btnplus);
		
		Button btnminus = new Button("-");
		btnminus.addActionListener(listener2);
		panel.add(btnminus);
		
		Button btnequal = new Button("=");
		btnequal.addActionListener(listener3);
		panel.add(btnequal);
		
		Button btnmul = new Button("*");
		btnmul.addActionListener(listener2);
		panel.add(btnmul);
		
		Button btndiv = new Button("/");
		btndiv.addActionListener(listener2);
		panel.add(btndiv);
				
		panel.setBackground(Color.LIGHT_GRAY);
		this.add(panel, BorderLayout.SOUTH);

		this.setTitle("Calculator");
		setSize(300,200);
		this.setVisible(true);
		
	}

	class MyListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			Button btn = (Button)e.getSource();	
			btn.setBackground(Color.YELLOW);
		}
	}

	class MyListener2 implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			Button btn = (Button)e.getSource();	
			btn.setBackground(Color.GREEN);
		}
	}
	
	class MyListener3 implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			Button btn = (Button)e.getSource();	
			btn.setBackground(Color.CYAN);
		}
	}
}

