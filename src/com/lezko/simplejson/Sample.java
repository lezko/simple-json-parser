package com.lezko.simplejson;

import java.util.List;
import java.util.Map;

public class Sample {
    public static void main(String[] args) {
        // Map objects
        Obj test = new MapObj(); // map
        test.put("data1", "test for data1");
        test.put("data2", "test for data2");

        System.out.println(test.get("data1"));;
        System.out.println(test.get("data2"));;

        String str = test.toString();
        System.out.println(str);

        Obj sameTest = Obj.fromString(str);

        System.out.println(sameTest.get("data1"));
        System.out.println(sameTest.get("data2"));

        // iterate
        for (Map.Entry<String, Obj> entry : test) {
            System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
        }

        // Arr objects
        Obj arr = new ArrObj();
        arr.append("o1");
        arr.append("o2");
        arr.append("o3");
        arr.append("o4");

        System.out.println(arr.get(2));

        for (Obj o : arr.toList()) {
            System.out.println(o);
        }

        // can also iterate, keys would be indexes (of type string)
        for (Map.Entry<String, Obj> entry : arr) {
            System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
        }

        // can put arr to map
        test.put("array", arr);
        for (Obj o : test.get("array").toList()) {
            System.out.println(o.toString());
        }
    }
}
