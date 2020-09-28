package oop1.example2;

import java.util.Scanner;

public class NumberSort {

    private static Scanner sc;

    private int[] sortList(int[] arr) {
	for (int i = 0; i < arr.length; i++) {
	    for (int j = i + 1; j < arr.length; j++) {
		if (arr[i] > arr[j]) {
		    int temp = arr[i];
		    arr[i] = arr[j];
		    arr[j] = temp;
		}
	    }
	}
	return arr;
    }

    public static void main(String[] args) {
	sc = new Scanner(System.in);
	int[] A = new int[5];
	for (int i = 0; i < 5; i++) {
	    System.out.print("Nhap so thu " + (i + 1) + " :");
	    A[i] = sc.nextInt();
	}
	System.out.println("Danh sach trc khi sort:");
	for (int i = 0; i < A.length; i++) {
	    System.out.print(A[i] + ",");
	}
	System.out.println();
	int[] B = new NumberSort().sortList(A);
	System.out.println("Danh sach sau khi sort:");
	for (int i = 0; i < B.length; i++) {
	    System.out.print(B[i] + ",");
	}

    }
}
