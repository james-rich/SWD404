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

        btnAdd.addActionListener(this);
        btnRemove.addActionListener(this);

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
        constraints.fill        = GridBagConstraints.HORIZONTAL;

        this.add(lblLoad, constraints);

        constraints.gridy       = 1;
        constraints.gridx       = 1;
        constraints.gridwidth   = 1;

        this.add(lblLoadTotal, constraints);

        constraints.gridy       = 2;
        constraints.gridx       = 0;
        constraints.gridwidth   = 1;
        constraints.anchor      = GridBagConstraints.EAST;

        this.add(lblReg, constraints);

        constraints.gridy       = 2;
        constraints.gridx       = 1;
        constraints.gridwidth   = 1;

        this.add(txtReg, constraints);

        constraints.gridy       = 3;
        constraints.gridx       = 0;
        constraints.gridwidth   = 1;

        this.add(lblWeight, constraints);

        constraints.gridy       = 3;
        constraints.gridx       = 1;
        constraints.gridwidth   = 1;

        this.add(txtWeight, constraints);

        constraints.gridy       = 4;
        constraints.gridx       = 0;
        constraints.gridwidth   = 1;

        this.add(btnAdd, constraints);

        constraints.gridy       = 4;
        constraints.gridx       = 1;
        constraints.gridwidth   = 1;

        this.add(btnRemove, constraints);

        constraints.gridy       = 5;
        constraints.gridx       = 0;
        constraints.gridwidth   = 2;
        constraints.anchor      = GridBagConstraints.NORTH;
        constraints.fill        = GridBagConstraints.CENTER;

        this.add(lblEntry, constraints);

        constraints.gridy       = 6;
        constraints.gridx       = 0;
        constraints.gridwidth   = 1;

        this.add(lblFee, constraints);

        constraints.gridy       = 6;
        constraints.gridx       = 1;
        constraints.gridwidth   = 1;

        this.add(lblFeePrice, constraints);
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        if(ev.getSource().equals(btnAdd)) {
            boolean res;
            double fees;
            String reg      = txtReg.getText();
            int weight      = Integer.parseInt(txtWeight.getText());

            txtReg.setText("");
            txtWeight.setText("");

            if(weight < 800){
                System.out.println("Bike");
                Motorbike motorbike = new Motorbike(reg, weight);
                res = bridge.addVehicles(motorbike);
                fees = motorbike.calculateFees();
            }else if (weight < 3001){
                System.out.println("Car");
                Car car = new Car(reg, weight);
                res = bridge.addVehicles(car);
                fees = car.calculateFees();
            }else{
                System.out.println("lorry");
                Lorry lorry = new Lorry(reg, weight);
                res = bridge.addVehicles(lorry);
                fees = lorry.calculateFees();
            }

            if(res){
                lblEntry.setText("Accepted");
                lblFeePrice.setText("£" + String.valueOf(fees));
                lblLoadTotal.setText(String.valueOf(bridge.calcTotalWeight()) + "kg");
            }else{
                lblEntry.setText("Denied");
                lblFeePrice.setText("£0");
            }

        }

        if(ev.getSource().equals(btnRemove)) {
            boolean res;
            String reg = txtReg.getText();
            res = bridge.removeVehicles(reg);
            lblEntry.setText("Nothing To Remove");
            if (res) {
                lblEntry.setText("Vehicle Removed");
                lblFeePrice.setText("£0");
                lblLoadTotal.setText(String.valueOf(bridge.calcTotalWeight()));
            }
        }
    }
}
