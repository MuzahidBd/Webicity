package everyos.browser.webicity.webribbon.core.ui;

import everyos.browser.spec.jcss.cssom.CSSOMNode;
import everyos.browser.webicity.webribbon.core.component.WebComponent;
import everyos.browser.webicity.webribbon.gui.UIBox;
import everyos.browser.webicity.webribbon.gui.WebPaintContext;
import everyos.browser.webicity.webribbon.gui.WebRenderContext;
import everyos.engine.ribbon.core.event.UIEvent;
import everyos.engine.ribbon.core.graphics.InvalidationLevel;
import everyos.engine.ribbon.core.rendering.RendererData;
import everyos.engine.ribbon.core.shape.Rectangle;
import everyos.engine.ribbon.core.shape.SizePosGroup;

public interface WebComponentUI {
	void recalculatePaintCSSOM(CSSOMNode cssomNode);
	
	//TODO: Also pass a stack
	void render(RendererData rd, SizePosGroup sizepos, WebRenderContext context);
	void paint(RendererData rd, Rectangle viewport, WebPaintContext context);
	//void composite(RendererData rd);
	
	WebComponentUI getParent();
	
	void invalidate(InvalidationLevel level);
	void invalidateLocal(InvalidationLevel level);
	void validateTo(InvalidationLevel level);
	boolean getValidated(InvalidationLevel level);
	
	UIBox getUIBox();

	void processEvent(UIEvent ev);
	WebComponent getComponent();
}
