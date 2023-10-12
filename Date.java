/**
 * Date.java for Lab 1, csskl 143, section b
 *
 * @student Michael Kim
 */
/*
-Instance variables are set to private to prevent subsequent code from accidentally or maliciously
accessing the values and modifying them. This is a sort of built-in privacy/security feature of Java.

-Private instance variables are accessible through the public methods that belong as sub-methods in the
same class as the private instance variables.
 */
public class Date {
    public static void main(String[] args) {
        // call date object constructor here
    }

    // make date object
    public class date {
        // make private instance var for day, month, and year
        private int day;
        private int month;
        private int year;

        // all constuctors and related actions of this object are sub-methods of the class

        // make empty constructor that initializes day 1, month 1, year 1975
        public date() {
            day = 1;
            month = 1;
            year = 1975;
        }

        // make constructor with input for each var
        public date(int day, int month, int year) {
            this.day = day;
            this.month = month;
            this.year = year;
            // add input validation for calculating and limiting days in the months
            if (year < 0) {
                throw new IllegalArgumentException("Invalid year");
            }
            if (month < 0 || month > 12) {
                throw new IllegalArgumentException("Invalid month");
            }
            // oh man... in excel we can just use a simple function known as "eosdate"
            if (day < 0) {
                throw new IllegalArgumentException("Invalid day");
            }

            // here we go
            int maxDays = 31;

            // determine if input year is a leap year, if so add a day to feb
            boolean leapYearTrigger = false;
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                leapYearTrigger = true;
            }
            if (leapYearTrigger && month == 2) {
                maxDays = 28;
            }
            if (leapYearTrigger == false && month == 2) {
                maxDays = 29;
            }
            // handle all non-leap year months with 30 days
            if (month == 4 || month == 6 || month == 9 || month == 11) {
                maxDays = 30;
            }
            // all other months have 31 days, so we can leave maxDays as is in these cases
            if (maxDays < day) {
                throw new IllegalArgumentException("Invalid day");
                // yay
            }

        }

        // seperate getters and setters for each var
        public void setDay(date object, int day) {
            object.day = day;
        }

        public void setMonth(date object, int month) {
            object.month = month;
        }

        public void setYear(date object, int year) {
            object.year = year;
        }

        public int getDay(date object) {
            return (object.day);
        }

        public int getMonth(date object) {
            return (object.year);
        }

        public int getYear(date object) {
            return (object.year);
        }

        // toString
        public String toString(date object) {
            String result = object.month + ", " + object.day + ", " + object.year;
            return result;
        }

    }
}

