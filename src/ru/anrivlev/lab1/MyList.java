package ru.anrivlev.lab1;

public class MyList {
    private int size;
    private Node first;
    private Node last;

    private class Node {
        Object obj;
        Node next;

        private Node(Object obj, Node next) {
            this.obj = obj;
            this.next = next;
        }

        private void set(Object obj) {
            this.obj = obj;
        }
    }

    private Node getFirstNode() {
        return this.first;
    }

    private Node getLastNode() {
        return this.last;
    }

    private Node getNode(int index) {
        if (index >= this.getSize()) {
            return null;
        } else {
            Node ptr = this.getFirstNode();
            for (int i = 0; i < index; i++) {
                ptr = ptr.next;
            }
            return ptr;
        }
    }

    public MyList() {
        this.size = 0;
        this.first = null;
        this.last = null;
    }

    public MyList(Object obj) {
        this.size = 1;
        this.first = new Node(obj, null);
        this.last = this.first;
    }

    public int getSize() {
        return size;
    }

    public void add(Object obj) {
        Node tmp = new Node(obj, null);
        if (this.getSize() == 0) {
            this.first = tmp;
        } else {
            this.getLastNode().next = tmp;
        }
        this.last = tmp;
        this.size++;
    }

    public void add(Object obj, int index) {
        if (index == 0) {
            this.first = new Node(obj, this.getFirstNode());
        } else if(index == this.size - 1) {
                Node tmp = new Node(obj, null);
                this.last.next = tmp;
                this.last = tmp;
        } else {
            Node ptr = this.getFirstNode();
            Node ptrNext = null;
            for (int i = 0; i <= index; i++) {
                ptr = ptr.next;
                if (ptr.next == null) {
                    break;
                }
            }
            if (ptr.next != null) {
                ptrNext = ptr.next;
            }
            ptr.next = new Node(obj, ptrNext);
        }
        this.size++;
    }

    public void remove(int index) {
        if (this.isEmpty()) return;
        if (index >= getSize()) return;
        if (index == 0) {
            this.first = this.first.next;
            if (this.first == null) {
                this.last = null;
            }
        } else {
            Node ptr = this.getFirstNode();
            Node ptrNext = null;
            for (int i = 1; i < index; i++) {
                ptr = ptr.next;
                if (ptr.next == null) {
                    break;
                }
            }
            if (ptr.next != null) {
                ptrNext = ptr.next;
            }
            if (ptrNext != null) {
                ptr.next = ptrNext.next;
            }
            if (index == this.getSize() - 1)
            {
                this.last = ptr;
            }
        }
        this.size--;
    }

    public Object get(int index) {
        Node ptr = this.getNode(index);
        if (ptr == null) {
            return -1;
        } else {
            return ptr.obj;
        }
    }

    public void set(Object obj, int index) {
        Node ptr = this.getNode(index);
        if (ptr != null) {
            ptr.set(obj);
        }
    }

    public boolean isEmpty() {
        return this.getSize() == 0;
    }

    public boolean contains(Object obj) {
        Node ptr = this.getFirstNode();
        while (ptr != null) {
            if (ptr.obj.equals(obj)) {
                return true;
            }
            ptr = ptr.next;
        }
        return false;
    }

    public int indexOf(Object obj) {
        int index = 0;
        Node ptr = this.getFirstNode();
        while (ptr != null) {
            if (ptr.obj.equals(obj)) {
                return index;
            }
            ptr = ptr.next;
            index++;
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("MyList{");
        Node ptr = this.getFirstNode();
        while (ptr != null) {
            result.append(ptr.obj.toString());
            ptr = ptr.next;
            if (ptr != null) {
                result.append(", ");
            }
        }
        result.append("}");
        return result.toString();
    }

    public static MyList merge(MyList a, MyList b) {
        MyList result = new MyList();
        Node nodeA = a.first;
        Node nodeB = b.first;
        while (nodeA != null && nodeB != null) {
            if ((Double) nodeA.obj < (Double) nodeB.obj) {
                result.add(nodeA.obj);
                nodeA = nodeA.next;
            } else {
                result.add(nodeB.obj);
                nodeB = nodeB.next;
            }
        }
        if (nodeA == null) {
            while(nodeB != null) {
                result.add(nodeB.obj);
                nodeB = nodeB.next;
            }
        } else if (nodeB == null) {
            while(nodeA != null) {
                result.add(nodeA.obj);
                nodeA = nodeA.next;
            }
        }
        return result;
    }
}
