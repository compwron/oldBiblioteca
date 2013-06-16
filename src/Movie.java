
public class Movie {
	private String name;
	private String director;
	private int rating = 0;
	
	public Movie(String name, String director) {
		super();
		this.name = name;
		this.director = director;
	}
	
	public Movie(String name, String director, int rating) {
		super();
		this.name = name;
		this.director = director;
		setRating(rating);
	}
	
	public String getName() {
		return name;
	}

	public String getDirector() {
		return director;
	}

	public void setRating(int rating) {
		if (rating > 0 && rating <= 10)
			this.rating = rating;
		else
			rating = 0; 
	}

	public int getRating() {
		return rating;
	}
	
	public boolean hasRating() {
		return rating != 0;
	}
	
	@Override
	public String toString() {
		return getName() + " directed by " + getDirector() + 
			   " rated " + getRating();
	}
}
