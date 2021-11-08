package com.nancy;

/**
 * 1894. 找到需要补充粉笔的学生编号
 * <p>
 * 一个班级里有 n 个学生，编号为 0 到 n - 1 。每个学生会依次回答问题，编号为 0 的学生先回答，然后是编号为 1 的学生，以此类推，直到编号为 n - 1 的学生，然后老师会重复这个过程，重新从编号为 0 的学生开始回答问题。
 * <p>
 * 给你一个长度为 n 且下标从 0 开始的整数数组 chalk 和一个整数 k 。一开始粉笔盒里总共有 k 支粉笔。当编号为 i 的学生回答问题时，他会消耗 chalk[i] 支粉笔。如果剩余粉笔数量 严格小于 chalk[i] ，那么学生 i 需要 补充 粉笔。
 * <p>
 * 请你返回需要 补充 粉笔的学生 编号 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-student-that-will-replace-the-chalk
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic1894 {
    public static void main(String[] args) {
        int[] chalk = new int[]{5, 1, 5};
        int k = 22;
        int num = chalkReplacer(chalk, k);
        System.out.println(num);
    }

    public static int chalkReplacer(int[] chalk, int k) {
        //定义为long,防止chalk数组数据过大,导致精度问题
        long sum = 0;
        for (int j : chalk) {
            sum += j;
        }
        k %= sum;
        int i = 0;
        while (true) {
            if (k < chalk[i]) {
                break;
            }
            k -= chalk[i];
            i++;
            if (i >= chalk.length) {
                i = 0;
            }
        }
        return i;
    }
}
