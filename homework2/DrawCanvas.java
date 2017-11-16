package homework2;

import java.awt.*;

public class DrawCanvas extends Canvas implements Drawable {
	private Color color = Color.red;
	private int radius = 6;
	private MacroCommand history;
	
	// invoke���� receiver
	public DrawCanvas(int width, int height, MacroCommand history) {
		setSize(width, height);
		// ���� ����
		setBackground(Color.white);
		this.history = history;
	}
	// ���� �� ����
	public void setColor(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	// �̷� ��ü�� �ٽ� �׸��� reprint �� ������ ����
	public void paint(Graphics g) {
		history.execute();
	}
	// �׸� �׸���
	public void draw(int x, int y) {
		Graphics g = getGraphics();
		g.setColor(color);
		// g.fill~ : ���� ������ ����
		// g.draw~ : ���� �� ����
		// fillOval : ���� ������ Ÿ����
		g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
	}
}
