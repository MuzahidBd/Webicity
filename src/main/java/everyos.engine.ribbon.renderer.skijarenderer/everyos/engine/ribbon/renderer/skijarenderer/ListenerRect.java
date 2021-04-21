package everyos.engine.ribbon.renderer.skijarenderer;

import everyos.engine.ribbon.renderer.guirenderer.event.MouseListener;
import everyos.engine.ribbon.renderer.guirenderer.event.UIEventTarget;
import everyos.engine.ribbon.renderer.guirenderer.shape.Rectangle;

public class ListenerRect {
	private Rectangle bounds;
	private MouseListener listener;
	private UIEventTarget target;

	public ListenerRect(Rectangle bounds, UIEventTarget target, MouseListener listener) {
		this.bounds = bounds;
		this.listener = listener;
		this.target = target;
	}
	
	public Rectangle getBounds() { return bounds; }
	public MouseListener getListener() { return listener; }
	public UIEventTarget getEventTarget() { return target; };
}
