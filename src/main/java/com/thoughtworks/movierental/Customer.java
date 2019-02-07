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
      return new TextStatement().display(this.getName(), this.totalAmount(), this.totalFrequentRenterPoints(), this.rentals);
  }

    private int totalFrequentRenterPoints() {
    int frequentRenterPoints = 0;
    for (Rental each : rentals) {
      frequentRenterPoints += each.getFrequentRenterPoints();
    }
    return frequentRenterPoints;
  }

  private double totalAmount() {
    double totalAmount = 0;
    for (Rental each : rentals) {
      totalAmount += each.getThisAmount();
    }
    return totalAmount;
  }

    public String htmlStatement() {
        String headerHTML = String.format(
                "<h1>Rental Record for <b>%s</b></h1><br/>", getName());
        String bodyHTML="";
        for (Rental each : rentals) {
            //show figures for this rental
            bodyHTML += String.format("<p>%s<&nbsp>%s<br/></p>", each.getMovie().getTitle(),
                    String.valueOf(each.getThisAmount()));
        }
        //add footer lines resultHTML
        String footerHTML =
                String.format("Amount owed is <b>%s</b><br/>You earned <b>%s</b> frequent renter points",
                String.valueOf(totalAmount()), String.valueOf(totalFrequentRenterPoints()));
        return headerHTML + bodyHTML + footerHTML;
  }

    private class TextStatement {
        public String display(String customerName,
                              double totalAmount,
                              int frequentRenterPoints,
                              List<Rental> rentals) {
            String result = "Rental Record for " + customerName + "\n";

            for (Rental each : rentals) {
              //show figures for this rental
              result += "\t" + each.getMovie().getTitle() + "\t" +
                  String.valueOf(each.getThisAmount()) + "\n";
            }

            //add footer lines result
            result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
            result += "You earned " + String.valueOf(frequentRenterPoints)
                + " frequent renter points";
            return result;
        }
    }
}
