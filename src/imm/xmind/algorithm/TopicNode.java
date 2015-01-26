package imm.xmind.algorithm;

import java.awt.Color;

import imm.impress.beans.Coordinates;
import imm.impress.beans.MapNode;
import imm.impress.beans.NodeColor;
import imm.impress.beans.Scale;
import imm.impress.beans.SimpleNode;
import imm.xmind.beans.XmindTopic;

public class TopicNode extends SimpleNode {
	
	private static int treeDepth = 0;
	
	private Integer level;
	private Configuration config;

	public TopicNode(XmindTopic topic, Integer level, Configuration config) {
		super();
		super.setContent(new TopicContent(topic, config));
		this.level = level;
		this.config = config;
		for (XmindTopic subtopic : topic.getChildren()) {
			super.addChild(new TopicNode(subtopic, level + 1, config));
		}
		if (level > treeDepth) {
			treeDepth = level;
		}
	}
	
	void computeColor(Color baseColor) {
		this.setColor(new NodeColor(color(baseColor)));
		for (MapNode child : getChildren()) {
			TopicNode node = (TopicNode)child;
			node.computeColor(baseColor);
		}
	}

	private Color color(Color baseColor) {
		float factor = 1 - ((float)(level + 1)/(float)(treeDepth + 1))*0.8f;
		float hsbVals[] = Color.RGBtoHSB(baseColor.getRed(),
				baseColor.getGreen(), baseColor.getBlue(), null);	
		Color color = Color.getHSBColor(hsbVals[0], hsbVals[1], factor * hsbVals[2]);
		return color;
	}
	
	public int computeCoordinates(int position) {
		float factor =  (1 - ((float)(level + 1)/(float)(treeDepth + 1)));
		float scale = factor;
		
		if (getChildren().size() == 0) {
			super.setCoordinates(new Coordinates(Math.round(position*config.xunit), level*config.yunit, 0));
			//super.setScale(new Scale(scale));
			return 1;
		} else {
			int sum = position;
			for (MapNode child : getChildren()) {
				TopicNode node = (TopicNode)child;
				sum += node.computeCoordinates(sum);
			}
			int leaves = sum - position; 
			super.setCoordinates(new Coordinates(Math.round((position + (((float)leaves)/2) - 0.5f) * config.xunit), level*config.yunit, 0));
			//super.setScale(new Scale(scale));
			return leaves;
		}
	}
	
}
