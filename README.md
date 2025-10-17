# Shape Studio v2.0.0

## Title
Shape Studio — object-oriented geometry simulator (Java, console-based).  
Version **2.0.0** integrates all previous concepts: polymorphism, object contracts, static/final, safe input, and utility classes.

---

## Features
- Abstract hierarchy `Shape` (`Circle`, `Rectangle`, `Triangle`);
- Polymorphic behavior: array of `Shape[]` with dynamic dispatch;
- Implemented `equals()`, `hashCode()`, `toString()` according to the strict equality policy (`RULES.md`);
- Added utility class `MathHelper` (constants, rounding, epsilon comparison);
- Safe CLI input handling with validation loops;
- One explicit `instanceof + cast` (for `Circle` radius only);
- Formatted numerical output with rounding for readability.

---

## How to Run
```bash
javac -d out src/org/example/*.java
java -cp out org.example.Main
```

---

## Examples
Example of polymorphic behavior with single `instanceof` usage:
```java
Shape[] shapes = {
new Circle(5),
new Rectangle(4, 10),
new Triangle(3, 4, 5)
};

for (Shape s : shapes) {
s.printInfo(); // polymorphic call
if (s instanceof Circle c) {
System.out.println("Circle radius: " + c.getRadius());
}
}
```

Example CLI session:
```text
=== Shape Studio v2.0 ===
1) Create Circle
2) Create Rectangle
3) Create Triangle
4) Show All Shapes
0) Exit

Enter choice: 1
Enter radius: abc
Error: enter a valid number
Enter radius: 10
Circle added successfully!

Enter choice: 4
Circle {Radius=10.0, Area=314.16, Perimeter=62.83}
```

---

## Acceptance
| Checkpoint | Status |
|-------------|---------|
| Polymorphism without instanceof chains | ✅ |
| One instanceof + cast (Circle only) | ✅ |
| MathHelper integrated (PI, EPS, round, epsilonEqual) | ✅ |
| CLI input protected | ✅ |
| Object contracts (equals/hashCode/toString) consistent | ✅ |
| RULES.md created and applied | ✅ |
| README updated and accurate | ✅ |

---

## Notes
- All calculations are routed through `MathHelper` to eliminate magic numbers.
- Floating-point equality and hashing strategies are documented in `RULES.md`.
- CLI prevents invalid input (no exceptions thrown).
- `Shape[]` dynamically grows when new figures are added.
- Rounding applied in `area()` and `perimeter()` for clean output.
- Full project follows single responsibility per class.

---

## Project Structure
```text
src/
└── org/example/
├── Shape.java
├── Circle.java
├── Rectangle.java
├── Triangle.java
├── MathHelper.java
├── Printable.java
├── Main.java
RULES.md
README.md
```

---

## Changelog

### v2.0.0 — Integration & Object Contracts
- Added `MathHelper` (PI, EPS, round, epsilonEqual);
- Introduced `RULES.md` with equality/hash policy;
- All Object contracts implemented and verified;
- Rounded numeric output for consistent CLI display;
- Safe input loops added to prevent user errors;

---

## Version
**Release:** v2.0.0  

