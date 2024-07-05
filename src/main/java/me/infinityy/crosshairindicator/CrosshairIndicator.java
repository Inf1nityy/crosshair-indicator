package me.infinityy.crosshairindicator;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CrosshairIndicator implements ClientModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("crosshair-indicator");

    @Override
    public void onInitializeClient() {
        LOGGER.info("Initialized crosshair indicator.");
    }
}
