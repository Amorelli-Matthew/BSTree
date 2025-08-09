# BstTree chapter 25

This folder contains Gradle build files to **bundle JavaFX** and produce self-contained builds.

## Quick Steps

1. Move your Java sources into Gradle layout:
```
BstTree chapter 25/
  src/
    main/
      java/
        <your packages and .java>
    resources/
```
> If your current code is under `src\<package>\*.java`, just move that `<package>` folder under `src\main\java\`.

2. From this folder, generate the Gradle wrapper (one-time):
```
gradle wrapper
```
This creates `gradlew` / `gradlew.bat` and the `gradle/` folder.

3. Run from source (JavaFX pulled automatically):
```
./gradlew run
```

4. Create self-contained runtime image (no Java/JavaFX install needed):
```
./gradlew jlink
```
Output: `build/image/BstTree chapter 25/bin/BstTree chapter 25` (launcher).

5. Create installer:
```
./gradlew jpackage
```
Output installers in `build/jpackage/`.

## Notes
- Main class: `bsttree.BstTreeMain` (set in `build.gradle`).
- JavaFX: 24.0.1; JDK toolchain: 21.
- If you have non-code files (e.g., `Text.txt`), place them under `src/main/resources/` and load via the classpath.
