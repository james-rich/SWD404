import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame implements ActionListener {

    private JLabel lblTitle;
    private JLabel lblLoad;
    private JLabel lblLoadTotal;
    private JLabel lblReg;
    private JLabel lblWeight;
    private JLabel lblEntry;
    private JLabel lblFee;
    private JLabel lblFeePrice;

    private JTextField txtReg;
    private JTextField txtWeight;

    private JButton btnAdd;
    private JButton btnRemove;

    private GridBagConstraints constraints;

    private Bridge bridge;
    private Vehicles vehicles;
    private Car car;
    private Lorry lorry;
    private Motorbike motorbike;

    public Gui(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        bridge = new Bridge();
        initComponents();
        layoutComponents();
    }

    private void initComponents() {
        lblTitle        = new JLabel("Bridge System");
        lblLoad         = new JLabel("Current Load");
        lblLoadTotal    = new JLabel("0kg");
        lblReg          = new JLabel("Registration:");
        lblWeight       = new JLabel("Weight:");
        lblEntry        = new JLabel("Entry Status!");
        lblFee          = new JLabel("Fee:");
        lblFeePrice     = new JLabel("£0.00");

        txtReg          = new JTextField();
        txtWeight       = new JTextField();

        btnAdd          = new JButton("Add");
        btnRemove       = new JButton("Remove");

        constraints = new GridBagConstraints();
    }


    private void layoutComponents() {
        constraints.gridy       = 0;
        constraints.gridx       = 0;
        constraints.gridwidth   = 2;
        constraints.fill        = GridBagConstraints.CENTER;

        this.add(lblTitle, constraints);

        constraints.gridy       = 1;
        constraints.gridx       = 0;
        constraints.gridwidth   = 1;
        constraints.fill        = GridBagConstraints.WEST;

        this.add(lblLoad, constraints);

        constraints.gridy       = 1;
        constraints.gridx       = 1;
        constraints.gridwidth   = 1;
        constraints.fill        = GridBagConstraints.HORIZONTAL;

        this.add(lblLoadTotal, constraints);

        constraints.gridy       = 2;
        constraints.gridx       = 0;
        constraints.gridwidth   = 1;
        constraints.fill        = GridBagConstraints.WEST;

        this.add(lblReg, constraints);

        constraints.gridy       = 2;
        constraints.gridx       = 1;
        constraints.gridwidth   = 1;
        constraints.fill        = GridBagConstraints.HORIZONTAL;

        this.add(txtReg, constraints);

        constraints.gridy       = 3;
        constraints.gridx       = 0;
        constraints.gridwidth   = 1;
        constraints.fill        = GridBagConstraints.WEST;

        this.add(lblWeight, constraints);

        constraints.gridy       = 3;
        constraints.gridx       = 1;
        constraints.gridwidth   = 1;
        constraints.fill        = GridBagConstraints.HORIZONTAL;

        this.add(txtWeight, constraints);

        constraints.gridy       = 4;
        constraints.gridx       = 0;
        constraints.gridwidth   = 1;
        constraints.fill        = GridBagConstraints.HORIZONTAL;

        this.add(btnAdd, constraints);

        constraints.gridy       = 4;
        constraints.gridx       = 1;
        constraints.gridwidth   = 1;
        constraints.fill        = GridBagConstraints.HORIZONTAL;

        this.add(btnRemove, constraints);

        constraints.gridy       = 5;
        constraints.gridx       = 0;
        constraints.gridwidth   = 2;
        constraints.fill        = GridBagConstraints.CENTER;

        this.add(lblEntry, constraints);

        constraints.gridy       = 6;
        constraints.gridx       = 0;
        constraints.gridwidth   = 1;
        constraints.fill        = GridBagConstraints.WEST;

        this.add(lblFee, constraints);

        constraints.gridy       = 6;
        constraints.gridx       = 1;
        constraints.gridwidth   = 1;
        constraints.fill        = GridBagConstraints.HORIZONTAL;

        this.add(lblFeePrice, constraints);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource().equals(btnAdd)) {
            String res = "";
            String reg      = txtReg.getText();
            int weight      = Integer.parseInt(txtWeight.getText());

            txtReg.setText("");
            txtWeight.setText("");

            if(weight < 800){
                motorbike = new Motorbike(reg, weight);
                res = bridge.addVehicles(motorbike);
            }else if (weight > 800 && weight < 3000){
                car = new Car(reg, weight);
                res = bridge.addVehicles(car);
            }else if (weight > 3000){
                lorry = new Lorry(reg, weight);
                res = bridge.addVehicles(lorry);
            }
            if(res != "Error!" && res.length() > 0){
                String weightRes = toString(bridge.calcTotalWeight());
                lblWeight = weightRes;
            }
        }

        if(actionEvent.getSource().equals(btnRemove)){
            String reg = txtReg.getText();
            bridge.removeVehicles(reg);
        }
    }

    private int toString(int i) {
        return i;
    }


}
