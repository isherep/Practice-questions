public class SumThreeFiveUnder1000 {
    private static final int MAX_LIMIT = 1000;

    /**
     * Calculates the sum of 3's and 5's under 1000.
     * @return The sum of multiples of 3 and 5 less than 1000
     */
    public static long findSum(){
        long sum = 0;
        for(int i = 3; i< MAX_LIMIT; i++){
            if(i % 3 == 0 || i % 5 == 0){
                sum +=i;
            }
        }
        return sum;
    }

    public static void main(String[] args){
        System.out.println(findSum());
    }
}
