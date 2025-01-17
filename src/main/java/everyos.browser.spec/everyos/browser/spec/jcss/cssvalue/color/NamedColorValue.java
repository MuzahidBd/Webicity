package everyos.browser.spec.jcss.cssvalue.color;

import java.util.HashMap;
import java.util.Map;

import everyos.browser.spec.jcss.cssvalue.ValueParseInfo;
import everyos.browser.spec.jcss.parser.CSSToken;
import everyos.browser.spec.jcss.parser.IdentToken;

public class NamedColorValue {
	
	private static Map<String, CSSColor> colors = new HashMap<>();
	
	public static ValueParseInfo<CSSColor> parse(int off, CSSToken[] cssTokens) {
		if (!(cssTokens[off] instanceof IdentToken)) {
			return ValueParseInfo.<CSSColor>empty();
		}
		
		String colorName = ((IdentToken) cssTokens[off]).getValue();
		
		CSSColor color = colors.getOrDefault(colorName, null);
		
		if (color == null) {
			return ValueParseInfo.<CSSColor>empty();
		} else {
			return new ValueParseInfo<CSSColor>(color, 1);
		}
	}
	
	
	private static final String[] colorNames = new String[] {
			"aliceblue", "antiquewhite", "aqua", "aquamarine", "azure",
			"beige", "bisque", "black", "blanchedalmond", "blue",
			"blueviolet", "brown", "burlywood", "cadetblue", "chartreuse",
			"chocolate", "coral", "cornflowerblue", "cornsilk", "crimson",
			"cyan", "darkblue", "darkcyan", "darkgoldenrod", "darkgray",
			"darkgreen", "darkgrey", "darkkhaki", "darkmagenta", "darkolivegreen",
			"darkorange", "darkorchid", "darkred", "darksalmon", "darkseagreen",
			"darkslateblue", "darkslategray", "darkslategrey", "darkturquoise", "darkviolet",
			"deeppink", "deepskyblue", "dimgray", "dimgrey", "dodgerblue",
			"firebrick", "floralwhite", "forestgreen", "fuchsia", "gainsboro",
			"ghostwhite", "gold", "goldenrod", "gray", "green",
			"greenyellow", "grey", "honeydew", "hotpink", "indianred",
			"indigo", "ivory", "khaki", "lavender", "lavenderblush",
			"lawngreen", "lemonchiffon", "lightblue", "lightcoral", "lightcyan",
			"lightgoldenrodyellow", "lightgray", "lightgreen", "lightgrey", "lightpink",
			"lightsalmon", "lightseagreen", "lightskyblue", "lightslategray", "lightslategrey",
			"lightsteelblue", "lightyellow", "lime", "limegreen", "linen",
			"magenta", "maroon", "mediumaquamarine", "mediumblue", "mediumorchid",
			"mediumpurple", "mediumseagreen", "mediumslateblue", "mediumspringgreen", "mediumturquoise",
			"mediumvioletred", "midnightblue", "mintcream", "mistyrose", "moccasin",
			"navajowhite", "navy", "oldlace", "olive", "olivedrab",
			"orange", "orangered", "orchid", "palegoldenrod", "palegreen",
			"paleturquoise", "palevioletred", "papayawhip", "peachpuff", "peru",
			"pink", "plum", "powderblue", "purple", "rebeccapurple",
			"red", "rosybrown", "royalblue", "saddlebrown", "salmon",
			"sandybrown", "seagreen", "seashell", "sienna", "silver",
			"skyblue", "slateblue", "slategray", "slategrey", "snow",
			"springgreen", "steelblue", "tan", "teal", "thistle",
			"tomato", "turquoise", "violet", "wheat", "white",
			"whitesmoke", "yellow", "yellowgreen"
	};
	
	private static final CSSColor[] colorValues = new CSSColor[] {
			rgb(240, 248, 255), rgb(250, 235, 215), rgb(0, 255, 255), rgb(127, 255, 212), rgb(240, 255, 255),
			rgb(245, 245, 220), rgb(255, 228, 196), rgb(0, 0, 0), rgb(255, 235, 205), rgb(0, 0, 255),
			rgb(138, 43, 226), rgb(165, 42, 42), rgb(222, 184, 135), rgb(95, 158, 160), rgb(127, 255, 0),
			rgb(210, 105, 30), rgb(255, 127, 80), rgb(100, 149, 237), rgb(255, 248, 220), rgb(220, 20, 60),
			rgb(0, 255, 255), rgb(0, 0, 139), rgb(0, 139, 139), rgb(184, 134, 11), rgb(169, 169, 169),
			rgb(0, 100, 0), rgb(169, 169, 169), rgb(189, 183, 107), rgb(139, 0, 139), rgb(85, 107, 47),
			rgb(255, 140, 0), rgb(153, 50, 204), rgb(139, 0, 0), rgb(233, 150, 122), rgb(143, 188, 143),
			rgb(72, 61, 139), rgb(47, 79, 79), rgb(47, 79, 79), rgb(0, 206, 209), rgb(148, 0, 211),
			rgb(255, 20, 147), rgb(0, 191, 255), rgb(105, 105, 105), rgb(105, 105, 105), rgb(30, 144, 255),
			rgb(178, 34, 34), rgb(255, 250, 240), rgb(34, 139, 34), rgb(255, 0, 255), rgb(220, 220, 220),
			rgb(248, 248, 255), rgb(255, 215, 0), rgb(218, 165, 32), rgb(128, 128, 128), rgb(0, 128, 0),
			rgb(173, 255, 47), rgb(128, 128, 128), rgb(240, 255, 240), rgb(255, 105, 180), rgb(205, 92, 92),
			rgb(75, 0, 130), rgb(255, 255, 240), rgb(240, 230, 140), rgb(230, 230, 250), rgb(255, 240, 245),
			rgb(124, 252, 0), rgb(255, 250, 205), rgb(173, 216, 230), rgb(240, 128, 128), rgb(224, 255, 255),
			rgb(250, 250, 210), rgb(211, 211, 211), rgb(144, 238, 144), rgb(211, 211, 211), rgb(255, 182, 193),
			rgb(255, 160, 122), rgb(32, 178, 170), rgb(135, 206, 250), rgb(119, 136, 153), rgb(119, 136, 153),
			rgb(176, 196, 222), rgb(255, 255, 224), rgb(0, 255, 0), rgb(50, 205, 50), rgb(250, 240, 230),
			rgb(255, 0, 255), rgb(128, 0, 0), rgb(102, 205, 170), rgb(0, 0, 205), rgb(186, 85, 211),
			rgb(147, 112, 219), rgb(60, 179, 113), rgb(123, 104, 238), rgb(0, 250, 154), rgb(72, 209, 204),
			rgb(199, 21, 133), rgb(25, 25, 112), rgb(245, 255, 250), rgb(255, 228, 225), rgb(255, 228, 181),
			rgb(255, 222, 173), rgb(0, 0, 128), rgb(253, 245, 230), rgb(128, 128, 0), rgb(107, 142, 35),
			rgb(255, 165, 0), rgb(255, 69, 0), rgb(218, 112, 214), rgb(238, 232, 170), rgb(152, 251, 152),
			rgb(175, 238, 238), rgb(219, 112, 147), rgb(255, 239, 213), rgb(255, 218, 185), rgb(205, 133, 63),
			rgb(255, 192, 203), rgb(221, 160, 221), rgb(176, 224, 230), rgb(128, 0, 128), rgb(102, 51, 153),
			rgb(255, 0, 0), rgb(188, 143, 143), rgb(65, 105, 225), rgb(139, 69, 19), rgb(250, 128, 114),
			rgb(244, 164, 96), rgb(46, 139, 87), rgb(255, 245, 238), rgb(160, 82, 45), rgb(192, 192, 192),
			rgb(135, 206, 235), rgb(106, 90, 205), rgb(112, 128, 144), rgb(112, 128, 144), rgb(255, 250, 250),
			rgb(0, 255, 127), rgb(70, 130, 180), rgb(210, 180, 140), rgb(0, 128, 128), rgb(216, 191, 216),
			rgb(255, 99, 71), rgb(64, 224, 208), rgb(238, 130, 238), rgb(245, 222, 179), rgb(255, 255, 255),
			rgb(245, 245, 245), rgb(255, 255, 0), rgb(154, 205, 50)
	};
	
	private static CSSColor rgb(int r, int g, int b) {
		return CSSColor.ofRGB8(r, g, b);
	}
	
	static {
		for (int i = 0; i < colorNames.length; i++) {
			colors.put(colorNames[i], colorValues[i]);
		}
	}
}
