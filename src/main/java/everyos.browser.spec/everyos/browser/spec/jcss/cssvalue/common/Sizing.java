package everyos.browser.spec.jcss.cssvalue.common;

public interface Sizing {
	
	public static final int AUTO_SIZING = -1;
	
	//TODO: Static values for special size situations
	//TODO: Pass more parameters
	public int calculateForParent(int parentWidth);
	
}