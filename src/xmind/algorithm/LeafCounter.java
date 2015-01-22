package xmind.algorithm;

import java.util.ArrayList;
import java.util.List;

public class LeafCounter<T extends Countable> implements Countable {

	private List<T> children = new ArrayList<T>();

	public LeafCounter(List<T> children) {
		if (children != null)
			this.children.addAll(children);
	}
	
	public LeafCounter() {
		this(null);
	}
	
	public int computeLeaves() {
		if (children.size() == 0) {
			return 1;
		} else {
			int sum = 0;
			for (T subtopic : children) {
				sum += subtopic.computeLeaves();
			}
			return sum;
		}
	}
	
}
