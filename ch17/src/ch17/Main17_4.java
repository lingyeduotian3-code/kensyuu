package ch17;
import java.io.*;
public class Main17_4 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
FileWriter fw =null;
try {
	fw = new FileWriter("data.txt");
	fw.write("hello");
}catch(IOException e) {
	System.out.println("エラーです");
}
	}

}
