import java.time.*;
import java.time.format.*;

public class Main15_16 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		
		// 1. パターンを「MM（大文字）」に修正
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		
		// 2. 文字列から日付に変換
		LocalDate ldete = LocalDate.parse("2023/09/22", fmt);
		
		// 3. 1000日後を計算
		LocalDate ldetep = ldete.plusDays(1000);
		
		// 4. 指定したフォーマットの文字列に戻す
		String str = ldetep.format(fmt);
		System.out.println("1000日後は" + str);
		
		// 5. 未来かどうかの判定（変数のスペルを ldetep に統一）
		LocalDate now = LocalDate.now();
		if (now.isAfter(ldetep)) {
			System.out.println("本日は、その日より未来どす");
		}
	} // mainメソッドの閉じカッコ
} // クラスの閉じカッコ