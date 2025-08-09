@echo off
echo ============================================
echo Compiling JavaFX project...
cd src
javac --module-path "..\..\..\..\..\Documents\javafx-sdk-24.0.1\lib" --add-modules javafx.controls,javafx.fxml -d ..\out AnimationPendulumSwing\*.java

if errorlevel 1 (
    echo ❌ Compilation failed.
    pause
    exit /b 1
)

echo ============================================
echo Running AnimationPendulumSwing.AnimationPendulumSwing...
cd ..\out
java --module-path "..\..\..\..\..\Documents\javafx-sdk-24.0.1\lib" --add-modules javafx.controls,javafx.fxml -cp . AnimationPendulumSwing.AnimationPendulumSwing

echo.
echo ✅ Done.
pause
