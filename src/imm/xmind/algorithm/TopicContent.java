package imm.xmind.algorithm;

import imm.impress.beans.Content;
import imm.xmind.beans.XmindTopic;

public class TopicContent extends Content {

	public TopicContent(XmindTopic topic, Configuration config) {
		super(topic.getTitleText(),
				topic.getNotes(),
				(topic.getImage() == null ? 
						null : 
						new PrefixedImage(topic.getImage(), config.imagePrefix)));
	}

}
