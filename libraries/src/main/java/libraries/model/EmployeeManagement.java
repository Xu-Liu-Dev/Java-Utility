package libraries.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Handles employee-related operations such as creation, update, retrieval,
 * and deletion of employee records. This class serves as the central
 * management component for employee data within the system.
 */
@Data
public class EmployeeManagement {

    // Primary key representing the employee in the system.
    private String id;

    // The employee's given name (first name).
    private String firstName;

    // The employee's given name (last name).
    private String lastName;

    // The employee's age in years.
    private int age;

    // The department to which the employee belongs.
    private String department;

    // Monetary salary amount for the employee, stored as BigDecimal to ensure precision.
    private BigDecimal salary;

    // The date on which the employee officially joined the company.
    // Stored as LocalDate since only the calendar date is required.
    private LocalDate startDate;

    // Optional remarks or descriptive notes related to the employee.
    private String comment;
}
