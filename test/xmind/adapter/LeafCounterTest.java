package xmind.adapter;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import xmind.algorithm.LeafCounter;

public class LeafCounterTest {
	
	@Test
	public void testLeafCounter() {
		LeafCounter counter = new LeafCounter(Arrays.asList(new LeafCounter(), new LeafCounter(), new LeafCounter()));
		Assert.assertEquals(counter.computeLeaves(),3);
	}
	
	@Test
	public void testLeafCounter2() {
		LeafCounter leafCounter = new LeafCounter(Arrays.asList(new LeafCounter(), new LeafCounter(), new LeafCounter()));
		LeafCounter leafCounter2 = new LeafCounter(Arrays.asList(new LeafCounter(), new LeafCounter()));
		LeafCounter counter = new LeafCounter(Arrays.asList(leafCounter, new LeafCounter(), leafCounter2));
		Assert.assertEquals(counter.computeLeaves(),6);
	}

}
