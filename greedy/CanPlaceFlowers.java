package greedy;

/**
 * @source: leetcode605
 * @difficulty: easy
 * @topic: 种花问题
 * @link: https://leetcode.cn/problems/can-place-flowers/
 * @description:
 * @input: flowerbed = [1,0,0,0,1], n = 1
 * @output: true
 * @requirements:
 */
public class CanPlaceFlowers {
    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[]{0,1,0}, 1));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                continue;
            }
            if (flowerbed[i] == 0 && ( i == 0 || flowerbed[i - 1] == 0)
                    && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                n--;
            }
        }
        return n <= 0;
    }
}
