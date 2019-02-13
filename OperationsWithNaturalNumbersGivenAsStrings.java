    import java.math.BigInteger;
    import java.util.*; // Scanner
    import static java.lang.System . out ;


    class OperationsWithNaturalNumbersGivenAsStrings
    {
        public static void main ( String [] args ) {
            out.println(" OPERATIONS ON NATURAL NUMBERS " +
                    " IN CHARACTER STRINGS ");
            // enter two natural numbers
            Scanner in = new Scanner(System.in);
            out.println(" two natural numbers : ");
            String tal1 = in.next();
            String tal2 = in.next();
            out.println();
            // add the numbers and show the result
            String sum = add(tal1, tal2);
            show(tal1, tal2, sum, '+');
            // subtract the numbers and show the result
            // *** WRITE YOUR CODE HERE ***
            String subs = subtract(tal1, tal2);
            show(tal1,tal2,subs,'-');
            String multiply = multiply(tal1, tal2);
            show(tal1,tal2,multiply,'*');
            String divide = divide(tal1, tal2);
            show(tal1,tal2,divide,'/');
        }
        // The add method accepts two natural numbers represented
        // as character strings and returns their sum as a
        // character string .
        public static String add ( String num1 , String num2 ) {
            int len1=num1.length();
            int len2=num2.length();
            StringBuilder result = new StringBuilder();
            int sum=0;
            int carry=0;
            for (int i=0;i<len2;i++) {
                sum=Character.getNumericValue(num1.charAt(len1-i-1))+
                        Character.getNumericValue(num2.charAt(len2-i-1))+carry;
                if (sum>9){
                    result.append(Integer.toString(sum-10));
                    carry=1;
                }
                else{
                    result.append(Integer.toString(sum));
                    carry=0;
                }
                if (i==len2-1&&i==len1-1){
                    if (carry==1){
                        result.append("1");
                    }
                }
            }
            for (int i=len2;i<len1;i++){
                result.append(Character.getNumericValue(num1.charAt(len1-i-1))+carry);
                carry=0;
            }
            return result.reverse().toString();
        }
        // The subtract method accepts two natural numbers
        // represented as character strings and returns their
        // difference as a character string .
        // The first number is not smaller than the second
        public static String subtract ( String num1 , String num2 ) {
            int len1=num1.length();
            int len2=num2.length();
            StringBuilder result = new StringBuilder();
            int sum=0;
            int carry=0;
            for (int i=0;i<len2;i++) {
                sum=Character.getNumericValue(num1.charAt(len1-i-1))-
                        Character.getNumericValue(num2.charAt(len2-i-1))-carry;
                if (sum<0){
                    result.append(Integer.toString(sum+10));
                    carry=1;
                }
                else{
                    result.append(Integer.toString(sum));
                    carry=0;
                }
            }
            for (int i=len2;i<len1;i++){
                result.append(Character.getNumericValue(num1.charAt(len1-i-1))-carry);
                carry=0;
            }
            return result.reverse().toString();
        }
        public static String multiply ( String num1 , String num2 ) {
            int len1 = num1.length();
            int len2 = num2.length();
            int int1 = 0;
            int int2 = 0;
            for (int i = 0; i < num1.length(); i++) {
                int1 += Character.getNumericValue(num1.charAt(num1.length() - i - 1)) * ((int) Math.pow(10, i));
            }
            for (int i = 0; i < num2.length(); i++) {
                int2 += Character.getNumericValue(num2.charAt(num2.length() - i - 1)) * ((int) Math.pow(10, i));
            }
            int sum = int1 * int2;
            return Integer.toString(sum);
        }
        public static String divide ( String num1 , String num2 ) {
            int len1 = num1.length();
            int len2 = num2.length();
            int int1 = 0;
            int int2 = 0;
            for (int i = 0; i < num1.length(); i++) {
                int1 += Character.getNumericValue(num1.charAt(num1.length() - i - 1)) * ((int) Math.pow(10, i));
            }
            for (int i = 0; i < num2.length(); i++) {
                int2 += Character.getNumericValue(num2.charAt(num2.length() - i - 1)) * ((int) Math.pow(10, i));
            }
            int sum = int1 / int2;
            return Integer.toString(sum);
        }
        // The show method presents two natural numbers , an
        // operator and the result string .
        public static void show ( String num1 , String num2 ,
                                  String result , char operator )
        {
        // set an appropriate length on numbers and result
            int len1 = num1.length ();
            int len2 = num2.length ();
            int len = result.length ();
            int maxLen = Math.max ( Math.max ( len1 , len2 ) , len );
            num1 = setLen ( num1 , maxLen - len1 );
            num2 = setLen ( num2 , maxLen - len2 );
            result = setLen ( result , maxLen - len );
        // show the expression
            out . println ( " " + num1 );
            out . println ( " " + operator + " " + num2 );
            for ( int i = 0; i < maxLen + 2; i ++)
                out . print ( " -" );
            out . println ();
            out . println ( " " + result + "\n" );
        }
        // The setLen method prepends the supplied number of
        // spaces ato the beginning of a string
        public static String setLen ( String s , int nofSpaces )
        {
            StringBuilder sb = new StringBuilder ( s );
            for ( int i = 0; i < nofSpaces ; i ++)
                sb . insert (0 , " " );
            return sb . toString ();
        }
    }