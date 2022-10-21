import java.io.FilterOutputStream;
import java.util.Random;
import java.util.Scanner;
class dinosaur_game {
    public static boolean store_toss;
    public static int fire, kick, foot;
    public static String num_1,num_2;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //Welcome to game
        int round = 0;
        System.out.println("****************\n\tWelcome to my world\n***************");
        System.out.println("Enter \"s\" for (Single player)\nEnter\"m\" for multiplayer");
        String type = s.next();
        String[] store = {"kick", "fire", "foot"};
        System.out.println("Following are the rules:\n\t1)Each player will be given 100Ep\n\tThree moves will be given fire,kick,foot\n\t3)Moves damages will be changes after each round\n\t4)Ignore case is there but spelling must be accurate else you will miss");
        int hp_user = 100;
        int hp_user2 = 100;

        boolean x = true;
        System.out.println("Enter o for the heads and 1 for the tail  user1");
        String position;
        while (x = true) {

            if (type.equalsIgnoreCase("s")) {
                //For single player
                while ((hp_user >= 0) || (hp_user2 >= 0)) {


                    System.out.println();
                    System.out.print("Enter your name user ");
                    String name = s.nextLine();
                    System.out.println("Enter '0' for kick\n '1'fire'\n'2'foot'");
                    int in_user = s.nextInt();
                    kick = (int) (Math.random() * 31);
                    fire = (int) (Math.random() * 31);
                    foot = (int) (Math.random() * 31);
                    while (x = true) {
                        switch (in_user) {
                            case 0:
                                hp_user = hp_user - kick;     // let me take user2 as 1 and assume it in my values and print the result
                                break;
                            case 1:
                                hp_user = hp_user - fire;
                                break;
                            case 2:
                                hp_user = hp_user - foot;
                                break;
                            default:
                                System.out.println("invalid statement");
                                break;
                        }
                        System.out.println("Computer your XP is " + hp_user);
                        System.out.println("*****************");
                        System.out.println();
                        if ((hp_user <= 0) || (hp_user2 <= 0)) {
                            System.out.println("Game over");
                            break;
                        }
                        // You  are playing with the computer allow me to take user1 as comp value
                        System.out.println("***************\nComputer turn");
                        System.out.println();
                        int random_num = (int) (Math.random() * 3);
                        position = store[random_num];
                        switch (random_num) {
                            case 0:
                                hp_user2 = hp_user2 - kick;     // let me take user2 as 1 and assume it in my values and print the result
                                break;
                            case 1:
                                hp_user2 = hp_user2 - fire;
                                break;
                            case 2:
                                hp_user2 = hp_user2 - foot;
                                break;
                            default:
                                System.out.println("invalid statement");
                                break;
                        }
                        System.out.println("User: " + name + " your XP is " + hp_user2);

                        round = round + 1;
                        System.out.println("Round " + round + " COMPLETED");
                        System.out.println();
                        if ((hp_user <= 0) || (hp_user2 <= 0)) {
                            System.out.println("GAME OVER");
                            x = false;
                            break;
                        }
                    }

                }
            }
            else if (type.equalsIgnoreCase("m")) {
                System.out.println("You choose playing the Multiplayer\n*************\n\t\tLets start");        //For multiplayer
                System.out.println("Choose your dinasour name user1,user2 by space");
                if ((hp_user <= 0) || (hp_user2 <= 0)) {
                    x = false;
                    break;
                }
                String name1 = s.nextLine();
                String name2 = s.nextLine();
                System.out.println("Name1:" + name1 + "nam2:" + name2);
                int toss = (int) ((Math.random() * 2) + 0);
                System.out.println("User1 enter 1 for heads and 0 for tails");
                int user1_toss = s.nextInt();

                if (user1_toss == toss) {
                    System.out.println("User1 u win the toss");
                    num_1 = name1;
                    num_2 = name2;
                    store_toss = true;
                    System.out.println(num_1 + "    " + num_2);
                } else if ((user1_toss == 1 && toss == 0) || (user1_toss == 0 && toss == 1)) {
                    System.out.println("User2 u win the toss ");
                    num_1 = name2;
                    num_2 = name1;
                    store_toss = false;
                    System.out.println(num_1 + "   " + num_2);
                } else {
                    System.out.println("Invalid value entered");
                    break;
                }

                while ((hp_user >= 0) || (hp_user2 >= 0)) {
                    System.out.println("Enter your move " + num_1);
                    System.out.println("Enter '0' for kick\n '1'fire'\n '2'foot'");
                    int no_1 = s.nextInt();
                    kick = (int) (Math.random() * 31);
                    fire = (int) (Math.random() * 31);
                    foot = (int) (Math.random() * 31);
                    switch (no_1) {
                        case 0:
                            hp_user2 = hp_user2 - kick;

                            break;
                        case 1:
                            hp_user2 = hp_user2 - fire;
                            break;
                        case 2:
                            hp_user2 = hp_user2 - foot;
                            break;
                        default:
                            System.out.println("invalid statement");
                            break;
                    }
                    System.out.println("User " + num_2 + " your  xp is '" + hp_user2 + "'");

                    System.out.println("Enter your move " + num_1);
                    System.out.println("Enter '0' for kick\n '1'fire'\n '2'foot'");
                    int no_2 = s.nextInt();
                    kick = (int) (Math.random() * 31);
                    fire = (int) (Math.random() * 31);
                    foot = (int) (Math.random() * 31);
                    switch (no_2) {
                        case 0:
                            hp_user = hp_user - kick;
                            break;
                        case 1:
                            hp_user = hp_user - fire;
                            break;
                        case 2:
                            hp_user = hp_user - foot;
                            break;
                        default:
                            System.out.println("invalid statement");
                            break;
                    }
                    System.out.println("User " + num_1 + " your xp is '" + hp_user + "'");
                    round = round + 1;
                    System.out.println("**************************");
                    System.out.println();
                    System.out.println("Round " + round + " Completed ");
                    System.out.println();
                    System.out.println("**************************");
                    if ((hp_user <= 0) || (hp_user2 <= 0)) {
                        x = false;
                        break;
                    }
                    if (hp_user > hp_user2) {
                        System.out.println(num_1 + " you have won the game");
                    }
                    if (hp_user2 > hp_user) {
                        System.out.println(num_2 + "you have won the game");
                    }


                }

            } else {
                System.out.println();
                System.out.println("************************");
                System.out.println("You entered wrong Value");
                System.out.println("Last Chance else will be\n**************\n\t\tG A M E   O V E R");
                System.out.println("Enter \"s\" for (Single player)\nEnter\"m\" for multiplayer");
                if ((type.equalsIgnoreCase("s")) || (type.equalsIgnoreCase("m"))) {
                    continue;
                } else {
                    System.out.println("G A M E   O V E R");
                    break;
                }
            }

        }
        if (type.equalsIgnoreCase("m")){
            if (hp_user > hp_user2) {
                System.out.println(num_1 + " you have won the game");
            }
            if (hp_user2 > hp_user) {
                System.out.println(num_2 + "you have won the game");
            }
        }
        }
    }

