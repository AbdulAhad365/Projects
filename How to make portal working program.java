

import java.util.Scanner;
import java.util.Calendar;

class Scratch {
    static int year_valu, month_value, semester;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter your session in for of the \nsp or fa");
        String session = s.next();   //For getting single word

        session = session.toLowerCase();
        System.out.println(session);      //For converting it into the lower case

        System.out.println("Enter your year of registeration");
        int reg_year;
        reg_year = s.nextInt();

        //For getting the year in the calender
        Calendar cal = Calendar.getInstance();
        // For calculating the year and the difference between them...
        System.out.println("Year is " + cal.get(Calendar.YEAR));
        int current_year = cal.get(Calendar.YEAR);
        int year_passed = current_year - reg_year;    //        years u passed
        // For oking the check conditions
        int year_value;
        year_value = current_year;

        int current_Month = cal.get(Calendar.MONTH) + 1;
        System.out.println("The current month is " + current_Month);


        //For calculating the month.
        // since spring ==02 to <9
        // Since the value of the Fall is =9 and <=12

        if ((session.equals("sp") || session.equals("fa")) && ((year_passed >= 0) && (year_passed <= 6))) {
            if ((year_passed >= 0) && (year_passed <= 6)) {
                if ((current_Month >= 2) && (current_Month < 9)) {
                    // Since the semester ends at exact 1 of feb
                    // This is spring session
                    int spring = 2;
                    month_value = current_Month - spring;
                    year_valu = year_passed;
                    System.out.println("SO the YEARS U PASSED ARE \nYears=" + year_valu + "\n" + "months=" + month_value);
                }

                if ((current_Month >= 9) && (current_Month <= 12)) {
                    int fall = 9;
                    month_value = current_Month - fall;  //from 9 to 12
                    year_valu = year_passed;
                    System.out.println("SO the YEARS U PASSED ARE \nYears=" + year_valu + "\n" + "months=" + month_value);
                } else if ((current_Month == 1)) {
                    // If the current month is 1 means approaching the spring
                    int month = 1;
                    int total_month = 12;
                    month_value = (total_month - month);
                    year_valu = (year_passed) - 1;
                    System.out.println("So the years u passed are \nYears=" + year_valu + "\nMonth=" + month_value);
                } else {
                    System.out.println("Sorry you are not regsitered");
                }

                System.out.println("total\nyears=" + year_valu + "\nMonths=" + month_value);
                semester = year_valu * 2;  // SEMESTER VALUE IN THE YEARS  AND NOW FOR THE MONTHS
                if ((month_value >= 0) && (month_value <= 6) && (year_valu == 0)) {
                    semester = semester + 1; // No extra semester is added
                } else if ((month_value > 6) && (month_value <= 12)) {
                    semester = semester + 2;
                } else if ((month_value >= 0) && (month_value <= 6)) {
                    semester = semester + 1;
                }
                System.out.println("So the number of the semesters are " + semester);
                if (semester == 1) {
                    System.out.println("Your couseses are \n1)English\n2)Physics\n3)Calculus\n4)Thermodynamics");
                } else if ((semester > 1) && (semester <= 10)) {
                    System.out.println("Choose couseses are \n1)Discrete(3)\n2)Maths(3)\n3)Report writing(3)\n4)DLD(4)\n5)Thermodynamics(4)\n6)PF(4)");
                    System.out.println("Enter '1' for selecting couse and '0' for not selecting");
                    //Subject 1
                    System.out.println("Discrete: ");
                    int discrete = s.nextInt();
                    int cred_discrete = 3;
                    //Subject 2
                    System.out.println("Maths: ");
                    int Maths = s.nextInt();
                    int cred_Maths = 3;
                    //Subject 3
                    System.out.println("Report writing: ");
                    int Report_Writing = s.nextInt();
                    int cred_Report = 3;
                    //Subject 4
                    System.out.println("DLD: ");
                    int DLD = s.nextInt();
                    int cred_DLD = 4;
                    //Subject 5
                    System.out.println("Thermodynamics: ");
                    int Thermodynamics = s.nextInt();
                    int cred_Thermo = 4;
                    //Subject 6
                    System.out.println("PF: ");
                    int PF = s.nextInt();
                    int cred_Pf = 4;
                    if (((discrete == 0) || (discrete == 1)) && ((Maths == 0) || (Maths == 1)) && ((PF == 0) || (PF == 1)) && ((Thermodynamics == 0) || (Thermodynamics == 1)) &&
                            ((DLD == 0) || (DLD == 1)) && ((Report_Writing == 0) || (Report_Writing == 1))) {
                            int net_credithour = cred_DLD + cred_Pf + cred_discrete + cred_Report + cred_Maths + cred_Thermo;
                            if ((PF == 1) && (DLD == 1) && (Thermodynamics == 1)) {
                                System.out.println("You choosed more than 2 couses of 4 Credit hours");}
                            else  if((net_credithour<12)) {
                                System.out.println("You choose less credit hour");
                            }
                            else if ((net_credithour>22)) {
                                System.out.println("You choose more credit hours");
                            }
                            else {
                                System.out.println("**************************************");
                                System.out.println("CONGRATULATIONS YOUR COURSE HAS BEEN REGISTERED");
                                System.out.println("**************************************");
                            }
                    } // Main condition closing
                    else{
                        System.out.println("Number out of range");
                        }
                    }

                }
            } else {
                System.out.println("You entered a wrong session\n or have graduated");
            }
        }
    }


