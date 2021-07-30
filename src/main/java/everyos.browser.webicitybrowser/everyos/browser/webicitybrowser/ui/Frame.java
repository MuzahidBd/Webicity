package everyos.browser.webicitybrowser.ui;

import java.net.MalformedURLException;
import java.util.Stack;

import everyos.browser.webicity.WebicityFrame;
import everyos.browser.webicity.event.FrameCallback;
import everyos.browser.webicity.event.NavigateEvent;
import everyos.browser.webicity.net.URL;
import everyos.browser.webicity.renderer.Renderer;
import everyos.browser.webicitybrowser.WebicityInstance;
import everyos.browser.webicitybrowser.event.EventDispatcher;
import everyos.browser.webicitybrowser.ui.event.FrameMutationEventListener;

public class Frame {
	private EventDispatcher<FrameMutationEventListener> mutationEventDispatcher = new EventDispatcher<>();
	private WebicityFrame frame;
	private WebicityInstance instance;
	private Stack<URL> history = new Stack<>();
	private Stack<URL> forwardHistory = new Stack<>();

	public Frame(WebicityInstance instance) {
		this.instance = instance;
	}
	
	public String getName() {
		String name = frame.getTitle();
		if (name!=null) return name;
		
		String host = getURL().getHost();
		return host.isEmpty()?"New tab":host;
	}

	public URL getURL() {
		if (frame==null) {
			try {
				return new URL("about:blank");
			} catch (MalformedURLException e) {
				throw new RuntimeException(e);
			}
		}
		return frame.getURL();
	}
	
	public void setURL(URL url) {
		setURL(url, true);
	}
	private void setURL(URL url, boolean clearFutureHistory) {
		//TODO: Use a "thread context" instead
		if (clearFutureHistory) {
			forwardHistory.clear();
		}
		history.push(url);
		this.frame = createFrame(url);
		mutationEventDispatcher.fire(l->l.onNavigate(()->url));
	}
	
	public void reload() {
		if (frame==null) return;
		URL url = frame.getURL();
		this.frame = createFrame(url);
		mutationEventDispatcher.fire(l->l.onNavigate(()->url));
	}
	
	public void back() {
		if (history.size()<2) return;
		forwardHistory.push(history.pop());
		setURL(history.pop(), false);
	}
	
	public void forward() {
		if (forwardHistory.isEmpty()) return;
		setURL(forwardHistory.pop(), false);
	}
	
	public Renderer getCurrentRenderer() {
		if (this.frame == null) return null;
		return frame.getRenderer();
	}

	public void addFrameMutationListener(FrameMutationEventListener mutationListener) {
		mutationEventDispatcher.addListener(mutationListener);
	}
	
	public void removeFrameMutationListener(FrameMutationEventListener mutationListener) {
		mutationEventDispatcher.removeListener(mutationListener);
	}
	
	private WebicityFrame createFrame(URL url) {
		if (frame != null) {
			frame.quit();
		}
		WebicityFrame frame = new WebicityFrame(instance.getEngine(), new FrameCallbackImp(), url, instance.getEngine().createThreadQueue());
		
		return frame;
	}
	
	private class FrameCallbackImp implements FrameCallback {
		@Override
		public void onNavigate(NavigateEvent navigateEvent) {
			setURL(navigateEvent.getURL());
			mutationEventDispatcher.fire(l->l.onNavigate(navigateEvent));
		}

		@Override
		public void onRendererCreated(Renderer r) {
			mutationEventDispatcher.fire(l->l.onRendererCreated(r));
		}
	}

	public void close() {
		frame.quit();
	}
}
