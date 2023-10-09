package NewDataHub;

public class Post {

	private int id;
	private String content;
	private String author;
	private int like;
	private int share;
	private String startDate;

	public Post() {
	}

	public Post(int id, String content, String author, int like, int share, String startDate) {
		this.id = id;
		this.content = content;
		this.author = author;
		this.like = like;
		this.share = share;
		this.startDate = startDate;

	}

	public Post(String content, int like) {
		this.content = content;
		this.like = like;
	}

	public Post(int id, String content, int share) {
		this.id = id;
		this.content = content;
		this.share = share;
	}

	public int getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public String getAuthor() {
		return author;
	}

	public int getLike() {
		return like;
	}

	public int getShare() {
		return share;
	}

	public String getDate() {
		return startDate;
	}

	public void setId(int id) {
		this.id = id;

	}

	public void setContent(String content) {
		this.content = content;

	}

	public void setAuthor(String author) {
		this.author = author;

	}

	public void setLike(int like) {
		this.like = like;

	}

	public void setShare(int share) {
		this.share = share;

	}

	public void setDate(String dateStr) {
		this.startDate = dateStr;

	}

	public String toString() {
		return "Post #: " + id + ", Content: " + content + ", Author: " + author + ", Likes:  " + like + ", Shares: "
				+ share + ", date: " + startDate;
	}

}