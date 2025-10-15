

public class Serpinski {
    public static void main(String[] args) {
        /*
        StdDraw.setPenRadius(0.05);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.point(0.5, 0.5);
        StdDraw.setPenColor(StdDraw.MAGENTA);
        StdDraw.line(0.2, 0.2, 0.8, 0.2);
        */

       DrawTriangle(DrawTriangle(.2,.5,.9));

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

}
