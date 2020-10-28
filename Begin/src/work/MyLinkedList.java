package work;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements List<T> {

    private Node<T> head;

    private Node<T> tail;

    private int size = 0;

    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        Node(Node<T> prev, T element, Node<T> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    @Override
    public Object[] toArray() {
        Object[] temp = new Object[size];
        int index = 0;
        for (Node<T> x = head; x != null;) {
            temp[index++] = x.item;
            x = x.next;
        }
        return temp;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T[] toArray(T[] a) {
        int index = 0;
        if (a.length < size) {
            a = (T[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
        }
        for (Node<T> x = (Node<T>) head; x != null;) {
            a[index++] = x.item;
            x = x.next;
        }
        return a;
    }

    @Override
    public boolean add(T e) {
        final Node<T> last = tail;
        final Node<T> newNode = new Node<>(last, e, null);
        tail = newNode;
        if (last == null)
            head = newNode;
        else
            last.next = newNode;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (o != null) { // 찾고자 하는 것이 null이 아닐 경우
            for (Node<T> x = head; x != null;) {
                if (o.equals(x.item))
                    unlink(x);
                x = x.next;
            }
        } else { // 찾고자 하는 것이 null일 경우
            for (Node<T> x = head; x != null;) {
                if (x.item == null)
                    unlink(x);
                x = x.next;
            }
        }
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        Iterator<?> cIter = c.iterator();
        boolean containFlag = true;
        while (cIter.hasNext()) {
            containFlag = contains(cIter.next());
            if (!containFlag)
                break;
        }
        return containFlag;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        Iterator<? extends T> cIter = c.iterator();
        while (cIter.hasNext()) {
            add(cIter.next());
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
        Iterator<? extends T> cIter = c.iterator();
        while (cIter.hasNext()) {
            add(index, cIter.next());
            index++;
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        Iterator<?> cIter = c.iterator();
        while (cIter.hasNext()) {
            Object nextElement = cIter.next();
            while (indexOf(nextElement) >= 0) {
                remove(nextElement);
            }
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        for (int i = 0; i < size; i++) {
            boolean containFlag = c.contains(this.get(i)); // 노드의 요소 하나하나를 Collection c와 공통 요소인지 확인
            if (!containFlag) { // 공통요소가 아닐 경우
                remove(i);
                i--;
            }
        }
        return true;
    }

    @Override
    public void clear() {
        for (Node<T> x = head; x != null;) {
            Node<T> next = x.next;
            x.item = null;
            x.prev = null;
            x.next = null;
            x = next;
        }
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public T get(int index) {
        return node(index).item;
    }

    @Override
    public T set(int index, T element) {
        node(index).item = element;
        return element;
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        } else if (index == size) { // index번호가 가장 뒤가 되는 경우 = 삽입하는 요소 다음자리가 null인 경우
            add(element);
        } else { // 삽입하는 요소 다음자리가 null이 아닌 경우
            Node<T> next = node(index); // index위치에 존재하는 현재 요소 => 앞으로 한칸 이동하게 될 요소(신규노드의 next값)
            Node<T> pred = next.prev; // index위치에 존재하는 현재요소의 이전 노드 => 신규노드의 prev값
            Node<T> newNode = new Node<T>(pred, element, next);
            next.prev = newNode; // 앞으로 이동한 요소의 prev에 신규노드를 연결
            if (pred == null) // before의 이전 노드가 없다면
                head = newNode; // newNode가 제일 처음자리
            else
                pred.next = newNode;
            size++;
        }
    }

    @Override
    public T remove(int index) {
        Node<T> removeNode = node(index);
        return unlink(removeNode);
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        if (o != null) { // 찾고자 하는 것이 null이 아닐 경우
            for (Node<T> x = head; x != null;) {
                if (o.equals(x.item))
                    return index;
                index++;
                x = x.next;
            }
        } else { // 찾고자 하는 것이 null일 경우
            for (Node<T> x = head; x != null;) {
                if (x.item == null)
                    return index;
                index++;
                x = x.next;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = size - 1;
        if (o != null) { // 찾고자 하는 것이 null이 아닐 경우
            for (Node<T> x = tail; x != null;) {
                if (o.equals(x.item))
                    return index;
                index--;
                x = x.prev;
            }
        } else { // 찾고자 하는 것이 null일 경우
            for (Node<T> x = tail; x != null;) {
                if (x.item == null)
                    return index;
                index--;
                x = x.prev;
            }
        }
        return -1;
    }

    @Override
    public ListIterator<T> listIterator() {
        return new ListItr(0);
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return new ListItr(index);
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        subListRangeCheck(fromIndex, toIndex, size());
        List<T> result = new MyLinkedList<>();
        for (int i = fromIndex; i < toIndex; i++) {
            result.add((T) this.get(i));
        }
        return result;
    }

    // linkedList의 특정 index 노드 찾기 메소드
    private Node<T> node(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
        Node<T> x = head;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    // 링크해제 메소드(remove, removeAll에서 사용)
    private T unlink(Node<T> x) {
        final T element = x.item;
        final Node<T> next = x.next;
        final Node<T> prev = x.prev;

        if (prev == null) { // 지우는 요소의 이전노드가 없을 경우
            head = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) { // 지우는 요소의 다음노드가 없을 경우
            tail = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }
        x.item = null;
        size--;
        return element;
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

    private class Itr implements Iterator<T> {

        Node<T> nextNode = head; // 다음으로 이동할 노드(커서담당)
        int nextIndex = 0;
        Node<T> currentNode; // 현재 노드

        Itr() {
        }

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public T next() {
            int i = nextIndex;
            if (i > size)
                throw new NoSuchElementException();
            currentNode = nextNode; // 현재 노드 (최초 시작시에는 head)
            nextIndex = i + 1; // 다음 위치값
            nextNode = nextNode.next; // 다음 노드 (최초 시작시에 head의 다음 노드)
            return currentNode.item;
        }
    }

    private class ListItr extends Itr implements ListIterator<T> {

        ListItr(int index) {
            nextNode = (index == size) ? null : node(index); //index값이 size와 동일하면 커서가 가야할 다음값이 없으므로 null
            nextIndex = index;
        }

        @Override
        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        @Override
        public T previous() {
            int i = nextIndex;
            if (!hasPrevious())
                throw new NoSuchElementException();
            currentNode = (nextNode == null) ? tail : nextNode.prev; //커서담당 nextNode가 null이면 현재 노드는 tail이다.
            nextNode = currentNode; //이전방향으로 이동하기 위해 nextNode에 현재 노드값 대입
            nextIndex = i - 1;
            return currentNode.item; //커서를 좌측으로 이동 후 출력
        }

        @Override
        public int nextIndex() {
            return nextIndex;
        }

        @Override
        public int previousIndex() {
            return nextIndex - 1;
        }

        @Override
        public void remove() {
            if (currentNode == null)
                throw new IllegalStateException();
            MyLinkedList.this.unlink(currentNode);
        }

        @Override
        public void set(T e) {
            if (currentNode == null)
                throw new IllegalStateException();
            currentNode.item = e;
        }

        @Override
        public void add(T e) {
            int i = nextIndex;
            if (i > size)
                throw new NoSuchElementException();
            if (nextNode == null) 
                MyLinkedList.this.add(e);
            else {
                MyLinkedList.this.add(i, e);
            }
            nextIndex++;
        }
    }

}
