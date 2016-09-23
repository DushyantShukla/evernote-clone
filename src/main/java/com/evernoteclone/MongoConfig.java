/**
 *
 */

package com.evernoteclone;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;

import de.flapdoodle.embed.process.runtime.Network;

/**
 * Description: Description goes here.
 *
 * @author <a href="mailto:dushyant.shukla@senecaglobal.com@xxx">Dushyant
 *         Shukla</a>
 * @version $Revision$ $Date$
 * @since 0.1
 */

@Configuration
public class MongoConfig {

	@Value("${spring.data.mongodb.port}")
	private int port;

	/**
	 * @return MongoDbFactory
	 */
	/*@Bean
	public MongoDbFactory mongoDbFactory() {
		try {
			port = Network.getFreeServerPort();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MongoClient mongo = new MongoClient("localhost", port);
		String databaseName = "notebook";
		MongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(mongo, databaseName);
		try {
			System.out.println("Database available!");
			mongo.getAddress();
			System.out.println("Database available!");
		} catch (Exception e) {
			System.out.println("Database unavailable!");
			mongo.close();
		}
		return mongoDbFactory;
	}

	**
	 * @return MongoTemplate
	 * @throws Exception
	 *//*
	@Bean
	public MongoTemplate mongoTemplate()
		throws Exception
	{
		return new MongoTemplate(mongoDbFactory());
	}*/
}
