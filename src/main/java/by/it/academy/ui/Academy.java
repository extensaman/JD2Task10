package by.it.academy.ui;

import javax.swing.*;
import java.awt.event.*;
import java.util.List;

import by.it.academy.repository.dao.impl.EntityDaoImpl;
import by.it.academy.repository.entity.Mentor;
import by.it.academy.repository.util.HibernateUtil;


public class Academy extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel Admin;
    private JPanel Mentor;
    private JPanel Student;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JButton CreateMentor;
    private JTextArea textArea1;
    private JTextPane textPane2;

    public Academy() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        List<Mentor> list = new EntityDaoImpl(HibernateUtil.getEntityManager().getEntityManagerFactory(), by.it.academy.repository.entity.Mentor.class).findAll();
list.stream().forEach(System.out::println);
        comboBox1.setModel(new DefaultComboBoxModel(list.stream().map(by.it.academy.repository.entity.Mentor::getMentorName).toArray()));

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        Academy dialog = new Academy();
        dialog.pack();
        dialog.setVisible(true);

        System.exit(0);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
