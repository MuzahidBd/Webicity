package everyos.browser.webicitybrowser.gui.component;

import everyos.browser.webicity.net.URL;
import everyos.browser.webicitybrowser.gui.Styling;
import everyos.browser.webicitybrowser.gui.animation.SlideInAnimation;
import everyos.browser.webicitybrowser.gui.behavior.ActionButtonBehavior;
import everyos.browser.webicitybrowser.gui.colors.Colors;
import everyos.browser.webicitybrowser.gui.directive.AnimationDirective;
import everyos.browser.webicitybrowser.ui.Window;
import everyos.engine.ribbon.components.component.BlockComponent;
import everyos.engine.ribbon.components.component.BreakComponent;
import everyos.engine.ribbon.components.component.LabelComponent;
import everyos.engine.ribbon.components.directive.BackgroundDirective;
import everyos.engine.ribbon.components.directive.PositionDirective;
import everyos.engine.ribbon.components.directive.SizeDirective;
import everyos.engine.ribbon.core.graphics.Component;
import everyos.engine.ribbon.core.shape.Location;

public class WebicityButton extends BlockComponent {

	private final AnimatedComponent dropMenu;

	public WebicityButton(Component parent, Window window, Colors colors) {
		super();
		
		dropMenu = new AnimatedComponent();
		dropMenu.directive(AnimationDirective.of(new SlideInAnimation()));
		dropMenu.directive(PositionDirective.of(new Location(0, 0, 0, Styling.ELEMENT_PADDING + Styling.BUTTON_WIDTH)));
		parent.addChild(dropMenu);
		
		String[] menuOptions = {
			"Open New Window",
			"Open New Private Window",
			"Settings",
			"History",
			"Bookmarks"
		};
		
		Runnable[] menuActions = {
			() -> {
				window.getApplicationInstance().createWindow(false);
			},
			() -> {
				window.getApplicationInstance().createWindow(true)
					.openNewTab();
			},
			() -> {
				window.getApplicationInstance().open(URL.ofSafe("webicity://settings"));
			},
			() -> {
				window.getApplicationInstance().open(URL.ofSafe("webicity://history"));
			},
			() -> {
				window.getApplicationInstance().open(URL.ofSafe("webicity://bookmarks"));
			}
		};
		
		BlockComponent content = new BlockComponent();
		content.directive(BackgroundDirective.of(colors.getBackgroundSecondaryActive()));
		content.addChild(new BlockComponent()
				.directive(SizeDirective.of(new Location(-1, -1, 0, 5))));
		content.addChild(new BreakComponent());
		
		for (int i = 0; i < menuOptions.length; i++) {
			BlockComponent menuItem = new BlockComponent();
			menuItem.addChild(new BlockComponent()
				.directive(SizeDirective.of(new Location(0, 10, -1, -1))));
			menuItem.addChild(new LabelComponent().text(menuOptions[i]));
			menuItem.addChild(new BlockComponent()
					.directive(SizeDirective.of(new Location(0, 10, -1, -1))));
			menuItem.directive(SizeDirective.of(new Location(1, 0, -1, 0)));
			content.addChild(menuItem);
			
			addButtonBehavior(menuItem, menuActions[i], colors);
			
			content.addChild(new BreakComponent());
		}
		
		content.addChild(new BlockComponent()
				.directive(SizeDirective.of(new Location(0, 150, 0, 5)))); // TODO: Auto-size
		
		dropMenu.addChild(content);
	}
	
	private void addButtonBehavior(Component button, Runnable handler, Colors colors) {
		ActionButtonBehavior.configure(button, handler, colors.getBackgroundSecondaryActive(),
			colors.getBackgroundSecondary(), colors.getBackgroundSecondarySelected(), colors.getBackgroundSecondaryHover(),
			()->false);
	}

	public void toggleMenu() {
		dropMenu.setVisible(!dropMenu.isVisible());
	}

}