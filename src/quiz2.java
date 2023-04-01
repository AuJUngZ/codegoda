import java.util.Scanner;

public class quiz2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] firstLine = input.nextLine().split(" "); //[0] = number of team [1] = number of bus
        String[] secondLine = input.nextLine().split(" "); //number of people in each team
        String[] capacity = input.nextLine().split(" "); //capacity of each bus

        int[] team = new int[Integer.parseInt(firstLine[0])];
        int[] bus = new int[Integer.parseInt(firstLine[1])];
        for(int i = 0; i < Integer.parseInt(firstLine[0]); i++) {
            team[i] = Integer.parseInt(secondLine[i]);
        }
        for(int i = 0; i < Integer.parseInt(firstLine[1]); i++) {
            bus[i] = Integer.parseInt(capacity[i]);
        }
        //out put the number of ways can fill each bus with full capacity
        int[] answer = new int[Integer.parseInt(firstLine[1])];
        for(int i = 0; i < Integer.parseInt(firstLine[1]); i++) {
            int count = 0;
            //try all the combination of team to get the full capacity
            for(int j = 0; j < Integer.parseInt(firstLine[0]); j++) {
                int sum = 0;
                for(int k = j; k < Integer.parseInt(firstLine[0]); k++) {
                    sum += team[k];
                    if(sum == bus[i]) {
                        count++;
                        break;
                    }
                }
            }
            answer[i] = count;
        }

        for(int i = 0; i < Integer.parseInt(firstLine[1]); i++) {
            System.out.println(answer[i]);
        }
    }
}