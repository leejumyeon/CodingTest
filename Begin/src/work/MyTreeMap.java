package work;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class MyTreeMap<K, V> implements Map<K, V> {

    private int size = 0;

    private Node<K, V> root;

    static final class Node<K, V> {
        K key;
        V value;
        Node<K, V> left;
        Node<K, V> right;
        Node<K, V> parent;

        public Node(K key, V value, Node<K, V> parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
        }

    }

    public Node<K, V> getRoot() {
        return root;
    }

    public K getKey(Node<K, V> node) {
        return node.key;
    }

    public V getValue(Node<K, V> node) {
        return node.value;
    }

    @Override
    public void clear() {
        size = 0;
        root = null;
    }

    @Override
    public boolean containsKey(Object arg0) {
        return getNode(arg0) != null;
    }

    @Override
    public boolean containsValue(Object arg0) {
        return inOrder(arg0, root);
    }

    private boolean inOrder(Object value, Node<K, V> node) {
        if (node == null)
            return false;
        if (inOrder(value, node.left))
            return true;
        if (value != null) {
            if (value.equals(node.value))
                return true;
        } else {
            if (value == node.value)
                return true;
        }
        if (inOrder(value, node.right))
            return true;
        return false;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> result = new LinkedHashSet<Entry<K, V>>();
        inOrderEntry(result, root);
        return result;
    }

    private void inOrderEntry(Set<Entry<K, V>> set, Node<K, V> node) {
        if (node != null) {
            inOrderEntry(set, node.left);
            Map.Entry<K, V> element = new AbstractMap.SimpleEntry<K, V>(node.key, node.value);
            set.add(element);
            inOrderEntry(set, node.right);
        }
    }

    @Override
    public V get(Object arg0) {
        Node<K, V> node = getNode(arg0);
        return (node != null) ? node.value : null;
    }

    private Node<K, V> getNode(Object key) {
        if (key == null)
            throw new NullPointerException();
        Node<K, V> node = root;
        int cmp;
        @SuppressWarnings("unchecked")
        Comparable<K> comp = (Comparable<K>) key; // 비교객체
        do {
            cmp = comp.compareTo(node.key);
            if (cmp > 0) {
                node = node.right;
            } else if (cmp < 0) {
                node = node.left;
            } else { // 찾고자 하는 값을 찾았으니 return
                return node;
            }
        } while (node != null);
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Set<K> keySet() {
        Set<K> set = new TreeSet<K>();
        inOrder(set, root);
        return set;
    }

    private void inOrder(Set<K> set, Node<K, V> node) {
        if (node != null) {
            inOrder(set, node.left);
            set.add(node.key);
            inOrder(set, node.right);
        }
    }

    @Override
    public V put(K arg0, V arg1) {
        Node<K, V> node = root;
        if (node == null) { // 최초 데이터 input일 때
            root = new Node<K, V>(arg0, arg1, null);
            size = 1;
            return root.value;
        }
        // 최초 데이터 input이 아닐 경우(비교하기)
        Node<K, V> parent; // 부모노드 변수
        int cmp; // 비교결과값 변수
        if (arg0 == null)
            throw new NullPointerException();
        @SuppressWarnings("unchecked")
        Comparable<K> comp = (Comparable<K>) arg0; // 비교객체
        do {
            parent = node;
            cmp = comp.compareTo(node.key);
            if (cmp > 0) {
                node = node.right;
            } else if (cmp < 0) {
                node = node.left;
            } else { // 기존에 있는 key값이면 value값만 교체
                node.value = arg1;
                return node.value;
            }
        } while (node != null);
        // node가 null로 가장 끝자리까지 왔으면 마지막 cmp값으로 새로운 노드 연결 위치 결정
        Node<K, V> newNode = new Node<K, V>(arg0, arg1, parent);
        if (cmp > 0)
            parent.right = newNode;
        else
            parent.left = newNode;
        size++;
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> arg0) {
        Iterator<? extends K> iter = arg0.keySet().iterator();
        while (iter.hasNext()) {
            K key = iter.next();
            if (key == null)
                throw new NullPointerException();
            this.put(key, arg0.get(key));
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public V remove(Object arg0) {
        if (arg0 == null)
            throw new NullPointerException();
        Node<K, V> node = root;
        Node<K, V> parent;
        Node<K, V> left;
        Node<K, V> right;
        int cmp;
        int cmpResult = 0;
        Comparable<Object> comp = (Comparable<Object>) arg0;
        do {
            parent = (node.parent == null) ? node : node.parent;
            left = node.left;
            right = node.right;
            cmp = comp.compareTo(node.key);
            if (cmp > 0) {
                node = node.right;
            } else if (cmp < 0) {
                node = node.left;
            } else {
                if (left != null && right != null) { // 삭제 노드의 자식이 양쪽 모두 있을 경우
                    Node<K, V> lastNode = getLast(left); // 자식노드 중 왼쪽 자식부분에서 가장 오른쪽 값을 갖고 온다.
                    if (!lastNode.parent.equals(node)) { // 삭제노드가 lastNode의 부모가 아닌 경우(lastNode가 삭제노드 바로 아래에 있지 않은 경우)
                        if (lastNode.left != null)// lastNode의 left가 존재할 경우
                            rightLink(lastNode.parent, lastNode.left);
                        else
                            lastNode.parent.right = null; // 기존에 lastNode가 연결되어 있던 부분을 null로 제거
                    }

                    // 삭제노드의 부모노드와 삭제노드위치에 올 lastNode 연결
                    if (cmpResult > 0)
                        rightLink(parent, lastNode);
                    else if (cmpResult < 0)
                        leftLink(parent, lastNode);
                    else // cmpResult = 0: root인 경우
                        rootLink(lastNode);

                    // 새롭게 열결된 lastNode는 삭제노드와 연결되어있던 left, right와 연결해준다.
                    if (!lastNode.equals(left) && left != null)
                        leftLink(lastNode, left);
                    else if (left == null)
                        lastNode.left = null;

                    if (!lastNode.equals(right) && right != null)
                        rightLink(lastNode, right);
                    else if (right == null)
                        lastNode.right = null;

                } else if (right != null) { // 삭제 노드의 자식이 오른쪽만 있을 경우
                    if (cmpResult > 0)
                        rightLink(parent, right);
                    else if (cmpResult < 0)
                        leftLink(parent, right);
                    else
                        rootLink(right);

                } else if (left != null) { // 삭제 노드의 자식이 왼쪽만 있을 경우
                    if (cmpResult > 0)
                        rightLink(parent, left);
                    else if (cmpResult < 0)
                        leftLink(parent, left);
                    else
                        rootLink(left);
                } else {
                    if (cmpResult > 0)
                        parent.right = null;
                    else if (cmpResult < 0)
                        parent.left = null;
                    else
                        root = null;
                }
                node = null;
                size--;
                break;
            }
            cmpResult = cmp;
        } while (node != null);
        return null;
    }

    private Node<K, V> getLast(Node<K, V> node) {
        Node<K, V> result = node;
        Node<K, V> parent = node;
        do {
            parent = result;
            result = result.right;
        } while (result != null);
        return parent;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Collection<V> values() {
        Collection<V> result = new ArrayList<V>();
        inOrder(result, root);
        return result;
    }

    private void inOrder(Collection<V> list, Node<K, V> node) {
        if (node != null) {
            inOrder(list, node.left);
            list.add(node.value);
            inOrder(list, node.right);
        }
    }

    private void rightLink(Node<K, V> node1, Node<K, V> node2) {
        node1.right = node2;
        node2.parent = node1;
    }

    private void leftLink(Node<K, V> node1, Node<K, V> node2) {
        node1.left = node2;
        node2.parent = node1;
    }

    private void rootLink(Node<K, V> node) {
        root = node;
        root.parent = null;
    }

}
