package br.edu.ifpe.acesso;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AcessoConfig implements WebMvcConfigurer {

	
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AutorizadorInterceptor())
			.addPathPatterns(new String[]{"/adm", "/adm/*"});
		
	}
}