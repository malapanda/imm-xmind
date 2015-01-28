package imm.xmind.algorithm;

import imm.impress.beans.MindMap;
import imm.xmind.beans.XmindWorkbook;

public class ImmAlgorithm {
	
	private XmindWorkbook workbook;
	private ImmConfiguration config;
	
	public ImmAlgorithm(XmindWorkbook workbook) {
		this(workbook, new ImmConfiguration(370, 100, 0));
	}
	
	public ImmAlgorithm(XmindWorkbook workbook, ImmConfiguration config) {
		this.workbook = workbook;
		this.config = config;
	}
	
	public MindMap generate() {
		ImmRootNode rootNode = new ImmRootNode(workbook.getRootTopic(), config);
		return new ImmMindMap(rootNode);
	}
	
}
