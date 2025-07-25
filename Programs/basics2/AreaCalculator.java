// Create AreaCalculator class with overloaded area methods:
// - area(int side) - for square
// - area(int length, int width) - for rectangle  
// - area(double radius) - for circle
// - area(double base, double height, String shape) - for triangle
// Return appropriate area calculations


class AreaCalculator{
    public int area(int side){
        return area(side, side);
    }

    public int area(int length, int width){
        return length * width;
    } 

    // public double area();
}