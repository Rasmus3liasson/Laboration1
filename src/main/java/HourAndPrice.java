public class HourAndPrice implements Comparable<HourAndPrice> {
    int hour;
    int price;

    public HourAndPrice(int hour, int price) {
        this.hour = (hour == 24) ? 0 : hour % 24; // convert to 0 for hour 24
        this.price = price;
    }

    public int getHour() {
        return hour;
    }

    public int getPrice() {
        return price;
    }

    public int compareTo(HourAndPrice compared) {
        return Integer.compare(this.price, compared.price);
    }
}
