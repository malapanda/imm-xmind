package imm.xmind.algorithm;

import java.awt.Color;
import java.util.Arrays;

public class ImmConfiguration {
	
	public int xunit;
	public int yunit;
	public int zunit;
	public String imagePrefix;
	public ImmColorPalette colorPalette;

	public ImmConfiguration(int xunit, int yunit, int zunit) {
		this(xunit, yunit, zunit, null);
	}
	
	public ImmConfiguration(int xunit, int yunit, int zunit, String imagePrefix) {
		this.xunit = xunit;
		this.yunit = yunit;
		this.zunit = zunit;
		this.imagePrefix = imagePrefix;
		this.colorPalette = new ImmColorPalette(Arrays.asList(Color.green, Color.orange, Color.blue, Color.red, Color.yellow));
	}

}
