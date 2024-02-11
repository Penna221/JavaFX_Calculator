# JavaFX Calculator

This project is part of my coding challenges video series.

This repo only contains a few key files for the javafx project. (App.java, Calculator.fxml CalculatorController.java and styles.css)

You can check out my video series from [My Youtube Channel!](https://www.youtube.com/channel/UCRDHTKI4CdWruExooizDMRw)

---

## What
This is a JavaFX project. I made a simple Calculator with basic arithmetic functions.
- Add
- Subtract
- Multipy
- Divide

---
## How

This project uses JavaFX Libraries and exp4j library to read java equation from a string. 

IDE: VSCode

Project type: Maven JavaFX


---
## What i learned

I learned that JavaFX is more complicated than presented. It needs Modules to work because its not part of jdk anymore. Maven imports are not fun to package to jar. I encountered the error **"Error: JavaFX runtime components are missing, and are required to run this application"** so many times.

The solution for that was to download the javafx sdk to my computer, and run the jar with following line of code:


```console
java --module-path "C:\Program Files\Java\javafx-sdk-21.0.2\lib" --add-modules javafx.controls,javafx.fxml -jar Calculator.jar`
```
