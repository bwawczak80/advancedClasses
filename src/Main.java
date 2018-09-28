
public class Main {

    public static void main(String args[]){

        Employee emp1 = new Employee("Juan Ramirez", Employee.PositionTitle.ADMINISTRATION, true, 45.00, 1, "May 2, 2012");
        Employee emp2 = new Employee("Bob Collingwood", Employee.PositionTitle.MAINTENANCE, false, 30.00, 2, "January 15, 1998");
        Employee emp3 = new Employee("Bill Peterson", Employee.PositionTitle.TECHNICAL, false, 17.00, 3, "September 12, 2017");


        emp1.calculate(80.0);
        emp2.calculate(50.0);
        emp3.calculate(35.0);



    }


}
