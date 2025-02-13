package org.heypers.directionalpointer;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class DirectionalPointer implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        System.out.println("DirectionalPointer мод загружен!");
    }
}
