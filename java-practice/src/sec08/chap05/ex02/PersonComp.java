package sec08.chap05.ex02;

import java.util.Comparator;

public class PersonComp implements Comparator<Person> {
    public enum SortBy {NO, NAME, AGE, HEIGHT}

    public enum SortDir {ASC, DESC}

    private SortBy sortBy;
    private SortDir sortDir;

    public PersonComp(SortBy sortBy, SortDir sortDir) {
        this.sortBy = sortBy;
        this.sortDir = sortDir;
    }

    @Override
    public int compare(Person o1, Person o2) {
        int result = 0;
        switch (sortBy) {
            case NO:
                result = o1.getNo() > o2.getNo() ? 1 : -1;
                break;
            case NAME:
                result = o1.getName().compareTo(o2.getName());
                break;
            case AGE:
                result = o1.getAge() > o2.getAge() ? 1 : -1;
                break;
            case HEIGHT:
                result = o1.getHeight() > o2.getHeight() ? 1 : -1;
                break;
        }
        return result * (sortDir == SortDir.ASC ? 1 : -1);
    }
}
