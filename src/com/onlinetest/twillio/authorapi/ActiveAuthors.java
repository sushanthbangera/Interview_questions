package com.onlinetest.twillio.authorapi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

/*
 * API gives collection of users and the articles they published
 * 
 * The program should return the list of most active users
 * 
 * A active user - with no. of articles greater than input threshold
 * 
 * The user list should be in the order they appear in the result.
 */
public class ActiveAuthors {

	private final static String url = "http://example.web.com/article_users?page=";

	public static List<String> getUsernames(int threshold) throws Exception {

		List<String> userList = new ArrayList<>();

		int pageCount = 1;
		int totalPages = 0;
		String json;

		do {
			json = readUrl(url + pageCount);
			Gson gson = new Gson();
			AuthorResponse page = gson.fromJson(json, AuthorResponse.class);
			if (page != null & !page.getData().isEmpty()) {
				for (User user : page.getData()) {
					if (user.getSubmission_count() > threshold) {
						userList.add(user.getUsername());
					}
				}
			}
			totalPages = page.getTotal_pages();
			pageCount++;
		} while (pageCount <= totalPages);

		return userList;
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
}
