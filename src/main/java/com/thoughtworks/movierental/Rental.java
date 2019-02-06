package com.thoughtworks.movierental;

public class Rental {

  private int daysRented;
  private Movie movie;

  public Rental(Movie movie, int daysRented){
    this.movie = movie;
    this.daysRented = daysRented;
  }

  public int getDaysRented() {
    return daysRented;
  }

  public Movie getMovie() {
    return movie;
  }

  int getFrequentRenterPoints() {
    int frequentRenterPoints = 1;
    if (isaBonusApplicable()) frequentRenterPoints++;
    return frequentRenterPoints;
  }

  private boolean isaBonusApplicable() {
    return (getMovie().getPriceCode() == Movie.NEW_RELEASE)
        &&
        getDaysRented() > 1;
  }
}