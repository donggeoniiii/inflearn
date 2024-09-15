package collection.compare;

import java.util.Comparator;

// Comparator: 비교 기준, 비교 결과를 반환하는 compare() 메서드 있음
public class IdComparator implements Comparator<MyUser> {

    @Override
    public int compare(MyUser o1, MyUser o2) {
        return o1.getId().compareTo(o2.getId());
    }
}