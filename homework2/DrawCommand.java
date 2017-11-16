package homework2;

import java.awt.Color;
import java.awt.Point;

public class DrawCommand implements Command {
	protected Drawable drawable;
	private Point position;
	private Color color;
	// x,y ��ǥ�� color�� ����
	public DrawCommand(Drawable drawable, Point position, Color color) {
		this.drawable = drawable;
		this.position = position;
		this.color = color;
	}
	
	// �ൿ �� ������ ����
	public void execute() {
		drawable.setColor(color);
		drawable.draw(position.x, position.y);
	}
}
