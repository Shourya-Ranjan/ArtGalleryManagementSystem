package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import entity.Artist;
import entity.Artwork;
import entity.User;
import myexceptions.ArtWorkNotFoundException;
import myexceptions.ArtistNotFoundException;
import myexceptions.UserNotFoundException;
import util.DBConnection;

public class VirtualArtGalleryServiceImpl implements IVirtualArtGallery{
	

	public boolean addNewUser(User user) {
		Connection conn = DBConnection.getConnection();

		boolean status = false;
		try {
			Statement stmt = conn.createStatement();
			String query = "INSERT INTO User VALUES (" +
					user.getUserId() + ", '" +
					user.getUserName() + "', " +
					"'" + user.getPassword() + "', " +
					"'" + user.getEmail() + "', " +
					"'" + user.getFirstName() + "', " +
					"'" + user.getLastName() + "', " +
					"'" + user.getDob() + "');";
			stmt.execute("use artgallery");
			System.out.println(query);
			return stmt.execute(query);
		} catch (Exception e) {
			System.out.println("Query exception :" + e);
		}

		return status;
	}

	public boolean removeUserById(int userID) {
		Connection conn = DBConnection.getConnection();
		boolean status = false;

		try {
			Statement stmt = conn.createStatement();
			String query = "delete from user where userid=" + userID + ";";
			stmt.executeUpdate("use artgallery");
			int trueorfalse = stmt.executeUpdate(query);
			if (trueorfalse == 1) {
				status = true;
			} else {
				throw new UserNotFoundException(userID);
			}
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		return status;
	}

	public boolean updateUser(User user) {
		Connection conn = DBConnection.getConnection();
		boolean status = false;
		try {
			Statement stmt = conn.createStatement();
			System.out.println(stmt.execute("use artgallery"));
			String query = "UPDATE user SET userName = '" + user.getUserName() +
					"', firstName = '" + user.getFirstName() +
					"', lastName = '" + user.getLastName() +
					"', email = '" + user.getEmail() +
					"', password = '" + user.getPassword() +
					"', DateOfBirth = '" + user.getDob() +
					"' WHERE userId = " + user.getUserId() + ";";

			status = stmt.execute(query);
			return status;
		} catch (Exception ue) {
			System.out.println(ue.getMessage());
		}
		return status;
	}

	public User getUserById(int userID) {
		Connection conn = DBConnection.getConnection();
		User user = null;
		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM user where userID=" + userID + ";";
			stmt.execute("use artgallery");

			ResultSet res = stmt.executeQuery(query);
			if (res.next()) {
				user = new User(res.getInt("UserID"), res.getString("UserName"), res.getString("FirstName"),
						res.getString("LastName"), res.getString("Email"), res.getString("Password"),
						res.getString("DateOfBirth"));
			} else {
				throw new UserNotFoundException(userID);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return user;
	}

	public List<User> displayAllUsers() {
		Connection conn = DBConnection.getConnection();
		List<User> result = new ArrayList<User>();
		try {

			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM User;";
			stmt.execute("use artgallery");
			ResultSet res = stmt.executeQuery(query);

			while (res.next()) {
				// Retrieve data from the result set

				User user = new User(res.getInt("UserID"), res.getString("UserName"), res.getString("FirstName"),
						res.getString("LastName"), res.getString("Email"), res.getString("Password"),
						res.getString("DateOfBirth"));
				result.add(user);
			}
		} catch (Exception e) {
			System.out.println("Query exception :" + e);
		}
		return result;
	}




    public boolean addArtist(Artist artist)
    {
		Connection conn = DBConnection.getConnection();
		boolean status=false;
		try {
			Statement stmt=conn.createStatement();
			String query = "INSERT INTO Artist VALUES (" +
	                artist.getArtistID() + ", " +
	                "'" + artist.getName() + "', " +
	                "'" + artist.getBiography() + "', " +
	                "'" + artist.getBirthDate() + "', " +
                    "'" + artist.getNationality() + "' , " + 
	                "'" + artist.getWebsite() + "', " +
	                "'" + artist.getContactInfo() + "')";
			System.out.println(query);
			return stmt.execute(query);	
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	
		return status;
	}
    public boolean updateArtist(Artist artist) {
		Connection conn = DBConnection.getConnection();
		boolean status=false;
		boolean result=false;

		try {
			Statement stmt=conn.createStatement();
			String query = "UPDATE Artist set name = '"+artist.getName()
			+"',biography='"+artist.getBiography()+
			"',BirthDate='"+artist.getBirthDate()+
			"', nationality='"+artist.getNationality()+
			"',Website='"+artist.getWebsite()+
			"',ContactInformation='"+artist.getContactInfo()+
			"' where ArtistID = "+artist.getArtistID()+";";	
			result=stmt.execute(query);
			if(result==true);
			status=true;		
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}	
		return status;
	}
    public Artist getArtistById(int artistID) {
		Connection conn = DBConnection.getConnection();
		Artist result=null;
		try {
			Statement stmt=conn.createStatement();
			String query = "SELECT * FROM Artist where ArtistID="+ artistID+";";
//			String query="INSERT INTO Artwork VALUES (1, 'The Starry Night', 'A famous painting by Vincent van Gogh.', '1889-06-29', 'Oil on canvas', 'https://example.com/starry-night.jpg');";
			stmt.execute("use artgallery");
			ResultSet res= stmt.executeQuery(query);	
			if(res.next())
			result=new Artist(res.getInt("ArtistID"),res.getString("Name"),res.getString("Biography"),res.getString("Birthdate"),res.getString("Nationality"),res.getString("Website"),res.getString("ContactInformation"));
			
			else{
				throw new ArtistNotFoundException(artistID);
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}	
		return result;
	}
    
	public boolean removeArtistById(int artistID) {
		Connection conn = DBConnection.getConnection();
		boolean status=false;
		
		try {
			Statement stmt=conn.createStatement();
			String query = "delete from artist where artistID="+artistID+";";
			stmt.execute("use artgallery");
			status = stmt.execute(query);	
			if(!status)
			{
				throw new ArtistNotFoundException(artistID);
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}	
		return status;
	}
    public List<Artist> displayAllArtists() {
		Connection conn = DBConnection.getConnection();
		List<Artist> result= new ArrayList<Artist>();
		try {
			
			Statement stmt=conn.createStatement();
			String query = "SELECT * FROM Artist ;";
			stmt.execute("use artgallery");
			ResultSet  res= stmt.executeQuery(query);	
			 
			while (res.next()) {
                // Retrieve data from the result set
              
			Artist ress=new Artist(res.getInt("ArtistID"),res.getString("Name"),res.getString("Biography"),res.getString("Birthdate"),res.getString("Nationality"),res.getString("Website"),res.getString("ContactInformation"));
                result.add(ress);
            }
			return result;

		}
		catch(Exception e) {
			System.out.println("Query exception :" +e);
		}	
	
		return result;
	}


	@Override
	public boolean addArtwork(Artwork artwork) {
		Connection conn = DBConnection.getConnection();
		int result=0;
		boolean status = false;
		try {
			Statement stmt = conn.createStatement();
			stmt.execute("use artgallery");
			String query = "INSERT INTO Artwork VALUES (" +
					artwork.getArtWorkId() + ", " +
					"'" + artwork.getTitle() + "', " +
					"'" + artwork.getDescription() + "', " +
					"'" + artwork.getCreationDate() + "', " +
					"'" + artwork.getMedium() + "', " +
					"'" + artwork.getImageUrl() + "')";
			result = stmt.executeUpdate(query);
			if(result>0)
			 	status=true;
			else
				return status;

		} 
		catch (Exception e) {
			
			System.out.println("Some error had occured!\n" + e.getMessage()+"\n");
		}

		return status;
	}

	@Override
	public boolean removeArtworkById(int artworkID){
		Connection conn = DBConnection.getConnection();
		boolean status = false;

		try 
		{
			Statement stmt = conn.createStatement();
			String query = "delete from artwork where artWorkId= " + artworkID + ";";
			stmt.executeUpdate("use artgallery");

			int result = stmt.executeUpdate(query);
			if (result == 1)
				status = true;
			else
			throw new ArtWorkNotFoundException(artworkID);
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		return status;
	}

	@Override
	public boolean updateArtwork(Artwork artwork) {
		Connection conn = DBConnection.getConnection();
		boolean status = false;
		int result=0;

		try {
			Statement stmt = conn.createStatement();
			stmt.execute("use artgallery");
			String query = "UPDATE ArtWork set title = '" + artwork.getTitle()
					+ "',description='" + artwork.getDescription() +
					"',CreationDate='" + artwork.getCreationDate() +
					"', medium='" + artwork.getMedium() +
					"',ImageURL='" + artwork.getImageUrl() +
					"' where artworkId = " + artwork.getArtWorkId() + ";";

			result = stmt.executeUpdate(query); //inbuilt-cmd executeUpdate
			if(result>0)
				status=true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return status;
	}

	@Override
	public Artwork getArtworkById(int artworkID) {
		Connection conn = DBConnection.getConnection();
		Artwork result = null;
		try {
			Statement stmt = conn.createStatement();
			stmt.execute("use artgallery");
	
			String query = "SELECT * FROM Artwork where ArtworkID=" + artworkID + ";";
			ResultSet res = stmt.executeQuery(query);
		
			
			if (res.next()) {
				result = new Artwork(res.getInt("ArtworkID"), res.getString("Title"), res.getString("Description"),
						res.getString("CreationDate"), res.getString("Medium"), res.getString("ImageURL"));
			}
			else
				throw new ArtWorkNotFoundException(artworkID);}
		
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		return result;
	}

	@Override
	public List<Artwork> searchArtworks(String keyword) {
		Connection conn = DBConnection.getConnection();
		ArrayList<Artwork> result = new ArrayList<Artwork>();
		try {

			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM Artwork where title LIKE '%" + keyword + "%';";
			stmt.execute("use artgallery");
			Artwork ress=null;
			ResultSet res = stmt.executeQuery(query);
			while (res.next()) {
				
				// Retrieve data from the result set
				ress = new Artwork(res.getInt("ArtworkID"), res.getString("Title"),
						res.getString("Description"), res.getString("CreationDate"), res.getString("Medium"),
						res.getString("ImageURL"));
				result.add(ress);}
				if(!result.contains(ress)){
				System.out.println("No such keyword exists!");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	@Override
	public List<Artwork> displayAllArtworks() {
		Connection conn = DBConnection.getConnection();
		List<Artwork> result = new ArrayList<Artwork>();
		try {

			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM Artwork ;";
			stmt.execute("use artgallery");
			ResultSet res = stmt.executeQuery(query);
			Artwork ress=null;

			while (res.next()) {
				// Retrieve data from the result set
				 ress = new Artwork(res.getInt("ArtworkID"), res.getString("Title"),
						res.getString("Description"), res.getString("CreationDate"), res.getString("Medium"),
						res.getString("ImageURL"));
				result.add(ress);
			}
			if(result.isEmpty()){
				System.out.println("No results to display!");
			}
			return result;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return result;
	}

	@Override
	public boolean addArtworkToFavorite(int userId, int artworkId) {		
		
		Connection conn = DBConnection.getConnection();
		boolean status=false;
		
		try {
			Statement stmt=conn.createStatement();
			String query = "INSERT INTO user_favorite_artwork VALUES ("+userId+","+artworkId +");";
			stmt.execute("use artgallery");
			return stmt.execute(query);	
		}
		catch(Exception e) {
			System.out.println("Query exception :" +e);
		}	
		return status;
		
	}

	@Override
	public boolean removeArtworkFromFavorite(int userId, int artworkId) {
		Connection conn = DBConnection.getConnection();
		boolean status=false;
		
		try {
			Statement stmt=conn.createStatement();
			String query = "delete from user_favorite_artwork where artworkid="+artworkId+" and userid="+userId+" ;";
			stmt.execute("use artgallery");
			int result= stmt.executeUpdate(query);	
			if(result==1)
				status=true;
			else
				throw new ArtWorkNotFoundException(artworkId);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}	
		return status;
	}

	@Override
	public List<Artwork> getUserFavoriteArtworks(int userId) 
	{
		Connection conn = DBConnection.getConnection();
		List<Artwork> result= new ArrayList<Artwork>();

		try {
			Statement stmt=conn.createStatement();
			String query = "select * from artwork a inner join user_favorite_artwork uf on a.artworkId=uf.artworkId AND uf.userId="+userId+";";
			stmt.execute("use artgallery");
			ResultSet  res= stmt.executeQuery(query);	
			Artwork ress=null;
		
			while (res.next()) 
			{
                // Retrieve data from the result set
                ress=new Artwork(res.getInt("ArtworkID"),res.getString("Title"),res.getString("Description"),res.getString("CreationDate"),res.getString("Medium"),res.getString("ImageURL"));
                result.add(ress);}

				if(!result.contains(ress))
				{
					System.out.println("-> No favourite artworks for the userId: "+userId);
            	}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}	
		return result;
	}
}


    

