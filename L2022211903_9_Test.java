import org.junit.Test;
import static org.junit.Assert.*;

public class L2022211903_9_Test {

    private final Solution9 solution = new Solution9();

    // 测试用例设计的总体原则
    // 等价类划分原则：按输入的n和dislikes的规模划分

    // 测试目的：验证正常情况下可以正确分组
    @Test
    public void testPossibleBipartition() {
        int n = 4;
        int[][] dislikes = {{1, 2}, {1, 3}, {2, 4}};
        assertTrue(solution.possibleBipartition(n, dislikes));
    }

    // 测试目的：验证无法分组的情况
    @Test
    public void testImpossibleBipartition() {
        int n = 3;
        int[][] dislikes = {{1, 2}, {1, 3}, {2, 3}};
        assertFalse(solution.possibleBipartition(n, dislikes));
    }

    // 测试目的：验证边界条件下的分组
    @Test
    public void testBoundaryCondition() {
        int n = 5;
        int[][] dislikes = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}};
        assertFalse(solution.possibleBipartition(n, dislikes));
    }


}