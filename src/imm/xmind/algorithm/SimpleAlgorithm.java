package imm.xmind.algorithm;

import imm.impress.beans.MapNode;
import imm.impress.beans.MindMap;
import imm.impress.utils.BFS;
import imm.xmind.beans.XmindWorkbook;

import java.util.List;

public class SimpleAlgorithm {
	
	private XmindWorkbook workbook;
	private Configuration config;
	
	public SimpleAlgorithm(XmindWorkbook workbook) {
		this(workbook, new Configuration(370, 100, 0));
	}
	
	public SimpleAlgorithm(XmindWorkbook workbook, Configuration config) {
		this.workbook = workbook;
		this.config = config;
	}
	
	public MindMap generate() {
		final TopicNode rootNode = new RootNode(workbook.getRootTopic(), config);
		rootNode.computeCoordinates(0);
		MindMap map = new MindMap() {
			@Override
			public List<MapNode> getNodesInOrder() {
				BFS dfs = new BFS(rootNode);
				return dfs.getNodes();
			}
		};
		return map;
	}
	
}
