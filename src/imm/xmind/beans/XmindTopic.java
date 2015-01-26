package imm.xmind.beans;

import java.util.ArrayList;
import java.util.List;

import org.xmind.core.ITopic;

public class XmindTopic {

	private String titleText;
	private XmindImage image;
	
	private List<XmindTopic> children = new ArrayList<XmindTopic>();
	
	public XmindTopic(ITopic xmindTopic) {
		titleText = xmindTopic.getTitleText();
		if (xmindTopic.getImage().getSource() != null) {
			image = new XmindImage(xmindTopic.getImage());
		}
		List<ITopic> allChildren = xmindTopic.getAllChildren();
		for (ITopic child : allChildren) {
			children.add(new XmindTopic(child));
		}
	}

	public String getTitleText() {
		return titleText;
	}

	public List<XmindTopic> getChildren() {
		return children;
	}
	
	public XmindImage getImage() {
		return image;
	}

	@Override
	public String toString() {
		return getTitleText();
	}
	
}
