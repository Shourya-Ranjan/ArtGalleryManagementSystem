package myexceptions;

public class ArtWorkNotFoundException extends Exception {
    public ArtWorkNotFoundException(int artworkId) {
        super("Artwork not found with ID: " + artworkId);
    }

}

