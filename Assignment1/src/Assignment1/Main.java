package Assignment1;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
//import com.itextpdf.layout.property.TextAlignment;
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.List;


public class Main{
    public static void main(String[] args) throws FileNotFoundException {

       //3. Define a set of predefined staff using collection concept

        Employee emp1 = new Employee("Employee1","abc@gmail.com","9234567891",80000, 3076);
        Employee emp2 = new Employee("Employee2","ghi@gmail.com","6665621898",60000, 2307);
        Employee emp3 = new Employee("Employee3","mno@gmail.com","9657689208",50000, 1923);

        ArrayList<Employee> employeeArrayList = new ArrayList<>();
        employeeArrayList.add(emp1);
        employeeArrayList.add(emp2);
        employeeArrayList.add(emp3);

        //4. Define a set of predefined time entries using collection

       Swipe swipe1 = new Swipe(1000,"9234567891", Swipe.SwipeKind.IN, LocalDateTime.of(2023, 1, 01, 10, 00, 0) );
       Swipe swipe2 = new Swipe(1001,"9234567891", Swipe.SwipeKind.OUT, LocalDateTime.of(2023, 1, 01, 17, 30, 0) );

       Swipe swipe5 = new Swipe(3000,"6665621898", Swipe.SwipeKind.IN, LocalDateTime.of(2023, 1, 01, 13, 00, 0) );
       Swipe swipe6 = new Swipe(3001,"6665621898", Swipe.SwipeKind.OUT, LocalDateTime.of(2023, 1, 01, 18, 30, 0) );

       Swipe swipe9 = new Swipe(5000,"9657689208",Swipe.SwipeKind.IN, LocalDateTime.of(2023, 1, 03, 10, 30, 0) );
       Swipe swipe10 = new Swipe(5001,"9657689208",Swipe.SwipeKind.OUT, LocalDateTime.of(2023, 1, 03, 18, 30, 0) );

       Swipe swipe11 = new Swipe(1002,"9234567891", Swipe.SwipeKind.IN, LocalDateTime.of(2023, 1, 02, 9, 00, 0) );
       Swipe swipe12 = new Swipe(1003,"9234567891", Swipe.SwipeKind.OUT, LocalDateTime.of(2023, 1, 02, 19, 30, 0) );

       Swipe swipe13 = new Swipe(3002,"6665621898", Swipe.SwipeKind.IN, LocalDateTime.of(2023, 1, 03, 12, 00, 0) );
       Swipe swipe14 = new Swipe(3003,"6665621898", Swipe.SwipeKind.OUT, LocalDateTime.of(2023, 1, 03, 19, 30, 0) );

       Swipe swipe15 = new Swipe(8000,"9657689208",Swipe.SwipeKind.IN, LocalDateTime.of(2023, 1, 05, 10, 30, 0) );
       Swipe swipe16 = new Swipe(8001,"9657689208",Swipe.SwipeKind.OUT, LocalDateTime.of(2023, 1, 05, 17, 30, 0) );

       Swipe swipe17= new Swipe(9000,"9234567891", Swipe.SwipeKind.IN, LocalDateTime.of(2023, 1, 03, 9, 00, 0) );
       Swipe swipe18 = new Swipe(9001,"9234567891", Swipe.SwipeKind.OUT, LocalDateTime.of(2023, 1, 03, 16, 30, 0) );

       Swipe swipe19 = new Swipe(1100,"6665621898", Swipe.SwipeKind.IN, LocalDateTime.of(2023, 1, 06, 13, 00, 0) );
       Swipe swipe20 = new Swipe(1101,"6665621898", Swipe.SwipeKind.OUT, LocalDateTime.of(2023, 1, 06, 19, 30, 0) );

        Swipe swipe21 = new Swipe(1102,"9657689208",Swipe.SwipeKind.IN, LocalDateTime.of(2023, 1, 06, 10, 30, 0) );
        Swipe swipe22 = new Swipe(1103,"9657689208",Swipe.SwipeKind.OUT, LocalDateTime.of(2023, 1, 06, 17, 30, 0) );

        Swipe swipe23 = new Swipe(1106,"9234567891", Swipe.SwipeKind.IN, LocalDateTime.of(2023, 1, 9, 9, 00, 0) );
        Swipe swipe24 = new Swipe(1105,"9234567891", Swipe.SwipeKind.OUT, LocalDateTime.of(2023, 1, 9, 16, 30, 0) );

        Swipe swipe25 = new Swipe(1106,"6665621898", Swipe.SwipeKind.IN, LocalDateTime.of(2023, 1, 9, 10, 00, 0) );
        Swipe swipe26 = new Swipe(1107,"6665621898", Swipe.SwipeKind.OUT, LocalDateTime.of(2023, 1, 9, 18, 30, 0) );

        Swipe swipe27 = new Swipe(1108,"9657689208",Swipe.SwipeKind.IN, LocalDateTime.of(2023, 1, 9, 9, 30, 0) );
        Swipe swipe28 = new Swipe(1109,"9657689208",Swipe.SwipeKind.OUT, LocalDateTime.of(2023, 1, 9, 18, 00, 0) );

        Swipe swipe29 = new Swipe(1110,"9234567891", Swipe.SwipeKind.IN, LocalDateTime.of(2023, 1, 10, 8, 00, 0) );
        Swipe swipe30 = new Swipe(1111,"9234567891", Swipe.SwipeKind.OUT, LocalDateTime.of(2023, 1, 10, 16, 30, 0) );

        Swipe swipe31 = new Swipe(1112,"6665621898", Swipe.SwipeKind.IN, LocalDateTime.of(2023, 1, 11, 12, 00, 0) );
        Swipe swipe32 = new Swipe(1113,"6665621898", Swipe.SwipeKind.OUT, LocalDateTime.of(2023, 1, 11, 18, 30, 0) );

        Swipe swipe33 = new Swipe(1114,"9657689208",Swipe.SwipeKind.IN, LocalDateTime.of(2023, 1, 12, 10, 30, 0) );
        Swipe swipe34 = new Swipe(1115,"9657689208",Swipe.SwipeKind.OUT, LocalDateTime.of(2023, 1, 12, 16, 30, 0) );

        Swipe swipe35= new Swipe(1116,"9234567891", Swipe.SwipeKind.IN, LocalDateTime.of(2023, 1, 13, 10, 00, 0) );
        Swipe swipe36 = new Swipe(1117,"9234567891", Swipe.SwipeKind.OUT, LocalDateTime.of(2023, 1, 13, 16, 30, 0) );

        Swipe swipe37 = new Swipe(1118,"6665621898", Swipe.SwipeKind.IN, LocalDateTime.of(2023, 1, 17, 13, 00, 0) );
        Swipe swipe38 = new Swipe(1119,"6665621898", Swipe.SwipeKind.OUT, LocalDateTime.of(2023, 1, 17, 18, 30, 0) );

        Swipe swipe39 = new Swipe(1120,"9657689208",Swipe.SwipeKind.IN, LocalDateTime.of(2023, 1, 16, 11, 30, 0) );
        Swipe swipe40 = new Swipe(1121,"9657689208",Swipe.SwipeKind.OUT, LocalDateTime.of(2023, 1, 16, 17, 30, 0) );

        Swipe swipe41 = new Swipe(1106,"9234567891", Swipe.SwipeKind.IN, LocalDateTime.of(2023, 1, 18, 9, 00, 0) );
        Swipe swipe42 = new Swipe(1105,"9234567891", Swipe.SwipeKind.OUT, LocalDateTime.of(2023, 1, 18, 16, 30, 0) );

        Swipe swipe43 = new Swipe(1106,"6665621898", Swipe.SwipeKind.IN, LocalDateTime.of(2023, 1, 18, 10, 00, 0) );
        Swipe swipe44 = new Swipe(1107,"6665621898", Swipe.SwipeKind.OUT, LocalDateTime.of(2023, 1, 18, 18, 30, 0) );

        Swipe swipe45 = new Swipe(1108,"9657689208",Swipe.SwipeKind.IN, LocalDateTime.of(2023, 1, 19, 9, 30, 0) );
        Swipe swipe46 = new Swipe(1109,"9657689208",Swipe.SwipeKind.OUT, LocalDateTime.of(2023, 1, 19, 16, 00, 0) );

        Swipe swipe47 = new Swipe(1110,"9234567891", Swipe.SwipeKind.IN, LocalDateTime.of(2023, 1, 19, 9, 00, 0) );
        Swipe swipe48 = new Swipe(1111,"9234567891", Swipe.SwipeKind.OUT, LocalDateTime.of(2023, 1, 19, 16, 30, 0) );

        Swipe swipe49 = new Swipe(1112,"6665621898", Swipe.SwipeKind.IN, LocalDateTime.of(2023, 1, 20, 12, 00, 0) );
        Swipe swipe50 = new Swipe(1113,"6665621898", Swipe.SwipeKind.OUT, LocalDateTime.of(2023, 1, 20, 17, 30, 0) );

        Swipe swipe51 = new Swipe(1114,"9657689208",Swipe.SwipeKind.IN, LocalDateTime.of(2023, 1, 20, 12, 30, 0) );
        Swipe swipe52 = new Swipe(1115,"9657689208",Swipe.SwipeKind.OUT, LocalDateTime.of(2023, 1, 20, 16, 30, 0) );

        Swipe swipe53= new Swipe(1116,"9234567891", Swipe.SwipeKind.IN, LocalDateTime.of(2023, 1, 23, 9, 00, 0) );
        Swipe swipe54 = new Swipe(1117,"9234567891", Swipe.SwipeKind.OUT, LocalDateTime.of(2023, 1, 23, 16, 30, 0) );

        Swipe swipe55 = new Swipe(1118,"6665621898", Swipe.SwipeKind.IN, LocalDateTime.of(2023, 1, 23, 11, 00, 0) );
        Swipe swipe56 = new Swipe(1119,"6665621898", Swipe.SwipeKind.OUT, LocalDateTime.of(2023, 1, 23, 18, 30, 0) );

        Swipe swipe57 = new Swipe(1120,"9657689208",Swipe.SwipeKind.IN, LocalDateTime.of(2023, 1, 24, 10, 30, 0) );
        Swipe swipe58 = new Swipe(1121,"9657689208",Swipe.SwipeKind.OUT, LocalDateTime.of(2023, 1, 24, 17, 30, 0) );

        Swipe swipe59 = new Swipe(1110,"9234567891", Swipe.SwipeKind.IN, LocalDateTime.of(2023, 1, 24, 9, 00, 0) );
        Swipe swipe60 = new Swipe(1111,"9234567891", Swipe.SwipeKind.OUT, LocalDateTime.of(2023, 1, 24, 17, 30, 0) );

        Swipe swipe61 = new Swipe(1112,"6665621898", Swipe.SwipeKind.IN, LocalDateTime.of(2023, 1, 25, 11, 00, 0) );
        Swipe swipe62 = new Swipe(1113,"6665621898", Swipe.SwipeKind.OUT, LocalDateTime.of(2023, 1, 25, 18, 30, 0) );

        Swipe swipe63 = new Swipe(1114,"9657689208",Swipe.SwipeKind.IN, LocalDateTime.of(2023, 1, 26, 10, 30, 0) );
        Swipe swipe64 = new Swipe(1115,"9657689208",Swipe.SwipeKind.OUT, LocalDateTime.of(2023, 1, 26, 17, 30, 0) );

        Swipe swipe65= new Swipe(1116,"9234567891", Swipe.SwipeKind.IN, LocalDateTime.of(2023, 1, 27, 10, 00, 0) );
        Swipe swipe66 = new Swipe(1117,"9234567891", Swipe.SwipeKind.OUT, LocalDateTime.of(2023, 1, 27, 15, 30, 0) );

        Swipe swipe67 = new Swipe(1118,"6665621898", Swipe.SwipeKind.IN, LocalDateTime.of(2023, 1, 27, 10, 30, 0) );
        Swipe swipe68 = new Swipe(1119,"6665621898", Swipe.SwipeKind.OUT, LocalDateTime.of(2023, 1, 27, 18, 30, 0) );

        Swipe swipe69 = new Swipe(1120,"9657689208",Swipe.SwipeKind.IN, LocalDateTime.of(2023, 1, 30, 9, 30, 0) );
        Swipe swipe70 = new Swipe(1121,"9657689208",Swipe.SwipeKind.OUT, LocalDateTime.of(2023, 1, 30, 16, 30, 0) );


        List<Swipe> objectList = Arrays.asList(swipe1,swipe2,swipe5,swipe6,swipe9,swipe10,swipe11,swipe12,swipe13,swipe14,swipe15,swipe16,swipe17,swipe18,swipe19,swipe20,
                                               swipe21, swipe22, swipe24, swipe23, swipe25, swipe26, swipe27, swipe28, swipe29, swipe30, swipe31, swipe32, swipe33, swipe34,
                                               swipe35, swipe36, swipe37, swipe38, swipe39, swipe40, swipe41, swipe42, swipe43, swipe44, swipe45, swipe46, swipe47, swipe48,
                                               swipe49, swipe50, swipe51, swipe52, swipe53, swipe54, swipe55, swipe56, swipe57, swipe58, swipe59, swipe60, swipe61, swipe62,
                                               swipe63, swipe64, swipe65,swipe66, swipe67, swipe68, swipe69, swipe70);

        ArrayList<Swipe> swipeArrayList = new ArrayList<>(objectList);


//        5. Compute the total time worked by each staff on each date and print it using collections
//        framework

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

//        6. Compute the total time worked by each staff for the whole month and print it using
//        collections framework

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

//        7. Compute the salary to be provided for each staff member for the month based on
//        number of days worked and perday salary and print it using collections framework


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

//        8.Create a PDF for each employee separately but with the following condition
//        Each PDF file must be created in a separate thread
//        Each PDF file must have Staff information on top followed by work timings in the
//        following format
//        Date   TimeIN    TimeOUT

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
    }
}
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