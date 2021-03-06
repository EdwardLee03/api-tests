package leet.code.onehundred.fiftyfive;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <a href="最小栈">https://leetcode-cn.com/problems/min-stack/</a>
 *
 * <pre>
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *     push(x) -- 将元素 x 推入栈中。
 *     pop() -- 删除栈顶的元素。
 *     top() -- 获取栈顶元素。
 *     getMin() -- 检索栈中的最小元素。
 * </pre>
 *
 * <pre>
 * 执行用时: 6 ms, 在所有 Java 提交中击败了 98.03% 的用户
 * 内存消耗: 41.3 MB, 在所有 Java 提交中击败了 16.20% 的用户
 * </pre>
 *
 * @author EdwardLee03
 * @since 2020-03-25
 */
@SuppressWarnings("unused")
public class MinStack {
    private static class Element {
        /** 元素值 */
        private int value;
        /** 最小值 */
        private int min;
    }

    /**
     * 数据值和最小值的同步栈，入栈和出栈操作是原子性的。
     *
     * 使用"双端队列"模拟"栈"（基本类型与包装类型存在自动解包装）
     */
    private Deque<Element> deque;

    /** initialize your data structure here. */
    public MinStack() {
        deque = new LinkedList<>();
    }

    public void push(int x) {
        Element e = new Element();
        e.value = x;
        int min;
        if (deque.isEmpty()) {
            e.min = x;
        } else {
            e.min = Math.min(deque.peekFirst().min, x);
        }
        deque.offerFirst(e);
    }

    public void pop() {
        deque.pollFirst();
    }

    public int top() {
        if (deque.isEmpty()) {
            return 0;
        }
        return deque.peekFirst().value;
    }

    public int getMin() {
        if (deque.isEmpty()) {
            return 0;
        }
        return deque.peekFirst().min;
    }
}
