@echo off
echo ============================================
echo Compiling BST project...

cd "src"

REM Create output folder if it doesn't exist
if not exist "..\out" (
    mkdir "..\out"
)

REM Compile all Java files in the bsttree package
javac -d ..\out bsttree\*.java
if errorlevel 1 (
    echo  Compilation failed.
    pause
    exit /b 1
)

echo ============================================
echo Running bsttree.BstTreeMain...
cd ..\out
java bsttree.BstTreeMain

pause
