package xmind.adapter;

import freemarker.template.TemplateException;
import impress.beans.MapNode;
import impress.beans.MindMap;
import impress.cases.SimpleCase;
import impress.generator.MindMapGenerator;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.xmind.core.CoreException;

import xmind.algorithm.SimpleAlgorithm;
import xmind.beans.Workbook;


public class AlgorithmTest {

	@Test
	public void testAlgorithm() throws Exception {
		File file = new File("resources/test_file.xmind");
		Workbook workbook = new Workbook(WorkbookLoader.loadWorkbook(file));
		SimpleAlgorithm simpleAlgorithm = new SimpleAlgorithm(workbook);
		MindMap mindMap = simpleAlgorithm.generate();
		for (MapNode node : mindMap.getNodesInOrder()) {
			System.out.println(node.toString());
		}
		
		
	}
	
	File templateFolder  = new File("resources");
	
	@Test
	public void testSth() throws IOException, TemplateException, CoreException {
		File file = new File("resources/test_file.xmind");
		Workbook workbook = new Workbook(WorkbookLoader.loadWorkbook(file));
		SimpleAlgorithm simpleAlgorithm = new SimpleAlgorithm(workbook);
		MindMap mindMap = simpleAlgorithm.generate();
		
		MindMapGenerator generator = new MindMapGenerator("impress.ftl", templateFolder);		
		
		generator.generateToFile(new File("test.html"),mindMap);
	}
}
