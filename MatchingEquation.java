import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;




public class MatchingEquation {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	
	static int[] numbers;  //size of this array is will be N where N is the total number of numbers (RHS + LHS)
	static String[] operators;//the size of this array is N-2
	
	
	//start with i=1 , n is the size of  operators array
	public static boolean checkEquation(int i , int n)
	{
		if(i==n+1){return ifLHSequalsRHS();}
		
		operators[i-1]="+";
		if(checkEquation(i+1,n)==true) {
			return true;
		}
		
		else
		{
			operators[i-1]="-";
			if(checkEquation(i+1,n)==true) {
				return true;
			}
			
		}
		return false;
		
	}//end of function checkEquation
	
	public static boolean ifLHSequalsRHS()
	{
		int firstOperand=numbers[0];
		int secondOperand=numbers[1];
		int result=-999;
	for(int i=0;i<operators.length;i++)
	{
	      result=calculate(firstOperand,secondOperand,operators[i]);
		
		firstOperand=result;
		secondOperand=numbers[i+2];
	}//end of for
		
	if(result==numbers[numbers.length-1])return true;
	else return false;
	}//end of function
	
	public static int calculate(int firstOperand,int secondOperand, String operator)
	{
		if(operator.equals("+")) return (firstOperand+secondOperand);
		else  return (firstOperand-secondOperand);
		
		
		
	}//end of function calculate
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method
		
		//You can use the path of your choice.
		String file="C:\\Users\\sangam\\Desktop\\equation.txt";
		Scanner sc=new Scanner(new File(file));
		int valueOfN=Integer.parseInt(sc.next());
		
		numbers=new int[valueOfN];//strong all the N numbers for the equation
		int i=0;
		while(i<valueOfN)
		{
		numbers[i]=	Integer.parseInt(sc.next());
		i++;
		}//end of file
		
		operators=new String[valueOfN-2];
		
		
		boolean result=checkEquation(1,valueOfN-2);
		
		if(result==true)
		{
		for(int j=0;j<numbers.length-1;j++)
		{
		System.out.println(numbers[j]);
		if(j<(numbers.length-2))
		System.out.println(operators[j]);
			
		}
		System.out.println("="+numbers[numbers.length-1]);
		}
		else
		{
			System.out.println("There are no operators to satisfy this equation");
		}
	}//end of main

}
