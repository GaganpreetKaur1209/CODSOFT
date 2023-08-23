import java.util.*;

public class DisplayResult {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of subjects");
		int numberofSubjects=sc.nextInt();
		String subject[]=new String[numberofSubjects];
		double marks[]=new double[numberofSubjects];
		double sum=0;
		
		for(int i=0;i<numberofSubjects;i++) {
			System.out.println("Name of the subject");
			 subject[i]=sc.next();
			 System.out.println("Marks obtained in "+subject[i]);
			 marks[i]=sc.nextDouble();	
			 
			if(marks[i]>=100||marks[i]<0) {
				System.out.println("Wrong input");
			    System.out.println("Marks obtained in "+subject[i]);
				marks[i]=sc.nextDouble();
			}
			sum+=marks[i];
		}
		
		double percentage=sum/numberofSubjects;
		String grades=grade(percentage);
		System.out.println("------------------------------");
		System.out.println("     RESULT DECLARATION       ");
		System.out.println("");
		
		 System.out.printf("%-10s%-10s%-10s%n", "Subject", "Maximum", "Score");
		for(int i=0;i<numberofSubjects;i++) {
			 printDataRow(subject[i], marks[i]);
		}
		
		System.out.println(" ");
		String totalsum = String.format("%.2f%n", sum);
       	System.out.printf("Total Marks:\t"+totalsum);
       	String averagepercentage = String.format("%.2f", percentage);
		System.out.println("PERCENTAGE:\t" +averagepercentage+"%");
		System.out.println("GRADES:\t\t"+grades);
		if(grades.equals("A")||grades.equals("B")||grades.equals("C")||grades.equals("D")||grades.equals("E"))
			System.out.println("PASS");
		else
			System.out.println("FAIL");
		System.out.println("------------------------------");
		
		sc.close();
	}
	static void printDataRow(String Subject, double Marks_Obtained) {
		String score=String.format("%.2f",Marks_Obtained);
		System.out.printf("%-10s%-10d%-10s%n", Subject, 100, score);
	}
	
static String grade(double percentage) {
	if(percentage>=90)
		return "A";
	else if(percentage>=80)
		return "B";
	else if(percentage>=70)
		return "C";
	else if(percentage>=60)
		return "D";
	else if(percentage>=50)
		return "E";
	else
		return "F";
}
}
