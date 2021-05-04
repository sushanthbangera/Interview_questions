package com.nineleaps.onlinecoding;

class Account implements OnlineAccount, Comparable<Account> {

	int noOfRegularMovies, noOfExclusiveMovies;
	String ownerName;

	// 1) Add a parameterized constructor that initializes the attributes
	// noOfRegularMovies and noOfExclusiveMovies.
	public Account(String ownerName, int noOfRegularMovies, int noOfExclusiveMovies) {
		this.ownerName = ownerName;
		this.noOfRegularMovies = noOfRegularMovies;
		this.noOfExclusiveMovies = noOfExclusiveMovies;
	}

	// 2. This method returns the monthly cost for the account.
	public int monthlyCost() {
		return basePrice + (this.noOfRegularMovies * regularMoviePrice)
				+ (this.noOfExclusiveMovies * exclusiveMoviePrice);
	}

	// 3. Override the compareTo method of the Comparable interface such that two
	// accounts can be compared based on their monthly cost.
	public int compareTo(Account acc) {
		int monthlyCost = this.monthlyCost();
		int accMonthlyCost = acc.monthlyCost();

		if (monthlyCost() == accMonthlyCost)
			return 0;

		if (monthlyCost < accMonthlyCost)
			return -1;

		return 1;
	}

	// 4. Returns "Owner is [ownerName] and monthly cost is [monthlyCost] USD."
	public String toString() {
		return "Owner is " + this.ownerName + " and monthly cost is " + this.monthlyCost() + " USD.";
	}
}
