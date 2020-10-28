package work;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class MyArrayList<T> implements List<T> {

    private Object[] item = new Object[10];
    private int size = 0;

    @Override
    public boolean add(T arg0) {
        sizeCheck(size);
        item[size] = arg0;
        size++;
        return true;
    }

    @Override
    public void add(int arg0, T arg1) {
        if (arg0 < 0 || arg0 > size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(arg0));
        }
        sizeCheck(size);
        System.arraycopy(item, arg0, item, arg0 + 1, size - arg0 + 1);
        item[arg0] = arg1;
        size++;
    }

    @Override
    public boolean addAll(Collection<? extends T> arg0) {
        Iterator<? extends T> iterator = arg0.iterator();
        while (iterator.hasNext()) {
            add(iterator.next());
        }
        return true;
    }

    @Override
    public boolean addAll(int arg0, Collection<? extends T> arg1) {
        if (arg0 < 0 || arg0 > size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(arg0));
        }
        int i = 0;
        Iterator<? extends T> iterator = arg1.iterator();
        while (iterator.hasNext()) {
            add(arg0 + i, iterator.next());
            i++;
        }
        return true;
    }

    @Override
    public void clear() {
        size = 0;
        item = new Object[10];
    }

    @Override
    public boolean contains(Object arg0) {
        return indexOf(arg0) >= 0;
    }

    @Override
    public boolean containsAll(Collection<?> arg0) {
        Iterator<?> iterator = arg0.iterator();
        boolean containsFlag = true;
        while (iterator.hasNext()) {
            containsFlag = contains(iterator.next());
            if (!containsFlag)
                break;
        }
        return containsFlag;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(int arg0) {
        if (arg0 < 0 || arg0 >= size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(arg0));
        }
        return (T) item[arg0];
    }

    @Override
    public int indexOf(Object arg0) {
        int idx = -1;
        for (int i = 0; i < size; i++) {
            if (arg0 == null) {
                if (arg0 == item[i]) {
                    idx = i;
                    break;
                }
            } else {
                if (arg0.equals(item[i])) {
                    idx = i;
                    break;
                }
            }
        }
        return idx;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    @Override
    public int lastIndexOf(Object arg0) {
        int idx = -1;
        for (int i = size - 1; i >= 0; i--) {
            if (arg0 == null) {
                if (arg0 == item[i]) {
                    idx = i;
                    break;
                }
            } else {
                if (arg0.equals(item[i])) {
                    idx = i;
                    break;
                }
            }
        }
        return idx;
    }

    @Override
    public ListIterator<T> listIterator() {
        return new ListIter(0);
    }

    @Override
    public ListIterator<T> listIterator(int arg0) {
        if (arg0 > size || arg0 < 0)
            throw new IndexOutOfBoundsException();
        return new ListIter(arg0);
    }

    @Override
    public boolean remove(Object arg0) {
        int idx = indexOf(arg0);
        if (idx == -1) {
            return false;
        }
        remove(idx);
        return true;
    }

    @Override
    public T remove(int arg0) {
        if (arg0 < 0 || arg0 >= size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(arg0));
        }
        System.arraycopy(item, arg0 + 1, item, arg0, size - (arg0 + 1));
        size--;
        return null;
    }

    @Override
    public boolean removeAll(Collection<?> arg0) {
        Iterator<?> iterator = arg0.iterator();
        while (iterator.hasNext()) {
            remove(iterator.next());
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> arg0) {
        for (int i = 0; i < size; i++) {
            boolean containsFlag = arg0.contains(item[i]); // arg0에 있는 요소들과 현재 뽑은 요소가 동일한 것인지 확인
            if (!containsFlag) {
                remove(i); // 요소를 제거하는 remove()메소드 실행
                i--;
            }
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T set(int arg0, T arg1) {
        if (arg0 < 0 || arg0 >= size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(arg0));
        }
        item[arg0] = arg1; // 배열의 특정 index(arg0)의 값을 새로운 값(arg1)로 수정
        return (T) item[arg0];
    }

    @Override
    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> subList(int arg0, int arg1) {
        subListRangeCheck(arg0, arg1, size());
        List<T> result = new MyArrayList<>();
        for (int i = arg0; i < arg1; i++) {
            result.add((T) item[i]);
        }
        return result;
    }

    @Override
    public Object[] toArray() {
        Object[] temp = new Object[size];
        System.arraycopy(item, 0, temp, 0, size);
        return temp; // item을 size만큼 복사한 Object[]를 반환
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T[] toArray(T[] arg0) {
        int len = arg0.length;
        if (size > len) { // 파라미터 객체의 크기가 size보다 작을경우 size크기로 고정
            len = size;
            arg0 = (T[])java.lang.reflect.Array.newInstance(
                    arg0.getClass().getComponentType(), size);
        }
        
        System.arraycopy(item, 0, arg0, 0, len);
        return arg0;
    }

    private void sizeCheck(int s) {
        if (s >= item.length) { // 추가하는 요소가 들어갈 공간이 없을 경우
            Object[] tempI = new Object[item.length * 2]; // 영역 확장
            System.arraycopy(item, 0, tempI, 0, item.length); // 기존내용 복사한 부분을 다시 item에 coppy
            this.item = tempI;
        }
    }

    // 예외 처리
    private void subListRangeCheck(int arg0, int arg1, int size) {
        if (arg0 < 0)
            throw new IndexOutOfBoundsException("fromIndex = " + arg0);
        if (arg1 > size)
            throw new IndexOutOfBoundsException("toIndex = " + arg0);
        if (arg0 > arg1)
            throw new IllegalArgumentException("fromIndex(" + arg0 + ") > toIndex(" + arg1 + ")");
    }

    // 벗어난 index값 메세지 출력
    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    // iterator 관련 class //
    private class Itr implements Iterator<T> {
        int cursor; // 다음을 가리키는 변수
        int lastRet = -1; // 현재 선택되어있는 커서의 위치 다음 커서가 0이므로 0보다 작은 값으로 초기화

        Itr() {}

        @Override
        public boolean hasNext() {
            return cursor < size; // size가 더 크다는 것은 다음 데이터가 있다는 의미
        }

        @SuppressWarnings("unchecked")
        @Override
        public T next() {
            int i = cursor;
            if (i > size)
                throw new NoSuchElementException();
            cursor = i + 1;
            lastRet = i;
            return (T) item[lastRet];
        }

        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();
            try {
                MyArrayList.this.remove(lastRet);
                cursor = lastRet;
                lastRet = -1;
            } catch (IndexOutOfBoundsException e) {
                throw new ConcurrentModificationException();
            }
        }

    }

    private class ListIter extends Itr implements ListIterator<T> {
        ListIter(int index) {
            cursor = index;
        }

        @Override
        public boolean hasPrevious() {
            return cursor != 0;
        }

        @SuppressWarnings("unchecked")
        @Override
        public T previous() {
            int i = cursor - 1;
            if (i < 0)
                throw new NoSuchElementException();
            cursor = i;
            lastRet = i;
            return (T) item[lastRet];
        }

        @Override
        public int nextIndex() {
            return cursor;
        }

        @Override
        public int previousIndex() {
            return cursor - 1;
        }

        @Override
        public void set(T e) {
            if (lastRet < 0 || lastRet >= size)
                throw new IndexOutOfBoundsException();
            MyArrayList.this.set(lastRet, e);
        }

        @Override
        public void add(T e) {
            try {
                int i = cursor;
                MyArrayList.this.add(i, e);
                cursor = i + 1;
                lastRet = -1;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }
    }
}
