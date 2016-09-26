
package com.evernoteclone;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.evernoteclone.entities.Notebook;
import com.evernoteclone.repositories.NotebookRepository;

/**
 * Description: Description goes here.
 *
 * @author <a href="mailto:dushyant.shukla@senecaglobal.com@xxx">Dushyant
 *         Shukla</a>
 * @version $Revision$ $Date$
 * @since 0.1
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EvernotecloneApplicationTests {

	@Mock
	private Notebook notebook;

	@Autowired
	private NotebookRepository notebookRepository;

	@Autowired
	private MongoTemplate mongoTemplate;

	/**
     *
     */
	@Before
	public void setup() {
		mongoTemplate.dropCollection(Notebook.class);
	}

	/**
     *
     */
	@Test
	public void shouldSaveNotebookAndReturnCountAsOne() {
		notebookRepository.save(notebook);
		Set<String> collections = mongoTemplate.getCollectionNames();
		for(String collection : collections){    
		   System.out.println("Collection: " + collection); // print the name of each collection
		   System.out.println(mongoTemplate.getDb().getCollectionFromString(collection).find()); //and then print the json of each of its elements
		}
		assertEquals(1, notebookRepository.count());
		System.out.println(notebookRepository.findAll());
	}

}
