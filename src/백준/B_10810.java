package 백준;

import java.util.Scanner;

public class B_10810 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int n, m, i, j, k;
		n = scanner.nextInt();
		m = scanner.nextInt();
		
		int[] pocket = new int[n];
		
		for(int l = 0; l < m; l++) {
			scanner.nextLine();
			i = scanner.nextInt();
			j = scanner.nextInt();
			k = scanner.nextInt();
			for(int x = i; x <= j; x++) {
				pocket[x-1] = k;
			}
		}
		for(int x = 0; x < pocket.length; x++) {
			System.out.print(pocket[x] + " ");
		}
		
	}

}
		//공을 넣을 바구니 범위를 정하고, 정한 바구니에 모두 같은 번호가 적혀있는 공을 넣음
		//바구니에 공이 이미 있는 경우 공을 빼고, 새로 공을 넣는다
		//연속된 바구니
		//바구니 개수: N , 넣는 턴 횟수 : M
		/* 한번 넣을 때 규칙
		 * i번 ~ j번 바구니까지 k번 공을 넣음 -> 이걸 M번 함
		 */