package rs.engineering.javacourse.myspringmvcapp.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MyWebApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		System.out.println("========================================================");
		System.out.println("============= MyWebApplicationIznitializer =============");
		System.out.println("========================================================");
		// web kontekst koji kreira dispatcher servlet u kome se nalaze objekte koje on
		// poziva pri izvrsenju zahteva
		AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
		webApplicationContext.register(MyWebContextConfig.class);
		webApplicationContext.setServletContext(servletContext);

		// registruj dispatcher srvlet
		ServletRegistration.Dynamic dispatcherServlet 
		= servletContext.addServlet("myDispatcherServlet",
				new DispatcherServlet(webApplicationContext));
		dispatcherServlet.addMapping("/");
		dispatcherServlet.setLoadOnStartup(1);
	}

}
