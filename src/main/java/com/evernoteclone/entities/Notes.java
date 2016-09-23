/**
 *
 */

package com.evernoteclone.entities;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Description: Description goes here.
 *
 * @author <a href="mailto:dushyant.shukla@senecaglobal.com@xxx">Dushyant
 *         Shukla</a>
 * @version $Revision$ $Date$
 * @since 0.1
 */
public class Notes {

	private String id;

	private String title;

	private String text;

	@DateTimeFormat(style = "M-")
	private LocalDateTime created;

	private String[] tags;

	/**
	 * @param id
	 * @param title
	 * @param text
	 * @param tags
	 */
	public Notes(String id, String title, String text, String[] tags) {
		super();
		this.id = id;
		this.title = title;
		this.text = text;
		created = LocalDateTime.now();
		this.tags = tags;
	}

	/**
	 * @return createdDate
	 */
	public LocalDateTime getCreated() {
		return created;
	}

	/**
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return tags
	 */
	public String[] getTags() {
		return tags;
	}

	/**
	 * @return text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param created
	 */
	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	/**
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param tags
	 */
	public void setTags(String[] tags) {
		this.tags = tags;
	}

	/**
	 * @param text
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

}
