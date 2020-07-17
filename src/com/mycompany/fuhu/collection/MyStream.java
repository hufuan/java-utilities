package com.mycompany.fuhu.collection;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyStream {

   public static void main(String argv[])
   {
       Map<String, String> someMap = new HashMap<>();
       someMap.put("jack","20");
       someMap.put("bill","35");
       Set<Map.Entry<String, String>> entries = someMap.entrySet();
       Set<String> keySet = someMap.keySet();
       Collection<String> values = someMap.values();
       Stream<Map.Entry<String, String>> entriesStream = entries.stream();
       Stream<String> valuesStream = values.stream();
       Stream<String> keysStream = keySet.stream();
       //1
       Optional<String> optionalName = someMap.entrySet().stream()
               .filter(e -> "20".equals(e.getValue()))
               .map(Map.Entry::getKey)
               .findFirst();
       System.out.println("current optionalName.get() = " + optionalName.get());
       //2
       optionalName = someMap.entrySet().stream()
               .filter(e -> "Non ages".equals(e.getValue()))
               .map(Map.Entry::getKey).findFirst();
       if (optionalName.isPresent()) {
           System.out.println("current  optionalName.get() = " + optionalName.get());
       }
       else {
           System.out.println("Non ages doesn't exist");
       }
       //3
       someMap.put("alice","20");
       List<String> listAges = someMap.entrySet().stream()
               .filter(e -> e.getKey().equals("alice"))
               .map(Map.Entry::getValue)
               .collect(Collectors.toList());

       System.out.println("listAges1= " + listAges);
       //4
       someMap.put("tom","95");
       listAges = someMap.entrySet().stream()
               .filter(e -> e.getKey().equals("tom"))
               .map(Map.Entry::getValue)
               .collect(Collectors.toList());
       System.out.println("listAges2= " + listAges);
       //5, same effect as 4
       listAges = someMap.entrySet().stream()
               .filter(e -> e.getKey().equals("tom"))
               .map(e->e.getValue())
               .collect(Collectors.toList());
       System.out.println("listAges3= " + listAges);
   }
}
