package Anima;

import java.util.Scanner;

public class Backjun {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int X = sc.nextInt();

		int arr[] = new int[N];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
//			System.out.println(arr[i] + " ");
		}
		sc.close();
//		System.out.println(N + " " + X);
			for (int i = 0; i < arr.length; i++) {
				if(arr[i] < X) 
				System.out.print(arr[i] + " ");
			
		}
		
		
		}

	}


