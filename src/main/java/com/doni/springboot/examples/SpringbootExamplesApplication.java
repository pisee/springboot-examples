package com.doni.springboot.examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @SpringBootApplication = @SpringBootConfiguration + @EnableAutoConfiguration + @ComponentScan
 * 
 * @SpringBootConfiguration
 * 클래스가 스프링 부트 응용 프로그램 @Configuration을 제공한다는 것을 나타냅니다. 
 * 스프링의 표준 @Configuration 어노테이션에 대한 대안으로 사용할 수 있으므로 자동으로 구성을 찾을 수 있습니다 (예 : 테스트).
 * 응용 프로그램에는 @SpringBootConfiguration이 하나만 포함되어야하며 
 * 대부분의 관용적 인 스프링 부팅 응용 프로그램은 @SpringBootApplication에서 응용 프로그램을 상속합니다.
 * 
 * 
 * @EnableAutoConfiguration
 * Spring Application Context의 자동 설정을 사용하여 필요할 가능성이 높은 bean을 추측하고 구성하십시오. 
 * 자동 구성 클래스는 일반적으로 classpath와 정의한 bean을 기반으로 적용됩니다. 
 * 예를 들어 클래스 경로에 tomcat-embedded.jar가있는 경우 TomcatServletWebServerFactory를 원할 수 있습니다 
 * (자신 만의 ServletWebServerFactory bean을 정의하지 않았다면).
 * 
 * SpringBootApplication을 사용할 때 컨텍스트의 자동 구성이 자동으로 활성화되므로이 주석을 추가하면 추가 효과가 없습니다.
 * 자동 구성은 가능한 한 지능적으로 시도하며 자신의 구성을 더 많이 정의하면 취소됩니다. 
 * 적용하지 않으려는 구성은 언제든지 수동으로 제외 () 할 수 있습니다 (액세스 권한이없는 경우 excludeName () 사용). 
 * 또한 spring.autoconfigure.exclude 속성을 통해 제외 할 수도 있습니다. 
 * 자동 구성은 사용자 정의 bean이 등록 된 후에 항상 적용됩니다.
 * 
 * 일반적으로 @SpringBootApplication을 통해 @EnableAutoConfiguration으로 주석 처리 된 클래스의 패키지는 
 * 특별한 중요성을 가지며 종종 '기본'으로 사용됩니다. 
 * 예를 들어, @Entity 클래스를 검색 할 때 사용됩니다. 
 * 일반적으로 루트 패키지에 @EnableAutoConfiguration (@SpringBootApplication을 사용하지 않는 경우)을 배치하여 
 * 모든 하위 패키지 및 클래스를 검색 할 수 있도록하는 것이 좋습니다.
 * 
 * 
 * @ComponentScan
 * @Configuration 클래스와 함께 사용할 구성 요소 검색 지시문을 구성합니다. 
 * Spring XML의 <context : component-scan> 요소와 함께 지원을 제공합니다.
 * 
 * basePackageClasses 또는 basePackages (또는 별명 값)를 지정하여 스캔 할 특정 패키지를 정의 할 수 있습니다. 
 * 특정 패키지가 정의되지 않은 경우이 주석을 선언 한 클래스의 패키지에서 검색이 수행됩니다.
 * 
 * <context : component-scan> 요소에는 annotation-config 속성이 있습니다. 
 * 그러나 이 주석은 그렇지 않습니다. 
 * 이는 @ComponentScan을 사용할 때 거의 모든 경우에 기본 주석 구성 처리 
 * (예 : @Autowired 및 friends 처리)가 가정되기 때문입니다. 
 * 또한 AnnotationConfigApplicationContext를 사용할 때 주석 구성 프로세서는 항상 등록되며 
 * @ComponentScan 수준에서 비활성화하려는 시도는 무시됩니다.
 * 
 */
@SpringBootApplication
public class SpringbootExamplesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootExamplesApplication.class, args);
		
//		SpringApplication application = new SpringApplication(SpringBootApplication.class);
//		application.setBanner(new Banner() {
//			
//			@Override
//			public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
//				out.println("doni springboot examples");
//				
//			}
//		});
//		application.run(args);
		
//		new SpringApplicationBuilder(SpringBootApplication.class)
//		.banner(new Banner() {
//			@Override
//			public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
//				out.print("hello my stock");
//			}
//		}).run(args);
		
//		new SpringApplicationBuilder(SpringBootApplication.class)
//			.banner((environment, sourceClass, out) -> out.print("hello my stock"))
//		.run(args);
	}
}
