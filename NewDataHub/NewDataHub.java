package NewDataHub;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class NewDataHub {

	private ArrayList<Post> posts;

	private FileInputStream fis;
	private ObjectInputStream ois;
	private FileOutputStream fos;
	private ObjectOutputStream oos;

	public NewDataHub() {
		// declare arraylist
		posts = new ArrayList<Post>();

		// finding csv file
		String filePath = "src\\posts.csv";
		String line = "";
		List<Post> posts = readFromCSV(filePath);
		for (Post p : posts) {
			System.out.println(p);
		}

	}

	// reading csv file
	private List<Post> readFromCSV(String filePath) {
		List<Post> posts = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line = "";
			boolean firstLine = true;
			while ((line = reader.readLine()) != null) {
				if (firstLine) {
					firstLine = false;
					continue; // Skip the header line
				}
				String[] parts = line.split(",");
				int id = Integer.parseInt(parts[0].trim());
				String content = parts[1].trim();
				String author = parts[2].trim();
				int like = Integer.parseInt(parts[3].trim());
				int share = Integer.parseInt(parts[4].trim());
				String dateStr = parts[5].trim();

				posts.add(new Post(id, content, author, like, share, dateStr));

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return posts;
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

	// added users into app
	public void UserLists() {
		User[] arryOfUsers = { 
				 User user1 = new User("user1", "password1", "John", "Doe");
			        User user2 = new User("user2", "password2", "Jane", "Smith");
		}
		

        // Display welcome message for logged-in user
        String enteredPassword = "password1"; // Password entered by the user during login
        if (user1.login(enteredPassword)) {
            System.out.println(user1.getWelcomeMessage());
        } else {
            System.out.println("Login failed. Incorrect password.");
        }

        // Edit user profile
        user1.editProfile("NewJohn", "NewDoe", "newpassword");
        System.out.println("Updated profile for " + user1.getUsername() + ": " + user1.getFullName());

        // Display welcome message after profile update
        System.out.println(user1.getWelcomeMessage());
    }

	public void vip() {
		User user1 = new User("user1", "password1", "John", "Doe");
		VIPUser vipUser = new VIPUser("vipuser", "password2", "Jane", "Smith");

		// Simulate user actions (as before)

		// Check if a user is VIP
		if (vipUser.isVIP()) {
			System.out.println(vipUser.getFullName() + " is a VIP user.");
		}

		// Generate a pie chart (not implemented here, use a data visualization library)
		// vipUser.generatePieChart(posts);

		// Bulk import social media posts from a CSV file
		// vipUser.bulkImportPosts("posts.csv");

	}

	public void menu() {
		boolean flag = true;
		Scanner input = new Scanner(System.in);
		while (flag) {
			System.out.println("Welcome to Social Media Analyzer!");
			System.out.println("\n----------------------------------\n");
			System.out.println("> Select from main menu ");
			System.out.println("--------------------------------------");
			System.out.println("1) Add a social media post ");
			System.out.println("2) Delete an existing social media post ");
			System.out.println("3) Retrieve a social media post");
			System.out.println("4) Retrieve the top N posts with most likes");
			System.out.println("5) Retrieve the top N posts with most shares");
			System.out.println("6) Exit");

			System.out.println("Please select:");
			int option = input.nextInt();
			input.nextLine();

			switch (option) {
			case 1:
				addPost();
				break;

			case 2:
				delPost();
				break;

			case 3:
				retrievePostById();
				break;
			case 4:
				topLikes();
				break;

			case 5:
				topShares();
				break;

			case 6:
				exit();
				break;

			default:
				System.out.println("Invalid option.");

			}

		}

	}

	public void addPost() { // Add a post to the collection
		Scanner input = new Scanner(System.in);
		System.out.println("Please provide the post ID: ");
		int id = input.nextInt();

		System.out.println("Please provide the post content: ");
		String content = input.nextLine();
		input.nextLine();

		System.out.println("Please provide the post author:  ");
		String author = input.nextLine();

		System.out.println("Please provide the number of likes of the post: ");
		int like = input.nextInt();

		System.out.println("Please provide the number of shares of the post:  ");
		int share = input.nextInt();
		input.nextLine();

		System.out.println("Please provide the date and time of the post in the format of DD/MM/YYYY HH:MM: ");
		String dateStr = input.nextLine();

		Post p = new Post(id, content, author, like, share, dateStr);
		posts.add(p);

		System.out.println("the post has been added to the collection!");

	}

	public void delPost() {
		// Remove a post from the collection based on the post ID

		Scanner input = new Scanner(System.in);
		System.out.println("Please provide the post ID: ");
		int postIdToRemove = input.nextInt();

		Iterator<Post> iterator = posts.iterator();
		while (iterator.hasNext()) {
			Post post = iterator.next();
			if (post.getId() == postIdToRemove) {
				iterator.remove();
				System.out.println("Post with ID " + postIdToRemove + " has been removed.");
				break;
			} else {

				// if post doesn't exist
				System.out.println("sorry the post does not exist ");
			}
		}
	}

	public void retrievePostById() {

		// Retrieve a post from the collection based on the post ID

		Scanner input = new Scanner(System.in);
		System.out.println("Please provide the post ID: ");
		int postIdToRetrieve = input.nextInt();
		Post retrievedPost = null;

		for (Post p : posts) {
			if (p.getId() == postIdToRetrieve) {
				retrievedPost = p;
				break;
			}
			// if theres nothing to retrieve

		}
		if (retrievedPost != null) {
			System.out.println("Retrieved Post:");
			System.out.println("Post ID: " + retrievedPost.getId());
			System.out.println("Content: " + retrievedPost.getContent());
			System.out.println("Author: " + retrievedPost.getAuthor());
			System.out.println("Like: " + retrievedPost.getLike());
			System.out.println("Share: " + retrievedPost.getShare());
			System.out.println("Date: " + retrievedPost.getDate());
		} else {
			System.out.println("Post with ID " + postIdToRetrieve + " not found.");
		}
	}

	public void topLikes() {

		// Retrieve the top N posts with the most likes, and show retrieved posts in
		// user input
		Scanner input = new Scanner(System.in);
		System.out.println("Please specify the number of posts to retrieve (N):");
		int topN = input.nextInt();

		// Sort the posts in ascending order of likes
		posts.sort(Comparator.comparingInt(Post::getLike));

		// Reverse the list to get descending order of likes
		Collections.reverse(posts);

		// Retrieve the top N posts with limit
		List<Post> topLikedPosts = posts.subList(0, Math.min(topN, posts.size()));

		System.out.println(" The Top " + topN + " posts with the most likes are:");
		for (Post p : topLikedPosts) {
			System.out.println("Id:" + p.getId() + "| Content: " + p.getContent() + "| Likes: " + p.getLike());
		}

	}

	public void topShares() {

		// user input
		Scanner input = new Scanner(System.in);
		System.out.println("Please specify the number of posts to retrieve (N):");
		int topN = input.nextInt();

		// Sort the posts in ascending order of shares
		posts.sort(Comparator.comparingInt(Post::getShare));

		// Reverse the list to get descending order of shares
		Collections.reverse(posts);

		// Retrieve the top N posts
		List<Post> topSharedPosts = posts.subList(0, Math.min(topN, posts.size()));

		System.out.println("The Top " + topN + " posts with the most shares are:");
		for (Post p : topSharedPosts) {
			System.out.println("Id:" + p.getId() + "| Content: " + p.getContent() + "| Shares: " + p.getShare());
		}

	}

	public void exit() {
		System.out.println(" Thanks for using Social Media Analyzer!");
		System.exit(0);

	}

}