package homework3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class DrawObserver extends JFrame implements Observer {
	
	protected JTextArea textArea;
	
	DrawObserver() {
		setTitle("Observer Command");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 400);
		setBackground(Color.white);
		setPreferredSize(new Dimension(400, 400));
		
		JPanel panel = new JPanel();
		textArea = new JTextArea(0, 33);
		textArea.setEditable(false);
		// ���ʿ� panel ����
		getContentPane().add(panel, "North");
		panel.add(textArea);
		
		pack();
		// Frame ��� ��ġ
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void update(NumberGenerator generator) {
		Graphics g = getGraphics();
		int count = generator.getNumber();
		String str;
		
		g.setColor(Color.RED);
		// ��ä�� 90�� ���� 360���� �׸��� ����
		g.fillArc(55, 77, 300, 300, 90, -count*10);
		
		str = count + " ";
		for(int i=0; i<count; i++) {
			str += "*";
		}
		// textArea�� text ���
		textArea.setText(str);
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
		}
	}
}
