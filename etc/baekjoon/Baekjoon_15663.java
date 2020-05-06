package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_15663 {
	
	static int N, M;
	
	static int[] arr;
	static int[] use;
	
	static int[] num;
	
	static StringBuilder ans;
	
	static Set<String> hs = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		use = new int[M];
		num = new int[10001];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		ans = new StringBuilder();
		
		set(0);
		System.out.println(ans);
	}
	
	static void set(int now) {
		if (now > M)
			return;
		
		if (now==M) {
			
			StringBuilder sb = new StringBuilder();
			for (int i : use)
				sb.append(i).append(' ');
			
			if (!hs.contains(sb.toString())) {
				hs.add(sb.toString());
				ans.append(sb);
				ans.append('\n');
			}			
			return;
		}
		
		for (int i=0; i<N; i++) {
			if (arr[i] != -1) {
				int tmp = arr[i];
				arr[i] = -1;
				use[now] = tmp;
				set(now+1);
				arr[i] = tmp;
			}
		}
	}

}
