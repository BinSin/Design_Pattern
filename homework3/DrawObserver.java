package homework3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class DrawObserver extends JFrame implements Observer, ActionListener {
	
	protected JTextArea textArea;
	private JButton closeButton = new JButton("close");
	
	DrawObserver() {
		
		setTitle("Observer Command");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 400);
		setBackground(Color.white);
		setPreferredSize(new Dimension(400, 400));
		
		closeButton.addActionListener(this);
		
		// ��ư ����
		add(closeButton, "South");
		
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
		g.fillArc(55, 75, 280, 280, 90, -count*10);
		
		
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
		// �ٽ� �׸���.
		this.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Ŭ���� ����
		if(e.getSource().equals(closeButton)) {
			System.exit(0);
		}
	}
}
