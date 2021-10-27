package com.bad_java.lectures._14.library.view.swing;

import com.bad_java.lectures._14.library.domain.User;
import com.bad_java.lectures._14.library.infrastructure.Dispatcher;
import com.bad_java.lectures._14.library.infrastructure.Model;
import com.bad_java.lectures._14.library.infrastructure.ModelAndTarget;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.Collections;
import java.util.List;

public class SwingAdminView extends AbstractSwingView {

    private static final String ADMIN_CONTROLLER = "admin_controller";
    private final Container content = new Container();
    private final UserTableModel userTableModel = new UserTableModel();
    private final JTable usersTable = new JTable(userTableModel);
    private final JLabel usernameLabel = new JLabel("Username");
    private final JTextField usernameTextField = new JTextField();
    private final JLabel passwordLabel = new JLabel("Password");
    private final JPasswordField passwordTextField = new JPasswordField();
    private final JLabel roleLabel = new JLabel("Role");
    private final JComboBox<String> roleTextField = new JComboBox<>(new String[]{"ADMIN", "MANAGER", "CLIENT"});
    private final JButton addUserButton = new JButton("Add");

    private final JLabel removeUserIdLabel = new JLabel("User ID");
    private final JTextField removeUserIdTextField = new JTextField();
    private final JButton removeUserButton = new JButton("Remove");

    private final JButton logout = new JButton("Logout");

    private User currentUser;

    public SwingAdminView(JFrame frame, Dispatcher dispatcher) {
        super(frame, dispatcher);

        logout.addActionListener(e -> {
            Model model = new Model();
            model.put("user", currentUser);
            model.put("action", "logout");
            ModelAndTarget response = dispatcher.dispatchRequest(ADMIN_CONTROLLER, model);
            SwingUtilities.invokeLater(() -> dispatcher.dispatchResponse(response.getTargetName(), response.getModel()));
        });

        addUserButton.addActionListener(e -> {
            Model model = new Model();
            model.put("user", currentUser);
            model.put("username", usernameTextField.getText());
            model.put("password", passwordTextField.getPassword());
            model.put("type", roleTextField.getSelectedItem());
            model.put("action", "addUser");

            ModelAndTarget response = dispatcher.dispatchRequest(ADMIN_CONTROLLER, model);
            SwingUtilities.invokeLater(() -> dispatcher.dispatchResponse(response.getTargetName(), response.getModel()));
        });

        removeUserButton.addActionListener(e -> {
            Model model = new Model();
            model.put("user", currentUser);
            model.put("userId", Long.parseLong(removeUserIdTextField.getText()));
            model.put("action", "deleteUser");

            ModelAndTarget response = dispatcher.dispatchRequest(ADMIN_CONTROLLER, model);
            SwingUtilities.invokeLater(() -> dispatcher.dispatchResponse(response.getTargetName(), response.getModel()));
        });
    }

    @Override
    public String update(Model inModel, Model outModel) {
        currentUser = inModel.get("user");

        frame.getContentPane().removeAll();

        JTableHeader usersTableHeader = usersTable.getTableHeader();
        usersTableHeader.setBounds(20, 20, 745, 20);
        usersTable.setBounds(20, 40, 745, 280);
        usernameLabel.setBounds(25, 340, 70, 20);
        usernameTextField.setBounds(85, 340, 100, 20);
        passwordLabel.setBounds(215, 340, 70, 20);
        passwordTextField.setBounds(275, 340, 100, 20);
        roleLabel.setBounds(405, 340, 70, 20);
        roleTextField.setBounds(435, 340, 100, 20);
        addUserButton.setBounds(595, 340, 100, 20);
        removeUserIdLabel.setBounds(25, 405, 100, 20);
        removeUserIdTextField.setBounds(85, 405, 100, 20);
        removeUserButton.setBounds(215, 405, 100, 20);
        logout.setBounds(670, 520, 100, 20);

        content.add(usersTableHeader);
        content.add(usersTable);
        content.add(usernameLabel);
        content.add(usernameTextField);
        content.add(passwordLabel);
        content.add(passwordTextField);
        content.add(roleLabel);
        content.add(roleTextField);
        content.add(addUserButton);
        content.add(removeUserIdLabel);
        content.add(removeUserIdTextField);
        content.add(removeUserButton);
        content.add(logout);

        resetFields();

        frame.getContentPane().add(content);
        frame.revalidate();
        frame.repaint();

        updateUsersTable(inModel);

        return ADMIN_CONTROLLER;
    }

    public void updateUsersTable(Model inModel) {
        Model model = new Model();
        model.put("user", inModel.get("user"));
        model.put("action", "showUsers");
        ModelAndTarget response = dispatcher.dispatchRequest(ADMIN_CONTROLLER, model);
        userTableModel.setUsers(response.getModel().get("users"));
    }

    private void resetFields() {
        usernameTextField.setText("");
        passwordTextField.setText("");
        removeUserIdTextField.setText("");
        roleTextField.setSelectedIndex(0);
    }

    private static class UserTableModel extends AbstractTableModel {

        private final String[] columnNames = {"ID", "Username", "PasswordHash", "Type"};
        private List<User> users = Collections.emptyList();

        public void setUsers(List<User> users) {
            this.users = users;
            fireTableDataChanged();
        }

        @Override
        public String getColumnName(int col) {
            return columnNames[col];
        }

        @Override
        public int getRowCount() {
            return users.size();
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public Object getValueAt(int row, int col) {
            switch (col) {
                case 0: return users.get(row).getId();
                case 1: return users.get(row).getUsername();
                case 2: return users.get(row).getPasswordHash();
                case 3: return users.get(row).getType();
                default: throw new IllegalArgumentException();
            }
        }

        @Override
        public boolean isCellEditable(int row, int col) {
            return false;
        }
    }
}
