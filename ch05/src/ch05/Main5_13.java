package ch05;

public class Main5_13 {
public static void incArrey(int[] arrey) {
	for(int i = 0 ; i < arrey.length ; i++) {
		arrey[i]++;
	}
}
public static void main(String[] args) {
	int[] arrey = {1,2,3};
	incArrey(arrey);
	for(int i : arrey) {
		System.out.println(i);
	}
}
}
