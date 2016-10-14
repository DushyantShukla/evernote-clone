
package com.evernoteclone;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import com.mongodb.MongoClient;

/**
 * Description: Description goes here.
 *
 * @author <a href="mailto:dushyant.shukla@senecaglobal.com@xxx">Dushyant
 *         Shukla</a>
 * @version $Revision$ $Date$
 * @since 0.1
 */
@SpringBootApplication
public class EvernotecloneApplication
	implements CommandLineRunner
{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(EvernotecloneApplication.class, args);
	}

	@Value("${spring.data.mongodb.port}")
	private int port;

	/**
	 * {@inheritDoc}
	 *
	 * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
	 */
	@Override
	public void run(String ... args)
		throws Exception
	{
		// System.err.println(port);
		MongoClient mongo = new MongoClient("localhost", port);
		// MongoIterable<String> dbs = mongo.listDatabaseNames();
		// for (String db : dbs) {
		// System.err.println("DB= " + db);
		// }
		// mongo.close();
		//

		//code to check if the database is available
		try {
			System.out.println("Database available!");
			mongo.getAddress();
			System.out.println("Database available!");
		} catch (Exception e) {
			System.out.println("Database unavailable!");
			mongo.close();
		}
	}

}
