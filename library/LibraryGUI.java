package library;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Swing GUI for the library system.
 * @author abdullahshahid,nafay,muhammadabdullah
 */
public class LibraryGUI extends JFrame {
    private final LibraryManager lib = new LibraryManager();
    private final JTextField idF = new JTextField(8), titleF = new JTextField(12), authF = new JTextField(12);
    private final JComboBox<Book.Status> statusC = new JComboBox<>(Book.Status.values());
    private final DefaultTableModel model =
        new DefaultTableModel(new String[]{"ID", "Title", "Author", "Status"}, 0);
    private final JTable table = new JTable(model);

    /** Builds the main window. */
    public LibraryGUI() {
        super("Library Book Management System");
        JPanel in = new JPanel(new FlowLayout());
        in.add(new JLabel("ID")); in.add(idF);
        in.add(new JLabel("Title")); in.add(titleF);
        in.add(new JLabel("Author")); in.add(authF);
        in.add(new JLabel("Status")); in.add(statusC);

        JPanel bt = new JPanel();
        String[] names = {"Add", "View All", "Update", "Delete"};
        for (String n : names) {
            JButton b = new JButton(n);
            b.addActionListener(e -> act(n));
            bt.add(b);
        }
        table.getSelectionModel().addListSelectionListener(e -> {
            int r = table.getSelectedRow();
            if (r >= 0) {
                idF.setText(model.getValueAt(r, 0).toString());
                titleF.setText(model.getValueAt(r, 1).toString());
                authF.setText(model.getValueAt(r, 2).toString());
                statusC.setSelectedItem(Book.Status.valueOf(model.getValueAt(r, 3).toString()));
            }
        });
        add(in, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(bt, BorderLayout.SOUTH);
        setSize(900, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    /**
     * Handles a button action.
     * @param a action name
     */
    private void act(String a) {
        try {
            switch (a) {
                case "Add":
                    lib.add(idF.getText(), titleF.getText(), authF.getText());
                    msg("Book added"); break;
                case "Update":
                    lib.update(idF.getText(), titleF.getText(), authF.getText(),
                               (Book.Status) statusC.getSelectedItem());
                    msg("Book updated"); break;
                case "Delete":
                    if (JOptionPane.showConfirmDialog(this, "Delete this book?", "Confirm",
                            JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) return;
                    lib.delete(idF.getText());
                    msg("Book deleted"); break;
                default: break;
            }
            refresh();
            if (a.equals("View All") && lib.getAll().isEmpty()) msg("Library is empty");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void msg(String m) { JOptionPane.showMessageDialog(this, m); }

    private void refresh() {
        model.setRowCount(0);
        for (Book b : lib.getAll())
            model.addRow(new Object[]{b.getId(), b.getTitle(), b.getAuthor(), b.getStatus()});
    }

    /**
     * Application entry point.
     * @param args unused
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LibraryGUI().setVisible(true));
    }
}