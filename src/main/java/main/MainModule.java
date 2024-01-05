package main;
import util.DBConnection;
import java.util.Scanner;
import dao.ArtistMenu;
import dao.ArtworkMenu;
import dao.UserMenu;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

public class MainModule {

	public static void main(String[] args) throws SQLException  {
		Connection conn =DBConnection.getConnection();
        Statement stmt= conn.createStatement();
        stmt.execute("use artgallery");
        
		Scanner scanner = new Scanner(System.in);
		int choice;
		do 
        {
		System.out.println("=========== ArtGallery Management System ==========");
        System.out.println("1. To Access Artwork Menu");
        System.out.println("2. To Access User Menu");
        System.out.println("3. To Access Artist Menu");
        System.out.println("0. To Exit");
        System.out.println("===================================================");
    		choice=scanner.nextInt();
        switch (choice) {
        
            case 1:{
            	// Artwork menu invocation
            	ArtworkMenu.manageArtwork(scanner);
            }
                break;
            case 2:{
            	// User menu invocation
            	UserMenu.manageUser(scanner);
            	
            }
                break;
            case 3:{
            	//Artist Menu invocation
            	ArtistMenu.manageArtist(scanner);
            }
                break;
            case 0: 
        	{
        		System.out.println("Thanks for using art gallery management Syatem!!");
//        		System.exit(0);
        	} break;
           
            default:
                System.out.println("Invalid choice");
                break;
        }
    	}while(choice!=0);
        scanner.close();
		
	}

}
