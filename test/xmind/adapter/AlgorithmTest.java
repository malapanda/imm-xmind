package xmind.adapter;

import freemarker.template.TemplateException;
import imm.impress.beans.MapNode;
import imm.impress.beans.MindMap;
import imm.impress.generator.MindMapGenerator;
import imm.xmind.adapter.WorkbookLoader;
import imm.xmind.algorithm.ImmAlgorithm;
import imm.xmind.beans.XmindWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.xmind.core.CoreException;

public class AlgorithmTest {

	@Test
	public void testAlgorithm() throws Exception {
		File file = new File("resources/test_file.xmind");
		XmindWorkbook workbook = new XmindWorkbook(WorkbookLoader.loadWorkbook(file));
		ImmAlgorithm simpleAlgorithm = new ImmAlgorithm(workbook);
		MindMap mindMap = simpleAlgorithm.generate();
		for (MapNode node : mindMap.getNodesInOrder()) {
			System.out.println(node.toString());
		}
	}
	
	File templateFolder  = new File("resources");
	
	@Test
	public void testSth() throws IOException, TemplateException, CoreException {
		File file = new File("resources/test_file.xmind");
		XmindWorkbook workbook = new XmindWorkbook(WorkbookLoader.loadWorkbook(file));
		ImmAlgorithm simpleAlgorithm = new ImmAlgorithm(workbook);
		MindMap mindMap = simpleAlgorithm.generate();
		
		MindMapGenerator generator = new MindMapGenerator("impress.ftl", templateFolder);		
		
		generator.generateToFile(new File("test.html"),mindMap);
	}
	
	
	@Test
	public void testWithImages() throws IOException, TemplateException, CoreException {
		File file = new File("resources/z_obrazkami.xmind");
		String tempDirectoryPath = FileUtils.getTempDirectoryPath();
		File tmpDir = new File(tempDirectoryPath,UUID.randomUUID().toString());
		FileUtils.forceMkdir(tmpDir); 
		System.out.println(tmpDir.getAbsolutePath());
		
		XmindWorkbook workbook = new XmindWorkbook(WorkbookLoader.loadWorkbookToDir(file, tmpDir));
		ImmAlgorithm simpleAlgorithm = new ImmAlgorithm(workbook);
		MindMap mindMap = simpleAlgorithm.generate();
		
		MindMapGenerator generator = new MindMapGenerator("impress.ftl", templateFolder);		
		
		generator.generateToFile(new File("test.html"),mindMap);
		
		FileUtils.deleteDirectory(tmpDir);
	}
	
	@Test
	public void testWithNotes() throws IOException, TemplateException, CoreException {
		File file = new File("resources/z_notatkami.xmind");		
		XmindWorkbook workbook = new XmindWorkbook(WorkbookLoader.loadWorkbook(file));
		ImmAlgorithm simpleAlgorithm = new ImmAlgorithm(workbook);
		MindMap mindMap = simpleAlgorithm.generate();
		MindMapGenerator generator = new MindMapGenerator("impress.ftl", templateFolder);		
		generator.generateToFile(new File("test.html"),mindMap);
	}
}
