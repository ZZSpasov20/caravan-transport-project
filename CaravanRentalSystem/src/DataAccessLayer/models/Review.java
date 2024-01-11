package DataAccessLayer.models;

public class Review {
    private int reviewId;
    private int rating;
    private String comment;

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Reviews{" +
                "reviewId=" + reviewId +
                ", rating=" + rating +
                ", comment='" + comment +
                '}';
    }
}
