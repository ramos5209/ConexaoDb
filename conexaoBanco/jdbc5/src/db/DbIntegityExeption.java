package db;

public class DbIntegityExeption extends RuntimeException {
	
	private static final long serialVersionUID = 1l;
	
	public DbIntegityExeption(String msg) {
		super(msg);
	}

}
