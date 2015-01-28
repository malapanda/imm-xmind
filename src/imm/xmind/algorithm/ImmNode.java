package imm.xmind.algorithm;

import imm.impress.beans.Coordinates;
import imm.impress.beans.MapNode;
import imm.impress.beans.NodeColor;
import imm.impress.beans.SimpleNode;
import imm.xmind.beans.XmindTopic;

import java.awt.Color;

public class ImmNode extends SimpleNode {
	
	private static int treeDepth = 0;
	
	private Integer level;
	private ImmConfiguration config;

	public ImmNode(XmindTopic topic, Integer level, ImmConfiguration config) {
		super();
		super.setContent(new ImmNodeContent(topic, config));
		this.level = level;
		this.config = config;
		for (XmindTopic subtopic : topic.getChildren()) {
			super.addChild(new ImmNode(subtopic, level + 1, config));
		}
		if (level > treeDepth) {
			treeDepth = level;
		}
	}
	
	void computeColor(Color baseColor) {
		this.setColor(new NodeColor(color(baseColor)));
		for (MapNode child : getChildren()) {
			ImmNode node = (ImmNode)child;
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
				ImmNode node = (ImmNode)child;
				sum += node.computeCoordinates(sum);
			}
			int leaves = sum - position; 
			super.setCoordinates(new Coordinates(Math.round((position + (((float)leaves)/2) - 0.5f) * config.xunit), level*config.yunit, 0));
			//super.setScale(new Scale(scale));
			return leaves;
		}
	}
	
}
