package me.amarpandey;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SendSms {

	public static void main(String[] args) throws IOException {

		JsonNode textDataJsonNode = getTextMessageJsonNode();

		MessageAPI msgObject = new MessageAPI("http://api.msg91.com/api/sendhttp.php?", "2006XXXXXXXXXXXXXXXXXXXb",
				"88XXXXXXX1", "MSGIND", "4", "91");

		for (int i = 0; i < textDataJsonNode.size(); i++) {

			URL myURL = null;
			String response = null;
			BufferedReader reader = null;
			String FinalEncodedMessage = null;
			URLConnection myURLConnection = null;
			String FinalMessageAPICallUrl = null;

			FinalEncodedMessage = getFinalEncodedMessage(textDataJsonNode.get(i).asText());

			FinalMessageAPICallUrl = getFinalAPICallURL(msgObject, FinalEncodedMessage);

			try {
				myURL = new URL(FinalMessageAPICallUrl);
				myURLConnection = myURL.openConnection();
				myURLConnection.connect();
				reader = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));

				while ((response = reader.readLine()) != null)
					System.out.println(response);

				reader.close();

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				System.out.println("Total message sent : " + i + "/" + textDataJsonNode.size());
			}

			try {
				Thread.sleep(120000);
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		}
	}

	private static JsonNode getTextMessageJsonNode() {

		String textDataJsonString = null;
		JsonNode textDataJsonNode = null;
		String textDataJsonUrl = "https://raw.githubusercontent.com/amarlearning/say-sorry/master/textmessage.json";

		try {
			textDataJsonString = getDataFromUrl(textDataJsonUrl);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			textDataJsonNode = new ObjectMapper().readTree(textDataJsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return textDataJsonNode;
	}

	private static String getDataFromUrl(String url) throws IOException {

		String inputLine = null;
		URL textMessageJsonUrl = new URL(url);
		URLConnection yc = textMessageJsonUrl.openConnection();

		BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));

		StringBuilder inputLineAppend = new StringBuilder();

		while ((inputLine = in.readLine()) != null) {
			inputLineAppend.append(inputLine);
		}

		in.close();

		return inputLineAppend.toString();
	}

	private static String getFinalAPICallURL(MessageAPI msgObject, String finalEncodedMessage) {

		StringBuilder sbPostData = new StringBuilder(msgObject.getMainUrl());
		sbPostData.append("sender=" + msgObject.getSenderId());
		sbPostData.append("&route=" + msgObject.getRoute());
		sbPostData.append("&mobiles=" + msgObject.getMobiles());
		sbPostData.append("&authkey=" + msgObject.getAuthkey());
		sbPostData.append("&country=" + msgObject.getCountry());
		sbPostData.append("&message=" + finalEncodedMessage);

		return sbPostData.toString();
	}

	private static String getFinalEncodedMessage(String textMessage) {

		String encodedMessage = null;
		textMessage = textMessage.toLowerCase();

		StringBuilder messageBuilder = new StringBuilder(textMessage);
		messageBuilder.append("\n\nPlease forgive me Chaheti :(\n\nFrom,\nAmar Prakash Pandey");

		try {
			encodedMessage = URLEncoder.encode(messageBuilder.toString(),
					java.nio.charset.StandardCharsets.UTF_8.toString());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return encodedMessage;
	}

}