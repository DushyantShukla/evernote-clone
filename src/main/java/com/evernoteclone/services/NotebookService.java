/**
 *
 */

package com.evernoteclone.services;

import java.util.List;

import com.evernoteclone.entities.Notebook;

/**
 * Description: Description goes here.
 *
 * @author <a href="mailto:dushyant.shukla@senecaglobal.com@xxx">Dushyant
 *         Shukla</a>
 * @version $Revision$ $Date$
 * @since 0.1
 */
public interface NotebookService {

	/**
	 * @param notebook
	 * @return Notebook
	 */
	public Notebook createNewNotebook(Notebook notebook);

	/**
	 * @param notebook
	 */
	public void deleteNotebook(Notebook notebook);

	/**
	 * @return Notebook Collection
	 */
	public List<Notebook> findAllNotebooks();

	/**
	 * @param id
	 * @return Notebook
	 */
	public Notebook findNotebook(String id);

	/**
	 * @return long
	 */
	public long numberOfNotebooks();

	/**
	 * @param notebook
	 * @return Notebook
	 */
	public Notebook updateNotebook(Notebook notebook);

}
