import java.util.*;

interface Multiset<E> {

    /**
     * Add an element to the multiset.
     * It increases the multiplicity of the element by 1.
     */
    void add(E elem);

    /**
     * Remove an element from the multiset.
     * It decreases the multiplicity of the element by 1.
     */
    void remove(E elem);

    /**
     * Unite this multiset with another one. The result is the modified multiset (this).
     * It will contain all elements that are present in at least one of the initial multisets.
     * The multiplicity of each element is equal to the maximum multiplicity of
     * the corresponding elements in both multisets.
     */
    void union(Multiset<E> other);

    /**
     * Intersect this multiset with another one. The result is the modified multiset (this).
     * It will contain all elements that are present in the both multisets.
     * The multiplicity of each element is equal to the minimum multiplicity of
     * the corresponding elements in the intersecting multisets.
     */
    void intersect(Multiset<E> other);

    /**
     * Returns multiplicity of the given element.
     * If the set doesn't contain it, the multiplicity is 0
     */
    int getMultiplicity(E elem);

    /**
     * Check if the multiset contains an element,
     * i.e. the multiplicity > 0
     */
    boolean contains(E elem);

    /**
     * The number of unique elements,
     * that is how many different elements there are in a multiset.
     */
    int numberOfUniqueElements();

    /**
     * The size of the multiset, including repeated elements
     */
    int size();

    /**
     * The set of unique elements (without repeating)
     */
    Map<E, Integer> getMap();
    Set<E> toSet();
    String toString();
}

class HashMultiset<E> implements Multiset<E> {
    private Map<E, Integer> map = new HashMap<>();

    public Map<E, Integer> getMap() {
        return map;
    }
    @Override
    public void add(E elem) {
        map.put(elem, map.getOrDefault(elem, 0) + 1);
    }

    @Override
    public void remove(E elem) {
        if (map.containsKey(elem)) {
            map.put(elem, map.get(elem) - 1);
            if (map.get(elem) == 0) {
                map.remove(elem);
            }
        }
    }

    @Override
    public void union(Multiset<E> other) {
        int otherMult = 0;
        for (E key:other.toSet()) {
            if ((otherMult = other.getMultiplicity(key)) > this.map.getOrDefault(key, 0)) {
                this.map.put(key, otherMult);
            }
        }
    }

    @Override
    public void intersect(Multiset<E> other) {
        for (E elem : this.toSet()) {
            if (other.contains(elem)) {
                int val = other.getMultiplicity(elem);
                if (val <= this.map.get(elem)) {
                    map.put(elem, val);
                }
            } else {
                map.remove(elem);
            }
        }
    }

    @Override
    public int getMultiplicity(E elem) {
        return map.getOrDefault(elem, 0);
    }

    @Override
    public boolean contains(E elem) {
        return map.containsKey(elem);
    }

    @Override
    public int numberOfUniqueElements() {
        return map.keySet().size();
    }

    @Override
    public int size() {
        int size = 0;
        for (int in:this.map.values()
             ) {
            size += in;
        }
        return size;
    }

    @Override
    public Set<E> toSet() {
        // Creating a new HashSet<> object helps us avoid ConcurrentModificationException.
        // It is thrown when we try to iterate over elements of Map and modify them at the same time
        return new HashSet<>(map.keySet());
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (var pairs : this.map.entrySet()) {
            for (int i = 0; i < pairs.getValue(); i++) {
                stringBuilder.append(pairs.getKey()).append(" ");
            }
        }
        return stringBuilder.toString();
    }
}

class SumClass {
    public static void main(String[] args) {
        HashMultiset<Integer> hashMultiset = new HashMultiset<>();

        hashMultiset.add(1);
        hashMultiset.add(2);
        hashMultiset.add(2);
        hashMultiset.add(2);
        hashMultiset.add(4);

        HashMultiset<Integer> hashMultiset1 = new HashMultiset<>();
        hashMultiset1.add(2);
        hashMultiset1.add(2);
        hashMultiset1.add(4);
        hashMultiset1.add(5);
        hashMultiset1.add(6);
        System.out.println(hashMultiset.toString());
        System.out.println(hashMultiset.numberOfUniqueElements());
        System.out.println(hashMultiset1.toString());
        hashMultiset.intersect(hashMultiset1);
        System.out.println(hashMultiset.toString());
    }
}