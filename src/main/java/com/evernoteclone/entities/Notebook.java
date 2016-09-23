/**
 *
 */

package com.evernoteclone.entities;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Description: Description goes here.
 *
 * @author <a href="mailto:dushyant.shukla@senecaglobal.com@xxx">Dushyant
 *         Shukla</a>
 * @version $Revision$ $Date$
 * @since 0.1
 */

@Document(collection = "notebooks")
public class Notebook {

	@Id
	private String id;

	@DateTimeFormat(style = "M-")
	private LocalDateTime created;

	private String name;

	private String description;

	private String author;

	private String[] tags;

	private Notes[] notes;

	/**
	 * @param name
	 * @param description
	 * @param author
	 * @param tags
	 * @param notes
	 */
	public Notebook(String name, String description, String author, String[] tags, Notes[] notes) {
		super();
		created = LocalDateTime.now();
		this.name = name;
		this.description = description;
		this.author = author;
		this.tags = tags;
		this.notes = notes;
	}

	/**
	 * @return author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @return createdDate
	 */
	public LocalDateTime getCreated() {
		return created;
	}

	/**
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return notes
	 */
	public Notes[] getNotes() {
		return notes;
	}

	/**
	 * @return tags
	 */
	public String[] getTags() {
		return tags;
	}

	/**
	 * @param author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @param created
	 */
	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	/**
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param notes
	 */
	public void setNotes(Notes[] notes) {
		this.notes = notes;
	}

	/**
	 * @param tags
	 */
	public void setTags(String[] tags) {
		this.tags = tags;
	}

}
