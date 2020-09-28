package oop1.example1;

import java.util.Random;

public class RanDomNumber {

    public int[] changeIndex(int[] arr) {
	int n = 5;
	while (n > 0) {
	    int i = new Random().nextInt(arr.length - 1);
	    int tmp = arr[i];
	    arr[i] = arr[i + 1];
	    arr[i + 1] = tmp;
	    n--;
	}
	return arr;
    }

    public static void main(String[] args) {
	int[] A = { 3, 4, 5, 7, 2, 9, 1 };
	System.out.println("Danh sach trc khi thay doi la:");
	for (int i = 0; i < A.length; i++) {
	    System.out.print(A[i] + ",");
	}
	System.out.println();
	int[] B = new RanDomNumber().changeIndex(A);
	System.out.println("Danh sach sau khi thay doi la:");
	for (int i = 0; i < B.length; i++) {
	    System.out.print(B[i] + ",");
	}

    }
}
