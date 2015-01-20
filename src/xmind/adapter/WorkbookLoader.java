package xmind.adapter;

import java.io.File;
import java.io.IOException;

import org.xmind.core.Core;
import org.xmind.core.CoreException;
import org.xmind.core.IWorkbook;
import org.xmind.core.IWorkbookBuilder;
import org.xmind.core.io.ByteArrayStorage;


public class WorkbookLoader {

	public static IWorkbook loadWorkbook(File file) throws IOException, CoreException {
		IWorkbookBuilder builder = Core.getWorkbookBuilder();
		IWorkbook c = builder.loadFromFile(file, new ByteArrayStorage(),null);
		return c;
	}
	
}
