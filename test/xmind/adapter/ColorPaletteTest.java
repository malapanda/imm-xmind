package xmind.adapter;

import imm.xmind.algorithm.ColorPalette;

import java.awt.Color;
import java.util.Arrays;

import org.junit.Test;

public class ColorPaletteTest {

	@Test
	public static void main(String[] args) {
		ColorPalette colorPalette = new ColorPalette(Arrays.asList(Color.black, Color.blue, Color.red, Color.yellow));
		System.out.println(colorPalette.nextColor());
		System.out.println(colorPalette.nextColor());
		System.out.println(colorPalette.nextColor());
		System.out.println(colorPalette.nextColor());
		System.out.println(colorPalette.nextColor());
		System.out.println(colorPalette.nextColor());
		System.out.println(colorPalette.nextColor());
		System.out.println(colorPalette.nextColor());
		System.out.println(colorPalette.nextColor());
		System.out.println(colorPalette.nextColor());
		System.out.println(colorPalette.nextColor());
		System.out.println(colorPalette.nextColor());
		System.out.println(colorPalette.nextColor());
		System.out.println(colorPalette.nextColor());
		System.out.println(colorPalette.nextColor());
	}
	
	
}
