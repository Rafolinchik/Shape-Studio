# Shape Studio v2.2.0

## Title
**Shape Studio** — object-oriented geometry simulator (Java, console-based).  
Version 2.2.0 adds nested classes, encapsulation improvements.  
The project now features clear modular architecture and strict visibility control.

---

## Features
- Abstract hierarchy `Shape` (`Circle`, `Rectangle`, `Triangle`);
- Polymorphism via `Shape[]` and dynamic dispatch (`printInfo()`);
- **Inner class** `Rectangle.Metrics` (diagonal & aspect ratio calculations);
- **Static nested class** `Main.Logger` (centralized logging);
- **Local and Anonymous classes** (`demoLocal()`, `demoAnonymous()`);
- Explicit imports (no `*`), clean public vs internal boundaries;
- Floating-point policy via `MathHelper` (`PI`, `EPS`, `round`, `epsilonEqual`);
- Fields encapsulated (`private`), immutable where applicable.

---

## How to Run
```bash
javac -d out src/org/example/**/*.java
java -cp out org.example.app.Main
```

---

## Examples

### 1️⃣ Polymorphic behavior
```java
Shape[] shapes = {
new Circle(5, Color.RED),
new Rectangle(4, 10, Color.BLUE),
new Triangle(3, 4, 5, Color.GREEN)
};

for (Shape s : shapes) {
s.printInfo(); // polymorphic call
}
```

### 2️⃣ Rectangle inner metrics
```java
Rectangle r = new Rectangle(3, 4, Color.BLUE);
Rectangle.Metrics m = r.metrics();
System.out.println("Diagonal: " + m.diagonal());
System.out.println("Aspect ratio: " + m.aspectRatio());
```

### 3️⃣ Local / Anonymous / Effectively final demos
```java
Main.demoLocal();
Main.demoAnonymous();
```

---

## Project Structure
```text
src/
└── org/example/
├── app/
│    └── Main.java
│         ├── Logger (static nested, internal)
│         ├── demoLocal()
│         ├── demoAnonymous()
│         └── demoEffectivelyFinal()
├── model/
│    ├── Shape.java          ← abstract base (public API)
│    ├── Circle.java         ← public
│    ├── Rectangle.java      ← public + inner Metrics (internal)
│    ├── Triangle.java       ← public
│    ├── DetailLevel.java    ← enum (formatting strategy)
│    └── Color.java          ← enum (type-safe colors)
├── spi/
│    └── Printable.java      ← public API contract
└── util/
└── MathHelper.java     ← constants & math helpers (public static)
```

### Package Responsibilities
| Package | Purpose | Visibility policy |
|----------|----------|------------------|
| `org.example.app` | CLI entry point & demos | `Main` public; `Logger` internal |
| `org.example.model` | Geometry domain layer | Figures public; helpers (`Metrics`) internal |
| `org.example.spi` | Contracts / interfaces | `Printable` public |
| `org.example.util` | Math utilities | `MathHelper` public static helpers |

---

## Acceptance
| Checkpoint | Status |
|-------------|--------|
| Inner class (`Rectangle.Metrics`) implemented | ✅ |
| Static nested class (`Main.Logger`) implemented | ✅ |
| Local & Anonymous class demos added | ✅ |
| Packages refactored (`app/model/spi/util`) | ✅ |
| Imports cleaned (no `*`) | ✅ |
| Public vs internal visibility verified | ✅ |
| README updated | ✅ |

---

## Notes
- `Main.Logger` handles runtime messages (`error()` → `System.err`);
- `Rectangle.Metrics` groups derived geometry calculations;
- Demo methods (`demoLocal`, `demoAnonymous`, `demoEffectivelyFinal`) illustrate Java nested class usage;
- All fields are `private`, immutable where possible;
- `MathHelper` unifies constants and rounding across the project;
- Architecture follows single responsibility and clean modularity.

---

## Changelog
### v2.2.0 — Nested Classes & Packaging Refactor
- Added `Rectangle.Metrics` (inner class);
- Added `Main.Logger` (static nested class);
- Added local and anonymous class demos;
- Enforced encapsulation (private fields);
- Updated README.

### v2.0.0 — Integration & Object Contracts
- Introduced `MathHelper` (PI, EPS, `round`, `epsilonEqual`);
- Added `RULES.md` with equality/hash policy;
- Implemented `equals/hashCode/toString`;
- Safe input loops and rounded numeric output.

---

## Version
**Release:** v2.2.0  
**Type:** Major Refactor — Nested Classes & Packaging
