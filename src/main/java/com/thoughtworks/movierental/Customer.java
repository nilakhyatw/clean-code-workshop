package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
  private String name;
  private List<Rental> rentals = new ArrayList<>();

  public Customer(String name) {
    this.name = name;
  }

  public void addRental(Rental arg) {
    rentals.add(arg);
  }

  public String getName() {
    return name;
  }

  public String statement() {
    String result = "Rental Record for " + getName() + "\n";
    int totalFrequentRenterPoints = totalFrequentRentalPoints();
    for (Rental rental : rentals) {
      //show figures for this rental
      result += "\t" + rental.getMovie().getTitle() + "\t" +
          String.valueOf(rental.amount()) + "\n";
    }

    //add footer lines result
    result += "Amount owed is " + String.valueOf(totalAmount()) + "\n";
    result += "You earned " + String.valueOf(totalFrequentRenterPoints)
        + " frequent renter points";
    return result;
  }

  private int totalFrequentRentalPoints() {
    int totalFrequentRenterPoints = 0;
    for (Rental rental : rentals) {
      totalFrequentRenterPoints += rental.frequentRentalPoints();
    }
    return totalFrequentRenterPoints;
  }

  private double totalAmount() {
    double totalAmount = 0;
    for (Rental rental : rentals) {
      totalAmount += rental.amount();
    }
    return totalAmount;
  }

}

