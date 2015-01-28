package imm.xmind.algorithm;

import imm.impress.beans.MapNode;
import imm.xmind.beans.XmindTopic;

public class ImmRootNode extends ImmNode {
	
	public ImmRootNode(XmindTopic topic, ImmConfiguration config) {
		super(topic, 0, config);
		for (MapNode child : getChildren()) {
			ImmNode node = (ImmNode) child;
			node.computeColor(config.colorPalette.nextColor());
		}
		this.computeCoordinates(0);
	}	
		
}
