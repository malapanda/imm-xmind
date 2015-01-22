package xmind.beans;

import java.util.ArrayList;
import java.util.List;

import org.xmind.core.ITopic;
import org.xmind.core.util.Point;

public class Topic {

	private String titleText;
	private List<Topic> children = new ArrayList<>();
		
	public Topic(ITopic xmindTopic) {
		titleText = xmindTopic.getTitleText();
		List<ITopic> allChildren = xmindTopic.getAllChildren();
		for (ITopic child : allChildren) {
			children.add(new Topic(child));
		}
	}

	public String getTitleText() {
		return titleText;
	}

	public List<Topic> getChildren() {
		return children;
	}

	@Override
	public String toString() {
		return getTitleText();
	}
	
}
