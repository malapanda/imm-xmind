package xmind.algorithm;

import impress.beans.MapNode;
import impress.beans.MindMap;
import impress.utils.BFS;

import java.util.List;

import xmind.beans.Workbook;


public class SimpleAlgorithm {
	
	private Workbook workbook;
	private Configuration config;
	
	public SimpleAlgorithm(Workbook workbook) {
		this.workbook = workbook;
		this.config = new Configuration(350, 100, 0);
	}
	
	public MindMap generate() {
		final TopicNode rootNode = new TopicNode(workbook.getRootTopic(), 0, config);
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
