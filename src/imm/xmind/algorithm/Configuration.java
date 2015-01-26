package imm.xmind.algorithm;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;

public class Configuration {
	
	public int xunit;
	public int yunit;
	public int zunit;
	public String imagePrefix;
	public ColorPalette colorPalette;

	public Configuration(int xunit, int yunit, int zunit) {
		this(xunit, yunit, zunit, null);
	}
	
	public Configuration(int xunit, int yunit, int zunit, String imagePrefix) {
		this.xunit = xunit;
		this.yunit = yunit;
		this.zunit = zunit;
		this.imagePrefix = imagePrefix;
		this.colorPalette = new ColorPalette(Arrays.asList(Color.green, Color.orange, Color.blue, Color.red, Color.yellow));
	}

}
