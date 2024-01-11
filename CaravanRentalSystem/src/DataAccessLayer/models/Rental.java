package DataAccessLayer.models;

public class Rental {
    private int rentalId;
    private String startDate;
    private String endDate;
    private int clientId;
    private int caravanId;
    private int reviewId;

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getCaravanId() {
        return caravanId;
    }

    public void setCaravanId(int caravanId) {
        this.caravanId = caravanId;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    @Override
    public String toString() {
        return "Rentals{" +
                "rentalId=" + rentalId +
                ", startDate='" + startDate +
                ", endDate='" + endDate +
                ", clientId=" + clientId +
                ", caravanId=" + caravanId +
                ", reviewId=" + reviewId +
                '}';
    }
}
