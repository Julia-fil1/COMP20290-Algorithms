package lab7_substring_search;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

class KMPsearch {
	private static void KMPSearch(String pat, String txt)
	{
		int M = pat.length();
		int N = txt.length();

		// create lps[] that will hold the longest
		// prefix suffix values for pattern
		int[] lps = new int[M];
		int j = 0; // index for pat[]

		// Preprocess the pattern (calculate lps[]
		// array)
		computeLPSArray(pat, M, lps);

		int i = 0;//index for the string
		while(i < N){
			if(pat.charAt(j) == txt.charAt(i)){
				//increment indexes
				j++;
				i++;
			}
			if(j == M){
				System.out.println("The pattern was found at index " + (i - j) );
				j = lps[j - 1];
			}
			// mismatch after j matches
			else if (i < N && pat.charAt(j) != txt.charAt(i)) {
				// Do not match lps[0..lps[j-1]] characters,
				// they will match anyway
				if (j != 0)
					j = lps[j - 1];
				else
					i = i + 1;
			}

		}

		//insert your code here

	}

	private static void computeLPSArray(String pat, int M, int[] lps)
	{
		// length of the previous longest prefix suffix
		int len = 0;
		int i = 1;
		lps[0] = 0; // lps[0] is always 0

		// the loop calculates lps[i] for i = 1 to M-1
		while (i < M) {
			if (pat.charAt(i) == pat.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			}
			else // (pat[i] != pat[len])
			{
				// This is tricky. Consider the example.
				// AAACAAAA and i = 7. The idea is similar
				// to search step.
				if (len != 0) {
					len = lps[len - 1];

					// Also, note that we do not increment
					// i here
				}
				else // if (len == 0)
				{
					lps[i] = len;
					i++;
				}
			}
		}
	}

	// Driver program to test above function
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		//String txt = "ABABDABACDABABCABAB";
        File file = new File("src/lab7_substring_search/randomString.txt");
		String pat = "ABABCABAB";
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

		KMPSearch(pat, sb.toString());
		long estimatedTime = System.currentTimeMillis() - startTime;
		System.out.println("Time taken: " + estimatedTime);
	}
}