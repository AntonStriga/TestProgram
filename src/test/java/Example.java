import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Scanner;

public class Example {

    @Test (groups = {"GET"})
    public void getTest() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(("https://www.google.com/"));
        HttpResponse httpResponse = httpClient.execute(httpGet);

        Scanner sc = new Scanner((httpResponse.getEntity().getContent()));

        System.out.println(httpResponse.getStatusLine());
        while(sc.hasNext()) {
            System.out.println(sc.nextLine());
        }
        Assert.assertEquals(200, httpResponse.getStatusLine().getStatusCode());
    }

    @Test (groups = {"POST"})
    public void postTest() {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(("https://www.google.com/"));
    }
}
