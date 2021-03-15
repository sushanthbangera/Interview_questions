package com.onlinetest.twillio.authorapi;


//"https://jsonmock.hackerrank.com/api/transactions/search?userId=";
public class Transaction {

	int id;
    
    Long timestamp;
    
    int userId;
    
    String userName;
    
    String txnType;
    
    String amount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTxnType() {
		return txnType;
	}

	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", timestamp=" + timestamp + ", userId=" + userId + ", userName=" + userName
				+ ", txnType=" + txnType + ", amount=" + amount + "]";
	}
    
}
