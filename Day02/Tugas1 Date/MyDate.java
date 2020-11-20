public class MyDate {
	private int day = 1;
	private int month = 1;
	private int year = 2000;
	
	public MyDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	public MyDate(MyDate date) {
		this.day = date.day;
		this.month = date.month;
		this.year = date.year;
	}

    public void setDay(int day) {
        this.day = day;
    }

    public MyDate addDays(int moreDays) {
            MyDate newDate = new MyDate(this);
            newDate.day = newDate.day + moreDays;
            // Not Yet Implemented: wrap around code...
            return newDate;
    }

    public MyDate addMonth(int moreMonth) {
        MyDate newMonth = new MyDate(this);
        newMonth.month = newMonth.month + moreMonth;
        return newMonth;
    }

    public MyDate addYears(int moreYears) {
        MyDate newYears = new MyDate(this);
        newYears.year = newYears.year + moreYears;
        return newYears;
    }

    public MyDate minDays(int minDays) {
        MyDate minDate = new MyDate(this);
        minDate.day = minDate.day - minDays;
        return minDate;
    }

    public MyDate minMonth(int minMonths) {
        MyDate minMonth = new MyDate(this);
        minMonth.month = minMonth.month - minMonths;
        return minMonth;
    }

     public String toString() {
           String retString = "" + day + "-" + month + "-" + year;
		return retString;
	}
}