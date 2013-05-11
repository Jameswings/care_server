import devutils.SpringDaoCodeUtils;


public class DaoCodeHandler {

	public static void main(String[] args) {
		SpringDaoCodeUtils builder = new SpringDaoCodeUtils("pending_request", "PendingRequest", "/src/main/webapp/WEB-INF/applicationContext.xml");
		
		builder.printCode();
	}
}
