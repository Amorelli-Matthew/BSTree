@echo off
setlocal

echo ============================================
echo Compiling...
cd /d "%~dp0"

:: Ensure output directory exists
if not exist "out" mkdir out

:: Compile all Java files
javac -d out src\BstTree\*.java
if errorlevel 1 (
    echo Compilation failed.
    pause
    exit /b 1
)

echo Compilation successful.
pause
endlocal
