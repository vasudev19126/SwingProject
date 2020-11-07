package Covid;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GUI {
    static int recovery(String tower, Date date){
        int recovered = 0;
        for (Patient patient: Patient.covid_Data){
            if (patient.date_of_Recovery == null){
                patient.date_of_Recovery = AddDate.Add21Days(patient.date_of_Reporting);
            }
            if (tower.equals(patient.tower) && date.compareTo(patient.date_of_Recovery)>=0){
                recovered++;
            }
        }
        return recovered;
    }
    static int active(String tower, Date date){
        int active = 0;
        for (Patient patient: Patient.covid_Data){
            if (tower.equals(patient.tower) && date.compareTo(patient.date_of_Recovery) < 0 && date.compareTo(patient.date_of_Reporting) >= 0){
                active++;
            }
        }
        return active;
    }
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        new Patient("Flora",6, "A", dateFormat.parse("01/04/2020"));
        new Patient("Denys",24,"B", dateFormat.parse("01/04/2020"));
        new Patient("Jim",42, "C", dateFormat.parse("18/05/2020"));
        new Patient("Hazel",87, "D", dateFormat.parse("23/06/2020"));
        new Patient("Caery",72, "A", dateFormat.parse("01/06/2020"));
        new Patient("David",7, "B", dateFormat.parse("14/06/2020"));
        new Patient("Kevim",37, "D", dateFormat.parse("05/06/2020"));
        new Patient("Tom",67, "D", dateFormat.parse("20/06/2020"));
        new Patient("Bob",74, "A", dateFormat.parse("04/07/2020"));
        new Patient("Rachel",48, "C", dateFormat.parse("24/07/2020"));
        new Patient("Thomas",21, "C", dateFormat.parse("11/06/2020"));
        new Patient("Mary",17, "D", dateFormat.parse("21/06/2020"));
        new Patient("Smith",89, "A", dateFormat.parse("07/08/2020"));
        new Patient("Pearson",47, "B", dateFormat.parse("04/06/2020"));
        new Patient("Anderson",62, "B", dateFormat.parse("27/07/2020"));
        new Patient("Johnson",10, "D", dateFormat.parse("01/08/2020"));
        new Patient("Robertz",50, "A", dateFormat.parse("09/08/2020"));
        new Patient("Juile",86, "B", dateFormat.parse("02/05/2020"));
        new Patient("Edith",42, "D", dateFormat.parse("07/06/2020"));
        new Patient("John",95, "D", dateFormat.parse("01/06/2020"));
        Swing obj = new Swing();
    }
}

class Swing extends JFrame implements ItemListener {
    JLabel jlabel;
    JLabel jlabel2 ;
    JLabel jlabel_A;
    JLabel jlabel_B;
    JLabel jlabel_C;
    JLabel jlabel_D;

    JTable jTable_headA;
    JTable jTable_headB;
    JTable jTable_headC;
    JTable jTable_headD;

    JTextField jTextField;

    JCheckBox checkBox_A;
    JCheckBox checkBox_B;
    JCheckBox checkBox_C;
    JCheckBox checkBox_D;

    JTable jTable_A;
    JTable jTable_B;
    JTable jTable_C;
    JTable jTable_D;
    Swing(){
        jlabel = new JLabel("Enter Date: ");
        jlabel2 = new JLabel("Select Tower");
        jlabel_A = new JLabel();
        jlabel_B = new JLabel();
        jlabel_C = new JLabel();
        jlabel_D = new JLabel();

        jTable_headA = new JTable(1,5);
        jTable_headB = new JTable(1,5);
        jTable_headC = new JTable(1,5);
        jTable_headD = new JTable(1,5);

        jTextField = new JTextField( 20);

        checkBox_A = new JCheckBox("A");
        checkBox_B = new JCheckBox("B");
        checkBox_C = new JCheckBox("C");
        checkBox_D = new JCheckBox("D");

        checkBox_A.addItemListener(this);
        checkBox_B.addItemListener(this);
        checkBox_C.addItemListener(this);
        checkBox_D.addItemListener(this);

        jTable_A = new JTable();
        jTable_B = new JTable();
        jTable_C = new JTable();
        jTable_D = new JTable();

        jTable_headA.setValueAt("Name", 0,0);
        jTable_headA.setValueAt("Age", 0,1);
        jTable_headA.setValueAt("Tower", 0,2);
        jTable_headA.setValueAt("Reporting", 0,3);
        jTable_headA.setValueAt("Recovery", 0,4);
        jTable_headA.setForeground(Color.blue);

        jTable_headB.setValueAt("Name", 0,0);
        jTable_headB.setValueAt("Age", 0,1);
        jTable_headB.setValueAt("Tower", 0,2);
        jTable_headB.setValueAt("Reporting", 0,3);
        jTable_headB.setValueAt("Recovery", 0,4);
        jTable_headB.setForeground(Color.blue);

        jTable_headC.setValueAt("Name", 0,0);
        jTable_headC.setValueAt("Age", 0,1);
        jTable_headC.setValueAt("Tower", 0,2);
        jTable_headC.setValueAt("Reporting", 0,3);
        jTable_headC.setValueAt("Recovery", 0,4);
        jTable_headC.setForeground(Color.blue);

        jTable_headD.setValueAt("Name", 0,0);
        jTable_headD.setValueAt("Age", 0,1);
        jTable_headD.setValueAt("Tower", 0,2);
        jTable_headD.setValueAt("Reporting", 0,3);
        jTable_headD.setValueAt("Recovery", 0,4);
        jTable_headD.setForeground(Color.blue);

        jTable_headA.setVisible(false);
        jTable_A.setVisible(false);

        jTable_headB.setVisible(false);
        jTable_B.setVisible(false);

        jTable_headC.setVisible(false);
        jTable_C.setVisible(false);

        jTable_headD.setVisible(false);
        jTable_D.setVisible(false);

        add(jlabel);
        add(jTextField);
        add(jlabel2);
        add(checkBox_A);
        add(checkBox_B);
        add(checkBox_C);
        add(checkBox_D);

        add(jlabel_A);
        add(jlabel_B);
        add(jlabel_C);
        add(jlabel_D);

        add(jTable_headA);
        add(jTable_A);
        add(jTable_headB);
        add(jTable_B);
        add(jTable_headC);
        add(jTable_C);
        add(jTable_headD);
        add(jTable_D);


        FlowLayout flowLayout = new FlowLayout();
        setLayout(flowLayout);
        setTitle("Covid-19 Update");

        setSize(420, 650);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = dateFormat.parse(jTextField.getText());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (itemEvent.getSource() == checkBox_A){
            if (itemEvent.getStateChange() == ItemEvent.SELECTED){
                int recovered = GUI.recovery("A", date);
                int active = GUI.active("A", date);
                jlabel_A.setText("Tower A : Recovered = "+recovered+", Active = "+active);
                jlabel_A.setForeground(Color.red);
                jTable_A.setModel(new DefaultTableModel(recovered+active,5));


                int i=0;
                for (Patient patient: Patient.covid_Data) {
                    if (patient.tower.equals("A") && date.compareTo(patient.date_of_Reporting) >=0 ) {
                        jTable_A.setValueAt(patient.name, i, 0);
                        jTable_A.setValueAt(patient.age, i, 1);
                        jTable_A.setValueAt(patient.tower, i, 2);
                        jTable_A.setValueAt(dateFormat.format(patient.date_of_Reporting), i, 3);
                        jTable_A.setValueAt(dateFormat.format(patient.date_of_Recovery), i, 4);
                        i++;
                    }
                }
                jlabel_A.setVisible(true);
                jTable_headA.setVisible(true);
                jTable_A.setVisible(true);

            }
            else {
                jlabel_A.setVisible(false);
                jTable_A.setVisible(false);
                jTable_headA.setVisible(false);
            }
        }
        if (itemEvent.getSource() == checkBox_B){
            if (itemEvent.getStateChange() == ItemEvent.SELECTED){
                int recovered = GUI.recovery("B", date);
                int active = GUI.active("B", date);
                jlabel_B.setText("Tower B : Recovered = "+recovered+", Active = "+(active));
                jlabel_B.setForeground(Color.red);
                jTable_B.setModel(new DefaultTableModel(recovered+active,5));



                int i=0;
                for (Patient patient: Patient.covid_Data) {
                    if (patient.tower.equals("B") &&  date.compareTo(patient.date_of_Reporting) >=0) {
                        jTable_B.setValueAt(patient.name, i, 0);
                        jTable_B.setValueAt(patient.age, i, 1);
                        jTable_B.setValueAt(patient.tower, i, 2);
                        jTable_B.setValueAt(dateFormat.format(patient.date_of_Reporting), i, 3);
                        jTable_B.setValueAt(dateFormat.format(patient.date_of_Recovery), i, 4);
                        i++;
                    }
                }
                jlabel_B.setVisible(true);
                jTable_headB.setVisible(true);
                jTable_B.setVisible(true);

            }
            else {
                jlabel_B.setVisible(false);
                jTable_headB.setVisible(false);
                jTable_B.setVisible(false);
            }
        }
        if (itemEvent.getSource() == checkBox_C){
            if (itemEvent.getStateChange() == ItemEvent.SELECTED){
                int recovered = GUI.recovery("C", date);
                int active = GUI.active("C", date);
                jlabel_C.setText("Tower C : Recovered = "+recovered+", Active = "+(active));
                jlabel_C.setForeground(Color.red);
                jTable_C.setModel(new DefaultTableModel(recovered+active,5));


                int i=0;
                for (Patient patient: Patient.covid_Data) {
                    if (patient.tower.equals("C") && date.compareTo(patient.date_of_Reporting) >=0) {
                        jTable_C.setValueAt(patient.name, i, 0);
                        jTable_C.setValueAt(patient.age, i, 1);
                        jTable_C.setValueAt(patient.tower, i, 2);
                        jTable_C.setValueAt(dateFormat.format(patient.date_of_Reporting), i, 3);
                        jTable_C.setValueAt(dateFormat.format(patient.date_of_Recovery), i, 4);
                        i++;
                    }
                }
                jlabel_C.setVisible(true);
                jTable_headC.setVisible(true);
                jTable_C.setVisible(true);

            }
            else {
                jlabel_C.setVisible(false);
                jTable_headC.setVisible(false);
                jTable_C.setVisible(false);

            }
        }
        if (itemEvent.getSource() == checkBox_D){
            if (itemEvent.getStateChange() == ItemEvent.SELECTED){
                int recovered = GUI.recovery("D", date);
                int active = GUI.active("D", date);
                jlabel_D.setText("Tower D : Recovered = "+recovered+", Active = "+(active));
                jlabel_D.setForeground(Color.red);
                jTable_D.setModel(new DefaultTableModel(recovered+active,5));


                int i=0;
                for (Patient patient: Patient.covid_Data ) {
                    if (patient.tower.equals("D") && date.compareTo(patient.date_of_Reporting) >=0) {
                        jTable_D.setValueAt(patient.name, i, 0);
                        jTable_D.setValueAt(patient.age, i, 1);
                        jTable_D.setValueAt(patient.tower, i, 2);
                        jTable_D.setValueAt(dateFormat.format(patient.date_of_Reporting), i, 3);
                        jTable_D.setValueAt(dateFormat.format(patient.date_of_Recovery), i, 4);
                        i++;
                    }
                }
                jlabel_D.setVisible(true);
                jTable_headD.setVisible(true);
                jTable_D.setVisible(true);

            }
            else {
                jlabel_D.setVisible(false);
                jTable_headD.setVisible(false);
                jTable_D.setVisible(false);

            }
        }
    }
}
