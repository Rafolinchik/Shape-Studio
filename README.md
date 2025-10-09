# Shape Studio

Console app demonstrating **OOP in Java**:  
abstract classes, interfaces, and polymorphism.

## Features
- Abstract base class `Shape` with `area()` and `perimeter()`
- Implementations: `Circle`, `Rectangle`, `Triangle`
- Interface `Printable` with `printInfo()` contract
- CLI menu for adding figures and viewing calculations
- Input validation (numeric checks, safe loops)

## Project structure
```тext
src/
└─ org/
└─ example/
├─ app/
│  └─ Main.java
├─ model/
│  ├─ Shape.java
│  ├─ Circle.java
│  ├─ Rectangle.java
│  └─ Triangle.java
└─ spi/
└─ Printable.java
```

## How to Run
```bash
javac -d out src/org/example/**/*.java
java -cp out org.example.app.Main
```

## Example session
```тext
Welcome to Shape Studio!
Add first figure for start:
1 - Circle
2 - Rectangle
3 - Triangle
0 - Exit
> 1
New Circle
Enter radius:
5
Figure added.
What do you want?
1 - Add figure
2 - Calculate area
3 - Calculate perimeter
4 - Print Info
0 - Exit
> 4
Circle area = 78.53981633974483
> 0
See you later!
```

## Acceptance
- ✅ Abstract class `Shape` and interface `Printable` implemented
- ✅ Polymorphism via `Shape[]` and interface calls
- ✅ CLI runs, supports multiple figures
- ✅ Safe input handling, no crashes on invalid input

## Notes
- `super(name)` used to initialize base class field
- Manual array resizing instead of collections (by design)
- Validation with `Scanner.hasNextDouble()` loops
- Uses Heron’s formula for triangle area  
