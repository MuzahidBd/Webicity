package everyos.browser.spec.jcss.intf;

public interface CSSStyleSheet extends StyleSheet {
	
	void setCSSRules(CSSRule[] rules);

	CSSRule[] getCSSRules();
	
}
