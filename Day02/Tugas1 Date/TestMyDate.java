public class TestMyDate {
	public static void main(String[] args) {
		MyDate my_birth = new MyDate(22, 7, 1964);
		MyDate the_next_week = my_birth.addDays(7);
        MyDate the_next_month = my_birth.addMonth(1);
        MyDate the_next_year = my_birth.addYears(1);
        MyDate the_prev_days = my_birth.minDays(5);
        MyDate the_prev_month = my_birth.minMonth(2);
			
		System.out.println(the_next_week);
		System.out.println(the_next_month);
		System.out.println(the_next_year);
		System.out.println(the_prev_days);
		System.out.println(the_prev_month);
	}
}