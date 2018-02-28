import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Gui {

    ArrayList<Car> listCars=new ArrayList<Car>();

    int state = 1;
    String result;
    Carpark carpark1 = new Carpark();
    public void MakeGui() {


        JFrame f = new JFrame("Carpark Tracker");

        JPanel containerPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));

        JPanel inputPanel = new JPanel(new GridLayout(2,1));
        inputPanel.setSize(400, 200);

        JPanel addPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));

        JPanel addLeftPanel = new JPanel();
        JTextField addCarTF = new JTextField(20);
        addLeftPanel.add(addCarTF);

        JPanel addRightPanel = new JPanel();
        JButton addButton = new JButton("Add Car");
        addRightPanel.add(addButton);

        addPanel.add(addLeftPanel);
        addPanel.add(addRightPanel);
        inputPanel.add(addPanel);


        JPanel removePanel = new JPanel(new FlowLayout(FlowLayout.LEADING));

        JPanel removeLeftPanel = new JPanel();
        JTextField removeCarTF = new JTextField(20);
        removeLeftPanel.add(removeCarTF);

        JPanel removeRightPanel = new JPanel();
        JButton removeButton = new JButton("Remove Car");
        removeRightPanel.add(removeButton);

        removePanel.add(removeLeftPanel);
        removePanel.add(removeRightPanel);
        inputPanel.add(removePanel);


        JPanel textPanel = new JPanel();
        JTextArea numberTextArea = new JTextArea(30,20);
        textPanel.add(numberTextArea);

        containerPanel.add(inputPanel);
        containerPanel.add(textPanel);


        f.add(containerPanel);
        f.setSize(400, 600);
        f.setVisible(true);

        addButton.addActionListener(e -> {
            String numberPlate = addCarTF.getText();
            addCarTF.setText("");
            Car addCar = new Car(numberPlate);
            boolean carAdded = carpark1.addCar(addCar);

            listCars.add(addCar);
            if(carAdded){
                String tmp = rebuildTextArea();
                numberTextArea.setText(tmp);
            }
        });

        removeButton.addActionListener(e -> {
            String numberPlate = removeCarTF.getText();
            removeCarTF.setText("");
            Car removeCar = new Car(numberPlate);
            boolean carRemoved = carpark1.removeCar(removeCar);
            if (carRemoved) {
                ArrayList<Car> found = new ArrayList<Car>();
                for (Car car : listCars) {
                    if (car.getNumberPlate().equals(numberPlate)) {
                        found.add(car);
                    }
                }
                listCars.removeAll(found);
                String tmp = rebuildTextArea();
                numberTextArea.setText(tmp);
            }
        });
    }
    public String rebuildTextArea(){
        String tmp = "";
        for (Car car: listCars){
            tmp += car.getNumberPlate() + "\n";
        }
        return tmp;
    }
}
