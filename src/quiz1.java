import java.util.Scanner;

public class quiz1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        int lineOfCommand = input.nextInt();
        input.nextLine();
        String[] coppy = new String[lineOfCommand];
        int count = 0;
        for (int i = 0; i < lineOfCommand; i++) {
            String[] arg = input.nextLine().split(" ");
            if (arg[0].equals("COPY")) {
                String got = text.substring(Integer.parseInt(arg[1]) - 1, Integer.parseInt(arg[2]));
                coppy[count] = got;
                count++;
            } else if (arg[0].equals("CUT")) {
                String got = text.substring(Integer.parseInt(arg[1]) - 1, Integer.parseInt(arg[2]));
                coppy[count] = got;
                String temp = text.substring(0, Integer.parseInt(arg[1]) - 1);
                String temp2 = text.substring(Integer.parseInt(arg[2]));
                text = temp + temp2;
                count++;
            } else if (arg[0].equals("PASTE")) { //paste last copy to specific index
                String temp = text.substring(0, Integer.parseInt(arg[1]) - 1);
                String temp2 = text.substring(Integer.parseInt(arg[1]) - 1);
                text = temp + coppy[count - 1] + temp2;
                //remove from clipboard
                coppy[count - 1] = null;
                count--;
            }
        }
        System.out.println();
        System.out.println(text);
    }
}
