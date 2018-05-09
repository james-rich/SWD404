import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Gui extends JFrame implements ActionListener {
    private JLabel lblTitle;
    private JLabel lblStormName;
    private JLabel lblWindSpeed;
    private JLabel lblTemp;
    private JLabel lblType;

    private JTextField txtStormName;
    private JTextField txtWindSpeed;
    private JTextField txtTemp;
    private JTextField txtType;

    private JButton btnAddStorm;
    private JButton btnRemoveStorm;
    private JButton btnViewStorm;

    private GridBagConstraints constraints;

    private AdviceCentre adviceCentre;

    private JDialog dialog;

    public Gui(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        adviceCentre = new AdviceCentre();
        initComponents();
        layoutComponents();
    }

    private void initComponents(){
        lblTitle        = new JLabel("Advice Centre");
        lblStormName    = new JLabel("Storm Name");
        lblWindSpeed    = new JLabel("Wind Speed");
        lblTemp         = new JLabel("Temperature");
        lblType         = new JLabel("Type");

        txtStormName    = new JTextField("");
        txtWindSpeed    = new JTextField("");
        txtTemp         = new JTextField("");
        txtType         = new JTextField("");

        btnAddStorm     = new JButton("Add Storm");
        btnRemoveStorm  = new JButton("Remove Storm");
        btnViewStorm    = new JButton("View Storm");

        constraints     = new GridBagConstraints();

        btnAddStorm.addActionListener(this);
        btnRemoveStorm.addActionListener(this);
        btnViewStorm.addActionListener(this);

        dialog          = new JDialog();
    }

    private void layoutComponents(){
        constraints.gridy       = 0;
        constraints.gridx       = 0;
        constraints.gridwidth   = 2;
        constraints.fill        = GridBagConstraints.CENTER;
        this.add(lblTitle, constraints);

        constraints.gridy       = 1;
        constraints.gridx       = 0;
        constraints.gridwidth   = 1;
        constraints.fill        = GridBagConstraints.HORIZONTAL;
        this.add(lblStormName, constraints);

        constraints.gridy       = 1;
        constraints.gridx       = 1;
        constraints.gridwidth   = 1;
        this.add(txtStormName, constraints);

        constraints.gridy       = 1;
        constraints.gridx       = 2;
        constraints.gridwidth   = 1;
        this.add(btnRemoveStorm, constraints);

        constraints.gridy       = 2;
        constraints.gridx       = 0;
        constraints.gridwidth   = 1;
        this.add(lblWindSpeed, constraints);

        constraints.gridy       = 2;
        constraints.gridx       = 1;
        constraints.gridwidth   = 1;
        this.add(txtWindSpeed, constraints);

        constraints.gridy       = 3;
        constraints.gridx       = 0;
        constraints.gridwidth   = 1;
        this.add(lblTemp, constraints);

        constraints.gridy       = 3;
        constraints.gridx       = 1;
        constraints.gridwidth   = 1;
        this.add(txtTemp, constraints);

        constraints.gridy       = 4;
        constraints.gridx       = 0;
        constraints.gridwidth   = 1;
        this.add(lblType, constraints);

        constraints.gridy       = 4;
        constraints.gridx       = 1;
        constraints.gridwidth   = 1;
        this.add(txtType, constraints);

        constraints.gridy       = 5;
        constraints.gridx       = 0;
        constraints.gridwidth   = 1;
        this.add(btnViewStorm, constraints);

        constraints.gridy       = 5;
        constraints.gridx       = 1;
        constraints.gridwidth   = 1;
        this.add(btnAddStorm, constraints);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        boolean processResult = false;
        if(actionEvent.getSource().equals(btnAddStorm)){
            String stormName = String.valueOf(txtStormName.getText());
            processResult = adviceCentre.addStorm(stormName, Integer.parseInt(txtWindSpeed.getText()), Integer.parseInt(txtTemp.getText()), txtType.getText());
            if(processResult){
                JOptionPane.showMessageDialog(null, "Storm Added");
            }else{
                JOptionPane.showMessageDialog(null, "Invalid Storm");
            }
        }

        if(actionEvent.getSource().equals(btnRemoveStorm)){
            String stormName = String.valueOf(txtStormName.getText());
            processResult = adviceCentre.removeStorm(stormName);
            if(processResult){
                JOptionPane.showMessageDialog(null, "Storm Removed");
                System.out.println("Storm Removed");
            }else{
                JOptionPane.showMessageDialog(null, "Invalid Storm Name");
            }
        }

        if(actionEvent.getSource().equals(btnViewStorm)){
            String stormName = String.valueOf(txtStormName.getText());
            Storm storm = adviceCentre.getStorm(stormName);
            if(storm != null){
                JOptionPane.showMessageDialog(null, "Name      : " + storm.getName() + "\nWind Speed: " + storm.getWindSpeed() + "\nTemp      : " + storm.getTemp() + "\nAdvice    : " + storm.getAdvice());
            }else{
                JOptionPane.showMessageDialog(null, "Invalid Storm Name");
            }
        }


    }

}
