import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class Gui extends JFrame implements ActionListener {
    private JLabel lblTitle;
    private JLabel lblLoad;
    private JLabel lblLoadTotal;
    private JLabel lblReg;
    private JLabel lblWeight;
    private JLabel lblEntry;
    private JLabel lblFee;
    private JLabel lblFeePrice;
    private DefaultListModel model;
    private JList lstVehicles;
    private JScrollPane pnlList;

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
        model           = new DefaultListModel<String>();
        lstVehicles     = new JList<String>(model);
        pnlList         = new JScrollPane(lstVehicles);

        txtReg          = new JTextField();
        txtWeight       = new JTextField();

        btnAdd          = new JButton("Add");
        btnRemove       = new JButton("Remove");

        lstVehicles.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        btnAdd.addActionListener(this);
        btnRemove.addActionListener(this);
        lstVehicles.addListSelectionListener(this::jListValueChanged);
        btnRemove.setEnabled(false);

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

        constraints.gridy       = 7;
        constraints.gridx       = 0;
        constraints.weightx     = 1;
        constraints.weighty     = 1;
        constraints.gridwidth   = 2;
        constraints.fill        = GridBagConstraints.BOTH;

        this.add(pnlList, constraints);
    }


    private void jListValueChanged(ListSelectionEvent evt){
        if(evt.getSource().equals(lstVehicles)){
            if(lstVehicles.getSelectedIndex() != -1) {
                btnRemove.setEnabled(true);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        if(ev.getSource().equals(btnAdd)) {
            double res      = 0;
            String reg      = txtReg.getText();
            int weight      = Integer.parseInt(txtWeight.getText());

            txtReg.setText("");
            txtWeight.setText("");

            if(weight < 800){
                System.out.println("Bike");
                motorbike = new Motorbike(reg, weight);
                res = bridge.addVehicles(motorbike);
                model.addElement(reg);
            }else if (weight < 3001){
                System.out.println("Car");
                Car car = new Car(reg, weight);
                res = bridge.addVehicles(car);
                model.addElement(reg);

            }else{
                System.out.println("lorry");
                Lorry lorry = new Lorry(reg, weight);
                res = bridge.addVehicles(lorry);
                model.addElement(reg);
            }
            lblEntry.setText("Denied");
            lblFeePrice.setText("£0");
            if(res != 0){
                lblEntry.setText("Accepted");
                lblFeePrice.setText("£" + String.valueOf(res));
                lblLoadTotal.setText(String.valueOf(bridge.calcTotalWeight()) + "kg");
            }

        }

        if(ev.getSource().equals(btnRemove)) {
            boolean res;
            lblEntry.setText("Nothing To Remove");
            String reg;

            if(lstVehicles.getSelectedIndex() != -1) {
                reg = lstVehicles.getSelectedValue().toString();
                System.out.println(lstVehicles.getSelectedIndex());
                res = bridge.removeVehicles(reg);
                if (res) {
                    lblEntry.setText("Vehicle Removed");
                    lblFeePrice.setText("£0");
                    lblLoadTotal.setText(String.valueOf(bridge.calcTotalWeight()) + "kg");
                    model.remove(lstVehicles.getSelectedIndex());
                }
            }
            btnRemove.setEnabled(false);
        }
    }
}
