package dao;

import java.util.List;
import java.util.Scanner;
import entity.Artwork;

public class ArtworkMenu {
    static void addNewArtwork(VirtualArtGalleryServiceImpl art, Scanner scanner)  {

        System.out.print("Enter Artwork ID: ");
        int artWorkId = scanner.nextInt();

        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();

        System.out.print("Enter Description: ");
        String description = scanner.nextLine();

        System.out.print("Enter Creation Date: ");
        String creationDate = scanner.nextLine();

        System.out.print("Enter Medium: ");
        String medium = scanner.nextLine();

        System.out.print("Enter Image URL: ");
        String imageUrl = scanner.nextLine();
        System.out.println("----------------------------");

        // Create an Artwork object with user input
        Artwork artwork = new Artwork(artWorkId, title, description, creationDate, medium, imageUrl);

        // Call the addArtwork method with the created Artwork object
        boolean result = art.addArtwork(artwork);

        if (result) {
            System.out.println("Artwork added successfully!");
        } 

    }

    static void updateArtwork(VirtualArtGalleryServiceImpl art, Scanner scanner)  {
        
        List<Artwork> resultt = art.displayAllArtworks();
                    for (Artwork res : resultt) {
                        System.out.println(res);
                    }

        System.out.print("Enter Artwork ID to select the artwork to be updated: ");
        int artWorkId = scanner.nextInt();
        Artwork result = art.getArtworkById(artWorkId);
        System.out.println(result);

        if(result!=null)
        {
            System.out.println("===== Update Menu =====");
        System.out.println("1. Update Title");
        System.out.println("2. Update Description");
        System.out.println("3. Update Creation Date");
        System.out.println("4. Update Medium");
        System.out.println("5. Update Image URL");
        System.out.println("========================");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1: {
                // Update Title
                System.out.println("Enter new Title : ");
                String newTitle = scanner.next();
                result.setTitle(newTitle);
            }
                break;
            case 2: {
                // Update Description
                System.out.println("Enter new Description : ");
                String newDesc = scanner.next();
                result.setTitle(newDesc);
            }
                break;
            case 3: {
                // Update Date
                System.out.println("Enter new Creation Date(YYYY-mm-dd) : ");
                String newDate = scanner.next();
                result.setTitle(newDate);
            }
                break;
            case 4: {
                // Update Medium
                System.out.println("Enter new Medium : ");
                String newMedium = scanner.next();
                result.setTitle(newMedium);
            }
                break;
            case 5: {
                // Update Description
                System.out.println("Enter new Image Url : ");
                String newUrl = scanner.next();
                result.setTitle(newUrl);
            }
                break;

            default:
                System.out.println("Invalid choice");
                break;
        }
        // System.out.println(result);
        boolean res = art.updateArtwork(result);
        if (res)
            System.out.println("Updated Successfully!!");
        else
            System.out.println("Unable to update!!");}

    }
    // Methods for artwork management

    static void removeArtwork(VirtualArtGalleryServiceImpl art, Scanner scanner) {

        List<Artwork> result = art.displayAllArtworks();
        for (Artwork res : result)
            System.out.println(res);
        
        System.out.print("Enter Artwork ID to delete the Artwork: ");
        int artWorkId = scanner.nextInt();        


        boolean res = art.removeArtworkById(artWorkId); 
        // here art is the object created for that class and we are calling the method removeArtworkById of that class.
        if (res)
            System.out.println("Deleted Successfully!!");
    
    }

    static void getArtworkById(VirtualArtGalleryServiceImpl art, Scanner scanner) {
        System.out.print("Enter Artwork ID: ");
        int artWorkId = scanner.nextInt();
        Artwork result = art.getArtworkById(artWorkId);
        System.out.println(result);
    }

    static void searchArtworks(VirtualArtGalleryServiceImpl art, Scanner scanner) {

        System.out.print("Enter Keyword to Search Artwork (Eg: Try using Title): ");
        String keyword = scanner.next();
        List<Artwork> result = art.searchArtworks(keyword);
        for (Artwork res : result)
            System.out.println(res);
    }

    public static void manageArtwork(Scanner sc)  {
        VirtualArtGalleryServiceImpl art = new VirtualArtGalleryServiceImpl();

        int choice;
        do {

            System.out.println("===== Artwork Menu =====");
            System.out.println("1. Add Artwork");
            System.out.println("2. Update Artwork");
            System.out.println("3. Remove Artwork");
            System.out.println("4. Get Artwork by ID");
            System.out.println("5. Search Artworks");
            System.out.println("6. Display All Artworks");
            System.out.println("0. Exit");
            System.out.println("========================");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addNewArtwork(art, sc);
                    break;
                case 2:
                    {
                    updateArtwork(art, sc);}
                    break;
                case 3:
                    removeArtwork(art, sc);
                    break;
                case 4:
                    getArtworkById(art, sc);
                    break;
                case 5:
                    searchArtworks(art, sc);
                    break;
                case 6: {
                    List<Artwork> resul = art.displayAllArtworks();
                    for (Artwork res : resul) {
                        System.out.println(res);
                    }
                }
                    break;
                case 0: {
                    System.out.println("Thanks for using art gallery management!!");
                    // System.exit(0);
                }
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }

        } while (choice != 0);
    }
}
