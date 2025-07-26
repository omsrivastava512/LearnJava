// Create AreaCalculator class with overloaded area methods:
// - area(int side) - for square
// - area(int length, int width) - for rectangle  
// - area(double radius) - for circle
// - area(double base, double height) - for triangle
// Return appropriate area calculations

package basics2;

class AreaCalculator{
    public int area(int side){
        return area(side, side);
    }

    public int area(int length, int width){
        return length * width;
    } 

    public double area(double radius){
        return Math.PI * radius * radius;
    }

    public double area(double base, double height){
        return 0.5 * base * height;
    }
}

 class Main {
    private static int testsPassed = 0;
    private static int totalTests = 0;
    private static final double DELTA = 0.0001; // For double comparison
    
    public static void main(String[] args) {
        System.out.println("============================================================");
        System.out.println("         AREA CALCULATOR - COMPREHENSIVE TEST SUITE");
        System.out.println("============================================================\n");
        
        AreaCalculator calculator = new AreaCalculator();
        
        // Test all area calculation methods
        testSquareArea(calculator);
        testRectangleArea(calculator);
        testCircleArea(calculator);
        testTriangleArea(calculator);
        testEdgeCases(calculator);
        testLargeValues(calculator);
        testMethodOverloading(calculator);
        testPrecisionAndRounding(calculator);
        
        // Print final results
        printTestSummary();
    }
    
    // Test square area calculations
    private static void testSquareArea(AreaCalculator calc) {
        System.out.println("1. TESTING SQUARE AREA CALCULATIONS");
        System.out.println("--------------------------------------------------");
        
        // Basic square tests
        testCase("Square with side 5", calc.area(5), 25);
        testCase("Square with side 1", calc.area(1), 1);
        testCase("Square with side 10", calc.area(10), 100);
        testCase("Square with side 0", calc.area(0), 0);
        testCase("Square with side 7", calc.area(7), 49);
        testCase("Square with side 15", calc.area(15), 225);
        
        System.out.println("✓ Square area tests completed\n");
    }
    
    // Test rectangle area calculations
    private static void testRectangleArea(AreaCalculator calc) {
        System.out.println("2. TESTING RECTANGLE AREA CALCULATIONS");
        System.out.println("--------------------------------------------------");
        
        // Basic rectangle tests
        testCase("Rectangle 5x3", calc.area(5, 3), 15);
        testCase("Rectangle 10x4", calc.area(10, 4), 40);
        testCase("Rectangle 1x1 (unit square)", calc.area(1, 1), 1);
        testCase("Rectangle 0x5 (zero width)", calc.area(0, 5), 0);
        testCase("Rectangle 8x0 (zero height)", calc.area(8, 0), 0);
        testCase("Rectangle 12x7", calc.area(12, 7), 84);
        testCase("Rectangle 20x25", calc.area(20, 25), 500);
        testCase("Rectangle 100x1", calc.area(100, 1), 100);
        
        System.out.println("✓ Rectangle area tests completed\n");
    }
    
    // Test circle area calculations
    private static void testCircleArea(AreaCalculator calc) {
        System.out.println("3. TESTING CIRCLE AREA CALCULATIONS");
        System.out.println("--------------------------------------------------");
        
        // Basic circle tests
        testCaseDouble("Circle with radius 1.0", calc.area(1.0), Math.PI);
        testCaseDouble("Circle with radius 2.0", calc.area(2.0), 4 * Math.PI);
        testCaseDouble("Circle with radius 0.0", calc.area(0.0), 0.0);
        testCaseDouble("Circle with radius 5.0", calc.area(5.0), 25 * Math.PI);
        testCaseDouble("Circle with radius 0.5", calc.area(0.5), 0.25 * Math.PI);
        testCaseDouble("Circle with radius 10.0", calc.area(10.0), 100 * Math.PI);
        testCaseDouble("Circle with radius 3.5", calc.area(3.5), 12.25 * Math.PI);
        testCaseDouble("Circle with radius 7.2", calc.area(7.2), 51.84 * Math.PI);
        
        System.out.println("✓ Circle area tests completed\n");
    }
    
    // Test triangle area calculations
    private static void testTriangleArea(AreaCalculator calc) {
        System.out.println("4. TESTING TRIANGLE AREA CALCULATIONS");
        System.out.println("--------------------------------------------------");
        
        // Basic triangle tests
        testCaseDouble("Triangle base=4.0, height=3.0", calc.area(4.0, 3.0), 6.0);
        testCaseDouble("Triangle base=10.0, height=5.0", calc.area(10.0, 5.0), 25.0);
        testCaseDouble("Triangle base=0.0, height=5.0", calc.area(0.0, 5.0), 0.0);
        testCaseDouble("Triangle base=8.0, height=0.0", calc.area(8.0, 0.0), 0.0);
        testCaseDouble("Triangle base=6.5, height=4.2", calc.area(6.5, 4.2), 13.65);
        testCaseDouble("Triangle base=12.0, height=8.5", calc.area(12.0, 8.5), 51.0);
        testCaseDouble("Triangle base=1.0, height=1.0", calc.area(1.0, 1.0), 0.5);
        testCaseDouble("Triangle base=2.5, height=6.0", calc.area(2.5, 6.0), 7.5);
        
        System.out.println("✓ Triangle area tests completed\n");
    }
    
    // Test edge cases and boundary conditions
    private static void testEdgeCases(AreaCalculator calc) {
        System.out.println("5. TESTING EDGE CASES AND BOUNDARY CONDITIONS");
        System.out.println("--------------------------------------------------");
        
        // Zero values
        testCase("Square with side 0", calc.area(0), 0);
        testCase("Rectangle 0x0", calc.area(0, 0), 0);
        testCaseDouble("Circle with radius 0.0", calc.area(0.0), 0.0);
        testCaseDouble("Triangle with base=0.0", calc.area(0.0, 5.0), 0.0);
        testCaseDouble("Triangle with height=0.0", calc.area(5.0, 0.0), 0.0);
        
        // Very small values
        testCaseDouble("Circle with tiny radius 0.001", calc.area(0.001), Math.PI * 0.001 * 0.001);
        testCaseDouble("Triangle with tiny dimensions", calc.area(0.01, 0.02), 0.0001);
        
        // Unit values
        testCase("Unit square", calc.area(1), 1);
        testCase("Unit rectangle", calc.area(1, 1), 1);
        testCaseDouble("Unit circle", calc.area(1.0), Math.PI);
        testCaseDouble("Unit triangle", calc.area(2.0, 1.0), 1.0);
        
        System.out.println("✓ Edge case tests completed\n");
    }
    
    // Test large values and performance
    private static void testLargeValues(AreaCalculator calc) {
        System.out.println("6. TESTING LARGE VALUES AND PERFORMANCE");
        System.out.println("--------------------------------------------------");
        
        // Large integer values
        testCase("Large square 1000x1000", calc.area(1000), 1000000);
        testCase("Large rectangle 500x2000", calc.area(500, 2000), 1000000);
        
        // Large double values
        testCaseDouble("Large circle radius=100.0", calc.area(100.0), 10000 * Math.PI);
        testCaseDouble("Large triangle base=1000.0, height=500.0", calc.area(1000.0, 500.0), 250000.0);
        
        // Very large values
        testCase("Very large square", calc.area(10000), 100000000);
        testCaseDouble("Very large circle", calc.area(1000.0), 1000000 * Math.PI);
        
        // Performance test with multiple calculations
        long startTime = System.nanoTime();
        for(int i = 0; i < 10000; i++) {
            calc.area(i % 100);
            calc.area(i % 50, (i + 1) % 50);
            calc.area((double)(i % 20));
            calc.area((double)(i % 30), (double)((i + 1) % 30));
        }
        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1_000_000.0; // Convert to milliseconds
        
        System.out.println("✓ Performance test: 40,000 calculations completed in " + 
                          String.format("%.2f ms", duration));
        System.out.println("✓ Large value tests completed\n");
    }
    
    // Test method overloading disambiguation
    private static void testMethodOverloading(AreaCalculator calc) {
        System.out.println("7. TESTING METHOD OVERLOADING DISAMBIGUATION");
        System.out.println("--------------------------------------------------");
        
        // Test that correct overloaded method is called
        int squareResult = calc.area(5);          // Should call area(int)
        int rectResult = calc.area(5, 3);         // Should call area(int, int)
        double circleResult = calc.area(5.0);     // Should call area(double)
        double triangleResult = calc.area(5.0, 3.0); // Should call area(double, double)
        
        testCase("Method overloading: Square area(5)", squareResult, 25);
        testCase("Method overloading: Rectangle area(5,3)", rectResult, 15);
        testCaseDouble("Method overloading: Circle area(5.0)", circleResult, 25 * Math.PI);
        testCaseDouble("Method overloading: Triangle area(5.0,3.0)", triangleResult, 7.5);
        
        // Test type conversion scenarios
        testCaseDouble("Type conversion: area(5) vs area(5.0)", 
                      calc.area(5.0), 25 * Math.PI); // 5.0 should call circle method
        
        System.out.println("✓ Method overloading tests completed\n");
    }
    
    // Test precision and rounding for floating point calculations
    private static void testPrecisionAndRounding(AreaCalculator calc) {
        System.out.println("8. TESTING PRECISION AND ROUNDING");
        System.out.println("--------------------------------------------------");
        
        // Test floating point precision
        testCaseDouble("Precision test: π calculations", calc.area(1.0), Math.PI);
        testCaseDouble("Precision test: small decimals", calc.area(0.1, 0.1), 0.005);
        testCaseDouble("Precision test: repeating decimals", calc.area(1.0/3.0, 1.5), 0.25);
        
        // Test calculations with irrational results
        double radius = Math.sqrt(2);
        testCaseDouble("Irrational radius √2", calc.area(radius), 2 * Math.PI);
        
        // Test very precise calculations
        testCaseDouble("High precision triangle", calc.area(3.14159, 2.71828), 4.26986063);
        
        System.out.println("✓ Precision and rounding tests completed\n");
    }
    
    // Helper method for integer test cases
    private static void testCase(String description, int actual, int expected) {
        totalTests++;
        if (actual == expected) {
            System.out.println("✓ PASS: " + description + " (Expected: " + expected + ", Got: " + actual + ")");
            testsPassed++;
        } else {
            System.out.println("✗ FAIL: " + description + " (Expected: " + expected + ", Got: " + actual + ")");
        }
    }
    
    // Helper method for double test cases (with tolerance)
    private static void testCaseDouble(String description, double actual, double expected) {
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
            System.out.println("Your AreaCalculator implementation is working perfectly!");
        } else {
            System.out.println("⚠️  Some tests failed. Please review the implementation.");
        }
        
        System.out.println("\n📊 TEST CATEGORIES COVERED:");
        System.out.println("   • Square area calculations");
        System.out.println("   • Rectangle area calculations");
        System.out.println("   • Circle area calculations");
        System.out.println("   • Triangle area calculations");
        System.out.println("   • Edge cases and boundary conditions");
        System.out.println("   • Large values and performance");
        System.out.println("   • Method overloading disambiguation");
        System.out.println("   • Precision and rounding");
        System.out.println("============================================================");
    }
}