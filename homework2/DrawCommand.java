package homework2;

import java.awt.Color;
import java.awt.Point;

public class DrawCommand implements Command {
	protected Drawable drawable;
	private Point position;
	
	// x,y ��ǥ�� ����
	public DrawCommand(Drawable drawable, Point position) {
		this.drawable = drawable;
		this.position = position;
	}
	
	// �ൿ �� ������ ����
	public void execute() {
		drawable.draw(position.x, position.y);
	}
}
