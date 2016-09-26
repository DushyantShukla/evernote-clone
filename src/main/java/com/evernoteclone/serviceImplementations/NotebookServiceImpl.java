/**
 *
 */

package com.evernoteclone.serviceImplementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evernoteclone.entities.Notebook;
import com.evernoteclone.repositories.NotebookRepository;
import com.evernoteclone.services.NotebookService;

/**
 * Description: Description goes here.
 *
 * @author <a href="mailto:dushyant.shukla@senecaglobal.com@xxx">Dushyant
 *         Shukla</a>
 * @version $Revision$ $Date$
 * @since 0.1
 */
@Service
public class NotebookServiceImpl
	implements NotebookService
{

	@Autowired
	private NotebookRepository notebookRepository;

	/**
	 * {@inheritDoc}
	 *
	 * @see com.evernoteclone.services.NotebookService#createNewNotebook(com.evernoteclone.entities.Notebook)
	 */
	@Override
	public Notebook createNewNotebook(Notebook notebook) {
		return notebookRepository.save(notebook);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see com.evernoteclone.services.NotebookService#deleteNotebook(com.evernoteclone.entities.Notebook)
	 */
	@Override
	public void deleteNotebook(Notebook notebook) {
		notebookRepository.delete(notebook);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see com.evernoteclone.services.NotebookService#findAllNotebooks()
	 */
	@Override
	public List<Notebook> findAllNotebooks() {
		return notebookRepository.findAll();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see com.evernoteclone.services.NotebookService#findNotebook(java.lang.String)
	 */
	@Override
	public Notebook findNotebook(String id) {
		return notebookRepository.findOne(id);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see com.evernoteclone.services.NotebookService#numberOfNotebooks()
	 */
	@Override
	public long numberOfNotebooks() {
		return notebookRepository.count();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see com.evernoteclone.services.NotebookService#updateNotebook(com.evernoteclone.entities.Notebook)
	 */
	@Override
	public Notebook updateNotebook(Notebook notebook) {
		return notebookRepository.save(notebook);
	}

}
