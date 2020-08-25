/**
 * 
 */
package datastructures.priorityqueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author Mischa Andriesse
 * @version 1.0 (24 aug. 2020)
 *
 */
public class Solution {
	private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}

class Priorities {
	Comparator<Student> studentSort = Comparator
			.comparing(Student::getCGPA).reversed()
			.thenComparing(Student::getName)
			.thenComparing(Student::getID);
	PriorityQueue<Student> queue = new PriorityQueue<>(studentSort);
	
	List<Student> getStudents(List<String> events) {
		for (String event: events) {
			String[] s = event.split(" ");
			if ("ENTER".equals(s[0])) {
				Student student = new Student(
						Integer.parseInt(s[3]), 
						s[1], 
						Double.parseDouble(s[2]));
				queue.add(student);
			} else if ("SERVED".equals(s[0])) {
				queue.poll();
			}
		}
		List<Student> students = new ArrayList<>(queue);
		students.sort(studentSort);
		return students;
	}
}

class Student {
	
	int id;
	String name;
	double cgpa;
	
	Student(int id, String name, double cgpa) {
		this.id = id;
		this.name = name;
		this.cgpa = cgpa;
	}
	
	int getID() {
		return id;
	}
	
	String getName() {
		return name;
	}
	
	double getCGPA() {
		return cgpa;
	}
}
