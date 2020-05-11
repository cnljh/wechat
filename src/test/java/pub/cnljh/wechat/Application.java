package pub.cnljh.wechat;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.ResourceUtils;
import pub.cnljh.wechat.payment.v2.PaymentV2;

@SpringBootApplication
@Configuration
@Setter
@Getter
@PropertySource("classpath:secret.properties")
@ConfigurationProperties(prefix = "wechat")
public class Application {

	private String appid;
	private String mchId;
	private String apiKey;
	private String keyStore;

	@Bean
	public WeChat wechat() {
		try {
//			File file = ResourceUtils.getFile("C:\\Users\\Think\\Desktop\\workarea\\WXCertUtil\\cert\\1503333761_20200411_cert\\apiclient_cert.p12");
			return WeChat.with()
							.appid(appid)
							.mchId(mchId)
							.apiKey(apiKey)
							.keyStore(new FileInputStream(keyStore))
							.build();
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Bean
	public PaymentV2 paymentV2() {
		return wechat().paymentV2();
	}

}
