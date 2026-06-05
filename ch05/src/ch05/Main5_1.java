package ch05;

public class Main5_1 {
	
	// 1. すべてのスタート地点となる main メソッド（mは小文字）
	public static void main(String[] args) {
		System.out.println("呼び出します");
		
		// kugiメソッドを呼び出して、計算結果を gojo に受け取る
		int gojo = kugi(34, 66);
		
		System.out.println("34 + 66 = " + gojo);
	}
	
	// 2. 足し算をして結果を返す kugi メソッド
	// ★修正点：戻すデータの型「int」を追加しました
	public static int kugi(int x, int y) {
		int ans = x + y;
		return ans; // 計算結果を main メソッドに返す
	}
}