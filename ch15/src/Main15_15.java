import java.time.*;

public class Main15_15 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		LocalDateTime l1 = LocalDateTime.now();
		LocalDateTime l2 = LocalDateTime.of(2024, 1, 1, 9, 5, 0, 0);
		ZonedDateTime z1 = l2.atZone(ZoneId.of("Europe/London"));
		LocalDateTime l3 = z1.toLocalDateTime();
	}

}
