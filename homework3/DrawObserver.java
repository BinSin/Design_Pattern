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
		// 북쪽에 panel 생성
		getContentPane().add(panel, "North");
		panel.add(textArea);
		
		pack();
		// Frame 가운데 위치
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void update(NumberGenerator generator) {
		Graphics g = getGraphics();
		int count = generator.getNumber();
		String str;
		
		g.setColor(Color.RED);
		// 부채꼴 90도 에서 360도를 그리게 설정
		g.fillArc(55, 77, 300, 300, 90, -count*10);
		
		str = count + " ";
		for(int i=0; i<count; i++) {
			str += "*";
		}
		// textArea에 text 출력
		textArea.setText(str);
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
		}
	}
}
