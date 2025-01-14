package com.epicness.alejandria.module.logic;

import static com.epicness.alejandria.ModuleID.ADVANCED_SPLIT_SCREEN;

import com.epicness.alejandria.ModuleID;
import com.epicness.alejandria.module.modules.masking.AlphaMasking;
import com.epicness.alejandria.module.modules.masking.LayeredMasking;
import com.epicness.alejandria.module.modules.masking.ShapeRendererMasking;
import com.epicness.alejandria.module.modules.pixmaps.PixelPerfectCollisionDetection;
import com.epicness.alejandria.module.modules.rendering.ProceduralSquare;
import com.epicness.alejandria.module.modules.shaders.InvertShader;
import com.epicness.alejandria.module.modules.shaders.ShakeShader;
import com.epicness.alejandria.module.modules.shaders.VignetteShader;
import com.epicness.alejandria.module.modules.viewports.AdvancedSplitScreen;
import com.epicness.alejandria.module.stuff.ModuleStorage;
import com.epicness.alejandria.module.stuff.ModuleStuff;

public class ModuleHandler {

    // Structure
    private ModuleStuff stuff;

    public void setup() {
        ModuleStorage moduleStorage = stuff.getModuleStorage();

        moduleStorage.addModule(new LayeredMasking());
        moduleStorage.addModule(new AlphaMasking());
        moduleStorage.addModule(new ShapeRendererMasking());
        moduleStorage.addModule(new ProceduralSquare());
        moduleStorage.addModule(new InvertShader());
        moduleStorage.addModule(new ShakeShader());
        moduleStorage.addModule(new VignetteShader());
        moduleStorage.addModule(new PixelPerfectCollisionDetection());
        moduleStorage.addModule(new AdvancedSplitScreen());

        changeModule(ADVANCED_SPLIT_SCREEN);
    }

    public void update(float delta) {
        stuff.getModuleStorage().getCurrentModule().update(delta);
    }

    public void changeModule(ModuleID moduleID) {
        ModuleStorage moduleStorage = stuff.getModuleStorage();

        if (moduleStorage.getCurrentModule() != null) {
            moduleStorage.getCurrentModule().dispose();
        }
        moduleStorage.setCurrentModule(moduleID);
        moduleStorage.getCurrentModule().setup();
    }

    // Structure
    public void setStuff(ModuleStuff stuff) {
        this.stuff = stuff;
    }
}