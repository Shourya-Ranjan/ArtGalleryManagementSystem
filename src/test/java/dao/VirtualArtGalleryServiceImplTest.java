package dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import entity.Artwork;

class VirtualArtGalleryServiceImplTest {
	


	@Test
	final void testAddArtwork() {
		VirtualArtGalleryServiceImpl service = new VirtualArtGalleryServiceImpl();

		Artwork artwork = new Artwork(1, "Sample Artwork", "Description", "2022-01-01", "Oil on Canvas", "https://sample-url.com");

		boolean result = service.addArtwork(artwork);
		service.removeArtworkById(1);
		assertTrue(result, "Add artwork failed");
	}

	@Test
	final void testRemoveArtworkById() {

		VirtualArtGalleryServiceImpl service = new VirtualArtGalleryServiceImpl();

		Artwork artwork = new Artwork(2, "Sample Artwork", "Description", "2022-01-01", "Oil on Canvas", "https://sample-url.com");


		service.addArtwork(artwork);
		
		boolean result = service.removeArtworkById(2);
		assertTrue(result, "Remove artwork by ID failed");
	}

	@Test
	final void testUpdateArtwork() {
		VirtualArtGalleryServiceImpl service = new VirtualArtGalleryServiceImpl();

		Artwork artwork = new Artwork(3, "Sample Artwork", "Description", "2022-01-01", "Oil on Canvas", "https://sample-url.com");
		service.addArtwork(artwork);

		Artwork updatedArtwork = new Artwork(3, "Updated Artwork", "Updated Description", "2022-01-02", "Acrylic on Canvas", "https://updated-url.com");
		boolean result = service.updateArtwork(updatedArtwork);
		assertTrue(result, "Update artwork failed");

		Artwork retrievedArtwork = service.getArtworkById(3);
		service.removeArtworkById(3);

		
		assertEquals(updatedArtwork.hashCode(), retrievedArtwork.hashCode(), "Artwork details not updated");
	}

	@Test
	final void testGetArtworkById() {
		VirtualArtGalleryServiceImpl service = new VirtualArtGalleryServiceImpl();

		Artwork artwork = new Artwork(4, "Sample Artwork", "Description", "2022-01-01", "Oil on Canvas", "https://sample-url.com");
		service.addArtwork(artwork);
		Artwork retrievedArtwork = service.getArtworkById(4);
		service.removeArtworkById(4);
		
		assertNotNull(retrievedArtwork, "Get artwork by ID failed");
		assertEquals(artwork.hashCode(), retrievedArtwork.hashCode(), "Retrieved artwork does not match");
		
	}

	@Test
	final void testSearchArtworks() {
		VirtualArtGalleryServiceImpl service = new VirtualArtGalleryServiceImpl();

		Artwork artwork1 = new Artwork(8, "Artwork One", "Description", "2022-01-01", "Oil on Canvas", "https://url1.com");
		Artwork artwork2 = new Artwork(9, "Artwork Two", "Description", "2022-01-02", "Watercolor", "https://url2.com");

		service.addArtwork(artwork1);
		service.addArtwork(artwork2);

		List<Artwork> searchResults = service.searchArtworks("Artwork");
		service.removeArtworkById(8);
		service.removeArtworkById(9);
		assertNotNull(searchResults, "Search artworks failed");
		assertEquals(2, searchResults.size(), "Incorrect number of search results");
		
	}

}
