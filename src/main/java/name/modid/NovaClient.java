package name.modid;

import name.modid.module.Mod;
import name.modid.module.ModuleManager;
import name.modid.ui.clickgui.ClickGUI;
import net.fabricmc.api.ModInitializer;

import net.minecraft.client.MinecraftClient;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NovaClient implements ModInitializer {

	public static final Logger LOGGER = LoggerFactory.getLogger("minecc");
	public static final NovaClient INSTANCE = new NovaClient();

	private MinecraftClient mc = MinecraftClient.getInstance();

	@Override
	public void onInitialize() {
	}

	public void onKeyPress(int key, int action) {
		if (action == GLFW.GLFW_PRESS) {
			for (Mod module : ModuleManager.INSTANCE.getModules()) {
				if (key == module.getKey()) {
					module.toggle();
				}
			}

			if (key == GLFW.GLFW_KEY_RIGHT_SHIFT) {
				mc.setScreen(ClickGUI.INSTANCE);
			}
		}
	}

	public void onTick() {
		if (mc.player != null) {
			for (Mod module : ModuleManager.INSTANCE.getEnabledModules()) {
				module.onTick();
			}
		}
	}
}