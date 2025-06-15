package enums;

public enum APIEndPoints 
{
	CREATE_BOOKING("/booking"),
	GET_BOOKING("/booking/{id}"),
	UPDATE_BOOKING("/booking/{id}"),
	DELETE_BOOKING("/booking/{id}"),
	AUTH("/auth"),
	HEALTH_CHECK("/ping"),
	CREATE_PRODUCT("/objects"),
	UPDATE_PRODUCT("/objects/{id}"),
	DELETE_PRODUCT("/objects/{id}");

	private final String path;

	APIEndPoints(String path)
	{
		this.path=path;
	}
	
	public String getPath()
	{
		return path;
	}
			
}
