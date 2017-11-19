package homework2;

import java.awt.Color;
import java.awt.Point;

public class DrawCommand implements Command {
	protected Drawable drawable;
	private Point position;
	
	// x,y 좌표를 저장
	public DrawCommand(Drawable drawable, Point position) {
		this.drawable = drawable;
		this.position = position;
	}
	
	// 행동 할 때마다 실행
	public void execute() {
		drawable.draw(position.x, position.y);
	}
}
