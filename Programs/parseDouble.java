/******************************************************************************
Program to Convert Numeric values from String to Double

*******************************************************************************/

 

 class Convert
{   static String c = new String();

    static boolean check(final String c){
        boolean chk=false;
            int i=0; 				//using i as an index variable to access array characters
            while (c.charAt(i) == ' ') {
                    i++; 
                }
            if(c.charAt(i)=='-'||c.charAt(i)=='+')
                i++;				//increment i value if the user has input a signed number
            
          // Iterate through the string to check for valid numerical characters
            while(i<c.length())			
            {            
              if(c.charAt(i)>='.' && c.charAt(i)<='9')		
              	chk=true;
              	else return false;
              	if(c.charAt(i)=='/') 			//since '/' lies b/w '.' and '9' in the character map
              	return false;
              	i++;
            }
            
        	 return chk;		
}
/* Convert the given string to a double */
static double stringToDouble(final String c) {
    double result = 0;
    double decimal=0;  		 
    int sign = 1; 		// Initialize sign as positive
	int i=0;
        // Skip white spaces
        while (c.charAt(i) == ' ') {
            i++;
        }
        // Handle signs
        if (c.charAt(i) == '-' || c.charAt(i) == '+') {
            sign = (c.charAt(i)=='-')? -1:1;
            i++;
        }
        
      

if(!check(c)) return 0;
       
        // Convert characters to double
        while ((i)<c.length()) {            
        //code store numeric value in result variable
            if(c.charAt(i)=='.'){
                i++;
                break;
        }  
            result = result * 10 + (c.charAt(i) - '0');
                i++;
        }
        int j = i;
        while(i<c.length()){
            decimal=decimal*10+(c.charAt(i)-'0');
            i++;
        }
        
    
	// Storing decimal numbers 
   
        while(j<c.length()){		
            if(c.charAt(i)=='.')		// Found another decimal
            break;
            decimal=decimal/10;		// Removing decimal after the numbers
            j++;
        }		// Placing decimal before the numbers
            

        
        
        // Apply sign
        return sign * (result+decimal) ;
    
}

	public static void main(String[] args) {
	    
	    c= System.console().readLine(":");
	    
		System.out.println(stringToDouble(c));
	}
}
