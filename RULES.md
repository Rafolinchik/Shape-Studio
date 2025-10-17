## Equality Policy (Shape Hierarchy)

- Strategy: by exact class (getClass()).
- Different types (Circle vs Rectangle) are never equal.
- Floating-point policy: strict equality (==).
- Rectangle equality ignores side order (4x10 == 10x4).
- Fields included in equality:
    - Circle: radius
    - Rectangle: width, height
    - Triangle: sideA, sideB, sideC
- toString(): class + key fields, no I/O.
- hashCode: consistent with equals.
