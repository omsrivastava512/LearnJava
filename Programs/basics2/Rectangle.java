// Create Rectangle class with:
// - Fields: length, width
// - Constructor with no parameters (creates unit square: 1x1)
// - Constructor with one parameter (creates square: nxn)
// - Constructor with two parameters (creates rectangle: length x width)
// - Methods: calculateArea(), calculatePerimeter()
// Use 'this()' for constructor chaining

package basics2;

 class Rectangle {
    double length, width;

    public Rectangle() {
       this(1);
    }

    public Rectangle(double n) {
        this(n, n);
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

    /** Getter methods for testing */
        public double getLength() {
            return length;
        }

        public double getWidth() {
            return width;
        }

        // Additional utility methods
        public boolean isSquare() {
            return length == width;
        }

        public String getShapeType() {
            return isSquare() ? "Square" : "Rectangle";
        }

        @Override
        public String toString() {
            return String.format("%s [Length: %.2f, Width: %.2f, Area: %.2f, Perimeter: %.2f]", 
                            getShapeType(), length, width, calculateArea(), calculatePerimeter());
        }
    /** */
}

class Main {
    private static int testsPassed = 0;
    private static int totalTests = 0;
    private static final double DELTA = 0.0001; // For double comparison

    public static void main(String[] args) {
        System.out.println("============================================================");
        System.out.println("         RECTANGLE CLASS - COMPREHENSIVE TEST SUITE");
        System.out.println("============================================================\n");

        // Test all constructor chaining scenarios
        testConstructorChaining();
        testDefaultConstructor();
        testSingleParameterConstructor();
        testTwoParameterConstructor();
        testAreaCalculations();
        testPerimeterCalculations();
        testEdgeCases();
        testLargeValues();
        testPrecisionAndFloatingPoint();
        testUtilityMethods();
        testPerformance();

        // Print final results
        printTestSummary();
    }

    // Test constructor chaining mechanism
    private static void testConstructorChaining() {
        System.out.println("1. TESTING CONSTRUCTOR CHAINING");
        System.out.println("--------------------------------------------------");

        // Test that constructor chaining works properly
        Rectangle defaultRect = new Rectangle();
        testCase("Default constructor chains to this(1)", defaultRect.getLength(), 1.0);
        testCase("Default constructor chains to this(1)", defaultRect.getWidth(), 1.0);

        Rectangle squareRect = new Rectangle(5);
        testCase("Single param constructor chains to this(5,5)", squareRect.getLength(), 5.0);
        testCase("Single param constructor chains to this(5,5)", squareRect.getWidth(), 5.0);

        Rectangle customRect = new Rectangle(3, 4);
        testCase("Two param constructor sets length", customRect.getLength(), 3.0);
        testCase("Two param constructor sets width", customRect.getWidth(), 4.0);

        System.out.println("✓ Constructor chaining tests completed\n");
    }

    // Test default constructor (no parameters)
    private static void testDefaultConstructor() {
        System.out.println("2. TESTING DEFAULT CONSTRUCTOR");
        System.out.println("--------------------------------------------------");

        Rectangle rect = new Rectangle();
        
        testCase("Default constructor - length should be 1.0", rect.getLength(), 1.0);
        testCase("Default constructor - width should be 1.0", rect.getWidth(), 1.0);
        testCase("Default constructor - area should be 1.0", rect.calculateArea(), 1.0);
        testCase("Default constructor - perimeter should be 4.0", rect.calculatePerimeter(), 4.0);
        testBoolean("Default constructor - should create square", rect.isSquare(), true);

        System.out.println("✓ Default constructor tests completed\n");
    }

    // Test single parameter constructor (square)
    private static void testSingleParameterConstructor() {
        System.out.println("3. TESTING SINGLE PARAMETER CONSTRUCTOR (SQUARE)");
        System.out.println("--------------------------------------------------");

        // Test various square sizes
        Rectangle square1 = new Rectangle(1);
        testCase("Square(1) - length", square1.getLength(), 1.0);
        testCase("Square(1) - width", square1.getWidth(), 1.0);
        testCase("Square(1) - area", square1.calculateArea(), 1.0);
        testCase("Square(1) - perimeter", square1.calculatePerimeter(), 4.0);

        Rectangle square5 = new Rectangle(5);
        testCase("Square(5) - length", square5.getLength(), 5.0);
        testCase("Square(5) - width", square5.getWidth(), 5.0);
        testCase("Square(5) - area", square5.calculateArea(), 25.0);
        testCase("Square(5) - perimeter", square5.calculatePerimeter(), 20.0);

        Rectangle square0 = new Rectangle(0);
        testCase("Square(0) - length", square0.getLength(), 0.0);
        testCase("Square(0) - width", square0.getWidth(), 0.0);
        testCase("Square(0) - area", square0.calculateArea(), 0.0);
        testCase("Square(0) - perimeter", square0.calculatePerimeter(), 0.0);

        Rectangle squareDecimal = new Rectangle(2.5);
        testCase("Square(2.5) - length", squareDecimal.getLength(), 2.5);
        testCase("Square(2.5) - width", squareDecimal.getWidth(), 2.5);
        testCase("Square(2.5) - area", squareDecimal.calculateArea(), 6.25);
        testCase("Square(2.5) - perimeter", squareDecimal.calculatePerimeter(), 10.0);

        System.out.println("✓ Single parameter constructor tests completed\n");
    }

    // Test two parameter constructor (rectangle)
    private static void testTwoParameterConstructor() {
        System.out.println("4. TESTING TWO PARAMETER CONSTRUCTOR (RECTANGLE)");
        System.out.println("--------------------------------------------------");

        Rectangle rect1 = new Rectangle(3, 4);
        testCase("Rectangle(3,4) - length", rect1.getLength(), 3.0);
        testCase("Rectangle(3,4) - width", rect1.getWidth(), 4.0);
        testCase("Rectangle(3,4) - area", rect1.calculateArea(), 12.0);
        testCase("Rectangle(3,4) - perimeter", rect1.calculatePerimeter(), 14.0);

        Rectangle rect2 = new Rectangle(10, 2);
        testCase("Rectangle(10,2) - length", rect2.getLength(), 10.0);
        testCase("Rectangle(10,2) - width", rect2.getWidth(), 2.0);
        testCase("Rectangle(10,2) - area", rect2.calculateArea(), 20.0);
        testCase("Rectangle(10,2) - perimeter", rect2.calculatePerimeter(), 24.0);

        Rectangle rect3 = new Rectangle(1.5, 2.5);
        testCase("Rectangle(1.5,2.5) - length", rect3.getLength(), 1.5);
        testCase("Rectangle(1.5,2.5) - width", rect3.getWidth(), 2.5);
        testCase("Rectangle(1.5,2.5) - area", rect3.calculateArea(), 3.75);
        testCase("Rectangle(1.5,2.5) - perimeter", rect3.calculatePerimeter(), 8.0);

        System.out.println("✓ Two parameter constructor tests completed\n");
    }

    // Test area calculations extensively
    private static void testAreaCalculations() {
        System.out.println("5. TESTING AREA CALCULATIONS");
        System.out.println("--------------------------------------------------");

        Rectangle[] rectangles = {
            new Rectangle(1, 1),      // Unit square
            new Rectangle(0, 5),      // Zero area
            new Rectangle(5, 0),      // Zero area
            new Rectangle(2, 3),      // Basic rectangle
            new Rectangle(10, 10),    // Large square
            new Rectangle(0.1, 0.2),  // Small decimals
            new Rectangle(100, 50),   // Large rectangle
            new Rectangle(Math.PI, 2) // Irrational number
        };

        double[] expectedAreas = {1.0, 0.0, 0.0, 6.0, 100.0, 0.02, 5000.0, 2 * Math.PI};

        for (int i = 0; i < rectangles.length; i++) {
            testCase("Area calculation test " + (i+1), 
                    rectangles[i].calculateArea(), expectedAreas[i]);
        }

        System.out.println("✓ Area calculation tests completed\n");
    }

    // Test perimeter calculations extensively
    private static void testPerimeterCalculations() {
        System.out.println("6. TESTING PERIMETER CALCULATIONS");
        System.out.println("--------------------------------------------------");

        Rectangle[] rectangles = {
            new Rectangle(1, 1),      // Unit square
            new Rectangle(0, 5),      // One side zero
            new Rectangle(5, 0),      // One side zero
            new Rectangle(2, 3),      // Basic rectangle
            new Rectangle(10, 10),    // Large square
            new Rectangle(0.5, 1.5),  // Small decimals
            new Rectangle(100, 50),   // Large rectangle
            new Rectangle(Math.PI, 1) // Irrational number
        };

        double[] expectedPerimeters = {4.0, 10.0, 10.0, 10.0, 40.0, 4.0, 300.0, 2 * (Math.PI + 1)};

        for (int i = 0; i < rectangles.length; i++) {
            testCase("Perimeter calculation test " + (i+1), 
                    rectangles[i].calculatePerimeter(), expectedPerimeters[i]);
        }

        System.out.println("✓ Perimeter calculation tests completed\n");
    }

    // Test edge cases and boundary conditions
    private static void testEdgeCases() {
        System.out.println("7. TESTING EDGE CASES AND BOUNDARY CONDITIONS");
        System.out.println("--------------------------------------------------");

        // Zero dimensions
        Rectangle zeroRect = new Rectangle(0, 0);
        testCase("Zero rectangle - area", zeroRect.calculateArea(), 0.0);
        testCase("Zero rectangle - perimeter", zeroRect.calculatePerimeter(), 0.0);

        // Very small dimensions
        Rectangle tinyRect = new Rectangle(0.001, 0.002);
        testCase("Tiny rectangle - area", tinyRect.calculateArea(), 0.000002);
        testCase("Tiny rectangle - perimeter", tinyRect.calculatePerimeter(), 0.006);

        // One dimension zero
        Rectangle flatRect1 = new Rectangle(0, 10);
        testCase("Flat rectangle (width=0) - area", flatRect1.calculateArea(), 0.0);
        testCase("Flat rectangle (width=0) - perimeter", flatRect1.calculatePerimeter(), 20.0);

        Rectangle flatRect2 = new Rectangle(10, 0);
        testCase("Flat rectangle (height=0) - area", flatRect2.calculateArea(), 0.0);
        testCase("Flat rectangle (height=0) - perimeter", flatRect2.calculatePerimeter(), 20.0);

        // Negative dimensions (if allowed by business logic)
        Rectangle negRect = new Rectangle(-5, 3);
        testCase("Negative length rectangle - area", negRect.calculateArea(), -15.0);
        testCase("Negative length rectangle - perimeter", negRect.calculatePerimeter(), -4.0);

        System.out.println("✓ Edge case tests completed\n");
    }

    // Test large values and performance
    private static void testLargeValues() {
        System.out.println("8. TESTING LARGE VALUES");
        System.out.println("--------------------------------------------------");

        Rectangle largeRect = new Rectangle(1000000, 2000000);
        testCase("Large rectangle - area", largeRect.calculateArea(), 2000000000000.0);
        testCase("Large rectangle - perimeter", largeRect.calculatePerimeter(), 6000000.0);

        Rectangle veryLargeSquare = new Rectangle(1000000);
        testCase("Very large square - area", veryLargeSquare.calculateArea(), 1000000000000.0);
        testCase("Very large square - perimeter", veryLargeSquare.calculatePerimeter(), 4000000.0);

        System.out.println("✓ Large value tests completed\n");
    }

    // Test precision and floating point calculations
    private static void testPrecisionAndFloatingPoint() {
        System.out.println("9. TESTING PRECISION AND FLOATING POINT");
        System.out.println("--------------------------------------------------");

        Rectangle piRect = new Rectangle(Math.PI, 2);
        testCase("π rectangle - area", piRect.calculateArea(), 2 * Math.PI);
        testCase("π rectangle - perimeter", piRect.calculatePerimeter(), 2 * (Math.PI + 2));

        Rectangle sqrtRect = new Rectangle(Math.sqrt(2), Math.sqrt(8));
        testCase("√2 × √8 rectangle - area", sqrtRect.calculateArea(), 4.0);

        Rectangle precisionRect = new Rectangle(1.0/3.0, 3.0);
        testCase("1/3 × 3 rectangle - area", precisionRect.calculateArea(), 1.0);

        System.out.println("✓ Precision tests completed\n");
    }

    // Test utility methods
    private static void testUtilityMethods() {
        System.out.println("10. TESTING UTILITY METHODS");
        System.out.println("--------------------------------------------------");

        Rectangle square = new Rectangle(5);
        Rectangle rectangle = new Rectangle(3, 4);

        testBoolean("Square should be identified as square", square.isSquare(), true);
        testBoolean("Rectangle should not be identified as square", rectangle.isSquare(), false);

        testString("Square shape type", square.getShapeType(), "Square");
        testString("Rectangle shape type", rectangle.getShapeType(), "Rectangle");

        // Test toString method
        String squareString = square.toString();
        testBoolean("Square toString contains 'Square'", squareString.contains("Square"), true);
        testBoolean("Square toString contains dimensions", squareString.contains("5.00"), true);

        System.out.println("✓ Utility method tests completed\n");
    }

    // Test performance with multiple objects
    private static void testPerformance() {
        System.out.println("11. TESTING PERFORMANCE");
        System.out.println("--------------------------------------------------");

        long startTime = System.nanoTime();
        
        // Create many rectangles and perform calculations
        for (int i = 1; i <= 10000; i++) {
            Rectangle rect1 = new Rectangle();
            Rectangle rect2 = new Rectangle(i % 100);
            Rectangle rect3 = new Rectangle(i % 50, (i + 1) % 50);
            
            rect1.calculateArea();
            rect1.calculatePerimeter();
            rect2.calculateArea();
            rect2.calculatePerimeter();
            rect3.calculateArea();
            rect3.calculatePerimeter();
        }
        
        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1_000_000.0; // Convert to milliseconds
        
        System.out.println("✓ Performance test: Created 30,000 rectangles and performed 60,000 calculations");
        System.out.println("✓ Completed in " + String.format("%.2f ms", duration));
        System.out.println("✓ Performance tests completed\n");
    }

    // Helper methods for testing
    private static void testCase(String description, double actual, double expected) {
        totalTests++;
        if (Math.abs(actual - expected) < DELTA) {
            System.out.println("✓ PASS: " + description + " (Expected: " + 
                             String.format("%.6f", expected) + ", Got: " + 
                             String.format("%.6f", actual) + ")");
            testsPassed++;
        } else {
            System.out.println("✗ FAIL: " + description + " (Expected: " + 
                             String.format("%.6f", expected) + ", Got: " + 
                             String.format("%.6f", actual) + ")");
        }
    }

    private static void testBoolean(String description, boolean actual, boolean expected) {
        totalTests++;
        if (actual == expected) {
            System.out.println("✓ PASS: " + description + " (Expected: " + expected + ", Got: " + actual + ")");
            testsPassed++;
        } else {
            System.out.println("✗ FAIL: " + description + " (Expected: " + expected + ", Got: " + actual + ")");
        }
    }

    private static void testString(String description, String actual, String expected) {
        totalTests++;
        if (actual.equals(expected)) {
            System.out.println("✓ PASS: " + description + " (Expected: '" + expected + "', Got: '" + actual + "')");
            testsPassed++;
        } else {
            System.out.println("✗ FAIL: " + description + " (Expected: '" + expected + "', Got: '" + actual + "')");
        }
    }

    // Print comprehensive test summary
    private static void printTestSummary() {
        System.out.println("============================================================");
        System.out.println("                    TEST SUMMARY");
        System.out.println("============================================================");
        System.out.println("Total Tests Run: " + totalTests);
        System.out.println("Tests Passed: " + testsPassed);
        System.out.println("Tests Failed: " + (totalTests - testsPassed));
        
        double successRate = (double) testsPassed / totalTests * 100;
        System.out.println("Success Rate: " + String.format("%.2f%%", successRate));
        
        if (testsPassed == totalTests) {
            System.out.println("🎉 ALL TESTS PASSED! 🎉");
            System.out.println("Your Rectangle class with constructor chaining is working perfectly!");
        } else {
            System.out.println("⚠️  Some tests failed. Please review the implementation.");
        }
        
        System.out.println("\n📊 CONSTRUCTOR CHAINING VERIFIED:");
        System.out.println("   • Rectangle() → this(1) → this(1,1) ✓");
        System.out.println("   • Rectangle(n) → this(n,n) ✓");
        System.out.println("   • Rectangle(l,w) → direct assignment ✓");
        
        System.out.println("\n📋 TEST CATEGORIES COVERED:");
        System.out.println("   • Constructor chaining mechanism");
        System.out.println("   • Default constructor (unit square)");
        System.out.println("   • Single parameter constructor (square)");
        System.out.println("   • Two parameter constructor (rectangle)");
        System.out.println("   • Area calculations");
        System.out.println("   • Perimeter calculations");
        System.out.println("   • Edge cases and boundary conditions");
        System.out.println("   • Large values and performance");
        System.out.println("   • Precision and floating point");
        System.out.println("   • Utility methods (isSquare, getShapeType, toString)");
        System.out.println("============================================================");
    }
}

// Learning : Learned about Constructor chaining using this() and super()