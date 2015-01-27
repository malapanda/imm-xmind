package imm.xmind.beans;

import java.util.ArrayList;
import java.util.List;

import org.xmind.core.INotes;
import org.xmind.core.ITopic;
import org.xmind.core.IPlainNotesContent;

public class XmindTopic {

	private String titleText;
	private String notes;
	private XmindImage image;
	
	private List<XmindTopic> children = new ArrayList<XmindTopic>();
	
	public XmindTopic(ITopic xmindTopic) {
		this.titleText = xmindTopic.getTitleText();
		INotes inotes = xmindTopic.getNotes();
		if (!inotes.isEmpty()) {
			IPlainNotesContent content = (IPlainNotesContent)inotes.getContent(INotes.PLAIN);
			this.notes = content.getTextContent();
		}
		if (xmindTopic.getImage().getSource() != null) {
			this.image = new XmindImage(xmindTopic.getImage());
		}
		List<ITopic> allChildren = xmindTopic.getAllChildren();
		for (ITopic child : allChildren) {
			this.children.add(new XmindTopic(child));
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

	public String getNotes() {
		return notes;
	}
	
}
