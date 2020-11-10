/*
 * A file exam.txt contains scores of 20 students in their first programming test.
 * An instructor wants to compute the average,maximum and minimum scores and later sort the scores.
 * Help the instructor by writing a complete Java program that performs such tasks as summarized below:
 * -read sores from the file
 * -compute the average score
 * -find the maximum and minimum scores
 * -sort the scores in ascending order
 * -Write the calculated average,minimum score,maximum score and sorted scores back into the file.
 * 
 * NB:Write functions to implement each task while avoiding the use of predefined methods in your program
 */
import java.io.*;
import java.util.Scanner;

public class Exams3000 {

	 public static void readScores() throws FileNotFoundException
	 {
		   File examFile = new File("exam.txt");
	        try (Scanner input = new Scanner(examFile))
	        {
				while(input.hasNextInt())
				  {
					  System.out.print(input.nextInt()+" ");
				  }
			} 
			
	 }
	 
	 public static void avgScore() throws FileNotFoundException
	 {
		 double sum = 0;
		 File examFile = new File("exam.txt");
	        try (Scanner input = new Scanner(examFile))
	        {
				while(input.hasNextInt())
				  {
					 sum = sum + input.nextInt();
				  }
				System.out.println("Average Score is "+sum/20);
			} 
	 }
	 
	 public static void minMaxScores() throws FileNotFoundException
	 {
		 int min = 100;
		 int max = 0;
		 File examFile = new File("exam.txt");
	        try (Scanner input = new Scanner(examFile))
	        {
				while(input.hasNextInt())
				  {
					  int number = input.nextInt();
						if(number < min )
						{
							min = number;
						}
						
						else if(number > max)
						{
							max = number;
						}
				  }
				System.out.println("The minimum score is: "+min+" and maximum score is: "+max);
			} 
	 }
	 public static int [] bubbleSort(int [] scores)
	 {
		  //bubble sort
	        for (int j = 0; j < scores.length; j++)
	        {
	            for (int k = j + 1; k < scores.length; k++)
	            {
	                int tmp = 0;
	                if (scores[j] > scores[k]) {
	                    tmp = scores[j];
	                    scores[j] = scores[k];
	                    scores[k] = tmp;
	                }
	            }
	           	           
	        }
			return scores;
	 }
	 public static void  sortAsc() throws FileNotFoundException
	 {
		 int scores[] = new int [20];
		 int i = 0;
		  File examFile = new File("exam.txt");
	        try (Scanner input = new Scanner(examFile))
	        {
				while(input.hasNext())
				  {		int number = input.nextInt();
					   scores[i] =number;
				          i++;	
				  }
			} 
	              
	        int [] sortedScores = bubbleSort(scores);
	        
	        //displaying scores in asc order
	        System.out.println("Sorted scores in asc order");
	        for (int m = 0 ; m <sortedScores.length; m++)
	        {
	        	 System.out.print(sortedScores[m]+" ");
	        }
	 }
	/* 
	 public static void   writeResults() 
	 {
		 try {
			  String avgScore = "41";
		      String minScore = "12";
		      String maxScore ="91";
		      String sortedScore = "12 34 54 65 73 78 87 91";
		      FileWriter myWriter = new FileWriter("exam.txt");
		      myWriter.write("Average Score is:"+avgScore+"\n");
		      myWriter.write("Minimum score is: "+minScore +" and maximum score is: "+maxScore+"\n");
		      myWriter.write("Sorted scores are: "+ sortedScore+"\n");
		      
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		   
		 }
		 
		 catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		    
		   
	 }*/
	public static void main(String[] args)  throws FileNotFoundException {
	
		System.out.println("1.Read Scores");
		System.out.println("2.Average Scores");
		System.out.println("3.Minimum and maximum scores");
		System.out.println("4.Sort scores in ascending order");
		System.out.println("5.Write results to a file");
		System.out.println("Please choose an option");
		
		try (Scanner input = new Scanner(System.in)) 
		{
			int choice = input.nextInt();
			switch(choice)
			{
			  case 1:
				  readScores();
			  break;
			  
			  case 2:
				  avgScore();
				  break;
			  case 3:
				  minMaxScores();
				  break;
			  case 4:
				  sortAsc();
				  break;
			  case 5:
				 // writeResults();
				  break;
			  default:
				System.out.println("Invalid Input");
			}
		}
         
	}

}
