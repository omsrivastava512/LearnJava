package basics;
// Create a Calculator class with:
// - Methods: add(), subtract(), multiply(), divide()
// - Each method should take two parameters and return result
// - Create object in main method and test all operations

 class Calculator{
    // Addtion
        int add(int a, int b){
            return a+b;
        }
        double add(double a, int b){
            return a+b;
        }
        double add(int a, double b){
            return a+b;
        }
        double add(double a, double b){
            return a+b;
        }

    // Subtraction
        int subtract(int a, int b){
            return a-b;
        }
        double subtract(double a, int b){
            return a-b;
        }
        double subtract(int a, double b){
            return a-b;
        }
        double subtract(double a, double b){
            return a-b;
        }
    // Multiplication
        int multiply(int a, int b){
            return a*b;
        }
        double multiply(double a, int b){
            return a*b;
        }
        double multiply(int a, double b){
            return a*b;
        }
        double multiply(double a, double b){
            return a*b;
        }
    
    // Division
        double divide(int a, int b){
           
            try{
                 return (double) a/b;  // to avoid truncating
            }catch(ArithmeticException e){
                System.out.println("Division by zero not allowd.");
                return Double.NaN;
            }
        }
        double divide(double a, int b){
           
            try{
                return  a/b;
            }catch(ArithmeticException e){
                System.out.println("Division by zero not allowd.");
                return Double.NaN;
            }
        }
        double divide(int a, double b){
           
            try{
                return  a/b;
            }catch(ArithmeticException e){
                System.out.println("Division by zero not allowd.");
                return Double.NaN;
            }
        }
        double divide(double a, double b){
            
           
            try{
                return  a/b;
            }catch(ArithmeticException e){
                System.out.println("Division by zero not allowd.");
                return Double.NaN;
            }
        
        }


}


class Main{
    public static void main(String [] args){
        Calculator cal1 = new Calculator();

        System.out.println(cal1.add(1,47));
        System.out.println(cal1.subtract(1,47));
        System.out.println(cal1.multiply(1,47));
        System.out.println(cal1.multiply(4,5));

        System.out.println(cal1.divide(1.0,47));
        System.out.println(cal1.divide(1,47));
        System.out.println(cal1.divide(1.0,0));
        System.out.println(cal1.divide(1.0,0));
        System.out.println(cal1.divide(4,3));
    }
}