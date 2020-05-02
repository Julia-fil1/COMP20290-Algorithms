package lab7_substring_search;
// Java program for Naive Pattern Searching 

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class BruteForceSearch {

	private static int search(String txt, String pat) {
		int n = txt.length();
		int m = pat.length();
		for (int i = 0; i <= n - m; i++) {
			int j;
			for (j = 0; j < m; j++) {
				if (txt.charAt(i + j) != pat.charAt(j)) {
					break;
				}
			}
			if (j == m) {
				return i;
			}
		}
		return n;
	}


	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
        File file = new File("src/lab7_substring_search/randomString.txt");


		FileInputStream fis = null;
		byte[] buffer = new byte[10];
		StringBuilder sb = new StringBuilder();
		try {
			fis = new FileInputStream(file);

			while (fis.read(buffer) != -1) {
				sb.append(new String(buffer));
				buffer = new byte[10];
			}
			fis.close();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null)
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
//		return sb.toString();


		//String txt = "ABABDABACDABABCABAB";
		String pat = "ABABCABAB";
		System.out.println(search(sb.toString(), pat));
		long estimatedTime = System.currentTimeMillis() - startTime;
		System.out.println("Time taken: " + estimatedTime);
	}
}