import java.text.NumberFormat;

public class Employee {

    enum PositionTitle {

        ADMINISTRATION("Administration"),
        PRODUCTION("Production"),
        SALES("Sales"),
        MAINTENANCE("Maintenance"),
        TECHNICAL("Technical"),
        SECRETARIAL("Secretarial");

        private final String stringCase;

     PositionTitle(String jobTitle){
         this.stringCase = jobTitle;
     }

    }
    private String name;
    private PositionTitle position;
    private boolean salary;
    private double payRate;
    private int shift;
    private String startDate;

    public Employee(String name, PositionTitle position, boolean salary, double payRate, int shift, String startDate) {
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.payRate = payRate;
        this.shift = shift;
        this.startDate = startDate;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PositionTitle getPosition() {
        return position;
    }

    public void setPosition(PositionTitle position) {
        this.position = position;
    }

    public boolean isSalary() {
        return salary;
    }

    public void setSalary(boolean salary) {
        this.salary = salary;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public int getShift() {
        return shift;
    }

    public void setShift(int shift) {
        this.shift = shift;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void calculate(double hoursIn) {
        NumberFormat numFormat = NumberFormat.getNumberInstance();
        numFormat.setGroupingUsed(true);
        numFormat.setMaximumFractionDigits(2);
        numFormat.setMinimumFractionDigits(2);
        String payRateOut;
        String weeklyPayOut;

        double shiftRates[] = {1.0, 1.05, 1.1};
        double adjustedRate = payRate * shiftRates[shift - 1];
        double overtimeRate = adjustedRate * 1.5;
        double overtimeHours = 0.0;
        double baseHours = hoursIn;
        if (!salary && hoursIn > 40) {
            overtimeHours = (hoursIn - 40);
            baseHours = 40.0;

        } else if (salary) {
            baseHours = 40.0;
        }

        double weeklyPay = adjustedRate * baseHours + overtimeRate * overtimeHours;
        payRateOut = numFormat.format(payRate);
        weeklyPayOut = numFormat.format(weeklyPay);
        System.out.println("\n" + name + ":");
        System.out.println("Position: " + position.stringCase);
        System.out.println("Hourly pay rate: $" + payRateOut);
        System.out.println("This weeks earnings: $" + weeklyPayOut);

    }
}
