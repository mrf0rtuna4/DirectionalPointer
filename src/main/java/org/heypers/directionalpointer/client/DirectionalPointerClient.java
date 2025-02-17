package org.heypers.directionalpointer.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class DirectionalPointerClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        System.out.println("DirectionalPointerClient инициализирован!");

        WorldRenderEvents.LAST.register((context) -> {
            MinecraftClient client = MinecraftClient.getInstance();
            if (client.player == null) return;

            MatrixStack matrices = context.matrixStack();
            VertexConsumerProvider vertexConsumers = context.consumers();

            float tickDelta = context.tickCounter().getTickDelta(true);
            DirectionalPointerRenderer.render3DCursor(matrices, vertexConsumers, tickDelta);
        });

        HudRenderCallback.EVENT.register((context, tickDeltaManager) -> {
            MinecraftClient client = MinecraftClient.getInstance();
            if (client == null || client.options == null || client.player == null) {
                return;
            }

            int windowWidth = client.getWindow().getScaledWidth();
            int windowHeight = client.getWindow().getScaledHeight();

            int centerX = windowWidth / 2;
            int centerY = windowHeight / 2;

            int cursorSize = 10;
            int cursorColor = 0xFFFFFF00;

            context.fill(centerX - cursorSize / 2, centerY, centerX + cursorSize / 2, centerY + 1, cursorColor);

            context.fill(centerX, centerY - cursorSize / 2, centerX + 1, centerY + cursorSize / 2, cursorColor);
        });
    }
}
