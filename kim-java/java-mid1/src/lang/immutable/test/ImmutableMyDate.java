package lang.immutable.test;

public class ImmutableMyDate {
    private final int year;
    private final int month;
    private final int day;

    public ImmutableMyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    // 불변 객체에서 값을 변경하는 경우 -> with-()
    public ImmutableMyDate withYear(int year) {
        return new ImmutableMyDate(year, month, day);
    }

    public ImmutableMyDate withMonth(int month) {
        return new ImmutableMyDate(year, month, day);
    }

    public ImmutableMyDate withDay(int day) {
        return new ImmutableMyDate(year, month, day);
    }

    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }
}
