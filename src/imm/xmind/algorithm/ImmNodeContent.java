package imm.xmind.algorithm;

import imm.impress.beans.Content;
import imm.xmind.beans.XmindTopic;

public class ImmNodeContent extends Content {

	public ImmNodeContent(XmindTopic topic, ImmConfiguration config) {
		super(topic.getTitleText(),
				topic.getNotes(),
				(topic.getImage() == null ? 
						null : 
						new ImmImage(topic.getImage(), config.imagePrefix)));
	}

}
