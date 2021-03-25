import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class ListUsersPage extends JPanel {
    JTable table;
    public ListUsersPage(MainFrame frame){
        setSize(500,500);
        setLayout(null);

        table = new JTable();

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(100,100,300,250);
        add(scrollPane);

        JButton backButton = new JButton("BACK");
        backButton.setBounds(100,360,300,40);
        add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                frame.menuPage.setVisible(true);
            }
        });

    }
    public void generateTable(ArrayList<Student> students){
        String[] header = {"ID","Name","Surname","Age"};
        Object[][] objects = new Object[students.size()][4];
        for (int i = 0; i<students.size(); i++){
            objects[i][0] = students.get(i).id;
            objects[i][1] = students.get(i).name;
            objects[i][2] = students.get(i).surname;
            objects[i][3] = students.get(i).age;
        }
        DefaultTableModel tableModel = new DefaultTableModel(objects,header);
        table.setModel(tableModel);
    }


}
