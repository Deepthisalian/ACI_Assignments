<h3>1. Design a POJO object which will have name, phone no and email representing the staff, monthly salary, perday salary.</h3>

```
package Assignment1;

public class Employee {
    private String name, email;
    private String phNo;
    private double pmSalary, pdSalary;

    public Employee(){}

    public Employee(String name, String email, String phNo, double pmSalary, double pdSalary) {
        this.name = name;
        this.email = email;
        this.phNo = phNo;
        this.pmSalary = pmSalary;
        this.pdSalary = pdSalary;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhNo() {
        return phNo;
    }

    public double getPmSalary() {
        return pmSalary;
    }

    public double getPdSalary() {
        return pdSalary;
    }
} 

```

<h3>2. Design a Swipe POJO object which can have swipeid, phoneno, swipekind which can be IN or OUT and then swipe timestamp (date and time representation)</h3>

```
package Assignment1;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

public class Swipe {
    private int swipeid;
    private String phoneNo;
    private SwipeKind swipekind;
    public enum SwipeKind {
        IN,
        OUT
    }
    private LocalDateTime swipeTimestamp;

    public Swipe(){

    }
    public Swipe(int swipeid, String phoneNo, SwipeKind swipekind, LocalDateTime swipeTimestamp) {
        this.swipeid = swipeid;
        this.phoneNo = phoneNo;
        this.swipekind = swipekind;
        this.swipeTimestamp = swipeTimestamp;
    }

    public int getSwipeid() {
        return swipeid;
    }
    public String getPhoneNo() {
        return phoneNo;
    }
    public SwipeKind isSwipekind() {
        return swipekind;
    }
    public LocalDateTime getSwipeTimestamp() {
        return swipeTimestamp;
    }

}

```
<h3>3. Define a set of predefined staff using collection concept</h3>

```
Employee emp1 = new Employee("Employee1","abc@gmail.com","9234567891",80000, 3076);
Employee emp2 = new Employee("Employee2","ghi@gmail.com","6665621898",60000, 2307);
Employee emp3 = new Employee("Employee3","mno@gmail.com","9657689208",50000, 1923);

ArrayList<Employee> employeeArrayList = new ArrayList<>();
employeeArrayList.add(emp1);
employeeArrayList.add(emp2);
employeeArrayList.add(emp3);

 ```       

<h3>4. Define a set of predefined time entries using collection</h3>

```

Swipe swipe1 = new Swipe(1000,"9234567891", Swipe.SwipeKind.IN, LocalDateTime.of(2023, 1, 01, 10, 00, 0) );
Swipe swipe2 = new Swipe(1001,"9234567891", Swipe.SwipeKind.OUT, LocalDateTime.of(2023, 1, 01, 17, 30, 0) );
.
.
.
Swipe swipe69 = new Swipe(1120,"9657689208",Swipe.SwipeKind.IN, LocalDateTime.of(2023, 1, 30, 9, 30, 0) );
Swipe swipe70 = new Swipe(1121,"9657689208",Swipe.SwipeKind.OUT, LocalDateTime.of(2023, 1, 30, 16, 30, 0) );

List<Swipe> objectList = Arrays.asList(swipe1,. . . ,swipe70);

ArrayList<Swipe> swipeArrayList = new ArrayList<>(objectList);

```

<h3>5. Compute the total time worked by each staff on each date and print it using collections framework</h3>
The totalTimeWorkedPerDate HashMap</b> is a HashMap of HashMap<br />The outer hashmap has key = date and value = a hashmap of all employes that worked on that day<br />The inner hashmap has key = the employee object and value = the duration that they worked

```

HashMap<LocalDate, HashMap<Employee, Duration>> totalTimeWorkedPerDate = new HashMap<>();

        for (Swipe swipe : swipeArrayList) {
            if (swipe.isSwipekind() == Swipe.SwipeKind.OUT) {
                Swipe previousSwipe = null;
                LocalDateTime currentSwipeTimestamp = swipe.getSwipeTimestamp();

                for (Swipe s : swipeArrayList) {
                    if (s.isSwipekind() == Swipe.SwipeKind.IN &&
                            s.getPhoneNo().equals(swipe.getPhoneNo()) &&
                            s.getSwipeTimestamp().isBefore(currentSwipeTimestamp)) {
                        if (previousSwipe == null || s.getSwipeTimestamp().isAfter(previousSwipe.getSwipeTimestamp())) {
                            previousSwipe = s;
                        }
                    }
                }

                if (previousSwipe != null) {
                    LocalDate date = swipe.getSwipeTimestamp().toLocalDate();
                    Duration timeWorked = Duration.between(previousSwipe.getSwipeTimestamp(), swipe.getSwipeTimestamp());

                    HashMap<Employee, Duration> staffDurationMap = totalTimeWorkedPerDate.getOrDefault(date, new HashMap<>());
                    Employee emp = null;

                    for (Employee e : employeeArrayList) {
                        if (e.getPhNo().equals(swipe.getPhoneNo())) {
                            emp = e;
                            break;
                        }
                    }
                    if (emp != null) {
                        staffDurationMap.put(emp, staffDurationMap.getOrDefault(emp, Duration.ZERO).plus(timeWorked));
                        totalTimeWorkedPerDate.put(date, staffDurationMap);
                    }
                }
            }


        }
        //System.out.println("total Time Worked PerDate "+totalTimeWorkedPerDate.entrySet());

        //Printing out the values
        for (HashMap.Entry<LocalDate, HashMap<Employee, Duration>> outerEntry : totalTimeWorkedPerDate.entrySet()) {
            LocalDate datekey = outerEntry.getKey();
            HashMap<Employee, Duration> temp = outerEntry.getValue();

            System.out.println("\n---------------------");
            System.out.println("On date: " + datekey);
            //System.out.println("---------------------");

            for (HashMap.Entry<Employee, Duration> innerEntry : temp.entrySet()) {
                Employee innerKey = innerEntry.getKey();
                Duration duration = innerEntry.getValue();
                System.out.println(innerKey.getName() + " worked for " + duration.toHours() + " Hrs "+ duration.toMinutesPart()+" Mins");
            }
        }
      
```
The Output:

![5_aci](https://github.com/Deepthisalian/ACI_Assignments/assets/81672515/424595ef-f8a1-494b-bf56-a87dea6c5cd7)

<h3>6. Compute the total time worked by each staff for the whole month and print it using collections framework</h3>

The TimeWorkedPerMonth HashMap has key = the Employee object and value = the total duration the employee has worked for the month

```

HashMap<Employee, Duration> TimeWorkedPerMonth = new HashMap<>();

        for( HashMap<Employee, Duration > staffDurationMap : totalTimeWorkedPerDate.values()) {
            for (HashMap.Entry<Employee, Duration> entry : staffDurationMap.entrySet()) {
                Employee emp = entry.getKey();
                Duration duration = entry.getValue();
                TimeWorkedPerMonth.put(emp, TimeWorkedPerMonth.getOrDefault(emp, Duration.ZERO).plus(duration));

            }
        }

        //Printing out the values
        System.out.println("total Time Worked Per Month "+TimeWorkedPerMonth.entrySet());
        System.out.println("---------------------");
        System.out.println("Total Duration each Employee worked for the whole month");
        for (HashMap.Entry<Employee, Duration> entry :  TimeWorkedPerMonth.entrySet()) {
            Employee emp = entry.getKey();
            Duration duration = entry.getValue();
            System.out.println(emp.getName() + " worked for "+duration.toHours() + " Hrs "+ duration.toMinutesPart()+ " Mins ");
      }

```
The Output:

![6_aci](https://github.com/Deepthisalian/ACI_Assignments/assets/81672515/d20a450b-6b92-403a-bbe1-b1f6b44f32e5)

<h3>7.Compute the salary to be provided for each staff member for the month based on number of days worked and perday salary and print it using collections framework</h3>

The <b>employeeSalary</b> HashMap has key = the employee object and value = the salary which is calculated based on the duration and perday salary

```

 HashMap<Employee,Double> employeeSalary = new HashMap<>();
        for( HashMap<Employee, Duration > staffDurationMap : totalTimeWorkedPerDate.values()) {
            for (HashMap.Entry<Employee, Duration> entry : staffDurationMap.entrySet()) {
                Employee emp = entry.getKey();
                Duration duration = entry.getValue();
                double salary = (duration.toHours() * emp.getPdSalary()) + ((double) duration.toMinutes() / 60) * emp.getPdSalary();
                employeeSalary.put(emp,salary);
            }
        }

        //Printing out the values
        System.out.println("\n---------------------");
        System.out.println("Salary of all employees for the month\nName   Salary(Rs)\n----------------------");
        for (HashMap.Entry<Employee, Double> innerEntry : employeeSalary.entrySet()) {
            Employee innerKey = innerEntry.getKey();
            double salary = innerEntry.getValue();
            System.out.println(innerKey.getName() + " "+salary);
        }
        
```
The Output:     

![7_aci](https://github.com/Deepthisalian/ACI_Assignments/assets/81672515/32a3b461-771d-456a-9ee7-0d0dea493c36)

<h3>8. Create a PDF for each employee separately but with the following condition</h3>
Each PDF file must be created in a separate thread
Each PDF file must have Staff information on top followed by work timings in the following format
Date   TimeIN    TimeOUT

```

class EmployeeInformationPDF extends Thread {
    private Employee employee;
    private ArrayList<Swipe> swipeArrayList;
    private HashMap<LocalDate, HashMap<Employee, Duration>> totalTimeWorkedPerDate;

    public EmployeeInformationPDF(Employee employee, ArrayList<Swipe> swipeArrayList,
                        HashMap<LocalDate, HashMap<Employee, Duration>> totalTimeWorkedPerDate) {
        this.employee = employee;
        this.swipeArrayList = swipeArrayList;
        this.totalTimeWorkedPerDate = totalTimeWorkedPerDate;
    }

    @Override
    public void run() {
        String Name = employee.getName();
        String Phone = employee.getPhNo();
        String Email = employee.getEmail();

        String filename = Name.replaceAll("\\s", "") + ".pdf";
        PdfWriter writer = null;
        try {
            writer = new PdfWriter(filename);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document document = new Document(pdfDoc);

        document.add(new Paragraph("Employee Information"));
        document.add(new Paragraph("Name: " + Name));
        document.add(new Paragraph("Phone No: " + Phone));
        document.add(new Paragraph("Email: " + Email));

        document.add(new Paragraph("Work Timings"));

        Table table = new Table(3);
        table.addCell("Date");
        table.addCell("TimeIN");
        table.addCell("TimeOUT");

        for (LocalDate date : totalTimeWorkedPerDate.keySet()) {

            String TimeIN = "";
            String TimeOUT = "";

            for (Swipe swipe : swipeArrayList) {
                if (swipe.getPhoneNo().equals(employee.getPhNo()) && swipe.getSwipeTimestamp().toLocalDate().equals(date)) {
                    if (swipe.isSwipekind() == Swipe.SwipeKind.IN)
                        TimeIN = swipe.getSwipeTimestamp().toLocalTime().toString();

                    if (swipe.isSwipekind() == Swipe.SwipeKind.OUT)
                        TimeOUT = swipe.getSwipeTimestamp().toLocalTime().toString();
                }
            }

            table.addCell(date.toString());
            table.addCell(TimeIN);
            table.addCell(TimeOUT);
        }

        document.add(table);

        document.close();

        System.out.println("Generated PDF for  " + Name + ": " + filename);
    }
}

```

```

ArrayList<Thread> threadList = new ArrayList<>();
for (Employee emp : employeeArrayList) {
EmployeeInformationPDF empInformation = new EmployeeInformationPDF(emp, swipeArrayList, totalTimeWorkedPerDate);
Thread thread = new Thread(empInformation);
thread.start();
threadList.add(thread);
}
        
for (Thread thread : threadList) {
try {
        thread.join();
} catch (InterruptedException e) {
        e.printStackTrace();
}
}

```
