package dao;

import java.util.List;

import entity.Artwork;

public interface IVirtualArtGallery {

    // Artwork Management

    boolean addArtwork(Artwork artwork);

    boolean updateArtwork(Artwork artwork);

    boolean removeArtworkById(int artworkID);

    Artwork getArtworkById(int artworkID);

    List<Artwork> searchArtworks(String keyword);
    
    List<Artwork> displayAllArtworks();

    //User Favoritesw

    boolean addArtworkToFavorite(int userId, int artworkId);

    boolean removeArtworkFromFavorite(int userId, int artworkId);
    
    List<Artwork> getUserFavoriteArtworks(int userId);
}

