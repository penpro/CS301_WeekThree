

public class Serpinski {
    public static void main(String[] args) {
        /*
        StdDraw.setPenRadius(0.05);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.point(0.5, 0.5);
        StdDraw.setPenColor(StdDraw.MAGENTA);
        StdDraw.line(0.2, 0.2, 0.8, 0.2);
        */

       //DrawTriangle(DrawTriangle(.2,.5,.9));
        StdDraw.setCanvasSize(1200, 1200);
       RecSierpinskiTriangle(4);

    }

    // draws equilateral triangle of dimension l starting at top point x, y
    // a^2 + b^2 = c^2
    // a = 1/2l
    // c = l
    // b =
    // point.a = x,y
    // point.b = x+1/2l, y-sqrt(l^2-(l1/2)^2)
    // point.c  = x-1/2l, y-sqrt(l^2-(l1/2)^2)

    public static double[] DrawTriangle(double length, double pointAx, double pointAy) {
        double YOffset = Math.sqrt( (length*length) - ((length/2)*(length/2)) );
        double pointBx = pointAx+( length/2 );
        double pointBy = pointAy-YOffset;
        double pointCx = pointAx-( length/2 );
        double pointCy = pointAy-YOffset;
        StdDraw.line(pointAx,pointAy,pointBx,pointBy);
        StdDraw.line(pointBx,pointBy,pointCx,pointCy);
        StdDraw.line(pointCx,pointCy,pointAx,pointAy);

        return new double[]{length,pointBx,pointBy,pointCx,pointCy};

    }



    public static void DrawTriangle(double[] points){
        DrawTriangle(points[0],points[1],points[2]);
        DrawTriangle(points[0],points[3],points[4]);
    }

    // Public wrapper with your fixed apex and side
    public static void RecSierpinskiTriangle(int depth) {
        StdDraw.setScale(0, 1);
        StdDraw.clear();
        StdDraw.setPenRadius(0.002);
        sierpinski(0.5, 0.95, 0.95, depth); // apex (0.5,0.9), side 0.9
    }

    // Recursive helper: depth == 1 just draws this triangle
    private static void sierpinski(double x, double y, double s, int depth) {
        // base case
        if (depth <= 1) {
            drawOutline(x, y, s);
            return;
        }
        double h = Math.sqrt(3) * 0.5 * s;

        // top child
        sierpinski(x, y, s / 2, depth - 1);
        // left child
        sierpinski(x - s / 4, y - h / 2, s / 2, depth - 1);
        // right child
        sierpinski(x + s / 4, y - h / 2, s / 2, depth - 1);
    }

    // Draw an equilateral triangle outline given apex and side
    private static void drawOutline(double x, double y, double s) {
        double h  = Math.sqrt(3) * 0.5 * s;
        double bx = x - s / 2, by = y - h;  // left base
        double cx = x + s / 2, cy = y - h;  // right base
        StdDraw.line(x, y, bx, by);
        StdDraw.line(bx, by, cx, cy);
        StdDraw.line(cx, cy, x, y);
    }

}
