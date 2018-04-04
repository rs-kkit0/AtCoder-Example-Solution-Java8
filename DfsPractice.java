/*
 * AtCoder Typical Contest 001
 * 2015/06/06
 * A - 深さ優先探索
 *
 * https://atc001.contest.atcoder.jp/tasks/dfs_a
 * */

import java.util.Scanner;

public class DfsPractice {

	static int h;
	static int w;
	static String c[][];
	static boolean reached[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		h = sc.nextInt();
		w = sc.nextInt();
		DfsPractice.c = new String[h][w];

		int startH = -1;
		int startW = -1;
		int goalH = -1;
		int goalW = -1;

		for (int i = 0; i < h; i++) {
			String str = sc.next();
			for (int j = 0; j < w; j++) {
				c[i][j] = str.substring(j, j + 1);
				if (c[i][j].equals("s")) {
					startH = i;
					startW = j;
				}
				if (c[i][j].equals("g")) {
					goalH = i;
					goalW = j;
				}

			}
		}
		DfsPractice.reached = new boolean[h][w];

		dfs(startH, startW);

		if (reached[goalH][goalW]) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
		sc.close();

	}

	public static void dfs(int x, int y) {
		if (x < 0 || h <= x || y < 0 || w <= y || c[x][y].equals("#")) {
			return;
		}
		if (reached[x][y]) {
			return;
		}

		reached[x][y] = true;

		dfs(x + 1, y);
		dfs(x - 1, y);
		dfs(x, y + 1);
		dfs(x, y - 1);
	}

}
