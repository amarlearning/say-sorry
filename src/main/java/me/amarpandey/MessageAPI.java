package me.amarpandey;

public class MessageAPI {

	private String mainUrl;
	private String authkey;
	private String mobiles;
	private String senderId;
	private String route;
	private String country;
		
	public MessageAPI() {
		super();
	}

	public MessageAPI(String mainUrl, String authkey, String mobiles, String senderId, String route, String country) {
		super();
		this.mainUrl = mainUrl;
		this.authkey = authkey;
		this.mobiles = mobiles;
		this.senderId = senderId;
		this.route = route;
		this.country = country;
	}

	public String getMainUrl() {
		return mainUrl;
	}

	public void setMainUrl(String mainUrl) {
		this.mainUrl = mainUrl;
	}

	public String getAuthkey() {
		return authkey;
	}

	public void setAuthkey(String authkey) {
		this.authkey = authkey;
	}

	public String getMobiles() {
		return mobiles;
	}

	public void setMobiles(String mobiles) {
		this.mobiles = mobiles;
	}

	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
