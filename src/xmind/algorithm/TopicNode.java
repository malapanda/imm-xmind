package xmind.algorithm;

import impress.beans.Coordinates;
import impress.beans.MapNode;
import impress.beans.SimpleNode;
import impress.beans.TextContent;
import xmind.beans.Topic;

public class TopicNode extends SimpleNode {
	
	private Topic topic;
	private Integer level;
	private Configuration config;

	public TopicNode(Topic topic, Integer level, Configuration config) {
		super();
		this.topic = topic;
		this.level = level;
		this.config = config;
		super.content = new TextContent(topic.getTitleText());
		for (Topic subtopic : topic.getChildren()) {
			super.addChild(new TopicNode(subtopic, level + 1, config));
		}
	}

	@Override
	public void addChild(SimpleNode child) {
		super.addChild(child);
	}
	
	public int computeCoordinates(int position) {
		if (children.size() == 0) {
			super.setCoordinates(new Coordinates(position*config.xunit, level*config.yunit , 0));
			return 1;
		} else {
			int sum = position;
			for (MapNode child : getChildren()) {
				TopicNode node = (TopicNode)child;
				sum += node.computeCoordinates(sum);
			}
			int leaves = sum - position; 
			super.setCoordinates(new Coordinates((position + leaves/2) * config.xunit, level*config.yunit , 0));
			return leaves;
		}
	}
	
}
