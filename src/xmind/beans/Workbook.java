package xmind.beans;

import org.xmind.core.ISheet;
import org.xmind.core.IWorkbook;

public class Workbook {

	private String titleText;
	
	private Topic rootTopic;
	
	public Workbook(IWorkbook workbook) {
		ISheet primarySheet = workbook.getPrimarySheet();
		rootTopic = new Topic(primarySheet.getRootTopic());
		titleText = primarySheet.getTitleText();
	}
	
	public Topic getRootTopic() {
		return rootTopic;
	}
	
	public String getTitleText() {
		return titleText;
	}
	
	@Override
	public String toString() {
		return getTitleText();
	}
	
}
