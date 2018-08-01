package util;

import entity.Course_pageBean;

import java.util.Comparator;

public class ComparatorCoursePage implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Course_pageBean c1 = (Course_pageBean) o1;
        Course_pageBean c2 = (Course_pageBean) o2;
        String[] l1 = c1.getNumber().split(".");
        String[] l2 = c2.getNumber().split(".");
        for (int i = 0; i < l1.length && i < l2.length; i++) {
            int flag = l1[i].compareTo(l2[i]);
            if (flag != 0)
                return flag;
        }
        if (l1.length < l2.length)
            return -1;
        else if (l1.length > l2.length)
            return 1;
        return 0;
    }
}
