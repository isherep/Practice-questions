import java.util.HashMap;

public class HashSet<E> {

    HashMap<E, Object> map;
    private static final Object PRESENT = new Object();

    public HashSet(){
            map = new HashMap<>();
    }
    // adds an element to HashSet if its not already present and returns true
    // if it is present - leaves set unchanged and returns false
    public boolean add(E e){
        if(map.put(e, PRESENT) == null){
            return true;
        } else {
            return false;
        }
    }

//    public boolean remove(E e){
//        map.remove(e);
//    }
}

/**
 public class HashSet<E> {
 ...
 public void add(E value) { ... }
 public boolean contains(E value) {
 ...
 while (current != null) {
    if (current.data.equals(value)) { ...
 }
 public void remove(E value) { ... }
 ...
 private class HashEntry {
 private E data;
 private HashEntry next;
 ...
 }
 */
