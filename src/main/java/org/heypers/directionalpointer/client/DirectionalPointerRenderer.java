package org.heypers.directionalpointer.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.*;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Vec3d;
import com.mojang.blaze3d.systems.RenderSystem;
import org.joml.Matrix3f;
import org.joml.Vector3f;

public class DirectionalPointerRenderer {
    public static void render3DCursor(MatrixStack matrices, VertexConsumerProvider vertexConsumers, float tickDelta) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player == null || client.world == null) return;

        // Получаем положение игрока
        Vec3d cameraPos = client.player.getLerpedPos(tickDelta);
        float yaw = client.player.getYaw(tickDelta);
        float pitch = client.player.getPitch(tickDelta);

        matrices.push();
        matrices.translate(cameraPos.x, cameraPos.y + client.player.getEyeHeight(client.player.getPose()), cameraPos.z);
        matrices.multiply(net.minecraft.util.math.RotationAxis.POSITIVE_Y.rotationDegrees(-yaw));
        matrices.multiply(net.minecraft.util.math.RotationAxis.POSITIVE_X.rotationDegrees(-pitch));

        // Убираем Z-тест, чтобы стрелки были видны всегда
        RenderSystem.disableDepthTest();

        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(RenderLayer.getLines());
        drawPointer(vertexConsumer, matrices);

        // Включаем Z-тест обратно
        RenderSystem.enableDepthTest();

        matrices.pop();
    }

    private static void drawPointer(VertexConsumer vertexConsumer, MatrixStack matrices) {
        drawLine(vertexConsumer, matrices, new Vec3d(1, 0, 0), 1.0f, 0.0f, 0.0f); // Красный (ось X)
        drawLine(vertexConsumer, matrices, new Vec3d(0, 1, 0), 0.0f, 1.0f, 0.0f); // Зеленый (ось Y)
        drawLine(vertexConsumer, matrices, new Vec3d(0, 0, 1), 0.0f, 0.0f, 1.0f); // Синий (ось Z)
    }

    private static void drawLine(VertexConsumer vertexConsumer, MatrixStack matrices, Vec3d direction, float r, float g, float b) {
        MatrixStack.Entry entry = matrices.peek();
        Matrix3f normalMatrix = entry.getNormalMatrix();
        Vector3f normal = new Vector3f(0, 0, 1);
        normal.mul(normalMatrix);

        vertexConsumer.vertex(entry.getPositionMatrix(), 0, 0, 0)
                .color(r, g, b, 1.0f)
                .normal(normal.x(), normal.y(), normal.z());

        vertexConsumer.vertex(entry.getPositionMatrix(), (float) direction.x, (float) direction.y, (float) direction.z)
                .color(r, g, b, 1.0f)
                .normal(normal.x(), normal.y(), normal.z());
    }
}
