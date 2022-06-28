import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHeaders;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.List;

public class Main {
    public static final String POSTS = "https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats";

    public static ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {

        CloseableHttpClient httpClient = HttpClientBuilder.create().
                setUserAgent("MyTestService").
                setDefaultRequestConfig(RequestConfig.custom().
                        setConnectTimeout(5000).
                        setSocketTimeout(30000).
                        setRedirectsEnabled(false).
                        build()).
                build();

        HttpGet request = new HttpGet(POSTS);
        request.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());

        CloseableHttpResponse response = httpClient.execute(request);


        var list = objectMapper.readValue(response.getEntity().getContent(), new TypeReference<List<Cat>>() {
                }
        );

        list.stream().filter(x -> x.getUpvote() != null && !x.getUpvote().equals("0")).forEach(System.out::println);

        httpClient.close();
        response.close();
    }
}
