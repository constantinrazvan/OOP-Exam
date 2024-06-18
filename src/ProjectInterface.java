import Models.AuxPersonal;
import Models.Employee;
import Models.Teacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProjectInterface extends Frame{

    private Panel topPanel, middlePanel, bottomPanel;
    private Button loadButton, deleteButton, closeButton;
    private List listEmpployees;

    private TextField field;

    private ArrayList<Employee> employeeList = new ArrayList<Employee>();
    public ProjectInterface(String title) {
        super(title);

        loadButton = new Button("Load");
        deleteButton = new Button("Delete");
        closeButton = new Button("Close App");

        field = new TextField(20);

        listEmpployees = new List();

        topPanel = new Panel();
        middlePanel = new Panel();
        bottomPanel = new Panel();

        topPanel.setLayout(new FlowLayout());
        middlePanel.setLayout(new BorderLayout());
        bottomPanel.setLayout(new FlowLayout());

        topPanel.add(loadButton);
        topPanel.add(field);
        topPanel.add(deleteButton);

        middlePanel.add(listEmpployees);

        bottomPanel.add(closeButton);

        add(topPanel, BorderLayout.NORTH);
        add(middlePanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadEmployees();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteEmployee();
            }
        });

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }

    private void deleteEmployee() {
        String indexText = field.getText().trim();
        if (indexText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter an index for removing an object!");
            return;
        }

        try {
            int index = Integer.parseInt(indexText);
            if (index >= 0 && index < employeeList.size()) {
                employeeList.remove(index);
                listEmpployees.remove(index);
                field.setText("Succes!");
            } else {
                field.setText("The deletion failed!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a numeric index.");
        }
    }



    private void loadEmployees() {
        File file = new File("employees.txt");
        try (Scanner scanner = new Scanner(file)) {
            employeeList.clear();
            listEmpployees.removeAll();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                Employee newEmployee = null;

                if (parts[0].equals("Teacher") && parts.length >= 5) {
                    newEmployee = new Teacher(parts[1], Integer.parseInt(parts[2]), parts[3], parts[4]);
                } else if (parts[0].equals("AuxPersonal") && parts.length >= 6) {
                    newEmployee = new AuxPersonal(parts[1], Integer.parseInt(parts[2]), parts[3], parts[4], Integer.parseInt(parts[5]));
                }

                if (newEmployee != null) {
                    employeeList.add(newEmployee);
                    listEmpployees.add(newEmployee.toString());
                }
            }

            System.out.println("Employees loaded and displayed.");
        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
        }
    }

}
