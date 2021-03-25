package com.onlinetest.twillio.authorapi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;

/*
 * {"page":1,"per_page":10,"total":67,"total_pages":7,
 * "data":[{"id":8,"userId":4,"userName":"Francesco De Mello","timestamp":1548805761859,"txnType":"credit","amount":"$1,214.44","location":{"id":1,"address":"948, Entroflex, Franklin Avenue","city":"Ilchester","zipCode":84181},"ip":"35.151.1.82"},
 * {"id":16,"userId":4,"userName":"Francesco De Mello","timestamp":1551533186809,"txnType":"credit","amount":"$1,233.56","location":{"id":9,"address":"961, Neptide, Elliott Walk","city":"Bourg","zipCode":68602},"ip":"212.215.115.165"},
 * {"id":17,"userId":4,"userName":"Francesco De Mello","timestamp":1551693726293,"txnType":"credit","amount":"$1,806.13","location":{"id":6,"address":"206, Portaline, Brooklyn Avenue","city":"Brownlee","zipCode":80358},"ip":"181.191.153.61"},
 * {"id":26,"userId":4,"userName":"Francesco De Mello","timestamp":1548544617435,"txnType":"credit","amount":"$743.38","location":{"id":6,"address":"206, Portaline, Brooklyn Avenue","city":"Brownlee","zipCode":80358},"ip":"212.215.115.165"},{"id":28,"userId":4,"userName":"Francesco De Mello","timestamp":1552809326043,"txnType":"credit","amount":"$2,769.86","location":{"id":1,"address":"948, Entroflex, Franklin Avenue","city":"Ilchester","zipCode":84181},"ip":"132.169.40.222"},{"id":30,"userId":4,"userName":"Francesco De Mello","timestamp":1548262142180,"txnType":"debit","amount":"$2,647.85","location":
 * {"id":9,"address":"961, Neptide, Elliott Walk","city":"Bourg","zipCode":68602},"ip":"119.162.205.226"},{"id":31,"userId":4,"userName":"Francesco De Mello","timestamp":1550206254757,"txnType":"credit","amount":"$3,960.30","location":{"id":8,"address":"389, Everest, Barwell Terrace","city":"Murillo","zipCode":66061},"ip":"181.191.153.61"},
 * {"id":35,"userId":4,"userName":"Francesco De Mello","timestamp":1546446032263,"txnType":"credit","amount":"$1,162.60","location":{"id":1,"address":"948, Entroflex, Franklin Avenue","city":"Ilchester","zipCode":84181},"ip":"5.116.1.11"},{"id":36,"userId":4,"userName":"Francesco De Mello","timestamp":1549391785785,"txnType":"debit","amount":"$188.04","location":{"id":8,"address":"389, Everest, Barwell Terrace","city":"Murillo","zipCode":66061},"ip":"5.116.1.11"},{"id":39,"userId":4,"userName":"Francesco De Mello","timestamp":1552166736242,"txnType":"credit","amount":"$3,705.83","location":{"id":9,"address":"961, Neptide, Elliott Walk","city":"Bourg","zipCode":68602},"ip":"212.215.115.165"}]}

 */
public class TransactionSummary {

	private static final String url = "https://jsonmock.hackerrank.com/api/transactions/search?userId=";

	public static List<Integer> getUserTransaction(int uid, String txnType, String monthYear) {
		
		List<Integer> txnList = new ArrayList<>();

		int pageCount = 1;
		int totalPages = 0;
		String json = "";
		Double amount = 0.0;
		
		List<Transaction> transctions = new ArrayList<>();
		do {
			try {
				json = readUrl(url + uid + "&page=" + pageCount);
				System.out.println(json);
			} catch (Exception e) {
				// TODO: handle exception
			}
			Gson gson = new Gson();
			Response response = gson.fromJson(json, Response.class);
			
			if (response != null && !response.getData().isEmpty()) {
				
				for (Transaction transaction : response.getData()) {
					
					Date date = new Date(transaction.getTimestamp());
					SimpleDateFormat sdf = new SimpleDateFormat("MM-YYYY");
					String dateString = sdf.format(date);
					
					if (transaction.getTxnType().equals(txnType) && dateString.equals(monthYear)) {
						transctions.add(transaction);
						
						String amt = transaction.getAmount().substring(1);
						
						amt = amt.replaceAll(",", "");
						amount += Double.parseDouble(amt);
					}
				}
			}
			
			pageCount++;
			totalPages = response.getTotal_pages();

		} while (pageCount <= totalPages);

		
		Double avg = amount / transctions.size();
		System.out.println(avg);
		
		for (Transaction txn : transctions) {
			String amt = txn.getAmount().substring(1);
			amt = amt.replaceAll(",", "");
			
			Double a = Double.parseDouble(amt);
			
			if (a > avg) {
				System.out.println(a);
				System.out.println(txn.getId());
			}
		}
		
		return txnList;
	}

	private static String readUrl(String urlString) throws Exception {
		BufferedReader reader = null;
		try {
			URL url = new URL(urlString);
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			StringBuffer buffer = new StringBuffer();
			int read;
			char[] chars = new char[1024];
			while ((read = reader.read(chars)) != -1)
				buffer.append(chars, 0, read);
			return buffer.toString();
		} finally {
			if (reader != null)
				reader.close();
		}
	}
	
	public static void main(String[] args) {
		getUserTransaction(4, "debit", "02-2019");
	}
}
