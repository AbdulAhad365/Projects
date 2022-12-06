import java.util.Scanner;
class Scratch {
    // for making a toss
    public static int user1 = 100, user2 = 100;

    public static void player1() {
        Scanner s = new Scanner(System.in);
        System.out.println("enter 1 for thumb move and 2 for wrist move PLAYER 1");
        int move = s.nextInt();
        if (move == 1) {
            int store=thumb();
            user2=user2-store;
            System.out.println("                        ");
            System.out.println("*************************");
            System.out.println("User 2 your XP is "+user2);
            System.out.println("*************************");
            System.out.println();

        } else if (move == 2) {
            int store=wrist();
            user2=user2-store;
            System.out.println("                        ");
            System.out.println("*************************");
            System.out.println("User 2 your XP is "+user2);
            System.out.println("*************************");
            System.out.println();

        }
    }
    public static void player2(){
        Scanner s=new Scanner(System.in);
        System.out.println("enter 1 for thumb move and 2 for wrist move PLAYER 2");
        int move = s.nextInt();
        if (move == 1) {
            int store=thumb();
            user1=user1-store;
            System.out.println("                        ");
            System.out.println("*************************");
            System.out.println("User 1 your XP is "+user1);
            System.out.println("*************************");
            System.out.println();
        } else if (move == 2) {
            int store=wrist();
            user1=user1-store;
            System.out.println("                        ");
            System.out.println("*************************");
            System.out.println("User 1 your XP is "+user1);
            System.out.println("*************************");
            System.out.println();


        }
    }
    public  static int thumb(){
        int tand_thumb=(int)(Math.random()*(30-0+1)+0);
        return tand_thumb;
    }
    public  static int wrist(){
        int tand_wrist=(int)(Math.random()*(30-0+1)+0);
        return tand_wrist;
    }

    public static int toss(int x) {
        //Math.random() * (max - min + 1) + min
        int rand_toss = (int) (Math.random() * (1 - 0 + 1) + 0);
        System.out.println(rand_toss);
        if (rand_toss == x) {
            System.out.println("User1 has won the toss ");
            return 1;
        } else {
            System.out.println("User 2 Has won the toss");
            return 0;
        }

    }

    public static void whi_loop(int x) {
        while ((user1 >= 0) || (user2 >= 0)) {
            if (x == 1) {
                System.out.println("user1 turn");
                player1();
                player2();
                if (((user1 <= 0) || (user2 <= 0))){
                    break;
                }
                continue;


            } else if (x == 2) {
                System.out.println("User2 your choice");
                player2();
                player1();
                if (((user1 <= 0) || (user2 <= 0))){
                    break;
                }
                continue;

            }

        }


    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("**********************\n\t\tDiano game\n*******************");
        System.out.println();
        System.out.println("User 1 enter \"1) for heads\n\"2) for the tails");
        int to=s.nextInt();
        int value=toss(to);   // toss value is stored in value
        // if user1 win the toss then it means his turn and return 1
            if (value==1){
                System.out.println("For first turn enters 1\n for 2nd turn enters 2");
                int choice_user1=s.nextInt();
                if(choice_user1==1){
                    whi_loop(choice_user1);
                } else if (choice_user1==2) {
                    whi_loop(choice_user1);
                }
            }
            else if(value==0){
                System.out.println("FOR your first turn enter 2 users 2\n else enter 1");
                int choice_user1=s.nextInt();
                if(choice_user1==1){
                    whi_loop(choice_user1);
                } else if (choice_user1==2) {
                    whi_loop(choice_user1);
                }

            }

    }
}
