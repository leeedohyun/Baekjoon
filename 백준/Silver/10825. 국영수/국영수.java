import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            
            String name = input[0];
            int korean = Integer.parseInt(input[1]);
            int english = Integer.parseInt(input[2]);
            int math = Integer.parseInt(input[3]);
            
            students.add(new Student(name, korean, english, math));
        }
        
        Collections.sort(students);
        
        for (int i = 0; i < n; i++) {
            System.out.println(students.get(i).getName());
        }
        
        br.close();
    }
    
    static class Student implements Comparable<Student> {
        private String name;
        private int korean;
        private int english;
        private int math;
        
        public Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }
        
        public String getName() {
            return name;
        }
        
        @Override
	    public int compareTo(Student o) {
	        if (this.korean == o.korean && this.english == o.english && this.math == o.math) {
	            return this.name.compareTo(o.name);
	        } 
	        if (this.korean == o.korean && this.english == o.english) {
	            return o.math - this.math;
	        }
	        if (this.korean == o.korean) {
	            return this.english - o.english;
	        }
	        return o.korean - this.korean;
	    }
    }
}