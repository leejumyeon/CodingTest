package work;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MyHashMap<K, V> implements Map<K, V> {

    private Node<K, V>[] table;

    private int size;

    static class Node<K, V> {
        int hash;
        K key;
        V value;
        Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

    }

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        table = new Node[16];
    }

    private int hash(Object key) {
        if(key == null)
            return 0;
        return Math.abs(key.hashCode())%table.length;
    }
    
    @Override
    public void clear() {
        Node<K, V>[] tab = table;
        if (tab != null && size > 0) {
            size = 0;
            for (int i = 0; i < tab.length; i++) {
                tab[i] = null;
            }
        }
    }

    @Override
    public boolean containsKey(Object arg0) {
        int hash = hash(arg0);
        for (Node<K, V> node = table[hash]; node != null; node = node.next) {
            if(arg0!= null) {
                if (arg0.equals(node.key))
                    return true;
            }
            else {
                if(node.key == null) 
                    return true;
            }
        }
        return false;
        // *** 다른 방법으로 구현 *** //
        //return keySet().contains(arg0);
    }

    @Override
    public boolean containsValue(Object arg0) {
        for (int i = 0; i < table.length; i++) {
            for (Node<K, V> node = table[i]; node != null; node = node.next) {
                if (arg0 != null) {
                    if (arg0.equals(node.value))
                        return true;
                } else {
                    if (node.value == null)
                        return true;
                }
            }
        }
        return false;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> result = new HashSet<Entry<K, V>>();
        for (int i = 0; i < table.length; i++) {
            for (Node<K, V> node = table[i]; node != null; node = node.next) {
                Entry<K, V> element = new AbstractMap.SimpleEntry(node.key, node.value);
                result.add(element);
            }
        }
        return result;
    }

    @Override
    public V get(Object arg0) {
        int hash = hash(arg0);
        for (Node<K, V> currentNode = table[hash]; currentNode != null; currentNode = currentNode.next) {
            if(arg0!=null) {
                if (arg0.equals(currentNode.key))
                    return currentNode.value;
            }
            else {
                if(currentNode.key == null)
                    return currentNode.value;
            }
            
        }

        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Set<K> keySet() {
        Set<K> result = new HashSet<K>();
        for (int i = 0; i < table.length; i++) {
            for (Node<K, V> node = table[i]; node != null; node = node.next) {
                result.add(node.key);
            }
        }
        return result;
    }

    @Override
    public V put(K arg0, V arg1) {
        if (arg0 == null)
            throw new NullPointerException();
        if((double)size/table.length > 0.7) {
            sizeUp();
        }
        int hash = hash(arg0); // hash
        Node<K, V> newNode = new Node<K, V>(hash, arg0, arg1, null);
        if (table[hash] == null) {
            table[hash] = newNode;
        } else {
            Node<K, V> currentNode = table[hash];
            Node<K, V> predNode = currentNode; // 이전 노드

            do {
                if(arg0!=null) {
                    if (arg0.equals(currentNode.key)) {
                        currentNode.value = arg1;
                        return arg1;
                    }
                }
                else {
                    if(currentNode.key == null) {
                        currentNode.value = arg1;
                        return arg1;
                    }
                }
                
                predNode = currentNode;
                currentNode = currentNode.next;
            } while (currentNode != null);
            // 수정되는 값이 없을 경우 = 새롭게 추가해야 하는 경우
            predNode.next = newNode;
        }
        size++;
        return arg1;
    }

    @SuppressWarnings("unchecked")
    private void sizeUp() { //기존에 있던 내용을 복제 후 table의 크기 확장 그리고 다시 복제한 내용을 table에 put하는 흐름
        Node<K, V>[] temp = table.clone();
        table = new Node[table.length*2];
        size = 0;
        for(int i=0; i<temp.length; i++) {
            for(Node<K, V>node = temp[i]; node!=null; node = node.next) {
                put(node.key, node.value);
            }
        }
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> arg0) {
        Iterator<? extends K> parameter = arg0.keySet().iterator();
        while (parameter.hasNext()) {
            K key = parameter.next();
            put(key, arg0.get(key));
        }
    }

    @Override
    public V remove(Object arg0) {
        int hash = hash(arg0);
        Node<K, V> currentNode = table[hash];
        Node<K, V> predNode = null;
        V result = null;
        if (currentNode == null)
            return null;
        do {
            if(arg0!=null) {
                if (arg0.equals(currentNode.key)) {
                    result = currentNode.value;
                    if (predNode == null) { // 가장 처음 요소 table[0]을 삭제할 경우
                        table[hash] = currentNode.next;
                        currentNode = null;
                    } else {
                        predNode.next = currentNode.next;
                        currentNode = null;
                    }
                    size--;
                    break;
                }
            }
            else {
                if(currentNode.key == null) {
                    result = currentNode.value;
                    if (predNode == null) { // 가장 처음 요소 table[0]을 삭제할 경우
                        table[hash] = currentNode.next;
                        currentNode = null;
                    } else {
                        predNode.next = currentNode.next;
                        currentNode = null;
                    }
                    size--;
                    break;
                }
            }
            
            predNode = currentNode;
            currentNode = currentNode.next;
        } while (currentNode != null);
        return result;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Collection<V> values() {
        Collection<V> result = new ArrayList<V>();
        for (int i = 0; i < table.length; i++) {
            for (Node<K, V> node = table[i]; node != null; node = node.next) {
                result.add(node.value);
            }
        }
        return result;
    }

}
