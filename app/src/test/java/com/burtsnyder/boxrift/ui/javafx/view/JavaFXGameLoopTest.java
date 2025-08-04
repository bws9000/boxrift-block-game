package com.burtsnyder.boxrift.ui.javafx.view;

import com.burtsnyder.boxrift.Game;
import com.burtsnyder.boxrift.config.BlockConfig;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

public class JavaFXGameLoopTest {
    /**
     * Verifies that the JavaFX application window launches with the correct width and height.
     * <p>This test launches the JavaFX application in a background thread since
     * {@link javafx.application.Application#launch(String...)} is a blocking call and must be
     * invoked from a non-JavaFX thread during testing.
     * @throws Exception if the latch is interrupted or the window fails to initialize in time
     * @see javafx.application.Platform#runLater(Runnable)
     * @see java.util.concurrent.CountDownLatch
     */
    @Test
    public void testWindowLaunchesWithCorrectSize() throws Exception {
        Thread fxThread = new Thread(() -> Game.main(new String[0]));
        fxThread.setDaemon(true);
        fxThread.start();

        for (int i = 0; i < 20; i++) {
            if (JavaFXGameLoop.JavaFXApp.primaryStageRef != null) break;
            Thread.sleep(200);
        }

        Stage stage = JavaFXGameLoop.JavaFXApp.primaryStageRef;
        assertNotNull(stage, "Stage should have been initialized");

        CountDownLatch latch = new CountDownLatch(1);
        final double[] width = new double[1];
        final double[] height = new double[1];

        Platform.runLater(() -> {
            width[0] = stage.getScene().getWidth();
            height[0] = stage.getScene().getHeight();
            latch.countDown();
        });

        assertTrue(latch.await(2, TimeUnit.SECONDS), "JavaFX thread timed out..");

        int expectedWidth = BlockConfig.GRID_COLUMNS * BlockConfig.BLOCK_SIZE;
        int expectedHeight = BlockConfig.GRID_ROWS * BlockConfig.BLOCK_SIZE;

        assertEquals(expectedWidth, width[0], "width should match BlockConfig");
        assertEquals(expectedHeight, height[0], "height should match BlockConfig");

        Platform.runLater(stage::close);
    }
}

