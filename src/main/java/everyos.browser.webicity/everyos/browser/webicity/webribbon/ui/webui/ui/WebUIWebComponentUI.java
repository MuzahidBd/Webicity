package everyos.browser.webicity.webribbon.ui.webui.ui;

import everyos.browser.spec.jcss.cssom.ApplicablePropertyMap;
import everyos.browser.spec.jcss.cssom.CSSOMNode;
import everyos.browser.spec.jcss.cssom.CSSOMUtil;
import everyos.browser.spec.jcss.cssom.property.PropertyName;
import everyos.browser.spec.jcss.cssom.property.display.DisplayProperty;
import everyos.browser.spec.jcss.cssvalue.display.OuterDisplayType;
import everyos.browser.webicity.webribbon.core.component.WebComponent;
import everyos.browser.webicity.webribbon.core.ui.WebComponentUI;
import everyos.browser.webicity.webribbon.core.ui.WebUIManager;
import everyos.browser.webicity.webribbon.gui.Content;
import everyos.browser.webicity.webribbon.gui.WebBoxContext;
import everyos.browser.webicity.webribbon.gui.box.MutableBox;
import everyos.browser.webicity.webribbon.ui.webui.display.inner.flow.FlowDisplayMode;
import everyos.browser.webicity.webribbon.ui.webui.display.outer.DisplayMode;
import everyos.browser.webicity.webribbon.ui.webui.psuedo.ScrollBarContent;
import everyos.browser.webicity.webribbon.ui.webui.rendering.box.BlockLevelBoxImp;
import everyos.browser.webicity.webribbon.ui.webui.rendering.box.InlineLevelBoxImp;

public class WebUIWebComponentUI extends WebUIWebComponentUIBase {
	
	private OuterDisplayType outerDisplayType;
	private DisplayMode innerDisplay;

	public WebUIWebComponentUI(WebComponent component, WebComponentUI parent) {
		super(component, parent);
	}

	@Override
	public void recalculateCSSOM(CSSOMNode cssomNode, WebUIManager manager) {
		CSSOMNode[] matchingNodes = CSSOMUtil.getMatchingNodes(getComponent().getNode(), cssomNode);
		ApplicablePropertyMap properties = CSSOMUtil.calculateProperties(matchingNodes);
		
		calculateDisplayProperties(properties, cssomNode, manager);
	}

	@Override
	public void box(MutableBox parent, WebBoxContext context) {
		MutableBox box = createOuterDisplay(parent);
		innerDisplay.box(box, context);
		box.finish();
	}
	
	//TODO: Should this be innerDisplayOverride?
	protected Content getContentOverride() {
		return innerDisplay.getContent();
	}
	
	private void calculateDisplayProperties(ApplicablePropertyMap properties, CSSOMNode cssomNode, WebUIManager manager) {
		this.outerDisplayType = ((DisplayProperty) properties.getPropertyByName(PropertyName.DISPLAY)).getOuterDisplayType();
		
		this.innerDisplay = new FlowDisplayMode(getComponent(), getParent());	
		innerDisplay.recalculateCSSOM(cssomNode, manager);
	}
	
	private MutableBox createOuterDisplay(MutableBox parent) {
		switch (outerDisplayType) {
			case INLINE:
				return createInlineOuterDisplay(parent);
		
			case BLOCK:
			default:
				return createBlockOuterDisplay(parent);
		}
		
	}
	
	private MutableBox createBlockOuterDisplay(MutableBox parent) {
		return new BlockLevelBoxImp(parent, new ScrollBarContent(this, getContentOverride()));
	}
	
	private MutableBox createInlineOuterDisplay(MutableBox parent) {
		return new InlineLevelBoxImp(parent, getContentOverride());
	}
	
}
