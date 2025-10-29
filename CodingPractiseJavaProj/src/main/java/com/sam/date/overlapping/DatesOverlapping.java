package com.sam.date.overlapping;

import org.jetbrains.annotations.NotNull;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.tuple.Pair;

public class DatesOverlapping {

    public static void main(String arg[]) {
        DatesOverlapping dol = new DatesOverlapping();
        Employee e1 = new Employee("abc", "2020-11-28 00:00:00.000", "2022-08-14 00:00:00.000");
        Employee e2 = new Employee("def", "2023-07-23 00:00:00.000", "3000-01-01 00:00:00.000");
        Employee e3 = new Employee("ser", "2019-02-16 00:00:00.000", "2019-11-05 00:00:00.000");
        Employee e4 = new Employee("abc", "2019-11-28 00:00:00.000", "2020/11/28 00:00:00.000");
        List<Employee> list = new ArrayList<>();
        list.add(e1);list.add(e2);list.add(e3);list.add(e4);
        try {
            System.out.println("overlapping response=" + dol.validateOverlapping(list));
        } catch(RuntimeException r) {
            System.out.println("RuntimeException=" + r);
        }

    }

    public boolean validateOverlapping(@NotNull List<Employee> list) throws RuntimeException {

        List<Employee> list2 = list.stream().sorted(
                (o1, o2) -> {
                    return dateConverted(o2.getExpirationDate())
                            .compareTo(dateConverted(o1.getExpirationDate()));
                })
                .collect(Collectors.toList());
        list2.forEach(d -> System.out.println("-->" + d.toString()));

        if(list2.size() > 1) {
            for(int i=0; i < (list2.size()-1); i++) {
                if(dateConverted(list2.get(i).getEffectiveDate()).before(dateConverted(list2.get(i+1).getExpirationDate()))) {
                    System.out.println("Overlapping b/w EffectiveDate= "
                            + list2.get(i).getEffectiveDate()
                            + " and ExpirationDate=" + list2.get(i+1).getExpirationDate());
                    return false;
                }
            }
        }
        return true;
    }

    public Date dateConverted(String dateStr) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = null;
        try {
            d = df.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("ParseException=" + e);
            throw new RuntimeException(e);
        }
        //System.out.println("Date=" + d);
        return d;
    }

//    public boolean validateOverlapping() {
//
//        List<Pair> list = new ArrayList();
//
//        List<Employee> list2 = list.stream().sorted(
//                        (o1, o2) -> dateConverted(o2.getExpirationDate())
//                                .compareTo(dateConverted(o1.getExpirationDate())))
//                .collect(Collectors.toList());
//        list2.forEach(d -> System.out.println("-->" + d.toString()));
//
//        if(list2.size() > 1) {
//            for(int i=0; i < (list2.size()-1); i++) {
//                if(dateConverted(list2.get(i).getEffectiveDate()).before(dateConverted(list2.get(i+1).getExpirationDate()))) {
//                    System.out.println("Overlapping b/w EffectiveDate= "
//                            + list2.get(i).getEffectiveDate()
//                            + " and ExpirationDate=" + list2.get(i+1).getExpirationDate());
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
}
