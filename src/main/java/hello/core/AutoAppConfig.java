package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core",
        basePackageClasses = AutoAppConfig.class,
//       지정을 안하면 이파일이위치한 패키지의 하위를 다 뒤짐( 관례)
        excludeFilters= @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)

)
public class AutoAppConfig {
//
//    @Bean(name = "memoryMemberRepository")
//    MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }

}
