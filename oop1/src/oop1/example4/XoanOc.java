package oop1.example4;

import java.util.Scanner;

public class XoanOc {

    public static Scanner sc;
    private static int[][] A;

    public static void main(String[] args) {
	sc = new Scanner(System.in);
	int n = 0;
	do {
	    System.out.print("Nhap vao so nguyen n: ");
	    n = sc.nextInt();
	} while (n < 3 || n > 8);

	System.out.println("Nhap danh sach theo thu tu tang dan:");
	A = new int[n][n];
	int value = 1;
	int k = 0;
	int column = n;
	int row = n;

	while (k < n * n) {
	    for (int x = k; x < column; x++)
		A[k][x] = value++;

	    for (int y = k + 1; y < row - 1; y++)
		A[y][column - 1] = value++;

	    for (int x = column - 1; x > k; x--)
		A[row - 1][x] = value++;

	    for (int y = row - 1; y > k; y--)
		A[y][k] = value++;

	    k++;
	    column--;
	    row--;
	}
	System.out.println("Xoan oc: ");
	for (int i = 0; i < n; i++) {
	    System.out.println();
	    for (int j = 0; j < n; j++) {
		System.out.print(A[i][j] + " ");
	    }
	}

    }
}
