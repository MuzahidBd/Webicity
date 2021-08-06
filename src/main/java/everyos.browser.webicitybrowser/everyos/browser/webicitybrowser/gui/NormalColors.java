package everyos.browser.webicitybrowser.gui;

import everyos.engine.ribbon.core.graphics.Color;

public class NormalColors implements Colors {
	
	private static final Color BACKGROUND_PRIMARY = new Color(0, 119, 131);
	private static final Color BACKGROUND_SECONDARY = new Color(0, 178, 152);
	private static final Color BACKGROUND_SECONDARY_HOVER = Color.LIGHT_GRAY;
	private static final Color BACKGROUND_SECONDARY_SELECTED = Color.DARK_GRAY;
	private static final Color BACKGROUND_SECONDARY_ACTIVE = new Color(0, 151, 129);
	private static final Color BACKGROUND_SECONDARY_DANGER = new Color(178, 0, 0);
	private static final Color FOREGROUND_PRIMARY = Color.WHITE;

	@Override
	public Color getBackgroundPrimary() {
		return BACKGROUND_PRIMARY;
	}

	@Override
	public Color getBackgroundSecondary() {
		return BACKGROUND_SECONDARY;
	}

	@Override
	public Color getBackgroundSecondaryHover() {
		return BACKGROUND_SECONDARY_HOVER;
	}

	@Override
	public Color getBackgroundSecondarySelected() {
		return BACKGROUND_SECONDARY_SELECTED;
	}

	@Override
	public Color getBackgroundSecondaryActive() {
		return BACKGROUND_SECONDARY_ACTIVE;
	}

	@Override
	public Color getBackgroundSecondaryDanger() {
		return BACKGROUND_SECONDARY_DANGER;
	}

	@Override
	public Color getForegroundPrimary() {
		return FOREGROUND_PRIMARY;
	}

}