package entity;

public class Gallery {
	public int galleryID;
	public String name, description, location, curator, openingHours;

	public Gallery(int galleryID, String name, String description, String location, String curator,
			String openingHours) {
		super();
		this.galleryID = galleryID;
		this.name = name;
		this.description = description;
		this.location = location;
		this.curator = curator;
		this.openingHours = openingHours;
	}

	public int getGalleryID() {
		return galleryID;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getLocation() {
		return location;
	}

	public String getCurator() {
		return curator;
	}

	public String getOpeningHours() {
		return openingHours;
	}

	@Override
	public String toString() {
		return "Gallery [galleryID=" + galleryID + ", name=" + name + ", description=" + description + ", location="
				+ location + ", curator=" + curator + ", openingHours=" + openingHours + "]";
	}

}
