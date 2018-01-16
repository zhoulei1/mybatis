package mybatis.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan(basePackages="mybatis.mapper",sqlSessionFactoryRef="sqlSessionFactory")
@EnableTransactionManagement
public class MybatisDataSourceConfig {

	
	
	//此处使用自动装配的H2数据源,可自定义数据源
	
/*	@Primary
	@Bean
	public DataSource dataSourceOne(){
	    return DruidDataSourceBuilder.create().build();
	}*/
    @Bean("sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setTypeAliasesPackage("mybatis.model");
        //sessionFactory.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config.xml"));
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return sessionFactory.getObject();
    }
    
    //事务配置,TransactionAutoConfiguration自动装配事物管理器DataSourceTransactionManager 
    //使用子自定义DataSourceTransactionManager
    @Bean
    @Primary
    public DataSourceTransactionManager transactionManager(DataSource dataSource){
    	return new DataSourceTransactionManager(dataSource);
    }
    
}
