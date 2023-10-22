package ru.admhmao.main;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

import lombok.SneakyThrows;

@SpringBootTest
class TelefonnyySpravochnikOgvHmaoApplicationTests {

	private static final String PROXY_SERVER_HOST = "45.145.3.135";

	private static final int PROXY_SERVER_PORT = 9061;

	private static final String USER = "user139728";

	private static final String PASSWORD = "zo6eqh";

	private static final String URL = "https://admhmao.ru/organy-vlasti/telefonnyy-spravochnik-ogv-hmao/";

	@Test
	@SneakyThrows
	void contextLoads() {
		final String username = "user139728";
		final String password = "zo6eqh";
		final String proxyUrl = "45.145.3.135";
		final int port = 9061;
		CredentialsProvider credsProvider = new BasicCredentialsProvider();
		credsProvider.setCredentials(new AuthScope(proxyUrl, port), new UsernamePasswordCredentials(username,
			password));
		HttpHost myProxy = new HttpHost(proxyUrl, port);
		HttpClientBuilder clientBuilder = HttpClientBuilder.create();
		clientBuilder.setProxy(myProxy).setDefaultCredentialsProvider(credsProvider).disableCookieManagement();
		HttpClient httpClient = clientBuilder.build();
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		factory.setHttpClient(httpClient);
		// System.out.println(new RestTemplate(factory).getForObject(URL,
		// String.class));
	}
}
