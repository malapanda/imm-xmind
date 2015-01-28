package imm.xmind.algorithm;

import imm.impress.beans.Image;
import imm.xmind.beans.XmindImage;

public class ImmImage implements Image {

	private String prefix;
	private XmindImage image;

	public ImmImage(XmindImage image, String prefix) {
		this.image = image;
		this.prefix = prefix;
	}
	
	@Override
	public String getPath() {
		if (prefix == null)
			return image.getPath();
		return prefix + "/" + image.getPath();
	}

}
