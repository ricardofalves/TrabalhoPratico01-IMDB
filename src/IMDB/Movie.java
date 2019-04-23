package IMDB;

public class Movie {

	private String color;
	private String director_name;
	private Integer num_critic_for_reviews;
	private Integer duration;	
	private Integer director_facebook_likes;
	private Integer actor_3_facebook_likes;
	private String actor_2_name;
	private Integer actor_1_facebook_likes;
	private Integer gross;
	private String genres;
	private String actor_1_name;
	private String movie_title;
	private Integer num_voted_users;
	private Integer cast_total_facebook_likes;
	private String actor_3_name;
	private Integer facenumber_in_poster;
	private String plot_keywords;
	private String movie_imdb_link;
	private Integer num_user_for_reviews;
	private String language;
	private String country;
	private String content_rating;
	private Integer budget;
	private Integer title_year;
	private Integer actor_2_facebook_likes;
	private Double imdb_score;
	private Double aspect_ratio;
	private Integer movie_facebook_likes;

	public Movie() {
		super();
	}

	public Movie(String color, String director_name, Integer num_critic_for_reviews, Integer duration,
			Integer director_facebook_likes, Integer actor_3_facebook_likes, String actor_2_name,
			Integer actor_1_facebook_likes, Integer gross, String genres, String actor_1_name, String movie_title,
			Integer num_voted_users, Integer cast_total_facebook_likes, String actor_3_name,
			Integer facenumber_in_poster, String plot_keywords, String movie_imdb_link, Integer num_user_for_reviews,
			String language, String country, String content_rating, Integer budget, Integer title_year,
			Integer actor_2_facebook_likes, Double imdb_score, Double aspect_ratio, Integer movie_facebook_likes) {
		super();
		this.color = color;
		this.director_name = director_name;
		this.num_critic_for_reviews = num_critic_for_reviews;
		this.duration = duration;
		this.director_facebook_likes = director_facebook_likes;
		this.actor_3_facebook_likes = actor_3_facebook_likes;
		this.actor_2_name = actor_2_name;
		this.actor_1_facebook_likes = actor_1_facebook_likes;
		this.gross = gross;
		this.genres = genres;
		this.actor_1_name = actor_1_name;
		this.movie_title = movie_title;
		this.num_voted_users = num_voted_users;
		this.cast_total_facebook_likes = cast_total_facebook_likes;
		this.actor_3_name = actor_3_name;
		this.facenumber_in_poster = facenumber_in_poster;
		this.plot_keywords = plot_keywords;
		this.movie_imdb_link = movie_imdb_link;
		this.num_user_for_reviews = num_user_for_reviews;
		this.language = language;
		this.country = country;
		this.content_rating = content_rating;
		this.budget = budget;
		this.title_year = title_year;
		this.actor_2_facebook_likes = actor_2_facebook_likes;
		this.imdb_score = imdb_score;
		this.aspect_ratio = aspect_ratio;
		this.movie_facebook_likes = movie_facebook_likes;
	}

	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getDirector_name() {
		return director_name;
	}
	public void setDirector_name(String director_name) {
		this.director_name = director_name;
	}
	public Integer getNum_critic_for_reviews() {
		return num_critic_for_reviews;
	}
	public void setNum_critic_for_reviews(Integer num_critic_for_reviews) {
		this.num_critic_for_reviews = num_critic_for_reviews;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public Integer getDirector_facebook_likes() {
		return director_facebook_likes;
	}
	public void setDirector_facebook_likes(Integer director_facebook_likes) {
		this.director_facebook_likes = director_facebook_likes;
	}
	public String getActor_2_name() {
		return actor_2_name;
	}
	public void setActor_2_name(String actor_2_name) {
		this.actor_2_name = actor_2_name;
	}
	public Integer getActor_3_facebook_likes() {
		return actor_3_facebook_likes;
	}
	public void setActor_3_facebook_likes(Integer actor_3_facebook_likes) {
		this.actor_3_facebook_likes = actor_3_facebook_likes;
	}
	public Integer getActor_1_facebook_likes() {
		return actor_1_facebook_likes;
	}
	public void setActor_1_facebook_likes(Integer actor_1_facebook_likes) {
		this.actor_1_facebook_likes = actor_1_facebook_likes;
	}
	public Integer getGross() {
		return gross;
	}
	public void setGross(Integer gross) {
		this.gross = gross;
	}
	public String getGenres() {
		return genres;
	}
	public void setGenres(String genres) {
		this.genres = genres;
	}
	public String getActor_1_name() {
		return actor_1_name;
	}
	public void setActor_1_name(String actor_1_name) {
		this.actor_1_name = actor_1_name;
	}
	public String getMovie_title() {
		return movie_title;
	}
	public void setMovie_title(String movie_title) {
		this.movie_title = movie_title;
	}
	public Integer getNum_voted_users() {
		return num_voted_users;
	}
	public void setNum_voted_users(Integer num_voted_users) {
		this.num_voted_users = num_voted_users;
	}
	public Integer getCast_total_facebook_likes() {
		return cast_total_facebook_likes;
	}
	public void setCast_total_facebook_likes(Integer cast_total_facebook_likes) {
		this.cast_total_facebook_likes = cast_total_facebook_likes;
	}
	public String getActor_3_name() {
		return actor_3_name;
	}
	public void setActor_3_name(String actor_3_name) {
		this.actor_3_name = actor_3_name;
	}
	public Integer getFacenumber_in_poster() {
		return facenumber_in_poster;
	}
	public void setFacenumber_in_poster(Integer facenumber_in_poster) {
		this.facenumber_in_poster = facenumber_in_poster;
	}
	public String getPlot_keywords() {
		return plot_keywords;
	}
	public void setPlot_keywords(String plot_keywords) {
		this.plot_keywords = plot_keywords;
	}
	public String getMovie_imdb_link() {
		return movie_imdb_link;
	}
	public void setMovie_imdb_link(String movie_imdb_link) {
		this.movie_imdb_link = movie_imdb_link;
	}
	public Integer getNum_user_for_reviews() {
		return num_user_for_reviews;
	}
	public void setNum_user_for_reviews(Integer num_user_for_reviews) {
		this.num_user_for_reviews = num_user_for_reviews;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getContent_rating() {
		return content_rating;
	}
	public void setContent_rating(String content_rating) {
		this.content_rating = content_rating;
	}
	public Integer getBudget() {
		return budget;
	}
	public void setBudget(Integer budget) {
		this.budget = budget;
	}
	public Integer getTitle_year() {
		return title_year;
	}
	public void setTitle_year(Integer title_year) {
		this.title_year = title_year;
	}
	public Integer getActor_2_facebook_likes() {
		return actor_2_facebook_likes;
	}
	public void setActor_2_facebook_likes(Integer actor_2_facebook_likes) {
		this.actor_2_facebook_likes = actor_2_facebook_likes;
	}
	public Double getImdb_score() {
		return imdb_score;
	}
	public void setImdb_score(Double imdb_score) {
		this.imdb_score = imdb_score;
	}
	public Double getAspect_ratio() {
		return aspect_ratio;
	}
	public void setAspect_ratio(Double aspect_ratio) {
		this.aspect_ratio = aspect_ratio;
	}
	public Integer getMovie_facebook_likes() {
		return movie_facebook_likes;
	}
	public void setMovie_facebook_likes(Integer movie_facebook_likes) {
		this.movie_facebook_likes = movie_facebook_likes;
	}




}
