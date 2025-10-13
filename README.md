# CS301 Personal Guide — Chapter 2: Functions

-**Source:** Princeton IntroCS — Chapter 2: Functions (Java)  
<https://introcs.cs.princeton.edu/java/20functions/>
-**Source:** Index by week for CS301
<https://github.com/penpro/CS-301-CS-Foundations-Index/tree/main>

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
```

### 2) Euclid’s GCD (iterative and recursive)
Reference: <https://en.wikipedia.org/wiki/Euclidean_algorithm>
```java
// iterative
public static int gcd(int a, int b) {
    a = Math.abs(a); b = Math.abs(b);
    while (b != 0) {
        int t = a % b;
        a = b;
        b = t;
    }
    return a;
}

// recursive
public static int gcdR(int a, int b) {
    return (b == 0) ? Math.abs(a) : gcdR(b, a % b);
}
```

### 3) Gaussian PDF helper
Reference: <https://en.wikipedia.org/wiki/Normal_distribution>
```java
public static double gaussianPdf(double x, double mu, double sigma) {
    double z = (x - mu) / sigma;
    return Math.exp(-0.5 * z * z) / (sigma * Math.sqrt(2.0 * Math.PI));
}
```

### 4) Stats helpers (mean and sample stddev)
```java
public static double mean(double[] a) {
    double sum = 0.0;
    for (double v : a) sum += v;
    return sum / a.length;
}

public static double sampleStdDev(double[] a) {
    double mu = mean(a);
    double sum = 0.0;
    for (double v : a) { double d = v - mu; sum += d * d; }
    return Math.sqrt(sum / (a.length - 1));
}
```

### 5) Coupon collector simulation
Reference: <https://en.wikipedia.org/wiki/Coupon_collector%27s_problem>
```java
// returns trials needed to collect all N types at least once
public static int couponCollector(int N) {
    boolean[] seen = new boolean[N];
    int collected = 0, trials = 0;
    java.util.Random r = new java.util.Random();
    while (collected < N) {
        int x = r.nextInt(N);
        trials++;
        if (!seen[x]) { seen[x] = true; collected++; }
    }
    return trials;
}
```

### 6) Recursion warmups: factorial and fast power
References:  
- Recursion basics: <https://en.wikipedia.org/wiki/Recursion_(computer_science)>
- Exponentiation by squaring: <https://en.wikipedia.org/wiki/Exponentiation_by_squaring>
```java
public static long fact(int n) { return (n <= 1) ? 1 : n * fact(n - 1); }

public static double pow(double a, int b) {
    if (b == 0) return 1.0;
    if (b % 2 == 0) return pow(a * a, b / 2);
    return a * pow(a, b - 1);
}
```

---

## Classic problems you should know
- Harmonic numbers and growth rates
- Gaussian functions and random processes
- Coupon collector experiment
- Recursion exemplars: Euclid, Towers of Hanoi, Gray codes, LCS, Brownian bridges
- Percolation threshold estimation via simulation

Helpful wiki links:
- Gray code: <https://en.wikipedia.org/wiki/Gray_code>  
- Longest common subsequence: <https://en.wikipedia.org/wiki/Longest_common_subsequence_problem>  
- Percolation theory: <https://en.wikipedia.org/wiki/Percolation_theory>

---

## Practice prompts
1. Write a tiny `MathExtras` library with `clamp`, `lerp`, and `map` functions.  
2. Convert a loop-based method to a recursive version, then back. Check edge cases.  
3. Recreate `StdRandom.uniform(int n)` using only `Math.random()` and integer casts.  
4. Implement a client `PercolationProbability` that runs T trials and prints the mean open-site fraction.

---

## Links
- Chapter page: <https://introcs.cs.princeton.edu/java/20functions/>
- Programs index: <https://introcs.cs.princeton.edu/java/code/>
- Stdlib overview: <https://introcs.cs.princeton.edu/java/stdlib/>

---

### Personal notes
Keep a `notes/` page where you log pitfalls when writing libraries and how you tested them. Add quick test harnesses so Future You can re-verify behavior in seconds.
