package cn.iocoder.mall.search.biz.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "cn.iocoder.mall.search.biz.dao")
public class JPAConfiguration {

	@Bean
    public TransportClient transportClient() throws UnknownHostException {
        TransportClient client = new PreBuiltXPackTransportClient(Settings.builder()
                .put("cluster.name", "docker-cluster")
                .put("xpack.security.user", "elastic:MagicWord")
                .build())
                .addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
        return client;
    }
    	
}
