/******************************************************************************
 *  Compilation:  javac Chaos.java
 *  Execution:    java Chaos n
 *  Dependencies: StdDraw.java
 *
 *  Play chaos game on triangle to produce Sierpinski gasket.
 *  Plots n points.
 *
 *  % java Chaos 10000
 *
 ******************************************************************************/

public class Chaos {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        // Canvas
        StdDraw.setCanvasSize(1200, 1250);
        StdDraw.setScale(0, 1);

        // Side length s < 1 to leave margins, and equilateral height h
        double s = 0.90;
        double h = Math.sqrt(3) / 2.0;

        // Offsets to center the triangle in [0,1]x[0,1]
        double xOff = (1.0 - s) / 2.0;
        double yOff = (1.0 - s * h) / 2.0;

        // Triangle vertices (A, B, C)
        double ax = xOff,         ay = yOff;          // left base
        double bx = xOff + s,     by = yOff;          // right base
        double cx = xOff + s/2.0, cy = yOff + s*h;    // apex

        // Draw boundary
        StdDraw.line(ax, ay, bx, by);
        StdDraw.line(bx, by, cx, cy);
        StdDraw.line(cx, cy, ax, ay);

        // Start at the centroid to be safely inside
        double x = (ax + bx + cx) / 3.0;
        double y = (ay + by + cy) / 3.0;

        // Chaos game
        for (int i = 0; i < n; i++) {
            double r = StdRandom.uniformDouble(0.0, 1.0);
            double vx, vy;

            if (r < 1.0/3.0) { vx = ax; vy = ay; StdDraw.setPenColor(StdDraw.RED); }
            else if (r < 2.0/3.0) { vx = bx; vy = by; StdDraw.setPenColor(StdDraw.GREEN); }
            else { vx = cx; vy = cy; StdDraw.setPenColor(StdDraw.BLUE); }

            x = 0.5 * (x + vx);
            y = 0.5 * (y + vy);
            StdDraw.point(x, y);
        }
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.setPenRadius(.05);
        StdDraw.point(.1, .9);
    }

}