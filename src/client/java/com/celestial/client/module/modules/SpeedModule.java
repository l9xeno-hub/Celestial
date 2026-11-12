package com.celestial.client.module.modules;

import com.celestial.client.module.Category;
import com.celestial.client.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.world.phys.Vec3;
import org.lwjgl.glfw.GLFW;

public class SpeedModule extends Module {
	/** Horizontal motion multiplier while moving on the ground. */
	private static final double MULTIPLIER = 1.25;

	public SpeedModule() {
		super("speed", "Speed", "Move faster on the ground.", Category.MOVEMENT, GLFW.GLFW_KEY_V);
	}

	@Override
	public void onTick(Minecraft mc) {
		if (mc.player == null) {
			return;
		}
		boolean moving = mc.options.keyUp.isDown() || mc.options.keyLeft.isDown() || mc.options.keyRight.isDown();
		if (!moving || !mc.player.onGround() || mc.player.isInWater()) {
			return;
		}
		Vec3 motion = mc.player.getDeltaMovement();
		mc.player.setDeltaMovement(motion.x * MULTIPLIER, motion.y, motion.z * MULTIPLIER);
	}
}
