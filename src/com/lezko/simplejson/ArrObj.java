package com.lezko.simplejson;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ArrObj extends Obj implements Iterable<Obj> {

    private final List<Obj> objects = new LinkedList<>();

    public ArrObj() {
        super(Type.ARR);
    }

    public ArrObj(List<String> objects) {
        this();
        this.objects.addAll(objects.stream().map(Obj::fromString).toList());
    }

    @Override
    public Obj get(Integer i) {
        return objects.get(i);
    }

    @Override
    public Obj append(Obj o) {
        objects.add(o);
        return o;
    }

    @Override
    public Obj append(String s) {
        return append(Obj.fromString(s));
    }

    public static Obj fromString(String s) {
        char[] a = s.toCharArray();
        ArrObj arrObj = new ArrObj();
        // todo check sequence if its correct using stack
        // todo handle trailing comma
        int l = 0, r, k = 0;
        k += a[0] == '[' || a[0] == '{' ? 1 : 0;
        for (r = 1; r < a.length; r++) {
            if (k == 0 && a[r] == ',') {
                arrObj.append(s.substring(l, r));
                l = r + 1;
            } else if (a[r] == '[' || a[r] == '{') {
                k++;
            } else if (a[r] == ']' || a[r] == '}') {
                k--;
            }
        }
        if (!s.isEmpty()) {
            arrObj.append(s.substring(l, r));
        }
        return arrObj;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (Obj o : objects) {
            sb.append(o.toString()).append(",");
        }
        if (objects.size() > 0) {
            sb.delete(sb.length() - 1, sb.length());
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Iterator<Obj> iterator() {
        return objects.iterator();
    }
}
