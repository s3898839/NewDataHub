package NewDataHubGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class MediaMenu extends JFrame {

	private JPanel contentPane;
	private ArrayList<Post> posts;
	private ArrayList<User> users;

	/**
	 * Launch the application.
	 */

	public static void run4() {
		try {
			MediaMenu frame = new MediaMenu();
			frame.postLists();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public MediaMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Social Media Menu");
		lblNewLabel.setBounds(164, 11, 93, 51);
		contentPane.add(lblNewLabel);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(249, 73, 142, 152);
		contentPane.add(textArea);

		posts = new ArrayList<Post>();
		users = new ArrayList<User>();

		JButton btnNewButton = new JButton("Add Post");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int response;
				response = Integer.parseInt(JOptionPane.showInputDialog("Please provide the post ID: "));
				int id = response;

				String Line;
				Line = JOptionPane.showInputDialog("Please provide the post content:  ");
				String content = Line;

				Line = JOptionPane.showInputDialog("Please provide the post author: ");
				String author = Line;

				response = Integer
						.parseInt(JOptionPane.showInputDialog("Please provide the number of likes of the post: "));
				int like = response;

				response = Integer
						.parseInt(JOptionPane.showInputDialog("Please provide the number of shares of the post: "));
				int share = response;

				Line = JOptionPane.showInputDialog(
						"Please provide the date and time of the post in the format of DD/MM/YYYY HH:MM:");
				String dateStr = Line;

				Post p = new Post(id, content, author, like, share, dateStr);
				posts.add(p);

				JOptionPane.showConfirmDialog(null, "the post has been added to the collection!");
				return;
			}
		});
		btnNewButton.setBounds(21, 54, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Retrieve Post");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int response;
				response = Integer.parseInt(JOptionPane.showInputDialog("Please provide the post ID: "));
				int postIdToRetrieve = response;
				Post retrievedPost = null;

				for (Post p : posts) {
					if (p.getId() == postIdToRetrieve) {
						retrievedPost = p;
						break;
					}
					// if theres nothing to retrieve

				}
				if (retrievedPost != null) {
					String message =

							"Retrieved Post:\n" + "Post ID: " + retrievedPost.getId() + "/n" + "Content: "
									+ retrievedPost.getContent() + "/n " + "Author: " + retrievedPost.getAuthor() + "/n"
									+ "Like: " + retrievedPost.getLike() + "Share: " + retrievedPost.getShare()
									+ "Date: " + retrievedPost.getDate();
					JOptionPane.showConfirmDialog(null, message);

				} else {
					JOptionPane.showMessageDialog(null, "Post with ID " + postIdToRetrieve + " not found.");
				}
			}
		});
		btnNewButton_1.setBounds(31, 128, 111, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Top Liked Post");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int response;
				response = Integer
						.parseInt(JOptionPane.showInputDialog("Please specify the number of posts to retrieve (N): "));
				int topN = response;

				// Sort the posts in ascending order of likes
				posts.sort(Comparator.comparingInt(Post::getLike));

				// Reverse the list to get descending order of likes
				Collections.reverse(posts);

				// Retrieve the top N posts with limit
				List<Post> topLikedPosts = posts.subList(0, Math.min(topN, posts.size()));

				JOptionPane.showConfirmDialog(null, " The Top " + topN + " posts with the most likes are:");
				for (Post p : topLikedPosts) {
					JOptionPane.showConfirmDialog(null,
							"Id:" + p.getId() + "| Content: " + p.getContent() + "| Likes: " + p.getLike());
				}
			}
		});
		btnNewButton_2.setBounds(21, 162, 132, 23);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Top Shared Post");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int response;
				response = Integer
						.parseInt(JOptionPane.showInputDialog("Please specify the number of posts to retrieve (N): "));
				int topN = response;

				// Sort the posts in ascending order of shares
				posts.sort(Comparator.comparingInt(Post::getShare));

				// Reverse the list to get descending order of shares
				Collections.reverse(posts);

				// Retrieve the top N posts
				List<Post> topSharedPosts = posts.subList(0, Math.min(topN, posts.size()));

				JOptionPane.showConfirmDialog(null, "The Top " + topN + " posts with the most shares are:");
				for (Post p : topSharedPosts) {
					JOptionPane.showConfirmDialog(null,
							"Id:" + p.getId() + "| Content: " + p.getContent() + "| Shares: " + p.getShare());
				}

			}
		});
		btnNewButton_3.setBounds(21, 196, 132, 23);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Delete Post");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Remove a post from the collection based on the post ID

				int response;
				response = Integer.parseInt(JOptionPane.showInputDialog("Please provide the post ID: "));
				int postIdToRemove = response;

				Iterator<Post> iterator = posts.iterator();
				while (iterator.hasNext()) {
					Post post = iterator.next();
					if (post.getId() == postIdToRemove) {
						iterator.remove();
						JOptionPane.showConfirmDialog(null, "Post with ID " + postIdToRemove + " has been removed.");
						return;
					} else {

						// if post doesn't exist
						JOptionPane.showConfirmDialog(null, "sorry the post does not exist ");
					}
				}
			}
		});
		btnNewButton_4.setBounds(31, 88, 89, 23);
		contentPane.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("Log out");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentUser = null;
				JOptionPane.showConfirmDialog(null, "Logged out. Returning to the main menu.");
				return;

			}
		});
		btnNewButton_5.setBounds(21, 230, 89, 23);
		contentPane.add(btnNewButton_5);
	}

	public void postLists() {
		Post[] arrOfPosts = {
				new Post(20582, "Come and meet us at Building 14 of RMIT.", " SD2C45", 10, 24,
						"12/05/2023  10:10:00 AM"),
				new Post(10, "Check out this epic film.", "A567VF", 1000, 1587, " 1/06/2023  2:25:00 PM"),
				new Post(37221, "Are we into Christmas month already?!", "3827F2", 526, 25, " 15/11/2022  11:30:00 PM"),
				new Post(382, "What a miracle!", "38726I", 2775, 13589, " 12/02/2023  6:18:00 PM"),
				new Post(36778, "Fantastic day today. Congratulations to all winners.", "1258XE", 230, 1214,
						" 6/06/2023  9:00:00 PM"), };
		for (int i = 0; i < arrOfPosts.length; i++) {
			posts.add(arrOfPosts[i]);
		}
	}
}
