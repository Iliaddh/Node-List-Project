/**
 * Full Name: Ilyad Hemmatjoo
 * ID: 40205441
 * Course: COMP249
 * Assignment: Assignment 3
 * Due Date: December 2, 2023
 */

// -----------------------------------------------------
// Assignment (3)
// Class: (4)
// Written by: (Ilyad Hemmatjoo ---- ID: 40205441)
// -----------------------------------------------------

package CellPhoneRecords;

import java.util.Scanner;

 public class cellPhone implements PubliclyCloneable{

	private long serialNum;
	private String brand;
	private int year;
	private double price;
	
	public cellPhone(long serialNumber, String brand, int year, double price) {
		this.serialNum = serialNumber;
		this.brand= brand;
		this.year = year;
		this.price= price;
	}
	
	public  cellPhone(cellPhone c , long serialNumber) {
		this.brand = c.brand;
		this.year = c.year;
		this.price = c.price;
		this.serialNum = serialNumber;
	}
	
	
	
	public long getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(long serialNum) {
		this.serialNum = serialNum;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
	
//	public cellPhone clone() {
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Enter a unique serial number: ");
//		long newSerialNumber = scanner.nextLong();
//		scanner.close();
//		return new cellPhone(this,newSerialNumber );
//	}
	
	public cellPhone clone() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a new serial number for the cloned cell phone: ");
        long newSerialNum = input.nextLong();
        return new cellPhone(newSerialNum, this.brand, this.year, this.price);
    }

	
	public String toString() {
		return "cellPhone [serialNum = " + serialNum + ", brand = " + brand + ", year = " + year + ", price = " + price + "]";
	}
	
	public boolean equals(Object o) {
		if(o == null | o.getClass() != this.getClass()) {
			return false;
		}else {
			cellPhone c = (cellPhone)o;
			if(c.brand.equals(this.brand) && c.getPrice() == this.price && c.year == this.year) {
				return true;
			}
		}
		
		return false;
		
		
	}
	
	
}
