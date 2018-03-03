import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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

    private JTextArea txtCarList;

    private JPanel pnlPane[];
    private JLabel lblCaparkReg[];
    private JLabel lblCarpakColour[];
    private JLabel lblCarparkMake[];
    private JLabel lblCarparkModel[];

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
        txtCarList  = new JTextArea(20, 15);

        pnlPane         = new JPanel[15];

        lblCaparkReg    = new JLabel[15];
        lblCarpakColour = new JLabel[15];
        lblCarparkMake  = new JLabel[15];
        lblCarparkModel = new JLabel[15];

        for(int i = 0; i < pnlPane.length; i++) {
            pnlPane[i] = new JPanel();
            pnlPane[i].setLayout(new BoxLayout(pnlPane[i], BoxLayout.PAGE_AXIS));
            pnlPane[i].setBorder(BorderFactory.createTitledBorder("Space " + i));

            lblCaparkReg[i]     = new JLabel("Space");
            lblCarpakColour[i]  = new JLabel("" + i + "");
            lblCarparkMake[i]   = new JLabel("is");
            lblCarparkModel[i]  = new JLabel("empty.");

            pnlPane[i].add(lblCaparkReg[i]);
            pnlPane[i].add(lblCarpakColour[i]);
            pnlPane[i].add(lblCarparkMake[i]);
            pnlPane[i].add(lblCarparkModel[i]);
        }

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
        constraints.gridwidth   = 2;
        constraints.fill        = GridBagConstraints.HORIZONTAL;

        this.add(txtReg, constraints);

        constraints.gridy       = 1;
        constraints.gridx       = 0;
        constraints.gridwidth   = 1;
        constraints.fill        = GridBagConstraints.NONE;

        this.add(lblColour, constraints);

        constraints.gridy       = 1;
        constraints.gridx       = 1;
        constraints.gridwidth   = 2;
        constraints.fill        = GridBagConstraints.HORIZONTAL;

        this.add(txtColour, constraints);

        constraints.gridy       = 2;
        constraints.gridx       = 0;
        constraints.gridwidth   = 1;
        constraints.fill        = GridBagConstraints.NONE;

        this.add(lblMake, constraints);

        constraints.gridy       = 2;
        constraints.gridx       = 1;
        constraints.gridwidth   = 2;
        constraints.fill        = GridBagConstraints.HORIZONTAL;

        this.add(txtMake, constraints);

        constraints.gridy       = 3;
        constraints.gridx       = 0;
        constraints.gridwidth   = 1;
        constraints.fill        = GridBagConstraints.NONE;

        this.add(lblModel, constraints);

        constraints.gridy       = 3;
        constraints.gridx       = 1;
        constraints.gridwidth   = 2;
        constraints.fill        = GridBagConstraints.HORIZONTAL;

        this.add(txtModel, constraints);

        constraints.gridy       = 4;
        constraints.gridx       = 0;
        constraints.gridwidth   = 3;
        this.add(lblNumCars, constraints);

        constraints.gridy       = 5;
        constraints.gridx       = 0;
        constraints.gridwidth   = 1;
        constraints.fill        = GridBagConstraints.NONE;

        this.add(btnAdd, constraints);

        constraints.gridy       = 5;
        constraints.gridx       = 1;

        this.add(btnRemove, constraints);

        constraints.gridy       = 5;
        constraints.gridx       = 2;
        constraints.fill        = GridBagConstraints.HORIZONTAL;

        this.add(btnGet, constraints);

        constraints.gridy       = 7;
        constraints.gridx       = 0;
        constraints.gridwidth   = 3;

        this.add(txtCarList, constraints);

        constraints.gridwidth   = 1;
        constraints.gridheight  = 4;

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 3; j++){
                int tmpSpace = (i * 3) + j;
                constraints.gridy       = 30 + i * 4;
                constraints.gridx       = j;

                this.add(pnlPane[tmpSpace], constraints);
            }
        }
    }

    public void buildCarList(){
        cars = newCarpark.getCars();
        String carTxtList = "";
        for(int i = 0; i < cars.length; i++){
            if(cars[i] != null){
                carTxtList += cars[i].getNumberPlate() + "\n";
                lblCaparkReg[i].setForeground(Color.RED);
                lblCarpakColour[i].setForeground(Color.RED);
                lblCarparkMake[i].setForeground(Color.RED);
                lblCarparkModel[i].setForeground(Color.RED);
                lblCaparkReg[i].setText(cars[i].getNumberPlate());
                lblCarpakColour[i].setText(cars[i].getColour().length() > 0 ? cars[i].getColour() : "N/A");
                lblCarparkMake[i].setText(cars[i].getMake().length() > 0 ? cars[i].getMake() : "N/A");
                lblCarparkModel[i].setText(cars[i].getModel().length() > 0 ? cars[i].getModel() : "N/A");
            }else{
                lblCaparkReg[i].setText(" ");
                lblCarpakColour[i].setText(" ");
                lblCarparkMake[i].setForeground(Color.GREEN);
                lblCarparkMake[i].setText("EMPTY");
                lblCarparkModel[i].setText(" ");
            }
        }
        txtCarList.setText(carTxtList);
        txtReg.requestFocus();
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
            }else{
                JOptionPane.showMessageDialog(null, "you cant add the same car twice!");
            }
            buildCarList();
        }

        if(ev.getSource().equals(btnRemove)){
            String carReg = txtReg.getText();

            txtReg.setText("");
            txtColour.setText("");
            txtMake.setText("");
            txtModel.setText("");
            newCarpark.removeCar(carReg);

            lblNumCars.setText("There are " + newCarpark.getNumCars() + " in the carpark.");
            buildCarList();
        }

        if(ev.getSource().equals(btnGet)){
            String carReg       = txtReg.getText();

            cars = newCarpark.getCars();

            for(int i = 0; i < cars.length; i++){
                if(cars[i] != null){
                    if(cars[i].getNumberPlate().equals(carReg)) {
                        txtColour.setText(cars[i].getColour());
                        txtMake.setText(cars[i].getMake());
                        txtModel.setText(cars[i].getModel());
                    }
                }
            }
            buildCarList();
        }
    }
}


