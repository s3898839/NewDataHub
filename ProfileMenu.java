package NewDataHubGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import NewDataHub.User;

public class ProfileMenu extends JFrame {

	private JPanel contentPane;
	private static User currentUser;

	private ArrayList<User> users;

	/**
	 * Launch the application.
	 */

	public static void run3() {
		try {
			ProfileMenu frame = new ProfileMenu();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Create the frame.
	 */
	public ProfileMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setBounds(183, 24, 46, 14);
		contentPane.add(lblNewLabel);

		users = new ArrayList<User>();

		JButton btnNewButton = new JButton("View Profile");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (User currentUser : users) {

					JOptionPane.showConfirmDialog(null, "User Profile:" + "Username: " + currentUser.getUsername()
							+ "Full Name: " + currentUser.getFullName() + "Password: " + currentUser.getPassword());

				}
			}
		});

		btnNewButton.setBounds(32, 57, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Edit Profile");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String response;
				response = JOptionPane.showInputDialog("Enter a username: ");
				String newUsername = response;

				response = JOptionPane.showInputDialog("Enter a password:  ");
				String newPassword = response;

				response = JOptionPane.showInputDialog("Enter your first name: ");
				String newFirstName = response;

				response = JOptionPane.showInputDialog("Enter your last name: ");
				String newLastName = response;

				NewDataHubGUI.getCurrentUser().editProfile(newUsername, newFirstName, newLastName, newPassword);
				JOptionPane.showConfirmDialog(null, "Profile updated successfully!");
			}
		});
		btnNewButton_1.setBounds(32, 112, 89, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Social Media Analyzer");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MediaMenu.run4();
				return;

			}
		});
		btnNewButton_2.setBounds(32, 169, 89, 23);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("LogOut");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentUser = null;
				JOptionPane.showConfirmDialog(null, "Logged out. Returning to the main menu.");
				return;
			}

		});
		btnNewButton_3.setBounds(32, 227, 89, 23);
		contentPane.add(btnNewButton_3);
	}

}
