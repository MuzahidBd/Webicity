package everyos.browser.webicitybrowser.gui.component;

import everyos.engine.ribbon.core.component.BlockComponent;
import everyos.engine.ribbon.core.component.Component;
import everyos.engine.ribbon.core.directive.FontSizeDirective;
import everyos.engine.ribbon.core.graphics.InvalidationLevel;

public class CircularText extends BlockComponent {
	private String text;

	public CircularText() {
		super();
		
		this
			.directive(FontSizeDirective.of(14));
	}

	public Component text(String text) {
		this.text = text;
		invalidate(InvalidationLevel.RENDER);
		return this;
	}
	
	public String getText() {
		return this.text;
	}
}
