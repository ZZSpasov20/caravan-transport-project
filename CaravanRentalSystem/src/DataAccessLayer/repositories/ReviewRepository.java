package DataAccessLayer.repositories;

import DataAccessLayer.models.Review;
import utils.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReviewRepository {
    private static ReviewRepository instance = null;

    public static ReviewRepository getInstance() {

        if (ReviewRepository.instance == null) {
            ReviewRepository.instance = new ReviewRepository();
        }

        return ReviewRepository.instance;
    }

    public Review mapToReview(ResultSet set){

        Review review = new Review();

        try{

            review.setReviewId(set.getInt(1));
            review.setRating(set.getInt(2));
            review.setComment(set.getString(3));

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return review;
    }

    public List<Review> getAllReviews(){
        List<Review> reviews = new ArrayList<>();
        Review review;

        String query = "SELECT * FROM [Reviews]";

        Connection connectionInstance;
        Statement statement;
        ResultSet set;

        try{
            connectionInstance = DbConnection.getInstance();
            statement = connectionInstance.createStatement();
            set = statement.executeQuery(query);

            while (set.next()){
                reviews.add(mapToReview(set));
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return reviews;
    }

    public Review getReviewById(int id) {

        String query = "SELECT * FROM Reviews WHERE ReviewId = ?";

        Connection connectionInstance;
        Review review = new Review();

        try {

            connectionInstance = DbConnection.getInstance();

            PreparedStatement preparedStatement = connectionInstance.prepareStatement(query);

            preparedStatement.setInt(1, id);


            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                review = mapToReview(resultSet);
            }


        }catch(SQLException e){
            throw new RuntimeException(e);
        }

        return review;

    }

    public void addReview(Review review){
        String query = "INSERT INTO Reviews (Rating, Comment) VALUES (?, ?)";

        Connection connectionInstance;

        try{
            connectionInstance = DbConnection.getInstance();

            PreparedStatement preparedStatement = connectionInstance.prepareStatement(query);

            preparedStatement.setInt(1, review.getRating());
            preparedStatement.setString(2, review.getComment());

            preparedStatement.executeUpdate();


        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void updateReview(Review review) {
        String query = "UPDATE Reviews SET Rating = ?, Comment = ? WHERE ReviewId = ?";

        Connection connectionInstance;

        try {
            connectionInstance = DbConnection.getInstance();

            PreparedStatement preparedStatement = connectionInstance.prepareStatement(query);

            preparedStatement.setInt(1, review.getRating());
            preparedStatement.setString(2, review.getComment());
            preparedStatement.setInt(3, review.getReviewId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteReviewById(int ReviewId) {
        String query1 = "DELETE FROM Reviews WHERE ReviewId = ?";

        Connection connectionInstance;
        try {
            connectionInstance = DbConnection.getInstance();

            PreparedStatement preparedStatement = connectionInstance.prepareStatement(query1);
            preparedStatement.setInt(1, ReviewId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
