package homework2;

import java.util.Iterator;
import java.util.Stack;

public class MacroCommand implements Command {
	// undo할 때 pop을 이용하면 편리함
	private Stack<Command> commands = new Stack<Command>();
	
	public void execute() {
		Iterator<Command> it = commands.iterator();
		while(it.hasNext()) {
			it.next().execute();
		}
	}
	// 추가
	public void append(Command cmd) {
		if(cmd != this) {
			commands.push(cmd);
		}
	}
	// 마지막 명령을 삭제
	public void undo() {
		if(!commands.empty()) {
			commands.pop();
		}
	}
	// 전부 삭제
	public void clear() {
		commands.clear();
	}
}
