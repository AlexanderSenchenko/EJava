import java.util.*;

public class Calc {
	
	public static void main(String[] args) {

		System.out.print("Input first number: ");
		Scanner in = new Scanner(System.in);
		float n1 = in.nextFloat();

		System.out.print("Input second number: ");
		// in = new Scanner(System.in);
		float n2 = in.nextFloat();

		System.out.print("Input act: ");
		// in = new Scanner(System.in);
		String act = in.next();

		float res;
		switch (act)
		{
			case "+":
				res = n1 + n2;
				System.out.println(res);
				break;
			case "-":
				res = n1 - n2;
				System.out.println(res);
				break;
			case "*":
				res = n1 * n2;
				System.out.println(res);
				break;
			case "/":
				res = n1 / n2;
				System.out.println(res);
				break;
			default:
				System.out.println("Error");
		}
	}
}