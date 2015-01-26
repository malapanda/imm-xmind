package imm.xmind.beans;

import org.xmind.core.IImage;

public class XmindImage {

	private String path;

	public XmindImage(IImage image) {
		String source = image.getSource();
		if (source.startsWith("xap:")) {
			this.path = source.replaceFirst("xap:", "");
		}
	}

	public String getPath() {
		return path;
	}

}
