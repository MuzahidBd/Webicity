package everyos.browser.spec.jhtml.parser;

import everyos.browser.spec.javadom.intf.Document;
import everyos.browser.spec.javadom.intf.Element;
import everyos.browser.spec.jhtml.imp.JHTMLAnchorElement;
import everyos.browser.spec.jhtml.imp.JHTMLElement;
import everyos.browser.spec.jhtml.imp.JHTMLStyleElement;
import everyos.browser.spec.jhtml.imp.JHTMLTitleElement;

public class ElementFactory {
	private Document document;
	private String namespaceURI;
	private String prefix;
	private String localName;
	private String tagName;
	private String is;

	public void setDocument(Document document) {
		this.document = document;
	}

	public void setNamespaceURI(String namespaceURI) {
		this.namespaceURI = namespaceURI;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public void setIs(String is) {
		this.is = is;
	}
	
	public Document getDocument() {
		return this.document;
	}
	
	public String getTagName() {
		return this.tagName;
	}
	
	public String getLocalName() {
		return this.localName;
	}

	public String getNamespaceURL() {
		return namespaceURI;
	}
	
	public Element createElement(String namespace, String localName) {
		switch(localName) {
			case "title":
				return new JHTMLTitleElement(this);
				
			case "style":
				return new JHTMLStyleElement(this);
				
			case "a":
				return new JHTMLAnchorElement(this);
		
			default:
				return new JHTMLElement(this);
		}
	}
}
