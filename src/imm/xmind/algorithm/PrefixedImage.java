package imm.xmind.algorithm;

import imm.impress.beans.Image;
import imm.xmind.beans.XmindImage;

public class PrefixedImage implements Image {

	private String prefix;
	private XmindImage image;

	public PrefixedImage(XmindImage image, String prefix) {
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
