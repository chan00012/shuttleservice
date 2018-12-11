package shuttleservice.beans;

public class Route {
	
	String shuttleRoute;
	String routeTime;
	
	
	public Route(String shuttleRoute, String routeTime) {
		super();
		this.shuttleRoute = shuttleRoute;
		this.routeTime = routeTime;
	}
	
	public String getShuttleRoute() {
		return shuttleRoute;
	}
	public void setShuttleRoute(String shuttleRoute) {
		this.shuttleRoute = shuttleRoute;
	}
	public String getRouteTime() {
		return routeTime;
	}
	public void setRouteTime(String routeTime) {
		this.routeTime = routeTime;
	}
	

}
