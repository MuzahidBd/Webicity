package everyos.browser.webicitybrowser.gui.renderer;

import everyos.browser.webicity.renderer.html.HTMLRenderer;
import everyos.browser.webicity.webribbon.core.component.WebDocumentComponent;
import everyos.browser.webicity.webribbon.core.ui.Pallete;
import everyos.browser.webicity.webribbon.gui.WebComponentWrapper;
import everyos.browser.webicitybrowser.gui.colors.Colors;
import everyos.engine.ribbon.core.component.BlockComponent;
import everyos.engine.ribbon.core.component.Component;
import everyos.engine.ribbon.core.directive.SizeDirective;
import everyos.engine.ribbon.core.graphics.Color;
import everyos.engine.ribbon.core.shape.Location;

public class HTMLRendererGUI {
	private final HTMLRenderer renderer;
	private final Colors colors;
	private final Component displayPane;

	public HTMLRendererGUI(HTMLRenderer renderer, Colors colors) {
		this.renderer = renderer;
		this.colors = colors;
		
		this.displayPane = new BlockComponent();
	}
	
	public void start() {
		renderer.addReadyHook(()->{
			WebComponentWrapper innerPane = new WebComponentWrapper();
			innerPane.directive(SizeDirective.of(new Location(1, 0, 1, 0)));
			innerPane.ui(new WebDocumentComponent(renderer, renderer.getDocument()));
			
			innerPane.pallete(new Pallete() {
				@Override
				public Color getAccent() {
					return colors.getBackgroundSecondary();
				}

				@Override
				public Color getAccentHover() {
					return colors.getBackgroundSecondaryHover();
				}

				@Override
				public Color getAccentSelect() {
					return colors.getBackgroundSecondarySelected();
				}
			});
			
			displayPane.children(new Component[] { innerPane });
		});
	}
	
	public void cleanup() {
		
	}

	public Component getDisplayPane() {
		return displayPane;
	}
}
