package homework2;

import java.awt.Color;
import java.awt.Point;

public class DrawCommand implements Command {
	protected Drawable drawable;
	private Point position;
	private Color color;
	// x,y 좌표와 color를 저장
	public DrawCommand(Drawable drawable, Point position, Color color) {
		this.drawable = drawable;
		this.position = position;
		this.color = color;
	}
	
	// 행동 할 때마다 실행
	public void execute() {
		drawable.setColor(color);
		drawable.draw(position.x, position.y);
	}
}
