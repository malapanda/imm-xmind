package xmind.algorithm;

import impress.beans.MapNode;
import impress.beans.MindMap;
import impress.utils.BFS;

import java.util.List;

import xmind.beans.Workbook;


public class SimpleAlgorithm {
	
	private Workbook workbook;

	private static final float X_SIZE = 15000;
	
	public SimpleAlgorithm(Workbook workbook) {
		this.workbook = workbook;
	}
	
	public MindMap generate() {
		final TopicNode rootNode = new TopicNode(workbook.getRootTopic(), 0);
		rootNode.computeLeaves();
		float unit = X_SIZE/((float)rootNode.getSubTreeLeaves());
		rootNode.setCoords(0, unit);
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
