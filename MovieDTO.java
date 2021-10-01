package Movie;

public class MovieDTO {
	   
	public String getMovieName() {
		return MovieName;
	}

	public void setMovieName(String movieName) {
		MovieName = movieName;
	}

	public String getMovieReleaseDate() {
		return MovieReleaseDate;
	}

	public void setMovieReleaseDate(String movieReleaseDate) {
		MovieReleaseDate = movieReleaseDate;
	}

	public String getMovieRunningTime() {
		return MovieRunningTime;
	}

	public void setMovieRunningTime(String movieRunningTime) {
		MovieRunningTime = movieRunningTime;
	}

	public String getMovieCompany() {
		return MovieCompany;
	}

	public void setMovieCompany(String movieCompany) {
		MovieCompany = movieCompany;
	}

	public String getMovieCountry() {
		return MovieCountry;
	}

	public void setMovieCountry(String movieCountry) {
		MovieCountry = movieCountry;
	}

	public String getMovieGenre() {
		return MovieGenre;
	}

	public void setMovieGenre(String movieGenre) {
		MovieGenre = movieGenre;
	}
	
	public String getMovieDirector() {
		return MovieDirector;
	}

	public void setMovieDirector(String movieDirector) {
		MovieDirector = movieDirector;
	}
	   private String MovieName;
	   private String MovieDirector;
	   private String MovieReleaseDate;
	   private String MovieRunningTime;
	   private String MovieCompany;
	   private String MovieCountry;
	   private String MovieGenre;
	   
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
