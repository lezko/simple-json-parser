package com.lezko.simplejson;

import java.util.Iterator;

public class Obj implements Iterable<Obj> {

    enum Type {
        MAP,
        ARR,
        STR
    }

    private final Type type;

    public Obj(Type type) {
        this.type = type;
    }

    public Obj get(String s) {
        throw new RuntimeException("Operation get(String s) is not supported for object of type " + type);
    }

    public Obj put(String key, Obj value) {
        throw new RuntimeException("Operation put(String s, Obj o) is not supported for object of type " + type);
    }

    public Obj put(String key, String value) {
        throw new RuntimeException("Operation put(String key, String value) is not supported for object of type " + type);
    }

    public Obj get(Integer i) {
        throw new RuntimeException("Operation get(Integer) is not supported for object of type " + type);
    }

    public Obj append(Obj o) {
        throw new RuntimeException("Operation append(Obj o) is not supported for object of type " + type);
    }

    public Obj append(String s) {
        throw new RuntimeException("Operation append(String s) is not supported for object of type " + type);
    }

    public String val() {
        throw new RuntimeException("Operation val() is not supported for object of type " + type);
    }

    public String set(String s) {
        throw new RuntimeException("Operation set(String s) is not supported for object of type " + type);
    }

    @Override
    public Iterator<Obj> iterator() {
        throw new RuntimeException("Operation Iterator() is not supported for object of type " + type);
    }

    public static Obj fromString(String s) {
        s = s.trim();
        if (s.startsWith("{")) {
            return MapObj.fromString(s.substring(1, s.length() - 1));
        } else if (s.startsWith("[")) {
            return ArrObj.fromString(s.substring(1, s.length() - 1));
        } else {
            return StrObj.fromString(s);
        }
    }

    public Type getType() {
        return type;
    }
}
