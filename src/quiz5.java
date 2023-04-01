import java.util.Scanner;

public class quiz5 {
    public static void main(String[] args) {
//        5
//        Nyc 4 100
//        Bangkok 3 10
//        Nyc 2 15
//        Warsaw 1 12
//        Paris 3 80
//        9 400 output

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        String[] offer = new String[n];
        int[][] dayAndPrice = new int[n][2];
        for(int i = 0 ; i < n ; i++){
            offer[i] = input.nextLine();
            String[] temp = offer[i].split(" ");
            dayAndPrice[i][0] = Integer.parseInt(temp[1]);
            dayAndPrice[i][1] = Integer.parseInt(temp[2]);
        }
        //to find the max day with the lowest price. like 0-1knapsack with fraction
        int maxDay = 0;
        int maxPrice = 0;
        //use algorithm that solve 0-1 knapsack with fraction
        for(int i = 0 ; i < n ; i++){
            if(dayAndPrice[i][0] > maxDay){
                maxDay = dayAndPrice[i][0];
                maxPrice = dayAndPrice[i][1];
            }
        }
        int[] dp = new int[maxDay+1];
        for(int i = 0 ; i < n ; i++){
            for(int j = maxDay ; j >= dayAndPrice[i][0] ; j--){
                dp[j] = Math.max(dp[j], dp[j-dayAndPrice[i][0]] + dayAndPrice[i][1]);
            }
        }
        System.out.println(maxDay + " " + dp[maxDay]);
    }
}
