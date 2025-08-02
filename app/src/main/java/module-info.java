open module com.burtsnyder.boxrift.app {
    requires javafx.controls;
    requires javafx.graphics;
    requires java.desktop;

    exports com.burtsnyder.boxrift.ui.javafx.view;
    exports com.burtsnyder.blockengine.core.engine;
    exports com.burtsnyder.blockengine.core.block;
    exports com.burtsnyder.blockengine.core.rules.interfaces;
    exports com.burtsnyder.blockengine.platform.interfaces;
}