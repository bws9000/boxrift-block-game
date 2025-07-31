package com.burtsnyder.boxrift.ui.javafx.view;

import com.burtsnyder.boxrift.platform.Configure;
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
        //because application launch blocks current thread
        Thread fxThread = new Thread(() -> Configure.launch(new String[0]));
        fxThread.setDaemon(true);
        fxThread.start();

        //poll for 4 seconds
        for (int i = 0; i < 20; i++) {
            if (JavaFXGameLoop.JavaFXApp.primaryStageRef != null) break;
            Thread.sleep(200);
        }

        //has primaryStageRef been assigned?
        Stage stage = JavaFXGameLoop.JavaFXApp.primaryStageRef;
        assertNotNull(stage, "Stage should have been initialized");

        //https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/concurrent/CountDownLatch.html
        CountDownLatch latch = new CountDownLatch(1);
        final double[] width = new double[1];
        final double[] height = new double[1];

        //https://openjfx.io/javadoc/21/javafx.graphics/javafx/application/Platform.html#runLater(java.lang.Runnable)
        Platform.runLater(() -> {
            width[0] = stage.getScene().getWidth();
            height[0] = stage.getScene().getHeight();
            latch.countDown();
        });

        assertTrue(latch.await(2, TimeUnit.SECONDS), "fx thread timed out");
        assertEquals(400, width[0], "width should be 400");
        assertEquals(800, height[0], "height should be 800");

        //cleanup
        Platform.runLater(stage::close);
    }
}

