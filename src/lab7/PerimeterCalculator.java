package lab7;

public class PerimeterCalculator {
    public static double CalculateTrianglePerimeter(double aSide, double bSide, double cSide){

        if(aSide <= 0 || bSide <= 0 || cSide <= 0)
            throw new ArithmeticException("side can't be 0 or less");
        if(aSide + bSide < cSide ||
            bSide + cSide < aSide ||
            aSide + cSide < bSide)
            throw new ArithmeticException("Sum of 2 sides can't be smaller than third side");
        return aSide + bSide + cSide;
    }
}
