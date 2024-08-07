# Star Display Project

This project is part of CSC 202 - Object oriented programming and Data Structures course at Augustana College and involves developing a graphical display of stars and constellations using Java.

## Project Overview

The Star Display project visualizes star data in a graphical window. It uses a cleaned catalog of stars, each represented by their x/y/z-coordinates and optionally a name. The project includes functionalities to display stars, connect them to form constellations, and simulate supernova events.

### Objectives

- Practice using maps and sets in Java.
- Work with graphical displays in Java.
- Simulate astronomical phenomena such as supernova events.

## Files

- `Star.java`: Represents individual stars.
- `StarChart.java`: Manages and displays the star chart.
- `StarDisplay.java`: Driver program.
- `DisplayableStarChart.java`: Interface implemented by `StarChart`.

## Class Specifications

### Star Class

- **Fields**: `x`, `y`, `z`, `magnitude`, `color`
- **Constructor**: `public Star(double x, double y, double z, double magnitude)`
- **Methods**:
  - `distance(Star other)`: Computes 3D distance.
  - `compareTo(Star other)`: Compares stars.
  - `equals(Object object)`: Checks equality.
  - `toString()`: Returns star state.

### StarChart Class

- **Constructor**: `public StarChart(int width, int height)`
- **Methods**:
  - `addStar(Star star, String name)`: Adds a star.
  - `addConstellation(String name, String[] stars)`: Adds a constellation.
  - `getName(Star star)`: Returns star name.
  - `isAnyConstellationDisplayed()`: Checks if any constellation is displayed.
  - `isThisConstellationDisplayed(String name)`: Checks if a specific constellation is displayed.
  - `removeConstellation(String name)`: Removes a constellation.
  - `getStar(String name)`: Returns a star by name.
  - `supernova(Star star)`: Simulates a supernova event.
  - `draw(Graphics g, boolean showStarNames)`: Draws stars and constellations.

## Running the Project

1. **Setup the Environment**:
   - Ensure Java is installed.
   - Use an IDE like Eclipse or IntelliJ IDEA.

2. **Compile and Run**:
   - Compile `Star.java`, `StarChart.java`, and `StarDisplay.java`.
   - Execute `StarDisplay.java` to launch the graphical display.

