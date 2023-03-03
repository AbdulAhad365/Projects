import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
 class HostelManagementSystem {
     public static int rooms_available, private_room,friends,sr,count1=0;
     public static boolean x;
     public static void main(String[] args) throws IOException {
         int fin=0;
         while ((true)) {

             int again=0;     // for again
             System.out.println("\033[30m\033[41mSMART CITY PROJECT\033[0m");
             System.out.println("\033[36mFOLLOWING ARE THE FUNCTIONS OF MY PROJECT:\033[0m");

             Scanner s = new Scanner(System.in);

             int tourist=0;
             gui();

             System.out.println("         \033[31m*\033[0m");
             System.out.println("         \033[31m******************************************************************************\033[0m");
             System.out.println("            \033[30m\033[44m1) '1' for Hotel reservation                                     \033[0m\n\n            \033[30m\033[44m2)'2' of Booking transport and visiting places                   \033[0m\n\n            \033[30m\033[44m3)'3' for Confirming your return Ticket                           \033[0m\n\n            \033[30m\033[44m4)Enter 4 for making a citizens list                               \033[0m\n\n            \033[30m\033[44m5) '5' for different companies employment opportunities\033[0m\n\n            \033[0m\033[30m\033[44m6) '6' for exit          \033[0m");
             System.out.println("         \033[31m******************************************************************************\033[0m");
             do {


                 try {
                     Scanner sc=new Scanner(System.in);
                     tourist = sc.nextInt();
                     if ((tourist>=1)&&(tourist<=6)){
                         break;
                     }
                     System.out.println("try again");

                 } catch (Exception e) {
                     System.out.println(e);
                     System.out.println("enter again");
                 }
             }while ((tourist<1)||(tourist>6));


             if (tourist == 1) {
                 setRooms_available(tourist);
             } else if (tourist==2) {
                 transport();
             } else if (tourist==3) {
                 return_ticket();
             }
             else if (tourist==4){
                 try {
                     citizen_module();
                 } catch (FileNotFoundException e) {
                     throw new RuntimeException(e);
                 }
             }
             else if (tourist==5){
                 employment_opportunity();
             }
             else if (tourist==6){
                 fin=1;
                 final_gui();
                 System.out.println("*************");
                 System.out.println("GOOD BYE");
                 System.out.println("*************");
                 break;

             }

             System.out.println("Do you want to play again if so enter 1");

             again=-4;
             do {


                 try {
                     Scanner sc=new Scanner(System.in);
                     again = sc.nextInt();
                     if(again>=0){
                         break;
                     }
                 } catch (Exception e) {
                     System.out.println(e);
                     System.out.println("enter again");
                 }
             }while ((again<0));

             // for again
             if(again==1){
                 continue;
             }
             else {
                 System.out.print("Have a nice trip");
                 final_gui();
                 break;

             }


         }//                                    for while
     }
     public static void setRooms_available(int tourist) {
         String valid = "start";
         Scanner s = new Scanner(System.in);
         String rooms = "closed";
         if (tourist == 1) {
             switch (tourist) {
                 case 1:
                     while (valid.equals("start")) {

                         int hotel_reservation;
                         if (rooms.equals("e")) {   // Will be entered when we have to decide numbers of rooms in a certain hostel


                             System.out.println("\033[30m\033[41m\"The number of rooms available are: \033[0m"+ rooms_available +"\n");
                             // percentage for the number availability
                             int room_02 = (int) (rooms_available * 0.30);
                             int room_03 = (int) (rooms_available * 0.50);
                             int room_04 = (int) (rooms_available * 0.20);
                             int net_rooms = room_02 + room_03 + room_04;

                             if (net_rooms < rooms_available) {
                                 private_room = rooms_available - net_rooms;
                                 System.out.println("           \033[33m*******************************************************\033[0m");
                                 System.out.println("           \033[30m\033[42mSince the private rooms are \033[0m"+ private_room+"\n" );
                             }
                             System.out.println("           \033[30m\033[42mSo 2 seated rooms are \033[0m"+ room_02+"\n" );
                             System.out.println("           \033[30m\033[42mSo 3 seated rooms are \033[0m"+ room_03+"\n" );
                             System.out.println("           \033[30m\033[42mSo 4 seated rooms are \033[0m"+ room_04+"\n" );
                             System.out.println("           \033[33m*******************************************************\033[0m");



                             System.out.println();

                             System.out.println("\033[36mEnter following commands for the registration:\033[0m");
                             System.out.println("         \033[31m******************************************************************************\033[0m");
                             System.out.println("            \033[30m\033[44m1) '1' For the private room                                     \033[0m\n\n            \033[30m\033[44m2)'2' for 2 seated rooms                   \033[0m\n\n            \033[30m\033[44m3)'3' for 3 seated rooms\033[0m            \033[30m\033[44m3)'4' for 4 sited rooms\033[0m");
                             System.out.println("         \033[31m******************************************************************************\033[0m");
                             int rooms_validation=0;
                             do {


                                 try {
                                     Scanner sc=new Scanner(System.in);
                                     rooms_validation = sc.nextInt();
                                     if (((rooms_validation>=1)&&(rooms_validation<=4))){
                                         break;
                                     }

                                 } catch (Exception e) {
                                     System.out.println(e);
                                     System.out.println("Try again");
                                 }
                             }while ((rooms_validation<1)||(rooms_validation>4));
                             if ((rooms_validation == 2) || (rooms_validation == 3) || (rooms_validation == 4) || (rooms_validation == 1)) {

                                 if (rooms_validation == 1) {
                                     x = false;

                                     int[] private_r = new int[private_room];
                                     for (int i = 0; private_room > i; i++) {
                                         int new_value = (int) (Math.random() * 20);
                                         private_r[i] = new_value;
                                         for (int j = 0; i > j; j++) {
                                             if (private_r[i] == private_r[j]) {
                                                 x = true;
                                             }
                                         }
                                         if (x == true) {
                                             i = i - 1;
                                         }
                                     }
                                     for (int i = 0; private_room > i; i++) {
                                         System.out.print("Which room do you want to register:  ");

                                         System.out.print(private_r[i] + "");
                                         int room_reg=s.nextInt();
                                          if (private_r[i]==room_reg){
                                              System.out.print("*********   Room has been registered **************");
                                          }
                                          else {
                                              System.out.println("Invalid number entered");
                                          }
                                     }


                                 }
                                 else if (rooms_validation == 2) {

                                     x = false;

                                     int[] room2_r = new int[room_02];
                                     for (int i = 0; room_02 > i; i++) {
                                         int new_value = (int) ((Math.random() * 35) + 11);
                                         room2_r[i] = new_value;

                                         for (int j = 0; i > j; j++) {
                                             if (room2_r[i] == room2_r[j]) {
                                                 x = true;
                                             }
                                         }
                                         if (x == true) {
                                             i = i - 1;
                                         }
                                     }
                                     for (int i = 0; room_02 > i; i++) {
                                         System.out.print(room2_r[i] + "  ");
                                     }
                                     System.out.print("Enter the room number for registeration:");
                                     //room

                                     int room_num =0;

                        //Exceptional handling
                                     do {


                                         try {
                                             Scanner sc=new Scanner(System.in);
                                             room_num = sc.nextInt();
                                             break;
                                         } catch (Exception e) {
                                             System.out.println(e);
                                             System.out.println("Try again");
                                         }
                                     }while((room_num>=0));


                                     for (int i = 0; room_02 > i; i++) {
                                         if (room2_r[i] == room_num) {
                                             System.out.println("Your room number:" + room_num + " has been registered");
                                             return;
                                         }



                                     }
                                     

                                    /*
                                    Now we will proceed for the 3 seated rooms registeration
                                     */


                                 } else if (rooms_validation == 3) {
                                     x = false;

                                     int[] room3_r = new int[room_03];
                                     for (int i = 0; room_03 > i; i++) {
                                         int new_value = (int) ((Math.random() * 70) + 0);
                                         room3_r[i] = new_value;

                                         for (int j = 0; i > j; j++) {
                                             if (room3_r[i] == room3_r[j]) {
                                                 x = true;
                                             }
                                         }
                                         if (x == true) {
                                             i = i - 1;
                                         }
                                     }
                                     for (int i = 0; room_03 > i; i++) {
                                         System.out.print(room3_r[i] + "  ");
                                     }
                                     System.out.println("Enter the room number for registeration:");
                                     int room_num = 0;
                                     //exceptional handling
                                     do {


                                         try {
                                             Scanner sc=new Scanner(System.in);
                                             room_num = sc.nextInt();
                                             break;
                                         } catch (Exception e) {
                                             System.out.println(e);
                                             System.out.println("Try again");
                                         }
                                     }while((room_num>=0));


                                     for (int i = 0; room_03 > i; i++) {
                                         if (room3_r[i] == room_num) {
                                             System.out.println("Your room number:" + room_num + " has been registered");
                                             return;
                                         }
                                     }
                                     System.out.print("Room not available");
                                 } else if (rooms_validation == 4) {

                                     x = false;

                                     int[] room4_r = new int[room_04];
                                     for (int i = 0; room_04 > i; i++) {
                                         int new_value = (int) ((Math.random() * 100) + 0);
                                         room4_r[i] = new_value;
                                         for (int j = 0; i > j; j++) {
                                             if (room4_r[i] == room4_r[j]) {
                                                 x = true;
                                             }
                                         }
                                         if (x == true) {
                                             i = i - 1;
                                         }
                                     }
                                     for (int i = 0; room_04 > i; i++) {
                                         System.out.print(room4_r[i] + "  ");
                                     }
                                     System.out.println("Enter the room number for registeration:");
                                     //Exceptional handling
                                     int room_num =0;
                                     do {


                                         try {
                                             Scanner sc=new Scanner(System.in);
                                             room_num = sc.nextInt();
                                             break;
                                         } catch (Exception e) {
                                             System.out.println(e);
                                             System.out.println("Try again");
                                         }
                                     }while((room_num>=0)||(room_num<0));
                                     //..........

                                     for (int i = 0; room_04 > i; i++) {
                                         if (room4_r[i] == room_num) {
                                             System.out.println("Your room number:" + room_num + " has been registered");
                                             return;
                                         }
                                     }
                                     System.out.println("Room not available");
                                 } else {

                                 }
                             } else {
                                 System.out.println("You entered Invalid number " + rooms_validation);
                             }
                             break;
                         }
                         System.out.println("\033[30m\033[41mFollowing are some hotels catagery:\033[0m");

                         System.out.println("         \033[31m******************************************************************************\033[0m");
                         System.out.println("            \033[30m\033[44m1) '1' for the 5 star                                    \033[0m\n\n            \033[30m\033[44m2) '2' for the 4 star                   \033[0m\n\n            \033[30m\033[44m3) '3' for the 3 star \033[0m");
                         System.out.println("         \033[31m******************************************************************************\033[0m");

                         System.out.println();
                         int user =-7;
                         //exceptional handling
                         do {


                             try {
                                 Scanner sc=new Scanner(System.in);
                                 user = sc.nextInt();
                                 if ((user>=1)&&(user<=3)){
                                     break;
                                 }
                                 System.out.println("try again 1-3");

                             } catch (Exception e) {
                                 System.out.println(e);
                                 System.out.println("Try again");
                             }
                         }while((user<1)||(user>3));


                         switch (user) {

                             case 1:
                                 System.out.println("\033[36mYou choosed 5 star:\033[0m");
                                 System.out.println("         \033[31m******************************************************************************\033[0m");
                                 System.out.println("            \033[30m\033[44m1) Royal Motel Guest House (0)                                    \033[0m\n\n            \033[30m\033[44m2) Empire Hotel (1)                   \033[0m\n\n            \033[30m\033[44m3) The 108 Hotel (2) \033[0m");
                                 System.out.println("         \033[31m******************************************************************************\033[0m");

                                 //Making an storing array:
                                 System.out.println("Given respective number for reservation");
                                 String[] hotel = {"Royal Motel Guest House", "Empire Hotel", "The 108 Hotel"};

                                 //Exceptional handling
                                 hotel_reservation =-9;
                                 do {


                                     try {
                                         Scanner sc=new Scanner(System.in);
                                         hotel_reservation = sc.nextInt();
                                         if ((hotel_reservation>=0)&&(hotel_reservation<=2)){
                                             break;
                                         }
                                         System.out.println("try again 0-2");
                                     } catch (Exception e) {
                                         System.out.println(e);
                                         System.out.println("Try again");
                                     }
                                 }while((hotel_reservation<0)||(hotel_reservation>2));
                                 if ((hotel_reservation == 0) || (hotel_reservation == 1) || (hotel_reservation == 2)) {
                                     System.out.println("You choose the hotel " + hotel[hotel_reservation]);
                                     rooms_available = (int) (Math.random() * 31);
                                     if (rooms_available == 0) {        //No room available
                                         System.out.println("Sorry no rooms available are: " + rooms_available);
                                         valid = "end";
                                     } else {
                                         rooms = "e";
                                         continue;

                                     }
                                 } else {
                                     System.out.println("Invalid value given");
                                     valid = "Stop";
                                     break;
                                 }
                                 break;
                             case 2:
                                 System.out.println("\033[36mYou choosed 4 star:\033[0m");

                                 System.out.println("         \033[31m******************************************************************************\033[0m");
                                 System.out.println("            \033[30m\033[44m1) Legend Hotel Islamabad 4 stars (0)                                    \033[0m\n\n            \033[30m\033[44m2) Ramada by Wyndham Islamabad  (1)           \033[0m\n\n            \033[30m\033[44m3) Al-khalid hotel  (2)    \033[0m");
                                 System.out.println("         \033[31m******************************************************************************\033[0m");

                                 //Making an storing array:
                                 System.out.println("Given respective number for reservation");
                                 String[] hotel_4_star = {"Legend Hotel Islamabad", "Ramada by Wyndham Islamabad", "Al-khalid hotel "};

                                 //Exceptional handling
                                 hotel_reservation =-7;
                                 do {


                                     try {
                                         Scanner sc=new Scanner(System.in);
                                         hotel_reservation = sc.nextInt();
                                         if ((hotel_reservation>=0)&& (hotel_reservation<=2)){
                                             break;
                                         }
                                         System.out.println("try again (0-2)");
                                     } catch (Exception e) {
                                         System.out.println(e);
                                         System.out.println("Try again");
                                     }
                                 }while((hotel_reservation<0)||(hotel_reservation>2));

                                 if ((hotel_reservation == 0) || (hotel_reservation == 1) || (hotel_reservation == 2)) {
                                     System.out.println("You choose the hotel " + hotel_4_star[hotel_reservation]);
                                     rooms_available = (int) (Math.random() * 31);
                                     if (rooms_available == 0) {        //No room available
                                         System.out.println("Sorry no rooms available are: " + rooms_available);
                                         valid = "end";
                                     } else {
                                         rooms = "e";
                                         continue;

                                     }
                                 } else {
                                     System.out.println("Invalid value given");
                                     valid = "Stop";
                                     break;
                                 }
                                 break;

                             case 3:
                                 System.out.println("\033[36mYou choosed 3 star:\033[0m");

                                 System.out.println("         \033[31m******************************************************************************\033[0m");
                                 System.out.println("            \033[30m\033[44m1) Hotel Crown Plaza Islamabad (0)                            \033[0m\n\n            \033[30m\033[44m2) Roomy Signature Hotel Islamabad (1)                \033[0m\n\n            \033[30m\033[44m3) Hotel Margala(2)       \033[0m");
                                 System.out.println("         \033[31m******************************************************************************\033[0m");

                                 //1F3E8
                                 //Making an storing array:
                                 System.out.println("\033[30m\033[41mGiven respective number for reservation\033[0m");
                                 System.out.println("Given respective number for reservation");
                                 String[] hotel_3_star = {"Hotel Crown Plaza Islamabad", "Roomy Signature Hotel Islamabad", "Hotel Margala"};

                                 //Exceptional handling
                                 hotel_reservation =-6;
                                 do {


                                     try {
                                         Scanner sc=new Scanner(System.in);
                                         hotel_reservation = sc.nextInt();
                                         if (((hotel_reservation>=0)&&(hotel_reservation<=2))) {
                                             break;
                                         }
                                         System.out.println("enter num 0-2");
                                     } catch (Exception e) {
                                         System.out.println(e);
                                         System.out.println("Try again");
                                     }
                                 }while((hotel_reservation<0)||(hotel_reservation>2));

                                 if ((hotel_reservation == 0) || (hotel_reservation == 1) || (hotel_reservation == 2)) {
                                     System.out.println("You choose the hotel " + hotel_3_star[hotel_reservation]);
                                     rooms_available = (int) (Math.random() * 31);
                                     if (rooms_available == 0) {        //No room av
                                         System.out.println("Sorry no rooms available are: " + rooms_available);
                                         valid = "end";
                                     } else {
                                         rooms = "e";
                                         continue;

                                     }
                                 } else {
                                     System.out.println("Invalid value given");
                                     valid = "Stop";
                                     break;
                                 }


                                 break;
                             default:
                                 System.out.println("Invalid number");
                                 System.out.println("Last chance else will be no result:");
                                 System.out.println();
                                 System.out.println("**********************");
                                 System.out.println("(Following are some hotels catagery) Enter:\n1) '1' for the 5 star \n2) '2' for the 4 star\n3) '3' for the 3 star ");
                                 System.out.println();
                                 System.out.println("**********************");
                                 //Exceptional handling
                                 int user1 =0;
                                 do {


                                     try {
                                         Scanner sc=new Scanner(System.in);
                                         user1 = sc.nextInt();
                                         break;
                                     } catch (Exception e) {
                                         System.out.println(e);
                                         System.out.println("Try again");
                                     }
                                 }while((user1>=0)||(user1<0));
                                 //..........

                                 if ((user1 == 0) || (user1 == 1) || (user1 == 2)) {
                                     System.out.println("OKS ENTER AGAIN");

                                 } else
                                     valid = "error";
                                 break;
                         }// Switch case ends here
                     }//while ends here
             }
         }
     }//setroom

     public static void transport(){

         Scanner s=new Scanner(System.in);

         System.out.println("Buses will be available after \033[32m2 hour\033[0m  and will be available after \033[32m12 AM\033[0m\nFollowing are some places to visit enter following numbers:");
         System.out.println();
         System.out.println("           \033[33m*******************************************************\033[0m");
         System.out.println("           \033[30m\033[42m1)Damn-e-Koh\033[0m\n\n           \033[30m\033[42m2)Shah faisal mosque\033[0m\n\n           \033[30m\033[42m3)Rawal Lake\033[0m\n\n           \033[30m\033[42m4)Margala Lake\033[0m\n\n           \033[30m\033[42m5)Pakistan Monument\033[0m\n" );
         System.out.println("           \033[33m*******************************************************\033[0m");


         //Exceptional handling
         int places=0;
         if ((places<=0)||(places>5)){
             System.out.println("You entered wrong value");
             while ((places<=0)||(places>5)){
                 System.out.println("Enter the correct value");

                 do {


                     try {
                         Scanner sc=new Scanner(System.in);
                         places = sc.nextInt();
                         break;
                     } catch (Exception e) {
                         System.out.println(e);
                         System.out.println("Try again");
                     }
                 }while((places>=1)||(places<=5));

             }
         }
         System.out.println(places);
         System.out.println();
         System.out.println("           \033[33m*******************************************************\033[0m");
         System.out.println("           \033[30m\033[42mSo the bus timing are starting from 12am to 11pm with 24h service\033[0m\n\n\033[30m\033[42mBUSES WILL BE AFTER 1HOUR DURATION\033[0m\n\n\t\t\033[30m\033[42mEnter the time for ticket:\033[0m\n\n" );
         System.out.println("           \033[33m*******************************************************\033[0m");
         System.out.println();
         System.out.println("**********************");
         System.out.println("\033[30m\033[41mEnter the hours 1-22");

         //Exceptional handling
         int time =0;
         do {


             try {
                 Scanner sc=new Scanner(System.in);
                 time = sc.nextInt();
                 if((time>=0)&&(time<=22)){
                 break;}
                 System.out.println("enter 1-22h");
             } catch (Exception e) {
                 System.out.println(e);
                 System.out.println("Try again");
             }
         }while((time<0)||(time>22));
         System.out.println("Enter the mintues");
         System.out.println("0-120");
         int min ;
         //Exceptional handling
         min =0;
         do {


             try {
                 Scanner sc=new Scanner(System.in);
                 min = sc.nextInt();
                 if ((min>=0)&&(min<=120)){
                     break;
                 }

             } catch (Exception e) {
                 System.out.println(e);
                 System.out.println("Try again");
             }
         }while((min<0)||(min>120));
         int min_value = (int) min / 60;
         int net_time = min_value + time;
         System.out.println();
         System.out.println("**********************");
         System.out.println("The booking time will be close to " + net_time + "hrs");
         System.out.println("Enter \"am\" or \"pm\" for respective time");
         System.out.println();
         System.out.println("**********************");
         String period = s.next();
         int r=0;
         if ((!period.equals("am"))||(!period.equals("pm"))) {
             while (((!period.equals("am"))&&(!period.equals("pm")))){
                 System.out.println("enter value again \"am\" or \"pm\"");
                 period=s.next();
                 System.out.println(r++);
             }
         }
         if ((period.equals("am") || (period.equals("pm")))) {
             for (int i = 0; i <= 24; i++) {
                 if (i == net_time) {
                     int petrol_price = (int) ((Math.random() * 250) + 200);
                     int l_Damn_koh = 7;
                     int l_faisal = 4;
                     int l_rawal_lake = 8;
                     int l_margala = 9;
                     int l_Pakistan_moment = 6;
                     int t_Damn_koh, t_faisal, t_rawal, t_margala, t_pakistanMOMENT;
                     switch (places) {
                         case 1:
                             t_Damn_koh = l_Damn_koh * petrol_price;
                             System.out.println("Your ticket price is " + t_Damn_koh + " for " + "Damn_e_koh");
                             break;
                         case 2:
                             t_faisal = l_faisal * petrol_price;
                             System.out.println("Your ticket price is " + t_faisal + " for " + "faisal mosque");
                             break;
                         case 3:
                             t_rawal = l_rawal_lake * petrol_price;
                             System.out.println("Your ticket price is " + t_rawal + " for " + "rawal dam");
                             break;
                         case 4:
                             t_margala = l_margala * petrol_price;
                             System.out.println("Your ticket price is " + t_margala + " for " + "margala");
                             break;
                         case 5:
                             t_pakistanMOMENT = l_Pakistan_moment * petrol_price;
                             System.out.println("Your ticket price is " + t_pakistanMOMENT + " for " + "Pakistan moment");
                             break;
                         default:
                             System.out.println("No Value");
                     }
                     System.out.println("Enter 1 for the confirming ticket");
                     System.out.println("Enter press 2 for Cancel");
                     int user ;

                     //Exceptional handling
                     user =0;
                     do {


                         try {
                             Scanner sc=new Scanner(System.in);
                             user = sc.nextInt();
                             break;
                         } catch (Exception e) {
                             System.out.println(e);
                             System.out.println("Try again");
                         }
                     }while((user>=0)||(user<0));
                     //.........
                     if (user == 1) {
                         System.out.println("Your ticket has been confirmed");
                         break;
                     } else if (user==2) {
                         continue;
                     }
                 }
             }
             System.out.println("Good bye");
         }
         else {
             System.out.println("Wrong value");
         }

         return;

     }
     public static void return_ticket(){
         Scanner s=new Scanner(System.in);
         long cnic = (int) ((Math.random() * 999999999) + 000000000);
         System.out.println();

         System.out.println("**********************");
         System.out.println("\033[30m\033[47m");
         System.out.println("Program for the verification of the person identity:" + cnic);

         System.out.println("Enter your CNIC number:");
         System.out.println();
         System.out.println("**********************");
         long cnic_store ;





       /*  Console console = System.console();
         cnic= 1;
         String password = "";
         if (console == null)
         {
             System.out.print("Enter username: ");
             cnic_store = s.nextInt();
             System.out.print("Enter password: ");
             password = s.nextInt();
         }
         else
         {
             username = console.readLine("Enter username: ");
             user_password = new String(console.readPassword("Enter password: "));
         }
         System.out.println("Username: " + user_password);
         System.out.println("Password: " + password);

         */





         //Exceptional handling
         cnic_store =0;
         do {


             try {
                 Scanner sc=new Scanner(System.in);
                 cnic_store = sc.nextInt();
                 if (cnic==cnic_store){
                    break;
                 }

             } catch (Exception e) {
                 System.out.println(e);
                 System.out.println("Try again");
             }
         }while((cnic_store!=cnic));

         if (cnic == cnic_store) {
             String[] names = {"khalid", "ahmad", "ali", "hashim", "rida", "saira"};
             int lengh_array = names.length;
             System.out.println(lengh_array);
             int orignal_num = lengh_array - 1;
             int rand_for_name = (int) ((Math.random() * orignal_num) + 0);
             System.out.println();
             System.out.println("**********************");
             String store_name = names[rand_for_name];
             System.out.println("Welcome " + store_name + " ");
             int rand_password = (int) ((Math.random() * 9999) + 0000);
             System.out.println(rand_password);
             System.out.println("Enter the desired password 4 digits");
             System.out.println();
             System.out.println("**********************");
             int user_password ;
             //Exceptional handling
             user_password =0;
             do {


                 try {
                     Scanner sc=new Scanner(System.in);
                     user_password = sc.nextInt();
                     if ((user_password==rand_password)) {
                         break;
                     }
                 } catch (Exception e) {
                     System.out.println(e);
                     System.out.println("Try again");
                 }
             }while((user_password!=rand_password));


             if (rand_password == user_password) {
                 int rand_money = (int) ((Math.random() * 100000000) + 1000000);
                 int number = 5;
                 int value_submit = 1;
                 System.out.println();
                 System.out.println("**********************");
                 System.out.println("Enter your name");
                 System.out.println("Hope that you have a good trip:\n Enter your response:");
                 System.out.println();
                 System.out.println("**********************");
                 for (int i = 0; number >= i; i++) {
                     System.out.print(value_submit + ")");
                     for (int j = 0; i > j; j++) {
                         System.out.print("*");
                     }
                     value_submit = value_submit + 1;
                     System.out.println();
                 }
                 int user_submit ;
                 //Exceptional handling
                 user_submit =0;
                 do {


                     try {
                         Scanner sc=new Scanner(System.in);
                         user_submit = sc.nextInt();
                         if ((user_submit>=0)&&(user_submit<=6)){

                         }
                         else {
                             while ((!(user_submit>=0)||!(user_submit<=6))) {
                                 System.out.println();
                                 System.out.println("**********************");
                                 System.out.println("enter b/w 1 to 6");
                                 System.out.println();
                                 System.out.println("**********************");
                                 user_submit = s.nextInt();
                             }


                         }
                         System.out.println("Ok! Your Response have been submitted");
                         break;
                     } catch (Exception e) {
                         System.out.println(e);
                         System.out.println("Try again");
                         System.out.println("Invalid value entered");
                     }
                 }while((user_submit>=0)||(user_submit<=6));
                 System.out.println();
                 System.out.println("**********************");
                 System.out.println("Enter your country name:");
                 System.out.println();
                 System.out.println("**********************");
                 String[] countryies = {"Austrailia", "Egypt", "France", "Neitherland","America","Germany","Scoutland"};
                 System.out.println("Enter a value from 0 to 6");

                 for  (int i = 0; i < countryies.length; i++) {
                     System.out.print(i + ")");
                     System.out.print(countryies[i] + " ");
                     System.out.println();
                 }
                 int val=-4;

                 do {


                     try {
                         Scanner sc=new Scanner(System.in);
                         val = sc.nextInt();
                         if ((val>=0)&&(val<=6)) {
                             break;
                         }
                     } catch (Exception e) {
                         System.out.println(e);
                         System.out.println("Try again");
                     }
                 }while((val<=0)||(val>=6));
                 System.out.println("Enter 1 for confirming ticket for "+countryies[val]);


                 int ticket_amount = (int) ((Math.random() * 1000000) + 100000);
                 System.out.println("Your Ticket amount is: " + ticket_amount);
                 System.out.println();
                 System.out.println("**********************");
                 System.out.println("Enter '1' for confirming payment\n'2' to decline ");
                 System.out.println("Your Account limit is " + rand_money);
                 System.out.println();
                 System.out.println("**********************");
                 int amount ;
                 //Exceptional handling
                 amount =0;
                 do {


                     try {
                         Scanner sc=new Scanner(System.in);
                         amount = sc.nextInt();
                         break;
                     } catch (Exception e) {
                         System.out.println(e);
                         System.out.println("Try again");
                     }
                 }while((amount>=0)||(amount<0));

                 if (amount == 1) {
                     if (ticket_amount <= rand_money) {
                         System.out.print("Your seat have been confirmed");
                     }
                     return;
                 }
             }
         }

     }
     public static void store_date_in_file(String name,int childs,String countryies){

         sr++;
         try {
             FileWriter fileWriter = new FileWriter("store_data_of_user.txt");
             BufferedWriter bw=new BufferedWriter(fileWriter);

             bw.write(sr+"     "+name+"      "+childs+"      "+countryies+"\n" );
             bw.close();
         } catch (IOException e) {
             throw new RuntimeException(e);
         }


     }
     public static void make_file(String name[],String children[],String country[],int ff,String username[],String password[]) {
             // for making a file
             File file = new File("ok.txt");
             // for counting

             count1++;
             try {
                 file.createNewFile();
             } catch (IOException e) {
                 System.out.println(e);
                 System.out.println("");
                 throw new RuntimeException(e);
             }


             // TYPE WRITING OF THE FILE
             try {
                 FileWriter fileWriter = new FileWriter("ok.txt",true);
                 BufferedWriter bw=new BufferedWriter(fileWriter);

                 if (count1<=1);{
                     bw.write("Sr.no     Father name      No of Sons      country_name      Username      Password+\n" );
                 }

                 for (int i=0;i<name.length;i++){
                     sr++;
                     bw.append("\u2022"+"          "+name[i]+"               "+children[i]+"                  "+country[i]+"                  "+username[i]+"                  "+password[i]+"\n");

                 }
                 bw.write("\n\n");
                 bw.close();


             } catch (IOException e) {
                 throw new RuntimeException(e);
             }
             //display
             //for priting the value in the file
             File hi=new File("ok.txt");
             System.out.println();
         Scanner w= null;
         try {
             w = new Scanner(hi);
         } catch (FileNotFoundException e) {
             throw new RuntimeException(e);
         }

         while (w.hasNextLine()) {
                 String rf = w.nextLine();
                 System.out.println(rf);
             }
             w.close();





     }
     public static void parent_to_child(int foreign_friends) {

         String name[]=new String[foreign_friends];
         String children[]=new String[foreign_friends];
         String countries[]=new String[foreign_friends];
         String password[]=new String[foreign_friends];
         String username[]=new String[foreign_friends];
         int count = 0;
         friends++;
         Scanner s = new Scanner(System.in);

         for (int i=0;i<name.length;i++){
             ++count;
             System.out.println();
             System.out.println("*******************");
             System.out.println("Enter the information of the user " + count);
             name[i]=s.next();
             System.out.println();
             System.out.println("*******************");
         }
         count=0;

         for (int i=0;i<children.length;i++){
             ++count;
             System.out.println();
             System.out.println("*******************");
             System.out.println("Whats your friends son names respectively" + count);
             String x=s.next();
             children[i]=x;
             try {
                 int a = Integer.valueOf(x);
             }
             catch (Exception e){
                 System.out.println(e);
                 System.out.println("You entered a string type");
                 i--;
                 count--;
                 continue;

             }



             System.out.println();
             System.out.println("*******************");
             }

         System.out.println("you were a citizen of ");
         String[] countryies = {"Austrailia", "Egypt", "France", "Neitherland","America","Germany","Scoutland"};

         for  (int i = 0; i < countryies.length; i++) {
             System.out.print(i + ")");
             System.out.print(countryies[i] + " ");
             System.out.println();
         }
         count=0;

         for (int i=0;i<countries.length;i++){
             count++;
             System.out.println("Country name choose (0-6)");
             System.out.println("user "+count);
             int y=-7;

             do {


                 try {
                     Scanner sc=new Scanner(System.in);
                     y=sc.nextInt();
                     System.out.println("try again");
                     if ((y>=0)&&(y<=6)) {
                         break;
                     }

                 } catch (Exception e) {
                     System.out.println(e);
                     System.out.println("Try again (0-6)");

                 }

             }while((y<=0)||(y>=5));
             countries[i]=countryies[y];

                 }
         // for user name
         int pass=(int)(Math.random()*99999-9+1)+9;
         for (int i=0;i< username.length;i++){
             username[i]=name[i]+pass;
         }
         System.out.println("Set a password for you of 4 digits(1111-9999)");
         int give_pass=-4;
         do {


             try {
                 Scanner sc=new Scanner(System.in);
                 give_pass=sc.nextInt();
                 System.out.println("Another chance choose 4 digit");
                 if ((give_pass>=1111)&&(give_pass<=9999)){
                     break;
                 }

             } catch (Exception e) {
                 System.out.println(e);
                 System.out.println("Try again (1111-9999)");

             }

         }while((give_pass<=1111)||(give_pass>=9999));
         for (int i=0;i<password.length;i++){
             password[i]= String.valueOf(give_pass);
         }



         make_file(name,children,countries,foreign_friends,username,password);
         }


     public static void display_employment(String companies[],int seats_reserved[],String date[]){

         File file=new File("stor.txt");
         try {
             file.createNewFile();
         } catch (IOException e) {
             throw new RuntimeException(e);
         }

         FileWriter fileWriter= null;
         try {
             fileWriter = new FileWriter("stor.txt");
             fileWriter.write("SR."+"      "+"Companies"+"              "+"Seats reserved"+"                "+"Date_to_apply"+"\n");


             for (int i=0;i<companies.length;i++){
                 fileWriter.write(i+1+")"+"      "+companies[i]+"              "+seats_reserved[i]+"               "+date[i]+"\n");

             }
             fileWriter.close();
         } catch (IOException e) {
             throw new RuntimeException(e);
         }




     }
     public static void employment_opportunity() throws IOException {
         Scanner s=new Scanner(System.in);
         System.out.println("\033[30m\033[47m");
         String[] companies = {"AA Group of Company   ", "Nestle Pakistan Ltd.    ", "Pakistan Tobacco Company", "Ltd. Mari Petroleum  ", " Pakistan Petroleum Ltd.","Mobilink Mobile Company","Coca-Cola drink Company","Engro Corporation    ","Standard Chartered      ","Fauji Fertiliser Comapny"};
         int [] seats_reserved=new int[companies.length];
         for (int i=0;i<seats_reserved.length;i++){
             seats_reserved[i]=(int)(Math.random()*(100-1+1)+1);
         }
         Date thisdate=new Date();
         SimpleDateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy");
         System.out.println(dateFormat.format(thisdate));
         String [] date=new String[seats_reserved.length];
         for (int i=0;i<date.length;i++){
             int date_to_print=(int)(Math.random()*(28-1+1)+1);
             int month;
             if (date_to_print<9){
                 month=(int)(Math.random()*(12-2+1)+2);
             }
             month=(int)(Math.random()*(12-1+1)+1);
             int year=(int)(Math.random()*(2024-2023+1)+2023);
             date[i]=date_to_print+"/"+month+"/"+year;
         }
         display_employment(companies,seats_reserved,date);
         System.out.println("What is your name user");
         String name=s.nextLine();
         System.out.println("Which company do you want to apply");


         for (int i=0;i<companies.length;i++){
             System.out.println(i+") "+companies[i]);
         }
         System.out.println("\n\n");
         int get_value=-3;

         do {


             try {
                 Scanner sc=new Scanner(System.in);
                 get_value=sc.nextInt();

                 if ((get_value>=0)&&(get_value<=9)) {
                     break;
                 }System.out.println("try again");

             } catch (Exception e) {
                 System.out.println(e);
                 System.out.println("Try again (0-9)");

             }
             System.out.println("\033[0m");

         }while((get_value<0)||(get_value>9));
         String user_information=companies[get_value];
         System.out.println(user_information);
         store_companies_information(name,user_information,thisdate);




     }
     public static void store_companies_information(String name,String user_info,Date store) throws IOException{
         Scanner s=new Scanner(System.in);
         File f=new File("companies.txt");
         System.out.println();
         try {
             f.createNewFile();
         } catch (IOException e) {
             throw new RuntimeException(e);
         }
         try {
             FileWriter fileWriter=new FileWriter("companies.txt",true);
             fileWriter.write("\n");
             fileWriter.write("******************************************************************************\n");
             fileWriter.write("User name            Company name                                Date_to apply\n");
             fileWriter.write(name+"            "+user_info+"                                "+store+"\n");
             fileWriter.write("******************************************************************************\n\n");
             fileWriter.close();
         } catch (IOException e) {
             throw new RuntimeException(e);
         }
         System.out.println("If you want to print the value enter 1");
         int n=s.nextInt();
         if (n==1){
             File file = new File("companies.txt");

             BufferedReader reader = new BufferedReader(new FileReader(file));

             String line;
             while ((line = reader.readLine()) != null) {
                 System.out.println(line);
             }

             // Close the file
             reader.close();
         }
         else {
             return;
         }
     }
     public static void final_gui(){
         JFrame frame= new JFrame();
         Border border=BorderFactory.createLineBorder(Color.cyan,16);

         frame.setSize(1500,0);
         frame.setTitle("SMART CITY PROJECT");




         ImageIcon image=new ImageIcon("qw.png");
         frame.setIconImage(image.getImage());
         frame.setVisible(true);
         frame.getContentPane().setBackground(Color.cyan);


         JLabel label=new JLabel();
         label.setText("SAFE TRIP...");
         label.setIcon(image);
         label.setHorizontalTextPosition(JLabel.LEADING);
         label.setVerticalTextPosition(JLabel.TOP);

         frame.add(label);// to add data inside box
         label.setForeground(Color.RED);
         label.setFont(new Font("MV BOLI",Font.PLAIN,33));
         label.setBackground(Color.BLUE);
         label.setOpaque(true);
         label.setBorder(border);
         label.setVerticalAlignment(JLabel.CENTER);
         label.setHorizontalAlignment(JLabel.CENTER);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
     public static void gui(){
         JFrame frame= new JFrame();
         Border border=BorderFactory.createLineBorder(Color.magenta,6);

         frame.setSize(1500,70);
         frame.setTitle("SMART CITY PROJECT");

         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


         ImageIcon image=new ImageIcon("city.png");
         frame.setIconImage(image.getImage());
         frame.setVisible(true);
         frame.getContentPane().setBackground(Color.cyan);


         JLabel label=new JLabel();
         label.setText("HELLO WELCOME TO THE SMART CITY PROJECT");
         label.setIcon(image);
         label.setHorizontalTextPosition(JLabel.CENTER);
         label.setVerticalTextPosition(JLabel.TOP);

         frame.add(label);// to add data inside box
         label.setForeground(Color.RED);
         label.setFont(new Font("MV BOLI",Font.PLAIN,33));
         label.setBackground(Color.black);
         label.setOpaque(true);
         label.setBorder(border);
         label.setVerticalAlignment(JLabel.CENTER);
         label.setHorizontalAlignment(JLabel.CENTER);

     }
     public static void Admin_for_tourist_data() throws FileNotFoundException {
         File f=new File("ok.txt");
         Scanner s=new Scanner(f);
         Scanner se=new Scanner(System.in);
         int count=0;
         String a;

         System.out.println("enter your username");
         String ee=se.nextLine();
         System.out.println("password");
         String wq=se.nextLine();
         System.out.println("Sr.no     Father name      No of Sons      country_name        Username            password+\n");
         while (s.hasNextLine()) {

             a=s.nextLine();
             String arr[]=a.split(" ");
             int y=1;

             for (int i = 0; i < arr.length; i++) {

                 if (arr[i].equals(ee)){

                     System.out.println("********************");
                     y=0;
                 }
                 if (y==0){
                     if (arr[i].equals(wq)){
                         System.out.println(a);
                         System.out.println("*******************");
                         y=0;
                     }

                 }

             }
         }
     }
     public static void for_line(int st) throws IOException {
         File f=new File("ok.txt");
         Scanner s=new Scanner(f);
         Scanner se=new Scanner(System.in);
         int count=0;
         String a;

         System.out.println("enter a String");
         String ee=se.next();
         System.out.println("Sr.no     Father name      No of Sons      country_name+\n");
         while (s.hasNextLine()) {

             a=s.nextLine();
             String arr[]=a.split(" ");
             int y=1;
             count++;

             for (int i = 0; i < arr.length; i++) {

                 if (arr[i].equals(ee)){

                     System.out.println("*******************");
                     y=0;
                     System.out.println(count);
                     if (st==2){
                         delete(count);
                         break;
                     } else if (st==3) {

                     }


                 }
             }

         }

     }
     public static void delete(int count) throws IOException {
         int lineNumberToRemove = count;
         // File to be read and written
         File file = new File("ok.txt");
         // Temporary file
         File tempFile = new File("temp.txt");

         BufferedReader reader = new BufferedReader(new FileReader(file));
         PrintWriter writer = new PrintWriter(new FileWriter(tempFile));

         String currentLine;
         int currentLineNumber = count;
         while((currentLine = reader.readLine()) != null) {
             // Removing the line if it is the same as lineNumberToRemove
             if (currentLineNumber != lineNumberToRemove) {
                 writer.println(currentLine);
                 writer.flush();
             }
             currentLineNumber++;
         }
         writer.close();
         reader.close();

         // Delete the original file
         if (!file.delete()) {
             System.out.println("Could not delete file");
             return;
         }

         // Rename the temporary file to the original file's name
         if (!tempFile.renameTo(file))
             System.out.println("Could not rename file");

     }




     public static void citizen_module() throws IOException {
         Scanner s=new Scanner(System.in);
         System.out.println("         \033[31m******************************************************************************\033[0m");
         System.out.println("            \033[30m\033[44m1) 1' for citizen of foreign                                     \033[0m\n");
         System.out.println("         \033[31m******************************************************************************\033[0m");


         int citizen;

         citizen=-7;

         do {


             try {
                 Scanner sc=new Scanner(System.in);
                 citizen=sc.nextInt();
                 System.out.println("try again 1");
                 if ((citizen==1)){
                         break;
                     }

             } catch (Exception e) {
                 System.out.println(e);
                 System.out.println("Try again (1)");

             }

         }while((citizen<1)||(citizen>1));



         System.out.println("1) '1' for Admin(ACCESS ALL DATA)\n2) '2' for User\n '3' for Exit");
         int val=-4;
         do {

             try {
                 Scanner sc=new Scanner(System.in);
                 val=sc.nextInt();
                 if ((val>=1)&&(val<=3)){
                     break;
                 }

             } catch (Exception e) {
                 System.out.println(e);
                 System.out.println("Try again (1-3)");

             }

         }while((val<=1)||(val>=3));


         if ((citizen==1)&&(val==2)){

             System.out.println("Enter your foreign friends numbers including you");
             int foreign_friends = 0;

             //Exceptional handling
             do {


                 try {
                     Scanner sc=new Scanner(System.in);
                     foreign_friends = sc.nextInt();
                     break;
                 } catch (Exception e) {
                     System.out.println(e);
                     System.out.println("Try again");
                 }
             }while((foreign_friends>=0)||(foreign_friends<0));
             parent_to_child(foreign_friends);

         } else if ((val==1)) {
             System.out.println("Enter the login password");
             int pass=3434;
             System.out.println("Login password is "+pass);
             int user_pass=s.nextInt();
             if (user_pass==pass){
                 System.out.println("Enter '1' for Checking the data\nEnter '2' for exit");
                 int st=s.nextInt();
                 if(st==1){
                 Admin_for_tourist_data();
                 } else if (st==2) {
                     return;
                     
                 }


             }
             else {
                 while (user_pass!=pass){
                     System.out.println("enter password again\n2to exist");
                     user_pass=s.nextInt();
                     if(user_pass==pass){
                         System.out.println("Enter '1' for Checking the data\nEnter '2' for deleting the data\nEnter '3' for Editing a certain data");
                         int st=s.nextInt();
                         if(st==1){
                             Admin_for_tourist_data();
                         } else if (st==2) {

                         } else if (st==3) {

                         }


                         
                     }
                     else if(user_pass==2){
                         break;
                     }
                 }
             }
             

         } else {
             System.out.println("Enjoy your trip");
         }
     }
 }
 













