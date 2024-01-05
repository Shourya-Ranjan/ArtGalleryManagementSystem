package entity;

public class Artist {
	private int ArtistID;
	private String Name;
	private String Biography;
	private String BirthDate;
	private String Nationality;
	private String Website;
	private String ContactInfo;

	public Artist(int artistID, String name, String biography, String birthDate, String nationality, String website,
			String contactInfo) {
		super();
		ArtistID = artistID;
		Name = name;
		Biography = biography;
		BirthDate = birthDate;
		Nationality = nationality;
		Website = website;
		ContactInfo = contactInfo;
	}

	public void setArtistID(int artistID) {
		ArtistID = artistID;
	}

	public void setName(String name) {
		Name = name;
	}

	public void setBiography(String biography) {
		Biography = biography;
	}

	public void setBirthDate(String birthDate) {
		BirthDate = birthDate;
	}

	public void setNationality(String nationality) {
		Nationality = nationality;
	}

	public void setWebsite(String website) {
		Website = website;
	}

	public void setContactInfo(String contactInfo) {
		ContactInfo = contactInfo;
	}

	public int getArtistID() {
		return ArtistID;
	}

	public String getName() {
		return Name;
	}

	public String getBiography() {
		return Biography;
	}

	public String getBirthDate() {
		return BirthDate;
	}

	public String getNationality() {
		return Nationality;
	}

	public String getWebsite() {
		return Website;
	}

	public String getContactInfo() {
		return ContactInfo;
	}

	@Override
	public String toString() {
		return "Artist [ArtistID=" + ArtistID + ", Name=" + Name + ", Biography=" + Biography + ", BirthDate="
				+ BirthDate + ", Nationality=" + Nationality + ", Website=" + Website + ", ContactInfo=" + ContactInfo
				+ "]";
	}

}