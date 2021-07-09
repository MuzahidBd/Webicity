package everyos.browser.webicitybrowser.gui.ui;

import everyos.browser.webicitybrowser.gui.Styling;
import everyos.browser.webicitybrowser.gui.component.OverlyingBlockComponent;
import everyos.browser.webicitybrowser.util.TimeSystem;
import everyos.engine.ribbon.core.component.Component;
import everyos.engine.ribbon.core.event.UIEvent;
import everyos.engine.ribbon.core.rendering.Renderer;
import everyos.engine.ribbon.core.shape.Dimension;
import everyos.engine.ribbon.core.shape.SizePosGroup;
import everyos.engine.ribbon.core.ui.ComponentUI;
import everyos.engine.ribbon.core.ui.UIDirective;
import everyos.engine.ribbon.core.ui.UIManager;
import everyos.engine.ribbon.ui.simple.SimpleBlockComponentUI;
import everyos.engine.ribbon.ui.simple.appearence.Appearence;
import everyos.engine.ribbon.ui.simple.layout.InlineBlockLayout;

public class OverlyingBlockComponentUI extends SimpleBlockComponentUI {

    private Appearence appearence;
    private OverlyingBlockComponent component;
    private InlineBlockLayout layout;

    public OverlyingBlockComponentUI(Component c, ComponentUI parent) {
        super(c, parent);
        component = (OverlyingBlockComponent) c;
        this.appearence = new OverlyingBlockComponentUIAppearence();
        layout = (InlineBlockLayout) getLayout();
        layout.setConsiderChildren(false);
    }

    @Override
    public Appearence getAppearence() {
        return appearence;
    }

    private class OverlyingBlockComponentUIAppearence implements Appearence {

        private Dimension bounds;

        @Override
        public void render(Renderer r, SizePosGroup sizepos, UIManager uimgr) {
//            sizepos.move(strwidth+r.getFontPaddingHeight(), true);
//            sizepos.setMinLineHeight(r.getFontHeight());

            this.bounds = sizepos.getSize();
            layout.renderChildren(r, sizepos, uimgr);

//            contentPaneUI = uimgr.get(component.contentView, OverlyingBlockComponentUI.this);
//            contentPaneUI.render(r, sizepos, uimgr);
//            contentPaneUI.directive(SizeDirective.of(new Location(1, 0, 1, 0)).getDirective());
        }

        private float progress = 0;

        @Override
        public void paint(Renderer r) {
            if (component.isInvisible()) {
                if (progress > 0) progress -= TimeSystem.getDeltaSeconds();
                else return;
            } else {
                if (progress < 1)
                    progress += TimeSystem.getDeltaSeconds();
            }

            r.useBackground();
            int w = bounds.getWidth();
            int h = bounds.getHeight();

            int ha = (int) (h * progress);

            r = r.getSubcontext(0, 0, w, ha);
            r.translate(0, ha - h);

            r.fillRoundRect(0, 0, w, h, Styling.BUTTON_WIDTH * 3);

            r.useForeground();

            layout.paintChildren(r);
//            contentPaneUI.paint(r);
        }

        @Override
        public void directive(UIDirective directive) {

        }

        @Override
        public void processEvent(UIEvent e) {

        }
    }

}
