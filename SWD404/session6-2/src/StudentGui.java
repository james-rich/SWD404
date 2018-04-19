import javax.swing.*;
import java.awt.*;

public class StudentGui extends JFrame{

    private JLabel lblStudentFirstName;
    private JLabel lblStudentLastName;
    private JLabel lblStudentDOB;
    private JLabel lblStudentId;
    private JLabel lblCourse;

    private JTextField txtStudentFirstName;
    private JTextField txtStudentLastName;
    private JTextField txtStudentDOB;
    private JTextField txtStudentId;
    private JTextField txtCourse;

    public StudentGui(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        initComponents();
        layoutComponents();
    }

    public void initComponents(){
        lblStudentFirstName = new JLabel("First Name:");
        lblStudentLastName  = new JLabel("Last Name:");
        lblStudentDOB       = new JLabel("DOB:");
        lblStudentId        = new JLabel("Student ID:");
        lblCourse           = new JLabel("Course:");

        txtStudentFirstName = new JTextField();
        txtStudentLastName  = new JTextField();
        txtStudentDOB       = new JTextField();
        txtStudentId        = new JTextField();
        txtCourse           = new JTextField();
    }

    public void layoutComponents(){

    }


}
