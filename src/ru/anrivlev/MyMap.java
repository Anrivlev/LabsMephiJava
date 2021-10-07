package ru.anrivlev;

public class MyMap {
    private final MyList map;
    public static class Pair {
        private final Object key;
        private Object value;
        private Pair(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
        public Object getKey() {
            return key;
        }
        public Object getValue() {
            return value;
        }
        public void setValue(Object value) {
            this.value = value;
        }
        public String toString() {
            return "(" + this.key + " " + this.value + ")";
        }
    }
    public MyMap() {
        this.map = new MyList();
    }
    public MyMap(Object key, Object value) {
        this.map = new MyList(new Pair(key, value));
    }
    public void put(Object key, Object value) {
        if (this.keyContains(key)) return;
        this.map.add(new Pair(key, value));
    }
    public Object get(Object key) {
        for (int i = 0; i < this.map.getSize(); i++) {
            Pair tmp = (Pair) this.map.get(i);
            if (tmp.key == key) return tmp.value;
        }
        return null;
    }
    public Object get(Object key, Object bydefault) {
        Object result = this.get(key);
        if (result != null) return result;
        this.put(key, bydefault);
        return bydefault;
    }
    public Object remove(Object key) {
        Object result = null;
        for (int i = 0; i < this.map.getSize(); i++) {
            Pair tmp = (Pair) this.map.get(i);
            if (tmp.key == key) {
                result = tmp.value;
                this.map.remove(i);
            }
        }
        return result;
    }
    public boolean keyContains(Object key) {
        for (int i = 0; i < this.map.getSize(); i++) {
            Pair tmp = (Pair) this.map.get(i);
            if (tmp.key == key) return true;
        }
        return false;
    }
    public MyList getKeys() {
        MyList result = new MyList();
        for (int i = 0; i < this.map.getSize(); i++) {
            Pair tmp = (Pair) this.map.get(i);
            result.add(tmp.key);
        }
        return result;
    }
    public MyList getValues() {
        MyList result = new MyList();
        for (int i = 0; i < this.map.getSize(); i++) {
            Pair tmp = (Pair) this.map.get(i);
            result.add(tmp.value);
        }
        return result;
    }
    public MyList getEntries() {
        MyList result = new MyList();
        for (int i = 0; i < this.map.getSize(); i++) {
            result.add(this.map.get(i));
        }
        return result;
    }
    public int getSize() {
        return this.map.getSize();
    }
    public boolean isEmpty() {
        return this.map.isEmpty();
    }
    public String toString() {
        return this.map.toString();
    }
}
