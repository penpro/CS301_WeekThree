# CS301 Personal Guide — Chapter 2: Functions

**Source:** Princeton IntroCS — Chapter 2: Functions (Java)  
<https://introcs.cs.princeton.edu/java/20functions/>

## Why this chapter matters
Functions let you split work into small, testable pieces, reuse logic, and reason at a higher level. Chapter 2 covers:
- Writing your own static methods with parameters and return values
- Packaging methods into libraries and writing clients for modular programs
- Recursion for self-similar computations with clear base cases
- A case study using Monte Carlo simulation (percolation)

---

## Fast Table of Contents
- [Key concepts](#key-concepts)
- [Mental model](#mental-model)
- [API design checklist](#api-design-checklist)
- [Common patterns and snippets](#common-patterns-and-snippets)
- [Classic problems you should know](#classic-problems-you-should-know)
- [Practice prompts](#practice-prompts)
- [Links](#links)

---

## Key concepts
- **Static method**: named block of code with a parameter list and a return type. Call as `ClassName.method(...)`.
- **Libraries and clients**: group related helpers into a library class; write a separate client that imports and calls them.
- **Recursion**: a method calling itself on smaller inputs until a base case.
- **Percolation**: application of functions, libraries, and simulation to estimate a threshold.

---

## Mental model
- Treat each function like a contract: name, inputs, outputs, side effects.
- Compose small functions into pipelines.
- Prefer pure helpers when possible; keep I/O in thin wrappers.
- For recursion, identify the base case and an edge-case guard before writing the recursive step.

---

## API design checklist
- Name is a verb phrase (`gcd`, `gaussianPdf`, `mean`, `sampleStdDev`)
- Arguments in natural order
- Document constraints and error behavior
- One clear purpose per function
- Put related utilities in a library class (for example, `StdStats`, `StdRandom`)

---

## Common patterns and snippets

### 1) Static method template
```java
public static ReturnType name(Type1 a, Type2 b) {
    // validate inputs if needed
    // compute
    return result;
}
