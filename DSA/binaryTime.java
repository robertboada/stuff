import java.utils.*;
import java.io.*;

class binaryTime{

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(new File("time.txt"));
		
		int lines = sc.nextInt();
		

		for(int i = 0; i < lines; i++){

			String time = sc.nextLine();

			String cleanTime = "";

			for(int j = 0;j < time.length();j++){

				if ( time.charAt(j) == ')' && time.charAt(j-1) == '(' ){

					cleanTime += " ";

				}

				if ( time.charAt(j) == ')' && time.charAt(j-1) == '*' ) {

					cleanTime += "*";
				}

			}

			String answer = "Case "+ i + ": ";

			answer += convert(cleanTime.substring(0,2));
			answer += convert(cleanTime.substring(2,6));
			answer += ":";
			answer += convert(cleanTime.substring(6,9));
			answer += convert(cleanTime.substring(9,13));
			answer += ":";
			answer += convert(cleanTime.substring(13,16));
			answer += convert(cleanTime.substring(16));

			System.out.println(answer);
		}	
	}

	private String convert(String s) {

		int count = 0;

		int sum = 0;

		for (int i = s.length();i > 0;i--){

			if(s.charAt(i) == '*'){

				sum += Math.pow(2,count);
			}

			count++;

		}

		return sum + "";

	}
}