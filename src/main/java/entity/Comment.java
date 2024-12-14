package entity;

public record Comment(CommentId commentId, ArticleId articleId, String text) {

  public Comment withText(String newText) {
    return new Comment(this.commentId, this.articleId, newText);
  }
}
