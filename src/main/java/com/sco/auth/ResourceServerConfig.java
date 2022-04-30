package com.sco.auth;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/socio/sel").permitAll()

				.antMatchers(HttpMethod.GET, "/adq/sel").permitAll().antMatchers(HttpMethod.GET, "/adq/sel/{adqid}")
				.permitAll().antMatchers(HttpMethod.POST, "/adq/add").permitAll()
				.antMatchers(HttpMethod.POST, "/adq/upload").permitAll().antMatchers(HttpMethod.GET, "/adq/adq/{adqid}")
				.permitAll().antMatchers(HttpMethod.DELETE, "/adq/del/{adqid}").permitAll()
				.antMatchers(HttpMethod.PUT, "/adq/upd/{adqid}").permitAll()

				.antMatchers(HttpMethod.GET, "/moneda/sel").permitAll()
				.antMatchers(HttpMethod.GET, "/moneda/sel/{monid}").permitAll()
				.antMatchers(HttpMethod.POST, "/moneda/add").permitAll()
				.antMatchers(HttpMethod.DELETE, "/moneda/del/{catid}").permitAll()
				.antMatchers(HttpMethod.PUT, "/moneda/upd/{monid}").permitAll()

				.antMatchers(HttpMethod.GET, "/corte/sel").permitAll().antMatchers(HttpMethod.GET, "/corte/sel/dolares")
				.permitAll().antMatchers(HttpMethod.GET, "/corte/sel/{corid}").permitAll()
				.antMatchers(HttpMethod.POST, "/corte/add").permitAll()
				.antMatchers(HttpMethod.DELETE, "/corte/del/{corid}").permitAll()
				.antMatchers(HttpMethod.PUT, "/corte/upd/{corid}").permitAll()

				.antMatchers(HttpMethod.GET, "/arqueo/sel").permitAll()
				.antMatchers(HttpMethod.GET, "/arqueo/sel/bolivianos/{id}").permitAll()
				.antMatchers(HttpMethod.GET, "/arqueo/sel/dolares/{id}").permitAll()
				.antMatchers(HttpMethod.GET, "/arqueo/sel/todo/{id}").permitAll()
				.antMatchers(HttpMethod.GET, "/arqueo/sel/sumabolivianos/{id}").permitAll()
				.antMatchers(HttpMethod.GET, "/arqueo/sel/sumadolares/{id}").permitAll()
				.antMatchers(HttpMethod.GET, "/arqueo/sel/{arqid}").permitAll()
				.antMatchers(HttpMethod.POST, "/arqueo/add").permitAll()
				.antMatchers(HttpMethod.DELETE, "/arqueo/del/{arqid}").permitAll()
				.antMatchers(HttpMethod.PUT, "/arqueo/upd/{arqid}").permitAll()

				// proyecto isos
				.antMatchers(HttpMethod.GET, "/nt/sel").permitAll().antMatchers(HttpMethod.GET, "/nt/sel/{ntid}")
				.permitAll().antMatchers(HttpMethod.POST, "/nt/add").permitAll()
				.antMatchers(HttpMethod.DELETE, "/nt/del/{ntid}").permitAll()
				.antMatchers(HttpMethod.PUT, "/nt/upd/{ntid}").permitAll()

				.antMatchers(HttpMethod.GET, "/ctrl/sel").permitAll().antMatchers(HttpMethod.GET, "/ctrl/sel/{ctrlid}")
				.permitAll().antMatchers(HttpMethod.POST, "/ctrl/add").permitAll()
				.antMatchers(HttpMethod.DELETE, "/ctrl/del/{ctrlid}").permitAll()
				.antMatchers(HttpMethod.PUT, "/ctrl/upd/{ctrlid}").permitAll()

				.antMatchers(HttpMethod.GET, "/gap/sel").permitAll().antMatchers(HttpMethod.GET, "/gap/sel/{gapid}")
				.permitAll().antMatchers(HttpMethod.POST, "/gap/add").permitAll()
				.antMatchers(HttpMethod.DELETE, "/gap/del/{gapid}").permitAll()
				.antMatchers(HttpMethod.PUT, "/gap/upd/{gapid}").permitAll()

				// plataforma
				.antMatchers(HttpMethod.GET, "/socio/sel").permitAll()
				.antMatchers(HttpMethod.GET, "/socio/sel/{cuenta}").permitAll()
				.antMatchers(HttpMethod.GET, "/socio/sel/firmantecaja/{cuenta}").permitAll()
				.antMatchers(HttpMethod.GET, "/socio/sel/firmantecajadistinct/{cuenta}").permitAll()

				// prestamo
				// .antMatchers(HttpMethod.GET,
				// "/prestamo/selnacional/{fechaini}/{fechafin}/{cargos}").permitAll()
				.antMatchers(HttpMethod.GET, "/prestamo/selextranjera/{fechaini}/{fechafin}/{cargos}").permitAll()

				// dpf
				.antMatchers(HttpMethod.GET, "/socio/sel/dpf/{cuenta}").permitAll()
				.antMatchers(HttpMethod.GET, "/socio/sel/dpf/firmantes/{cuenta}").permitAll()

				// plataforma excel
				.antMatchers(HttpMethod.GET, "/plataforma/socio/{nsocio}").permitAll()
				// caja excel
				.antMatchers(HttpMethod.GET, "/caja/{nrocuentacaja}").permitAll()
				// MODULO DE REGISTRO DE ERRORES
				// TIPO ERROR
				.antMatchers(HttpMethod.GET, "/tipoerror/sel").permitAll()
				// .antMatchers(HttpMethod.GET, "/tipoerror/sel/{cuenta}").permitAll()
				// .antMatchers(HttpMethod.GET,
				// "/tipoerror/sel/firmantecaja/{cuenta}").permitAll()
				// .antMatchers(HttpMethod.GET,
				// "/tipoerror/sel/firmantecajadistinct/{cuenta}").permitAll()
				// ERROR
				.antMatchers(HttpMethod.GET, "/error/sel").permitAll().antMatchers(HttpMethod.GET, "/error/sel/{id}")
				.permitAll().antMatchers(HttpMethod.POST, "/error/add").permitAll()
				.antMatchers(HttpMethod.DELETE, "/error/del/{id}").permitAll()
				.antMatchers(HttpMethod.PUT, "/error/upd/{id}").permitAll()
				// AUTORIZACIONES
				.antMatchers(HttpMethod.GET, "/autorizacion/sel").permitAll()
				.antMatchers(HttpMethod.GET, "/atorizacion/sel/{id}").permitAll()
				.antMatchers(HttpMethod.POST, "/autorizacion/add").permitAll()
				.antMatchers(HttpMethod.DELETE, "/autorizacion/del/{id}").permitAll()
				.antMatchers(HttpMethod.PUT, "/autorizacion/upd/{id}").permitAll()
				// MODULO DE DECLARACIONES JURADAS PARA PLATAFORMA
				.antMatchers(HttpMethod.GET, "/declaracion/sel/{codigo_cliente}").permitAll()
				.antMatchers(HttpMethod.GET, "/declaracion/activos/{codigo_cliente}").permitAll()
				.antMatchers(HttpMethod.GET, "/declaracion/pasivos/{codigo_cliente}").permitAll()
				.antMatchers(HttpMethod.GET, "/declaracion/ingresosfijos/{codigo_cliente}").permitAll()
				.antMatchers(HttpMethod.GET, "/declaracion/ingresosvariables/{codigo_cliente}").permitAll()
				.antMatchers(HttpMethod.GET, "/declaracion/gastosfijos/{codigo_cliente}").permitAll()
				.antMatchers(HttpMethod.GET, "/declaracion/gastosvariables/{codigo_cliente}").permitAll()
				// MODULO IMPRESION DE CETIFICADOS DE APORTACION
				.antMatchers(HttpMethod.GET, "/certificado/sel/{nro_socio}").permitAll()
				// ENTIDAD CLASE DE ERROR
				.antMatchers(HttpMethod.GET, "/claseerror/sel").permitAll()
				
				// Modulo Gestion de usuarios
				.antMatchers(HttpMethod.GET, "/usuario/sel").permitAll()
				.antMatchers(HttpMethod.POST, "/usuario/add").permitAll()
				.antMatchers(HttpMethod.DELETE, "/usuario/del/{id}").permitAll()
				.antMatchers(HttpMethod.PUT, "/usuario/upd/{id}").permitAll()
				
				.anyRequest().authenticated().and().cors().configurationSource(corsConfigurationSource());
	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowedOrigins(Arrays.asList("http://localhost:4200")); // endpoint que consumira servicios
		// config.setAllowedOrigins(Arrays.asList("http://10.1.0.232"));
		// config.setAllowedOrigins(Arrays.asList("*"));
		// config.setAllowedOrigins(Arrays.asList("https://tuwebzone.com")); //entpoint
		// para produccion
		config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		config.setAllowCredentials(true);
		config.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);
		return source;
	}

	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter() {
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(
				new CorsFilter(corsConfigurationSource()));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}
}