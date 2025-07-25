// Create Rectangle class with:
// - Fields: length, width
// - Constructor with no parameters (creates unit square: 1x1)
// - Constructor with one parameter (creates square: nxn)
// - Constructor with two parameters (creates rectangle: length x width)
// - Methods: calculateArea(), calculatePerimeter()
// Use 'this()' for constructor chaining

package basics2;
public class Rectangle {
    double length, width;

    public Rectangle() {
       this(1);
    }

    public Rectangle(double n) {
        this(n,n);
    }

    public Rectangle(double l, double w){
        this.length = l;
        this.width = w;
    }

    public double calculateArea(){
        return this.length * this.width;
    }

    public double calculatePerimeter(){
        return 2 * (length + width);
    }

}

// Learning : Learned about Constructot chaining using this() and super()


