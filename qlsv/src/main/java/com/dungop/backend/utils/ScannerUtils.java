package com.dungop.backend.utils;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class ScannerUtils {
	private static Scanner sc = new Scanner(System.in);

	public static int inputInt() {
		while (true) {
			try {
				return Integer.parseInt(sc.next().trim());
			} catch (Exception e) {
				System.err.println("Nhập lại:");
			}
		}
	}

	public static int inputIntPositive() {
		while (true) {
			try {
				int intPositive = Integer.parseInt(sc.next().trim());
				if (intPositive >= 0) {
					return intPositive;
				} else {
					System.err.println("Nhập lại:");
				}

			} catch (Exception e) {
				System.err.println("Nhập lại:");
			}

		}
	}

	public static Float inputFloat() {
		while (true) {
			try {
				return Float.parseFloat(sc.next());
			} catch (Exception e) {
				System.err.println("Nhập lại:");
			}
		}
	}

	public static Double inputDouble() {
		while (true) {
			try {
				return Double.parseDouble(sc.next());
			} catch (Exception e) {
				System.err.println("Nhập lại:");
			}
		}
	}

	public static String inputString() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			String string = sc.nextLine().trim();
			if (!string.isEmpty()) {
				return string;
			} else {
				System.err.println("Nhập lại:");
			}
		}
	}

	public static LocalDate inputLocalDate() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập theo định dạng yyyy-MM-dd");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		while (true) {
			String localdate = sc.nextLine().trim();
			try {
				if (format.parse(localdate) != null) {
					LocalDate lc = LocalDate.parse(localdate);
					return lc;
				}
			} catch (Exception e) {
				System.err.println("Nhập lại:");
			}
		}
	}
	public static Date inputDate() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập theo định dạng yyyy-MM-dd");
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		
		while (true) {
			String input = sc.nextLine().trim();
			
			try {
				Date date = dateformat.parse(input);
				return date;
			} catch (Exception e) {
				System.err.println("Nhập lại:");
			}
		}
	}

}
