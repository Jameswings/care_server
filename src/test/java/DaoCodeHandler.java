import devutils.SpringDaoCodeUtils;


public class DaoCodeHandler {

	public static void main(String[] args) {
		SpringDaoCodeUtils builder = new SpringDaoCodeUtils("users", "User", "/src/main/webapp/WEB-INF/applicationContext.xml");
		
		builder.printCode();
	}
}
