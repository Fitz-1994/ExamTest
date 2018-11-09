package thinkinjava;

import java.util.*;

/**
 * 对三种set实现类的测试
 * @author forward
 */
public class SetTest {
    public static void main(String[] args) {
        List<String> arr = Arrays.asList("d k i m a q e t c z".split(" "));
        Set<String> hashSet = new HashSet<>(arr);
        Set<String> linkedHashSet = new LinkedHashSet<>(arr);
        Set<String> treeSet = new TreeSet<>(arr);

        System.out.println("hashSet:\n"+hashSet);
        System.out.println("linkedHashSet:\n"+linkedHashSet);
        System.out.println("treeSet:\n"+treeSet);
        /*
        output:
        hashSet:
        [a, q, c, d, t, e, i, z, k, m]
        linkedHashSet:
        [d, k, i, m, a, q, e, t, c, z]
        treeSet:
        [a, c, d, e, i, k, m, q, t, z]
        ------------------------------
        hashSet以哈希值排序
        LinkedHashSet以数据的输入顺序来排序
        treeSet以元素的比较顺序排序
        * */
    }
}
