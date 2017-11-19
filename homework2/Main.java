package homework2;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame implements ActionListener {
	// 그림 그린 이력
	private MacroCommand history = new MacroCommand();
	private DrawCanvas canvas = new DrawCanvas(400, 400, history);
	private JButton redButton = new JButton("red");
	private JButton blueButton = new JButton("blue");
	private JButton greenButton = new JButton("green");
	private JButton clearButton = new JButton("clear");
	private JButton undoButton = new JButton("undo");
	
	public Main(String title) {
		super(title);
		// X버튼 눌렀을 때 종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 드래그 할 때 마다 Command 생성
		canvas.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				Command cmd = new DrawCommand(canvas, e.getPoint());
				Command cmd2 = new ColorCommand(canvas, canvas.getColor());
				history.append(cmd, cmd2);
				cmd.execute();
			}
		});
		
		// 버튼 누르면 작동하게 설정
		clearButton.addActionListener(this);
		undoButton.addActionListener(this);
		redButton.addActionListener(this);
		blueButton.addActionListener(this);
		greenButton.addActionListener(this);
		
		// Box는 프레임의 끝을 만나면 줄바꿈 안하고 프레임을 넘겨서 채운다.
		Box buttonBox = new Box(BoxLayout.X_AXIS);
		// 버튼 생성
		buttonBox.add(clearButton);
		buttonBox.add(redButton);
		buttonBox.add(blueButton);
		buttonBox.add(greenButton);
		buttonBox.add(undoButton);
		
		Box mainBox = new Box(BoxLayout.Y_AXIS);
		mainBox.add(buttonBox);
		mainBox.add(canvas);
		// 폰트 변경
		// mainBox.setFont(new Font("고딕", Font.ITALIC, 20));
		getContentPane().add(mainBox);
		
		pack();
		// setVisible(boolean) 컴포넌트 보이기/숨기기
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		// getSource() : 초기에 발생한 이벤트의 객체를 리턴
		// clearButton 누르면 clear
		if(e.getSource() == clearButton) {
			history.clear();
			canvas.repaint();
		}
		// undoButton 누르면 undo
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
