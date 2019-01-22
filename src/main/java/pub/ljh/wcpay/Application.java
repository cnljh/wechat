/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pub.ljh.wcpay;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author Think
 */
@SpringBootApplication
public class Application implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("inininin");
//		WeChat wechat = WeChat.with().appid("wxbd878fc34fb8c6fe")
//						.secret("911d4465848ac9873c1281c0a81b5667")
//						.mchId("1503333761")
//						.key("V85s0fn9YrXIKzHEVLplRSQHNOhUML3L")
//						.keyStore(null).build();
	}

}
