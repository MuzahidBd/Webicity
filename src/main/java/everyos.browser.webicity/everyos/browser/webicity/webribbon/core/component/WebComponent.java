package everyos.browser.webicity.webribbon.core.component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import everyos.browser.javadom.intf.Node;
import everyos.browser.javadom.intf.NodeList;
import everyos.browser.jcss.cssom.Attribute;
import everyos.browser.webicity.renderer.html.HTMLRenderer;
import everyos.engine.ribbon.core.event.UIEventTarget;

public class WebComponent implements UIEventTarget { //TODO: Code will be moved to WebUI
	@SuppressWarnings("unused")
	private Map<Attribute, Object> attributes;
	private Node node;
	private List<WebComponent> children;
	private HTMLRenderer renderer;
	private WebComponent[] childrenArray;
	
	public WebComponent(HTMLRenderer renderer, Node node) {
		this.renderer = renderer;
		this.node = node;
	}
	
	public WebComponent[] getChildren() {
		if (this.children == null) {
			NodeList nchildren = node.getChildNodes();
			int len = (int) nchildren.getLength();
			this.children = new ArrayList<>(len);
			for (int i=0; i<len; i++) {
				WebComponent c = WebComponentFactory.createComponentFromNode(nchildren.item(i), renderer);
				if (c!=null) children.add(c);
			}
		}
		if (this.childrenArray == null) {
			this.childrenArray = this.children.toArray(new WebComponent[this.children.size()]);
		}
		return this.childrenArray;
	}

	public Node getNode() {
		return node;
	}

	public HTMLRenderer getRenderer() {
		return renderer;
	}
}
