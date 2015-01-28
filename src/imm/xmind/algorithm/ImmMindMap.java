package imm.xmind.algorithm;

import java.util.List;

import imm.impress.beans.MapNode;
import imm.impress.beans.MindMap;
import imm.impress.utils.BFS;

public class ImmMindMap implements MindMap {

	private ImmRootNode rootNode;

	public ImmMindMap(ImmRootNode rootNode) {
		this.rootNode = rootNode;
	}

	@Override
	public List<MapNode> getNodesInOrder() {
		BFS search = new BFS(rootNode);
		List<MapNode> nodes = search.getNodes();
		
		return nodes;
	}

}
