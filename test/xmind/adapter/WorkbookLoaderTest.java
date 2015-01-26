package xmind.adapter;

import imm.xmind.adapter.WorkbookLoader;
import imm.xmind.beans.XmindWorkbook;

import java.io.File;

import junit.framework.Assert;

import org.junit.Test;
import org.xmind.core.IWorkbook;



public class WorkbookLoaderTest {

	@Test
	public void testLoadWorbook() throws Exception {
		File file = new File("resources/test_file.xmind");
		IWorkbook workbook = WorkbookLoader.loadWorkbook(file);
		Assert.assertEquals("KOKOKOKO", workbook.getPrimarySheet().getRootTopic().getTitleText());
		
		XmindWorkbook workbook2 = new XmindWorkbook(workbook);
		workbook2.getRootTopic();
	}
	
}
