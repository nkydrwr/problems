package nkyd.tech.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TextWrapProblem {
	private static int CHAR_LIMIT = 13;
	public static void main(String[] args) throws IOException {
		// taking user input
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		// reading input string
		System.out.println("Please enter the input:\n");
		String inputString = reader.readLine();
		StringBuffer input = new StringBuffer(inputString);

		List<String> charList = new ArrayList<String>();
		int nextWordEndIndex = 0;
		StringBuffer eachString = new StringBuffer("");
		for (int i = 0; i < input.length(); i++) {

			if(input.charAt(i) == ' ') {
				nextWordEndIndex = input.indexOf(" ", i + 1) - 1;

				
				if(nextWordEndIndex > 0 && ((nextWordEndIndex - i) + eachString.length() + 1) <= CHAR_LIMIT) {
					eachString.append(input.charAt(i));
				} else {
					charList.add(eachString.toString());
					eachString = new StringBuffer("");
				}
			} else {
				eachString.append(input.charAt(i));
			}
			
		}
		// for the final remaining string to add to list
		if(eachString.length() > 0) {
			charList.add(eachString.toString());
		}
		for (String chars : charList) {
			System.out.println(chars);
		}
	}

}
