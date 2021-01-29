package core.streams;

import core.pojo.Employee;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class StreamFile {

  public static void main(String[] args) {

    int[] intar = {1, 3, 4, 542, 23, 3};
    System.out.println("Even numbers in the intar: ");
    Arrays.stream(intar).filter(n -> n % 2 == 0).forEach(n -> System.out.println(n));


    System.out.println("Double each value, and skip first two elements:");
    List<Integer> intList = Arrays.stream(intar)
        .map(n -> 2 * n).boxed()
        .sorted(Collections.reverseOrder()).skip(1).limit(4).collect(Collectors.toList());


    System.out.println(intList.toString());

    double[] listNew = Arrays.stream(intar).map(n -> 2 * n).asDoubleStream().toArray();

    String[] list = {"pdda", "dddu", "wd", "pd", "pga", "lag", "ladla"};

    String[] newStrList =
        Arrays.stream(list)
            .filter(str -> str.length() > 2)
            .map(str -> str.trim().substring(0, 2))
            .toArray(String[]::new);

    Arrays.stream(newStrList).forEach(str -> System.out.println(str));

      List<String> strList = Arrays.stream(list)
              .filter(str -> str.length() > 2)
              .map(str -> str.trim().substring(0, 2))
              .collect(Collectors.toList());

    List<String> strreduce = Arrays.stream(list)
            .filter(str -> str.length() > 2)
            .map(str -> str.trim().substring(0, 2))
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());

            //  .collect(Collectors.toList());
            // mapToInt(str->str.length()).summaryStatistics().toString();
            //    .reduce("",(ans,str)->ans+","+str)



    System.out.println(strreduce.toString());

    Map<Integer, List<String>> strreduce2 = Arrays.stream(list)
            .filter(str -> str.length() > 2)
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.groupingBy(str-> str.length()));

    System.out.println(strreduce2.toString());
    String one = "somestring";
    String two = new String("somestring");
    //one = "baba";
    System.out.println(one.equals(two));

    List<Employee> employeeList = new ArrayList<>();

    employeeList.add(new Employee("kaku",2423L, LocalDate.of(1992,1,20)));
    employeeList.add(new Employee("maku",1423L, LocalDate.of(1992,2,22)));
    employeeList.add(new Employee("taku",3323L, LocalDate.of(1992,3,2)));
    employeeList.add(new Employee("laku",5423L, LocalDate.of(1992,5,1)));

    employeeList.sort(comparing(Employee::getName).reversed().thenComparing(Employee::getJoiningDate));
    // Collections.sort(employeeList);
    System.out.println(employeeList.toString());
  }
}
