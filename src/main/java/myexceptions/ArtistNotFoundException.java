package myexceptions;

public class ArtistNotFoundException extends Exception{
    public ArtistNotFoundException(int artistID){
        super("Artist not found with ID: "+artistID);
    }
    
}
