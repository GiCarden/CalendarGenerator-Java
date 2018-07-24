import java.util.Scanner;

/**
 * Write a program that displays the calendar for a given month of the year. The program prompts the user to
 * enter the month and the year, then displays the entire calendar for the month.
 */
class CalendarGenerator {

//Variable(s)-
    private static final int MIN_YEAR = 1900;
    private static final int MAX_YEAR = 2099;

    private static final int MIN_MONTH = 1;
    private static final int MAX_MONTH = 12;

    private static final int START_DAY_FOR_JAN_1_1800 = 3;
    private static final int START_YEAR_FOR_JAN_1_1800 = 1800;
    private static final int DAYS_IN_A_WEEK = 7;

//Private Method(s)-
    /**
     * Validates if value is between min and max.
     *
     * @param value to test.
     * @param min lowest acceptable value.
     * @param max highest acceptable value.
     * @return true if value is between min and max, else false.
     */
    private static boolean rangeValidator(int value, int min, int max) { return (value >= min && value <= max); }

    /**
     * User input validator, this method Validates that that the user enters a valid value for a month.
     *
     * @return month
     */
    private static int monthInputProcessor() {

        Scanner cin = new Scanner(System.in);
        boolean isInt = false;
        int month = 0;

        System.out.print("\nEnter Month as a Number Between 1 and 12: ");

        do {
            try {

                month = Integer.parseInt(cin.next().trim());

                if ((rangeValidator(month, MIN_MONTH, MAX_MONTH))) {

                    isInt = true;
                } else {

                    System.out.print("Invalid Month Range, Try Again: ");
                }

            } catch (NumberFormatException | NullPointerException e) {

                System.out.print("Invalid Month Format, Try Again: ");
            }
        } while (!isInt);

        return month;
    }


    /**
     * User input validator, this method Validates that that the user enters a valid value for a year.
     *
     * @return year
     */
    private static int yearInputProcessor() {

        Scanner cin = new Scanner(System.in);
        boolean isInt = false;
        int year = 0;

        System.out.print("Enter Year (e.g., 2018): ");

        do {
            try {

                year = Integer.parseInt(cin.next().trim());

                if ((rangeValidator(year, MIN_YEAR, MAX_YEAR))) {

                    isInt = true;
                } else {

                    System.out.print("Invalid Year Range, Try Again: ");
                }

            } catch (NumberFormatException | NullPointerException e) {

                System.out.print("Invalid Year Format, Try Again: ");
            }
        } while (!isInt);

        return year;
    }


    /**
     * Get the English String representation of a Specific day in the week.
     *
     * @param day integer between 0 and 6.
     * @return a specific day in the week.
     */
    private static String getStringRepresentationWeekday(int day) {

        String weekDayStringRepresentation;

        switch (day) {
            case 0 : //Sunday = 0.
                weekDayStringRepresentation = "Sunday";
                break;
            case 1 : //Monday = 1.
                weekDayStringRepresentation = "Monday";
                break;
            case 2 : //Tuesday = 2.
                weekDayStringRepresentation = "Tuesday";
                break;
            case 3 : //Wednesday = 3.
                weekDayStringRepresentation = "Wednesday";
                break;
            case 4 : //Thursday = 4.
                weekDayStringRepresentation = "Thursday";
                break;
            case 5 : //Friday = 5.
                weekDayStringRepresentation = "Friday";
                break;
            case 6 : //Saturday = 6.
                weekDayStringRepresentation = "Saturday";
                break;
            default :
                weekDayStringRepresentation = "Invalid WeekDay Match";
        }
        return weekDayStringRepresentation;
    }


    /**
     * Get the English String representation of a Specific month in a year.
     *
     * @param month integer between 1 and 12.
     * @return a specific month in a year.
     */
    private static String getStringRepresentationMonth(int month) {

        String monthStringRepresentation;

        switch (month) {
            case 1 : //January
                monthStringRepresentation = "January";
                break;
            case 2 : //February
                monthStringRepresentation = "February";
                break;
            case 3 : //March
                monthStringRepresentation = "March";
                break;
            case 4 : //April
                monthStringRepresentation = "April";
                break;
            case 5 : //May
                monthStringRepresentation = "May";
                break;
            case 6 : //June
                monthStringRepresentation = "June";
                break;
            case 7 : //July
                monthStringRepresentation = "July";
                break;
            case 8 : //August
                monthStringRepresentation = "August";
                break;
            case 9 : //September
                monthStringRepresentation = "September";
                break;
            case 10 : //October
                monthStringRepresentation = "October";
                break;
            case 11 : //November
                monthStringRepresentation = "November";
                break;
            case 12 : //December
                monthStringRepresentation = "December";
                break;
            default :
                monthStringRepresentation = "Invalid Month Match";
        }
        return monthStringRepresentation;
    }


    /**
     * Determines whether a year is a leap year or not.
     *
     * @param year to test.
     * @return true if leap year, else false.
     */
    private static boolean isLeapYear(int year) { return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0); }


    /**
     * Determines whether a year has 365 days or 366 days.
     *
     * @param year to test.
     * @return total days in a year.
     */
    private static int getDaysInYear(int year) { return isLeapYear(year) ? 366 : 365; }


    /**
     * Calculates the number of days in a particular month of a particular year,
     * this method takes leap years into consideration.
     *
     * @param month integer between 1 and 12.
     * @param year to determine if is a leap year or not.
     * @return number of days in a specific month.
     */
    private static int getDaysInMonth(int month, int year) {

        int totalDaysInMonth;

        switch (month) {
            case 1 : //January 31 days.
                totalDaysInMonth = 31;
                break;
            case 2 : //February 28 days or 29 days if leap year.
                totalDaysInMonth = isLeapYear(year) ? 29 : 28;
                break;
            case 3 : //March 31 days.
                totalDaysInMonth = 31;
                break;
            case 4 : //April 30 days.
                totalDaysInMonth = 30;
                break;
            case 5 : //May 31 days.
                totalDaysInMonth = 31;
                break;
            case 6 : //June 30 days.
                totalDaysInMonth = 30;
                break;
            case 7 : //July 31 days.
                totalDaysInMonth = 31;
                break;
            case 8 : //August 31 days.
                totalDaysInMonth = 31;
                break;
            case 9 : //September 30 days.
                totalDaysInMonth = 30;
                break;
            case 10 : //October 31 days.
                totalDaysInMonth = 31;
                break;
            case 11 : //November 30 days.
                totalDaysInMonth = 30;
                break;
            case 12 : //December 31 days.
                totalDaysInMonth = 31;
                break;
            default :
                totalDaysInMonth = 0;
        }
        return totalDaysInMonth;
    }


    /**
     * Calculates the total number of days since January 1, 1800.
     *
     * @param month end point.
     * @param year end point.
     * @return total number of days between January 1, 1800 and Month 1, Year.
     */
    private static int getTotalNumberOfDaysPassed(int month, int year) {

        int daysPassed = 0;

        //Calculates the total number of days from 1800 to 1/1/year.
        for (int i = START_YEAR_FOR_JAN_1_1800; i < year; i++) {

            daysPassed += getDaysInYear(i);
        }

        //Calculates the total number of days from Jan to the month prior to the calendar month.
        for (int i = 1; i < month; i++) {

            daysPassed += getDaysInMonth(i, year);
        }

        return daysPassed;
    }


    /**
     * Calculates the start day of month/1/year.
     *
     * @param month integer between 1 and 12.
     * @param year integer between 1800 and 12.
     * @return the start day of month/1/year
     */
    private static int getStartDayOfMonth(int month, int year) {

        return (START_DAY_FOR_JAN_1_1800 + getTotalNumberOfDaysPassed(month, year)) % DAYS_IN_A_WEEK;
    }


    /**
     *  Displays the Calenders Title.
     *
     * @param month integer between 1 and 12.
     * @param year integer between MIN_YEAR and MAX_YEAR.
     */
    private static void displayCalenderTitle(int month, int year) {

        System.out.printf("%n%s %d%n", getStringRepresentationMonth(month), year);
        System.out.println("-----------------------------");
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
    }


    /**
     * Displays the Calenders Body.
     *
     * @param month integer between 1 and 12.
     * @param year integer between MIN_YEAR and MAX_YEAR.
     */
    private static void displayCalenderBody(int month, int year) {

        int monthStartDay = getStartDayOfMonth(month, year);

        int daysInMonth = getDaysInMonth(month, year);

        for (int i = 0; i < monthStartDay; i++) { System.out.printf("%4s", "X"); }

        for (int i = 1; i <= daysInMonth; i++) {

            System.out.printf("%4d", i);

            if ((i + monthStartDay) % 7 == 0) { System.out.println(); }
        }

        System.out.println();
    }

//Package Private Method(s)-
    /**
     * Main inputProcessor.
     */
    static void inputProcessor() {

        int month = monthInputProcessor();
        int year = yearInputProcessor();

        displayCalenderTitle(month, year);
        displayCalenderBody(month, year);
    }

}//End of Class.
