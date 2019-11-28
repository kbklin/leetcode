package org.forrestlin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @program: leetcode
 * @description: 组合总合II
 * @author: forrestlin
 * @create: 2019-11-28 18:16
 */
public class L40combinationSumII {

    public static void main(String[] args) {
        L40combinationSumII test = new L40combinationSumII();
        System.out.println(test.combinationSum22(new int[]{2, 5, 2, 1, 2}, 5));
    }

    public List<List<Integer>> combinationSum22(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        // 先将数组排序，这一步很关键
        Arrays.sort(candidates);
        findCombinationSum2(candidates, 0, len, target, new Stack<>(), res);
        return res;
    }


    // residue 表示剩余，这个值一开始等于 target，基于题目中说明的"所有数字（包括目标数）都是正整数"这个条件
    // residue 在递归遍历中，只会越来越小
    private void findCombinationSum2(int[] candidates, int begin, int len, int residue, Stack<Integer> stack, List<List<Integer>> res) {
        if (begin == 1 && stack.size() == 1) {
            System.out.println("");
        }
        if (residue == 0) {
            res.add(new ArrayList<>(stack));
            return;
        }

        for (int i = begin; i < len && residue - candidates[i] >= 0; i++) {
            // 这一步之所以能够生效，其前提是数组一定是排好序的，这样才能保证：
            // 在递归调用的统一深度（层）中，一个元素只使用一次。
            //TODO 这一步剪枝操作基于 candidates 数组是排序数组的前提下
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            stack.add(candidates[i]);
            // 【关键】因为元素不可以重复使用，这里递归传递下去的是 i + 1 而不是 i
            findCombinationSum2(candidates, i + 1, len, residue - candidates[i], stack, res);
            stack.pop();
        }
    }


}
