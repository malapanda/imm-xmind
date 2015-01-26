package imm.xmind.algorithm;

import imm.impress.beans.MapNode;
import imm.xmind.beans.XmindTopic;

public class RootNode extends TopicNode {
	
	public RootNode(XmindTopic topic, Configuration config) {
		super(topic, 0, config);
		for (MapNode child : getChildren()) {
			TopicNode node = (TopicNode) child;
			node.computeColor(config.colorPalette.nextColor());
		}
	}	
		
}
