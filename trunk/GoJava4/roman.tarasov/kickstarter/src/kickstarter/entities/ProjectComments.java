package kickstarter.entities;

public class ProjectComments {
	public int[] usersID;
	public String[] comment;
	private int commentIndex = 0;
	final int INIT_SIZE = 10;
	final int ADD_TO_SIZE = 10;
	public int projectID;

	public ProjectComments(int projectID) {
		this.projectID = projectID;
		usersID = new int[INIT_SIZE];
		comment = new String[INIT_SIZE];
	}

	public void addComment(int userID, String newComment) {
		int len = comment.length;
		if (commentIndex >= len) {
			String[] newComments = new String[comment.length + ADD_TO_SIZE];
			System.arraycopy(comment, 0, newComments, 0, comment.length);
			comment = newComments;

			int[] newUsersID = new int[len + ADD_TO_SIZE];
			System.arraycopy(usersID, 0, newUsersID, 0, getCommentLength());

			usersID = newUsersID;
		}
		comment[commentIndex] = newComment;
		usersID[commentIndex] = userID;
		commentIndex++;
	}

	public int getCommentLength() {
		return commentIndex;
	}

	public void deleteComment(String userID, String commentID)
			throws NullPointerException, NumberFormatException {
		
		int intUserID=Integer.parseInt(userID);
		int intCommentID = Integer.parseInt(commentID);
		if (intCommentID < 0 || intCommentID >= commentIndex
				|| usersID[intCommentID] != intUserID) {
			throw new NullPointerException(null);
		}
		usersID[intCommentID]=0;//0 - deleted comment
		

	}
}
