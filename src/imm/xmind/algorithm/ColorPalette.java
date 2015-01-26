package imm.xmind.algorithm;

import java.awt.Color;
import java.util.Iterator;
import java.util.List;

public class ColorPalette {

	private List<Color> colorList;

	private Iterator<Color> iterator;
	
	public ColorPalette(List<Color> colorList) {
		this.colorList = colorList;
		this.iterator = this.colorList.iterator();
	}
	
	public Color nextColor() {
		if (iterator.hasNext()) {
			return iterator.next();
		} else {
			iterator = colorList.iterator();
		}
		return nextColor();
	}
	
}
