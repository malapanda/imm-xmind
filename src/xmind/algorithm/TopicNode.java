package xmind.algorithm;

import java.util.ArrayList;
import java.util.List;

import impress.beans.Coordinates;
import impress.beans.MapNode;
import impress.beans.SimpleNode;
import impress.beans.TextContent;
import xmind.beans.Topic;

public class TopicNode extends SimpleNode implements Countable {
	
	private Topic topic;
	private Integer level;
	private int subTreeLeaves;

	public TopicNode(Topic topic, Integer level) {
		super();
		this.topic = topic;
		this.level = level;
		super.content = new TextContent(topic.getTitleText());
		for (Topic subtopic : topic.getChildren()) {
			super.addChild(new TopicNode(subtopic, level + 1));
		}
	}

	@Override
	public void addChild(SimpleNode child) {
		super.addChild(child);
	}
	
	public int computeLeaves() {
		List<TopicNode> children = new ArrayList<>();
		for (MapNode topicNode : super.getChildren()) {
			children.add((TopicNode)topicNode);
		}
		LeafCounter<TopicNode> leafCounter = new LeafCounter<TopicNode>(children);
		subTreeLeaves = leafCounter.computeLeaves();
		return subTreeLeaves;
	}
	
	public void setCoords(int position, float unit) {
		if (subTreeLeaves == 1) {
			super.setCoordinates(new Coordinates(Math.round(position*unit), 100 * level, 0));
		} else {
			int sum = position;
			for (MapNode child : getChildren()) {
				TopicNode node = (TopicNode)child;
				node.setCoords(sum, unit);
				sum += node.subTreeLeaves;
			}
			super.setCoordinates(new Coordinates(Math.round((position + subTreeLeaves/2) * unit), 100 * level, 0));
		}
	}
	
	public int getSubTreeLeaves() {
		return subTreeLeaves;
	}

}
