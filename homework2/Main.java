package homework2;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame implements ActionListener {
	// �׸� �׸� �̷�
	private MacroCommand history = new MacroCommand();
	private DrawCanvas canvas = new DrawCanvas(400, 400, history);
	private JButton redButton = new JButton("red");
	private JButton blueButton = new JButton("blue");
	private JButton greenButton = new JButton("green");
	private JButton clearButton = new JButton("clear");
	private JButton undoButton = new JButton("undo");
	
	public Main(String title) {
		super(title);
		// X��ư ������ �� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// �巡�� �� �� ���� Command ����
		canvas.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				Command cmd = new DrawCommand(canvas, e.getPoint());
				Command cmd2 = new ColorCommand(canvas, canvas.getColor());
				history.append(cmd, cmd2);
				cmd.execute();
			}
		});
		
		// ��ư ������ �۵��ϰ� ����
		clearButton.addActionListener(this);
		undoButton.addActionListener(this);
		redButton.addActionListener(this);
		blueButton.addActionListener(this);
		greenButton.addActionListener(this);
		
		// Box�� �������� ���� ������ �ٹٲ� ���ϰ� �������� �Ѱܼ� ä���.
		Box buttonBox = new Box(BoxLayout.X_AXIS);
		// ��ư ����
		buttonBox.add(clearButton);
		buttonBox.add(redButton);
		buttonBox.add(blueButton);
		buttonBox.add(greenButton);
		buttonBox.add(undoButton);
		
		Box mainBox = new Box(BoxLayout.Y_AXIS);
		mainBox.add(buttonBox);
		mainBox.add(canvas);
		// ��Ʈ ����
		// mainBox.setFont(new Font("���", Font.ITALIC, 20));
		getContentPane().add(mainBox);
		
		pack();
		// setVisible(boolean) ������Ʈ ���̱�/�����
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		// getSource() : �ʱ⿡ �߻��� �̺�Ʈ�� ��ü�� ����
		// clearButton ������ clear
		if(e.getSource() == clearButton) {
			history.clear();
			canvas.repaint();
		}
		// undoButton ������ undo
		else if(e.getSource() == undoButton) {
			history.undo();
			canvas.repaint();
		}
		// 
		else if(e.getSource() == redButton) {
			canvas.setColor(Color.RED);
		}
		else if(e.getSource() == blueButton) {
			canvas.setColor(Color.BLUE);
		}
		else if(e.getSource() == greenButton) {
			canvas.setColor(Color.GREEN);
		}
	}
		
	public static void main(String[] args) {
		new Main("Command Pattern Sample");
	}
}
