
/*
 * AtCoder Beginner Contest 088
 * 2018/02/18
 * D - Grid Repainting
 *
 * https://beta.atcoder.jp/contests/abc088/tasks/abc088_d
 * */

import java.awt.Point;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class GridRepainting {

	static int H, W;
	static char[][] map;
	static int[][] num;
	static Queue<Point> que = new ArrayDeque<Point>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		H = sc.nextInt();
		W = sc.nextInt();
		map = new char[H][W];
		num = new int[H][W];
		int periodCnt = 0;

		for (int i = 0; i < H; i++) {
			String temp = sc.next();
			for (int j = 0; j < W; j++) {
				map[i][j] = temp.charAt(j);
				if (map[i][j] == '.') {
					periodCnt++;
				}
			}

		}
		que.add(new Point(0, 0));
		num[0][0] = 0;
		map[0][0] = 'x';

		while (!que.isEmpty()) {
			Point a = que.poll();
			int n = num[a.x][a.y] + 1;

			solve(a.x + 1, a.y, n);
			solve(a.x - 1, a.y, n);
			solve(a.x, a.y + 1, n);
			solve(a.x, a.y - 1, n);
		}

		if (map[H - 1][W - 1] != 'x') {
			System.out.println(-1);
		} else {
			System.out.println(periodCnt - num[H - 1][W - 1] - 1);
		}
		sc.close();
	}

	public static void solve(int x, int y, int n) {
		if (x < 0 || H <= x || y < 0 || W <= y || map[x][y] == '#' || map[x][y] == 'x') {
			return;
		}
		map[x][y] = 'x';
		num[x][y] = n;
		que.add(new Point(x, y));
	}

}
