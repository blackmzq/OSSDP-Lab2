import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 *
 * 给定一组 n 人（编号为 1, 2, ..., n）， 我们想把每个人分进任意大小的两组。每个人都可能不喜欢其他人，那么他们不应该属于同一组。
 *
 * 给定整数 n 和数组 dislikes ，其中 dislikes[i] = [ai, bi] ，表示不允许将编号为 ai 和  bi的人归入同一组。当可以用这种方法将所有人分进两组时，返回 true；否则返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 4, dislikes = [[1,2],[1,3],[2,4]]
 * 输出：true
 * 解释：group1 [1,4], group2 [2,3]
 * 示例 2：
 *
 * 输入：n = 3, dislikes = [[1,2],[1,3],[2,3]]
 * 输出：false
 * 示例 3：
 *
 * 输入：n = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
 * 输出：false
 *
 *
 * 提示：
 *
 * 1 <= n <= 2000
 * 0 <= dislikes.length <= 104
 * dislikes[i].length == 2
 * 1 <= dislikes[i][j] <= n
 * ai < bi
 * dislikes 中每一组都 不同
 *
 */
public class Solution9 {

    private boolean[] visited;
    private int[] group;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        // 初始化visited和group数组
        visited = new boolean[n + 1];
        group = new int[n + 1];
        Arrays.fill(group, -1);

        // 构建邻接表
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; ++i) {
            graph[i] = new ArrayList<>();
        }
        for (int[] dislike : dislikes) {
            graph[dislike[0]].add(dislike[1]);
            graph[dislike[1]].add(dislike[0]);
        }

        // 对每个节点进行DFS
        for (int i = 1; i <= n; ++i) {
            if (!visited[i]) {
                if (!dfs(graph, i, 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(List<Integer>[] graph, int node, int currGroup) {
        if (group[node] != -1) {
            return group[node] == currGroup;
        }
        group[node] = currGroup;
        visited[node] = true;
        for (int neighbor : graph[node]) {
            if (!dfs(graph, neighbor, 1 - currGroup)) {
                return false;
            }
        }
        return true;
    }
}