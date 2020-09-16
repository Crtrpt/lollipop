
### DateUtils

```java
        String start = "2020-01-01 00:00:00";
        String end = "2021-01-01 00:00:01";

        List<Date> dateList = DateUtils.scale(start, end, Calendar.MONTH, 1);
        dateList.stream().forEach(s->{
            System.out.println(s);
        });
```

```java
     String start = "2020-01-01 00:00:00";
            String end = "2021-01-01 00:00:01";
     DateUtils.scale(start, end, Calendar.MONTH, 1, (Date s, Date e, Integer index) -> {
               System.out.println(s);
            });
```
```text
Wed Jan 01 00:00:00 CST 2020
Sat Feb 01 00:00:00 CST 2020
Sun Mar 01 00:00:00 CST 2020
Wed Apr 01 00:00:00 CST 2020
Fri May 01 00:00:00 CST 2020
Mon Jun 01 00:00:00 CST 2020
Wed Jul 01 00:00:00 CST 2020
Sat Aug 01 00:00:00 CST 2020
Tue Sep 01 00:00:00 CST 2020
Thu Oct 01 00:00:00 CST 2020
Sun Nov 01 00:00:00 CST 2020
Tue Dec 01 00:00:00 CST 2020
```