public class Main {
    public static void main(String[] args) {
        System.out.println("Is even number ...");
        boolean isEvenNumber = isEvenNumber(4);
        System.out.println(isEvenNumber);
        int[] arr = new int[]{2,3,4,1,2,1,3,6,4};
        System.out.println("Number that appears once ...");
        int onceAppearance = numberThatAppearsOnce(arr);
        System.out.println(onceAppearance);
        System.out.println("ith bit ...");
        int ithBit = ithBit(5,3);
        System.out.println(ithBit);
        System.out.println("Set ith bit ...");
        int setIthBit = setIthBit(1,3);
        System.out.println(setIthBit);
        System.out.println("Reset ith bit ...");
        int resetIthBit = resetIthBit(1,3);
        System.out.println(resetIthBit);
        System.out.println("Right most bit ...");
        int rightMostBit = rightMostBit(8);
        System.out.println(rightMostBit);
        System.out.println("Nth Magic number ...");
        int nthMagicNumber = nthMagicNumber(5);
        System.out.println(nthMagicNumber);
        System.out.println("Power of two ...");
        boolean powerOfTwo = powerOfTwo(4);
        System.out.println(powerOfTwo);
        System.out.println("Power of number ...");
        int powerOfNumber = powerOfNumber(4,2);
        System.out.println(powerOfNumber);
        System.out.println("Find number of set bits ...");
        int findSetBits = findNumberOfSetBits(9);
        System.out.println(findSetBits);
        System.out.println("Find number of set bits with less Time Complexity ...");
        int findSetBitsLessTc = findNumberOfSetBitsUsingLessTc(5);
        System.out.println(findSetBitsLessTc);
        System.out.println("Find x or of numbers ...");
        int xOrOfAllNumbers = findXorOfNumbers(5);
        System.out.println(xOrOfAllNumbers);
        System.out.println("Find x or of numbers normally ...");
        int xOrOfAllNumbersNormally = findXorOfNumbersNormally(9);
        System.out.println(xOrOfAllNumbersNormally);
        System.out.println("Compare x or of numbers normally and iteratively...");
        System.out.println(xOrOfAllNumbers == xOrOfAllNumbersNormally);
    }

    private static boolean isEvenNumber(int n){
        return ((n & 1) == 0);
    }

    private static int numberThatAppearsOnce(int[] arr){
        int currEle = arr[0];
        for (int x = 1;x<arr.length;x++){
            currEle = currEle^arr[x];
        }
        return currEle;
    }

    private static int ithBit(int n,int ith){
        return (n & (1 << (ith-1)));
    }

    private static int setIthBit(int n, int ith) {
        /// 001
        // 0 - 1
        // 1 - 1
        return (n | (1 << (ith-1)));
    }
    private static int resetIthBit(int n, int ith) {
        // 101
        // 1 - 0
        // 0 - 0
        return (n & ~ (1 << (ith-1)));
    }

    private static int rightMostBit(int n) {
        // 101
        // 011
        // 100 ~(100) = (011+1 = 100)
        // 100
        return (n & ((~n) + 1));
    }

    private static int nthMagicNumber(int n) {
        int sum = 0;
        int exponent = 1;
        while (n > 0){
            int bit = n & 1;
            sum = sum + (int) (bit * Math.pow(5,exponent));
            exponent++;
            n = (n >> 1); /// right shift by 1
        }
        return sum;
    }

    private static boolean powerOfTwo(int n) {
        // 100
        // 011
        return ((n & (n-1)) == 0);
    }

    /***
     *
     * Time Complexity is log(b)
     * If you do by iteratively it comes as O(n)
     * **/
    private static int powerOfNumber(int a,int b) {
        /// 100 // 10
        int exponent = 0;
        int op = 1;
        while (b > 0){
            int setBit = b & 1;
            op = op * (int) Math.pow(a,Math.pow(2,exponent)*setBit);
            exponent++;
            b = (b >> 1); /// right shift by 1 // 11
        }
        return op;
    }

    /**
     Time complexity is O(n)
     */
    private static int findNumberOfSetBits(int n) {
        /// 10
        int numberOfSetBits = 0;
        while (n > 0){
            if ((n & 1) == 1){
                numberOfSetBits++;
            }
            n = n >> 1;
        }
        return numberOfSetBits;
    }

    private static int findNumberOfSetBitsUsingLessTc(int n) {
        /// 101
        /// 100 - 4
        /// 100 
        /// 
        int numberOfSetBits = 0;
        while (n > 0){
            n = n & (n-1);
            numberOfSetBits++;
        }
        return numberOfSetBits;
    }

    private static int findXorOfNumbers(int i) {
        // 0  - 0
        // 01 - 1 - 00^01 = 1
        // 10 - 2 - 01 ^ 10 = 11
        // 11 - 3 - 11 ^ 11 = 0
        // 100 - 4 - 000 ^ 100 = 100
        // 101 - 5 - 100 ^ 101 = 001
        if (i%4 == 0){
            return i;
        }else if (i%4 == 3){
            return 0;
        }else if (i%4 == 2){
            return i+1;
        }else if (i%4 == 1){
            return 1;
        }else {
            return -1;
        }
    }

    private static int findXorOfNumbersNormally(int n) {
        int op = 0;
        for (int x = 0;x<=n;x++){
            op = op^x;
        }
        return op;
    }

}