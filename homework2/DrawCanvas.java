package homework2;

import java.awt.*;

public class DrawCanvas extends Canvas implements Drawable {
	private Color color = Color.red;
	private int radius = 6;
	private MacroCommand history;
	
	// invoke이자 receiver
	public DrawCanvas(int width, int height, MacroCommand history) {
		setSize(width, height);
		// 배경색 세팅
		setBackground(Color.white);
		this.history = history;
	}
	// 도형 색 설정
	public void setColor(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	// 이력 전체를 다시 그리기 reprint 할 때마다 실행
	public void paint(Graphics g) {
		history.execute();
	}
	// 그림 그리기
	public void draw(int x, int y) {
		Graphics g = getGraphics();
		g.setColor(color);
		// g.fill~ : 속이 가득찬 도형
		// g.draw~ : 속이 빈 도형
		// fillOval : 속이 가득찬 타원형
		g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
	}
}
