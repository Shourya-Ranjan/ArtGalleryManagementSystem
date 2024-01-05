package dao;

import java.util.List;
import java.util.Scanner;
import entity.Artwork;
import entity.User;

public class UserMenu {	
	VirtualArtGalleryServiceImpl person =new VirtualArtGalleryServiceImpl();

	public static void getUserById(VirtualArtGalleryServiceImpl person, Scanner scanner) {
		System.out.print("Enter user ID: ");
		int userId = scanner.nextInt();
		User result = person.getUserById(userId);
		System.out.println(result);
	}

	public static void addArtworkToFavorite(VirtualArtGalleryServiceImpl person, Scanner scanner) {
		VirtualArtGalleryServiceImpl art = new VirtualArtGalleryServiceImpl();
		List<Artwork> artwork = art.displayAllArtworks();
		for (Artwork res : artwork)
			System.out.println(res);
		System.out.print("Enter User ID : ");
		int userId = scanner.nextInt();
		System.out.print("Enter Artwork ID to add in favourites: ");
		int artworkId = scanner.nextInt();
		boolean ress = art.addArtworkToFavorite(userId, artworkId);
		if (!ress)
			System.out.println("Added Successfully!!");
		else
			System.out.println("Unable to Add   TRY AGAIN!!");

	}

	public static void removeArtworkFromFavorite(VirtualArtGalleryServiceImpl person, Scanner scanner)
			 {
		VirtualArtGalleryServiceImpl art = new VirtualArtGalleryServiceImpl();

		System.out.print("Enter User ID : ");
		int userId = scanner.nextInt();
		User users = person.getUserById(userId);
		if (users != null)// change1
		{
			System.out.println(users + "\n");
			System.out.println("---------------------------------------------");
			System.out.println(" Your Favourite Artworks are/is listed below. \n ");
			System.out.println("---------------------------------------------");
			List<Artwork> artwork = art.getUserFavoriteArtworks(userId);
			for (Artwork res : artwork)
				System.out.println(res);
			System.out.println("---------------------------------------------");
			if (!artwork.isEmpty()) // change2
			{
				System.out.print("Enter Artwork ID to Delete : ");
				int artworkId = scanner.nextInt();
				System.out.println();

				boolean res = art.removeArtworkFromFavorite(userId, artworkId);
				if (res)
					System.out.println("Deleted Successfully!!");
			}
		}
	}

	public static void displayUserFavoriteArtworks(VirtualArtGalleryServiceImpl person, Scanner scanner) {
		VirtualArtGalleryServiceImpl art = new VirtualArtGalleryServiceImpl();

		System.out.print("Enter User ID : ");
		int userId = scanner.nextInt();
		List<Artwork> artwork = art.getUserFavoriteArtworks(userId);
		if (artwork.isEmpty()) {
			System.out.println();
		} else {
			System.out.print("Your Favourite Artworks are/is listed below: \n");
			System.out.println();
			for (Artwork res : artwork)
				System.out.println(res);
			System.out.println();
		}
	}

	public static void addUser(VirtualArtGalleryServiceImpl person, Scanner scanner) {

		System.out.print("Enter User ID: ");
		int userId = scanner.nextInt();

		scanner.nextLine(); // Consume the newline character
		System.out.print("Enter User Name: ");
		String userName = scanner.nextLine();

		System.out.print("Enter Password: ");
		String password = scanner.nextLine();

		System.out.print("Enter Email: ");
		String email = scanner.nextLine();

		System.out.print("Enter First Name: ");
		String firstName = scanner.nextLine();

		System.out.print("Enter Last Name: ");
		String lastName = scanner.nextLine();

		System.out.print("Enter Date of Birth: ");
		String dob = scanner.nextLine();

		User user = new User(userId, userName, firstName, lastName, email, password, dob);
		// Call the addArtwork method with the created Artwork object
		boolean result = person.addNewUser(user);

		if (!result) {
			System.out.println("User added successfully!");
		} else {
			System.out.println("Failed to add User.");
		}
	}

	public static void updateUser(VirtualArtGalleryServiceImpl person, Scanner scanner) {
		System.out.print("Enter User ID: ");
		int userId = scanner.nextInt();
		User result = person.getUserById(userId);
		System.out.println(result);

		System.out.println("===== User Menu =====");
		System.out.println("1. Update User Name");
		System.out.println("2. Update Password");
		System.out.println("3. Update Email");
		System.out.println("4. Update First Name");
		System.out.println("5. Update Last Name");
		System.out.println("6. Update Date of Birth");
		System.out.println("========================");

		int choice = scanner.nextInt();

		switch (choice) {
			case 1: {
				// Update UserName
				System.out.println("Enter new Username : ");
				String newUsername = scanner.next();
				result.setUserName(newUsername);
			}
				break;
			case 2: {
				// Update Password
				System.out.println("Enter new Password : ");
				String newPassword = scanner.next();
				result.setPassword(newPassword);
			}
				break;
			case 3: {
				// Update Email
				System.out.println("Enter new Email : ");
				String newEmail = scanner.next();
				result.setEmail(newEmail);
			}
				break;
			case 4: {
				// Update First Name
				System.out.println("Enter new First Name : ");
				String newFirst = scanner.next();
				result.setFirstName(newFirst);
			}
				break;
			case 5: {
				// Update Last Name
				System.out.println("Enter new Last Name : ");
				String newLast = scanner.next();
				result.setLastName(newLast);
			}
				break;
			case 6: {
				// Update Dob
				System.out.println("Enter new Creation Date(yyyy-mm-dd)/(yyyy.mm.dd): ");
				String newDob = scanner.next();
				result.setDob(newDob);
			}
				break;

			default:
				System.out.println("Invalid choice");
				break;
		}
		// System.out.println(result);
		boolean res = person.updateUser(result);
		if (!res)
			System.out.println("Updated Successfully!!");
		else
			System.out.println("Not Updated!!");

	}

	public static void removeUser(VirtualArtGalleryServiceImpl person, Scanner scanner) {

		List<User> user = person.displayAllUsers();
		for (User res : user)
			System.out.println(res);

		System.out.print("Enter User ID to delete the User: ");
		int userId = scanner.nextInt();

		boolean res = person.removeUserById(userId);
		if (res == true)
			System.out.println("Deleted Successfully!!");
		else {
			System.out.println("Unable to remove!");
		}
	}

	public static void manageUser(Scanner sc) {
		int choice;
		VirtualArtGalleryServiceImpl person = new VirtualArtGalleryServiceImpl();
		do {
			System.out.println("===== User Menu =====");
			System.out.println("1. Add User");
			System.out.println("2. Update User");
			System.out.println("3. Remove User");
			System.out.println("4. Display all Users");
			System.out.println("5. Get User using UserId");
			System.out.println("6. Add Artworks to Favorites");
			System.out.println("7. Remove Artworks from Favorites");
			System.out.println("8. Display All Favorite Artworks");
			System.out.println("0. Exit");
			System.out.println("========================");

			choice = sc.nextInt();

			switch (choice) {
				case 1:
					addUser(person, sc);
					break;
				case 2:
					updateUser(person, sc);
					break;
				case 3:
					removeUser(person, sc);
					break;
				case 4: {
					List<User> user = person.displayAllUsers();
					for (User res : user) {
						System.out.println(res);
					}
					break;
				}

				case 5: {
					getUserById(person, sc);
					break;
				}
				case 6:
					addArtworkToFavorite(person, sc);
					break;
				case 7:
					removeArtworkFromFavorite(person, sc);
					break;
				case 8:
					displayUserFavoriteArtworks(person, sc);
					break;
				case 0:
					System.out.println("Thanks for using User Menu!!");
					break;
				default:
					System.out.println("Invalid choice!!");
					break;
			}
		} while (choice != 0);
	}
}