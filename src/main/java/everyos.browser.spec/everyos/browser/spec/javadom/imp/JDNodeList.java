package everyos.browser.spec.javadom.imp;

import java.util.Iterator;
import java.util.List;

import everyos.browser.spec.javadom.intf.Node;
import everyos.browser.spec.javadom.intf.NodeList;

public class JDNodeList implements NodeList {
	private List<Node> children;

	public JDNodeList(List<Node> children) {
		this.children = children;
	}

	@Override
	public long getLength() {
		if (children==null) return 0;
		return children.size();
	}

	@Override
	public Node item(long index) {
		if (children==null) return null;
		return children.get((int) index);
	}

	@Override
	public Iterator<Node> iterator() {
		return children.iterator();
	}
}
