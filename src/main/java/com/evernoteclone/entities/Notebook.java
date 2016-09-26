/**
 *
 */

package com.evernoteclone.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

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

	/**
	 * @param json
	 * @return Notebook collection
	 */
	public static Collection<Notebook> fromJsonArrayToNotebooks(String json) {
		return new JSONDeserializer<List<Notebook>>().use(null, ArrayList.class).use("values", Notebook.class).deserialize(json);
	}

	/**
	 * @param json
	 * @return Notebook
	 */
	public static Notebook fromJsonToNotebook(String json) {
		return new JSONDeserializer<Notebook>().use(null, Notebook.class).deserialize(json);
	}

	/**
	 * @param collection
	 * @return String
	 */
	public static String toJsonArray(Collection<Notebook> collection) {
		return new JSONSerializer().include("tags").include("notes.tags").exclude("*.class").serialize(collection);
	}

	@Id
	@Field
	private String id;

	@Field
	@DateTimeFormat(style = "M-")
	private LocalDateTime created;

	@Field
	private String name;

	@Field
	private String description;

	@Field
	private String author;

	@Field
	private String[] tags;

	@Field
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
	 * {@inheritDoc}
	 *
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Notebook other = (Notebook) obj;
		if (author == null) {
			if (other.author != null) {
				return false;
			}
		} else if (!author.equals(other.author)) {
			return false;
		}
		if (created == null) {
			if (other.created != null) {
				return false;
			}
		} else if (!created.equals(other.created)) {
			return false;
		}
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (!Arrays.equals(tags, other.tags)) {
			return false;
		}
		return true;
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
	 * {@inheritDoc}
	 *
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (author == null ? 0 : author.hashCode());
		result = prime * result + (created == null ? 0 : created.hashCode());
		result = prime * result + (description == null ? 0 : description.hashCode());
		result = prime * result + (name == null ? 0 : name.hashCode());
		result = prime * result + Arrays.hashCode(tags);
		return result;
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
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;

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

	/**
	 * @return String
	 */
	public String toJson() {
		return new JSONSerializer().include("tags").include("notes.tags").exclude("*.class").serialize(this);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Notebook [id=" + id + ", name=" + name + ", description=" + description + ", created=" + created + ", author=" + author + ", tags=" + Arrays.toString(tags) + ", notes=" + Arrays.toString(notes) + "]";
	}

}
