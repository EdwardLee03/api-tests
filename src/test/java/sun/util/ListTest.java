package sun.util;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.collect.Lists;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Test of {@link java.util.List}.
 *
 * @since 1.0
 */
public class ListTest {

    @Test
    public void forEach() {
        List<String> list = new ArrayList<>(10);
        list.add("dannong");
        for (String str : list) {
            assertThat(str).isNotEmpty(); // 不会遍历到多余的null元素
        }
    }

    @Test(dataProvider = "containsTestData")
    public <E> void contains(List<E> target, E element, boolean expected) {
        assertThat(target.contains(element)).isEqualTo(expected);
    }

    @DataProvider(name = "containsTestData")
    private static Object[][] containsTestData() {
        return new Object[][]{
                {Arrays.asList(1, null, 3), null, true},
        };
    }

    @Test(dataProvider = "addAllTestData")
    public <E> void addAll(List<E> target, List<E> list, List<E> expected) {
        target.addAll(list);
        assertThat(target.size()).isEqualTo(expected.size());
        assertThat(target).isEqualTo(expected);
    }

    @DataProvider(name = "addAllTestData")
    private static Object[][] addAllTestData() {
        return new Object[][]{
                {Collections.emptyList(), Collections.emptyList(), Collections.emptyList()},
                // Arrays.asList 返回的列表不支持增加、删除操作
                {Lists.newArrayList(3, 7), Arrays.asList(10, 3), Arrays.asList(3, 7, 10, 3)},
        };
    }


    @Test(expectedExceptions = NullPointerException.class, dataProvider = "addAllExceptionTestData")
    public <E> void addAllException(List<E> target, List<E> list) {
        target.addAll(list);
    }

    @DataProvider(name = "addAllExceptionTestData")
    private static Object[][] addAllExceptionTestData() {
        return new Object[][]{
                {Collections.emptyList(), null},
        };
    }

}
