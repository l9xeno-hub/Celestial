package com.celestial.client.module.modules;

import com.celestial.client.module.Category;
import com.celestial.client.module.Module;
import net.minecraft.client.Minecraft;
import org.lwjgl.glfw.GLFW;

public class StepModule extends Module {
	private boolean previousAutoJump;

	public StepModule() {
		super("step", "Step", "Step up blocks using auto-jump.", Category.MOVEMENT, GLFW.GLFW_KEY_M);
	}

	@Override
	protected void onEnable(Minecraft mc) {
		previousAutoJump = mc.options.autoJump().get();
		mc.options.autoJump().set(true);
	}

	@Override
	protected void onDisable(Minecraft mc) {
		mc.options.autoJump().set(previousAutoJump);
	}
}
