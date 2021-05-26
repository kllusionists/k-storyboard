package com.kuo.storyboard.configuration;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author Channing Kuo
 * @date 2020/12/23
 */
@Slf4j
@Configuration
public class MybatisPlusConfigurer {

	@Bean
	public SqlSessionFactory sqlSessionFactoryBean(DataSource dataSource) throws Exception {
		MybatisSqlSessionFactoryBean factoryBean = new MybatisSqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		factoryBean.setTypeAliasesPackage("com.kuo.storyboard.entity");

		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		factoryBean.setMapperLocations(resolver.getResources("classpath*:/mapper/**/*.xml"));
		return factoryBean.getObject();
	}

	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
		mapperScannerConfigurer.setBasePackage("com.kuo.storyboard.mapper");

		return mapperScannerConfigurer;
	}
}
