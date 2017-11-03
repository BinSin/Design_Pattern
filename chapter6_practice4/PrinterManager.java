package chapter6_practice4;

import java.util.ArrayList;

public class PrinterManager {
	private static PrinterManager mgr = null;
	private ArrayList<Printer> managedPrinters = new ArrayList<Printer>();
	
	// 프린터 관리자는 하나만 존재해야 하므로 싱글턴 패던으로 구현
	// 3개의 Printer instance 미리 생성해 저장
	private PrinterManager() {
		managedPrinters.add(new Printer());
		managedPrinters.add(new Printer());
		managedPrinters.add(new Printer());
	}
	
	public synchronized static PrinterManager getPrinterManager() {
		if(mgr == null) {
			mgr = new PrinterManager();
		}
		return mgr;
	}
	
	public synchronized Printer getPrinter() {
		while(true) {
			for(Printer printer : managedPrinters) {
				if(printer.isAvailable()) {
					printer.setAvailable(false);
					return printer;
				}
			}
		}
	}
}
