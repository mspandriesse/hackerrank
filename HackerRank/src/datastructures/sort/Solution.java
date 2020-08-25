/**
 * 
 */
package datastructures.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author Mischa Andriesse
 * @version 1.0 (23 aug. 2020)
 *
 */
class Student{
	private int id;
	private String fname;
	private double cgpa;
	public Student(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}
	public int getId() {
		return id;
	}
	public String getFname() {
		return fname;
	}
	public double getCgpa() {
		return cgpa;
	}
}

//Complete the code
public class Solution
{
	public static void main(String[] args){
		try (Scanner in = new Scanner(System.in)) {
			int testCases = Integer.parseInt(in.nextLine());

			List<Student> studentList = new ArrayList<>();
			while(testCases>0){
				int id = in.nextInt();
				String fname = in.next();
				double cgpa = in.nextDouble();

				Student st = new Student(id, fname, cgpa);
				studentList.add(st);

				testCases--;
			}
			Collections.sort(studentList, Comparator
					.comparing(Student::getCgpa)
					.reversed()
					.thenComparing(Student::getFname)
					.thenComparing(Student::getId)
					);
			for(Student st: studentList){
				System.out.println(st.getFname());
			}
		}
	}
}