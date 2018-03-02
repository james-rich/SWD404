import javafx.scene.input.KeyCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.security.Key;

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
    private JButton btnGet;

    private GridBagConstraints constraints;

    private Carpark newCarpark;
    private Car[] cars;

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

        lblMake.setAlignmentX(Component.LEFT_ALIGNMENT);

        txtReg      = new JTextField();
        txtColour   = new JTextField();
        txtMake     = new JTextField();
        txtModel    = new JTextField();

        txtReg.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    btnAdd.doClick();
                }
            }
        });
        txtColour.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    btnAdd.doClick();
                }
            }
        });
        txtMake.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    btnAdd.doClick();
                }
            }
        });
        txtModel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    btnAdd.doClick();
                }
            }
        });


        btnAdd      = new JButton("Add Car");
        btnRemove   = new JButton("Remove Car");
        btnGet      = new JButton("Get Car");

        btnAdd.addActionListener(this);
        btnRemove.addActionListener(this);
        btnGet.addActionListener(this);

        constraints = new GridBagConstraints();

    }

    public void layoutComponents(){
        constraints.gridy       = 0;
        constraints.gridx       = 0;
        constraints.gridwidth   = 1;
        constraints.anchor      = GridBagConstraints.WEST;

        this.add(lblReg, constraints);

        constraints.gridy       = 0;
        constraints.gridx       = 1;
        constraints.fill        = GridBagConstraints.HORIZONTAL;

        this.add(txtReg, constraints);

        constraints.gridy       = 1;
        constraints.gridx       = 0;
        constraints.fill        = GridBagConstraints.NONE;

        this.add(lblColour, constraints);

        constraints.gridy       = 1;
        constraints.gridx       = 1;
        constraints.fill        = GridBagConstraints.HORIZONTAL;

        this.add(txtColour, constraints);

        constraints.gridy       = 2;
        constraints.gridx       = 0;
        constraints.fill        = GridBagConstraints.NONE;

        this.add(lblMake, constraints);

        constraints.gridy       = 2;
        constraints.gridx       = 1;
        constraints.fill        = GridBagConstraints.HORIZONTAL;

        this.add(txtMake, constraints);

        constraints.gridy       = 3;
        constraints.gridx       = 0;
        constraints.fill        = GridBagConstraints.NONE;

        this.add(lblModel, constraints);

        constraints.gridy       = 3;
        constraints.gridx       = 1;
        constraints.fill        = GridBagConstraints.HORIZONTAL;

        this.add(txtModel, constraints);

        constraints.gridy       = 4;
        constraints.gridx       = 0;
        constraints.gridwidth   = 2;

        this.add(lblNumCars, constraints);

        constraints.gridy       = 5;
        constraints.gridx       = 0;
        constraints.gridwidth   = 1;
        constraints.fill        = GridBagConstraints.NONE;

        this.add(btnAdd, constraints);

        constraints.gridy       = 5;
        constraints.gridx       = 1;

        this.add(btnRemove, constraints);

        constraints.gridy       = 6;
        constraints.gridx       = 0;
        constraints.gridwidth   = 2;
        constraints.fill        = GridBagConstraints.HORIZONTAL;

        this.add(btnGet, constraints);


    }

    @Override
    public void actionPerformed(ActionEvent ev) {

        if(ev.getSource().equals(btnAdd)){

            String carReg       = txtReg.getText();
            String carColour    = txtColour.getText();
            String carMake      = txtMake.getText();
            String carModel     = txtModel.getText();

            txtReg.setText("");
            txtColour.setText("");
            txtMake.setText("");
            txtModel.setText("");

            Car addCar = new Car(carReg, carColour, carMake, carModel);

            if(newCarpark.addCar(addCar)){
                lblNumCars.setText("There are " + newCarpark.getNumCars() + " in the carpark.");
            }

        }

        if(ev.getSource().equals(btnRemove)){
            String carReg       = txtReg.getText();

            txtReg.setText("");
            txtColour.setText("");
            txtMake.setText("");
            txtModel.setText("");
            newCarpark.removeCar(carReg);

            lblNumCars.setText("There are " + newCarpark.getNumCars() + " in the carpark.");
        }

        if(ev.getSource().equals(btnGet)){
            String carReg       = txtReg.getText();

            cars = newCarpark.getCars();

            for(int i = 0; i < cars.length; i++){
                if(cars[i] != null){
                    if(cars[i].getNumberPlate().equals(carReg)) {
                        txtColour.setText(cars[i].getColour());
                        txtMake.setText(cars[i].getMake());
                        txtModel.setText(cars[i].getModle());
                    }
                }
            }
        }
    }
}


