package main;
import java.util.Arrays;
import java.util.Scanner;

public class DMOJsorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] a = new int[n];
		for (int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		sc.close();
		Arrays.sort(a);
		for (int i=0; i<n; i++) {
			System.out.println(a[i]);
		}
		
	}

}
