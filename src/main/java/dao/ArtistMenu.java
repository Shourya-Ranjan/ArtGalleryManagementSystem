package dao;

import java.util.List;
import java.util.Scanner;
import entity.Artist;

public class ArtistMenu {

    public static void addNewArtist(VirtualArtGalleryServiceImpl artt, Scanner scanner) {
        System.out.print("Enter Artist ID: ");
        int artistId = scanner.nextInt();

        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Biography: ");
        String biography = scanner.nextLine();

        System.out.print("Enter BirthDate: ");
        String birthDate = scanner.nextLine();

        System.out.print("Enter Nationality: ");
        String nationality = scanner.nextLine();

        System.out.print("Enter Website: ");
        String website = scanner.nextLine();

        System.out.print("Enter Contact Information: ");
        String contactInfo = scanner.nextLine();

        Artist artist = new Artist(artistId, name, biography, birthDate, nationality, website, contactInfo);
        boolean result = artt.addArtist(artist);

        if (!result) {
            System.out.println("Artist added successfully!");
        } else {
            System.out.println("Failed to add artist.");
        }
    }

    public static void updateArtist(VirtualArtGalleryServiceImpl artt, Scanner scanner) {
        System.out.print("Enter Artist ID: ");
        int artistId = scanner.nextInt();

        Artist result = artt.getArtistById(artistId);
        System.out.println(result);
        if (result != null) {
            System.out.println("===== Artist Menu =====");
            System.out.println("1. Update Name:");
            System.out.println("2. Update Biography:");
            System.out.println("3. Update BirthDate:");
            System.out.println("4. Update Nationality:");
            System.out.println("5. Update Website:");
            System.out.println("6. Update Contact Information:");
            System.out.println("========================");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    // Update Name
                    scanner.nextLine();
                    System.out.println("Enter new Name : ");

                    String name = scanner.nextLine();
                    result.setName(name);
                }
                    break;
                case 2: {
                    // Update BirthDate
                    scanner.nextLine();
                    System.out.println("Enter new Biography : ");
                    String newBiography = scanner.next();
                    result.setBiography(newBiography);
                }
                    break;
                case 3: {
                    // Update BirthDate
                    System.out.println("Enter new BirthDate Date(YYYY-mm-dd) : ");
                    String newBirthdate = scanner.next();
                    result.setBirthDate(newBirthdate);
                }
                    break;
                case 4: {
                    // Update Nationality
                    System.out.println("Enter new Nationality : ");
                    String newNationality = scanner.next();
                    result.setNationality(newNationality);
                }
                    break;
                case 5: {
                    // Update Website
                    System.out.println("Enter new Website : ");
                    String newWebsite = scanner.next();
                    result.setWebsite(newWebsite);
                }
                    break;
                case 6: {
                    System.out.println("Enter new Contact Information");
                    String newContactInfo = scanner.next();
                    result.setContactInfo(newContactInfo);
                }

                default:
                    System.out.println("Invalid choice");
                    break;
            }
            boolean res = artt.updateArtist(result);
            if (res)
                System.out.println("Updated Successfully!!");
            else
                System.out.println("Not Updated!!");
        }
    }

    public static void removeArtwork(VirtualArtGalleryServiceImpl artt, Scanner scanner) {

        List<Artist> result = artt.displayAllArtists();
        for (Artist res : result)
            System.out.println(res);

        System.out.print("Enter Artist ID to delete the Artist: ");
        int artistId = scanner.nextInt();

        boolean res = artt.removeArtistById(artistId);
        if (res)
            System.out.println("Deleted Successfully!!");
    }

    public static void getArtistById(VirtualArtGalleryServiceImpl artt, Scanner scanner) {
        System.out.print("Enter Artist ID: ");
        int artistID = scanner.nextInt();
        Artist result = artt.getArtistById(artistID);
        System.out.println(result);
    }

    public static void manageArtist(Scanner sc) {
        VirtualArtGalleryServiceImpl artt = new VirtualArtGalleryServiceImpl();
        int choice;
        do {
            System.out.println("===== Artist Menu =====");
            System.out.println("1. Add Artist");
            System.out.println("2. Update Artist");
            System.out.println("3. Remove Artist");
            System.out.println("4. Display all artists");
            System.out.println("0. Exit");
            System.out.println("========================");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addNewArtist(artt, sc);
                    break;
                case 2:
                    List<Artist> ressult = artt.displayAllArtists();
                        for (Artist res : ressult) {
                        System.out.println(res);}
                    updateArtist(artt, sc);
                    break;
                case 3:
                    removeArtwork(artt, sc);
                    break;
                case 4:
                    List<Artist> result = artt.displayAllArtists();
                    for (Artist res : result) {
                        System.out.println(res);
                    }
                    break;
                case 0: {
                    System.out.println("Thanks for using Artist Menu!!");
                    System.exit(0);
                }
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choice != 0);
    }
}