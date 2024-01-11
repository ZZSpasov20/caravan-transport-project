package BusinessLayer.services;

import DataAccessLayer.models.Review;
import DataAccessLayer.repositories.ReviewRepository;

import java.util.ArrayList;
import java.util.List;

public class ReviewService {
    private static ReviewService instance = null;

    private final ReviewRepository reviewRepository;

    private ReviewService() {
        this.reviewRepository = ReviewRepository.getInstance();
    }

    public static ReviewService getInstance() {

        if (ReviewService.instance == null) {
            ReviewService.instance = new ReviewService();
        }

        return ReviewService.instance;
    }

    public String castReviewToString(Review reviewModule){
        String review = "";
        review = reviewModule.toString();
        return review;
    }

    public Review mapValuesToReview(int rating, String comment){
        Review review = new Review();

        review.setRating(rating);
        review.setComment(comment);

        return review;
    }
    public Review mapValuesToReview(int id, int rating, String comment){
        Review review = new Review();

        review.setReviewId(id);
        review.setRating(rating);
        review.setComment(comment);

        return review;
    }


    public List<String> getAllReviews(){
        List<String> allReviews = new ArrayList<>();
        List<Review> allReviewsModules = new ArrayList<>();
        allReviewsModules = reviewRepository.getAllReviews();

        for (Review review : allReviewsModules ){
            allReviews.add(castReviewToString(review));
        }

        return allReviews;
    }

    public String getReviewById(int id){
        String review = "";

        review = castReviewToString(reviewRepository.getReviewById(id));

        return review;
    }

    public void addReview(int rating, String comment){
        reviewRepository.addReview(mapValuesToReview(rating, comment));
    }

    public void updateReview(int id, int rating, String comment){
        reviewRepository.updateReview(mapValuesToReview(id, rating, comment));
    }

    public void deleteReview(int id) {
        reviewRepository.deleteReviewById(id);
    }
}
