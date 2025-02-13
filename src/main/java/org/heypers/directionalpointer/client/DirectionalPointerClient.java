package org.heypers.directionalpointer.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class DirectionalPointerClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        System.out.println("DirectionalPointerClient инициализирован!");
    }
}
