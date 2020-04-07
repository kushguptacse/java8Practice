package java8Practice.model;

public class Movie {
	private String name;
	private String result;
	private String hero;

	public Movie(String name, String result, String hero) {
		super();
		this.name = name;
		this.result = result;
		this.hero = hero;
	}

	public String getHero() {
		return hero;
	}

	public void setHero(String hero) {
		this.hero = hero;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
