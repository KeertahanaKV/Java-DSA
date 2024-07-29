import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sol());
    }

    public ArrayList<Integer> sol() {
        ArrayList<Integer> list = new ArrayList<>();
        int n, k;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] num = new int[n];
        k = 3;

        for (int i = 0; i < num.length; i++) {
            num[i] = sc.nextInt();
        }

        int i = 0;
        while (i < num.length) {
            int max = Integer.MIN_VALUE; // Initialize max to a very low value
            for (int j = i; j < i + k && j < num.length; j++) {
                if (num[j] > max) {
                    max = num[j];
                }
            }
            list.add(max);
            i += k; // Move to the next segment
        }

        return list;
    }
}
