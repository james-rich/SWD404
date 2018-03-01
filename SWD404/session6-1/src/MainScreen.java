import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen extends JFrame implements ActionListener {

    private JLabel lblReg;
    private JLabel lblColour;
    private JLabel lblMake;
    private JLabel lblModel;
    private JLabel lblNumCars;

    private JTextField txtReg;
    private JTextField txtColour;
    private JTextField txtMake;
    private JTextField txtModel;

    private JButton btnAdd;
    private JButton btnRemove;

    private GridBagConstraints constraints;

    private Carpark newCarpark;

    public MainScreen(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        newCarpark = new Carpark();
        initComponents();
        layoutComponents();



    }

    public void initComponents(){
        lblReg      = new JLabel("Reg Number");
        lblColour   = new JLabel("Colour");
        lblMake     = new JLabel("Make");
        lblModel    = new JLabel("Model");
        lblNumCars  = new JLabel("The carpark is empty.");

        txtReg      = new JTextField();
        txtColour   = new JTextField();
        txtMake     = new JTextField();
        txtModel    = new JTextField();

        btnAdd      = new JButton("Add Car");
        btnAdd.addActionListener(this);
        btnRemove   = new JButton("Remove Car");

        constraints = new GridBagConstraints();

    }

    public void layoutComponents(){
        constraints.gridy       = 0;
        constraints.gridx       = 0;
        constraints.gridwidth   = 1;

        this.add(lblReg, constraints);

        constraints.gridy       = 0;
        constraints.gridx       = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;

        this.add(txtReg, constraints);

        constraints.gridy       = 1;
        constraints.gridx       = 0;
        constraints.fill = GridBagConstraints.NONE;

        this.add(lblColour, constraints);

        constraints.gridy       = 1;
        constraints.gridx       = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;

        this.add(txtColour, constraints);

        constraints.gridy       = 2;
        constraints.gridx       = 0;
        constraints.fill = GridBagConstraints.NONE;

        this.add(lblMake, constraints);

        constraints.gridy       = 2;
        constraints.gridx       = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;

        this.add(txtMake, constraints);

        constraints.gridy       = 3;
        constraints.gridx       = 0;
        constraints.fill = GridBagConstraints.NONE;

        this.add(lblModel, constraints);

        constraints.gridy       = 3;
        constraints.gridx       = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;

        this.add(txtModel, constraints);

        constraints.gridy       = 4;
        constraints.gridx       = 0;
        constraints.gridwidth   = 2;

        this.add(lblNumCars, constraints);

        constraints.gridy       = 5;
        constraints.gridx       = 0;
        constraints.gridwidth   = 1;
        constraints.fill = GridBagConstraints.NONE;

        this.add(btnAdd, constraints);

        constraints.gridy       = 5;
        constraints.gridx       = 1;

        this.add(btnRemove, constraints);


    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        if(ev.getSource().equals(btnAdd)){

            String carReg = txtReg.getText();
            System.out.println(newCarpark.getNumberOfSpaces());
            Car addCar = new Car(carReg);
            System.out.println(addCar.getNumberPlate());
            if(newCarpark.addCar(addCar)){
                lblNumCars.setText("Car " + carReg + " has been added!");
            }
        }
    }
}


