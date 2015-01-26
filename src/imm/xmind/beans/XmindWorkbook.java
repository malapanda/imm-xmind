package imm.xmind.beans;

import org.xmind.core.ISheet;
import org.xmind.core.IWorkbook;

public class XmindWorkbook {

	private String titleText;
	
	private XmindTopic rootTopic;
	
	public XmindWorkbook(IWorkbook workbook) {
		ISheet primarySheet = workbook.getPrimarySheet();
		rootTopic = new XmindTopic(primarySheet.getRootTopic());
		titleText = primarySheet.getTitleText();
	}
	
	public XmindTopic getRootTopic() {
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
