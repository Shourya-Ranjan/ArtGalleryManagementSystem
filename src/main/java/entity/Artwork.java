package entity;

import java.util.Objects;

public class Artwork {
	private int artWorkId;
	private String title;
	private String description;
	private String creationDate;
	private String medium;
	private String imageUrl;
	
	@Override
	public int hashCode() {
	    return Objects.hash(artWorkId, title, description, creationDate, medium, imageUrl);
	}

	public Artwork(int artWorkId, String title, String description, String creationDate, String medium,
			String imageUrl) {
		this.artWorkId = artWorkId;
		this.title = title;
		this.description = description;
		this.creationDate = creationDate;
		this.medium = medium;
		this.imageUrl = imageUrl;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getArtWorkId() {
		return artWorkId;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public String getMedium() {
		return medium;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	@Override
	public String toString() {
		return "Artwork [artWorkId=" + artWorkId + ", title=" + title + ", description=" + description
				+ ", creationDate=" + creationDate + ", medium=" + medium + ", imageUrl=" + imageUrl + "]";
	}

}

