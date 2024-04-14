package name.modid.ui.screens.clickgui;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

import java.util.ArrayList;
import java.util.List;

import name.modid.module.Mod.Category;

public class ClickGUI extends Screen {

    public static final ClickGUI INSTANCE = new ClickGUI();

    private List<Frame> frames;

    private ClickGUI() {
        super(Text.literal("Click GUI"));

        frames = new ArrayList<>();
        int offset = 20;
        for (Category category : Category.values()) {
            frames.add(new Frame(category, offset, 25, 100, 30));
            offset += 120;
        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        for (Frame frame : frames) {
            frame.render(context, mouseX, mouseY, delta);
        }
        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        for (Frame frame : frames) {
            frame.mouseClicked(mouseX, mouseY, button);
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }
}
