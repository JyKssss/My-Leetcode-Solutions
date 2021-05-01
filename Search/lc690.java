package Search;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class lc690 {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer,Integer>employeeMap=new HashMap<>();
        for (int i = 0; i < employees.size(); i++) {
            employeeMap.put(employees.get(i).id,i);
        }

        int value=0;
        Deque<Integer> list=new LinkedList<>();
        list.add(employeeMap.get(id));
        while (list.size()>0){
            Employee employee=employees.get(list.pollFirst());
            value+=employee.importance;
            for (Integer kidId : employee.subordinates) {
                list.addLast(employeeMap.get(kidId));
            }
        }
        return value;
    }

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
}
