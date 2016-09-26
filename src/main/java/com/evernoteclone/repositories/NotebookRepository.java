/**
 *
 */

package com.evernoteclone.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.evernoteclone.entities.Notebook;

/**
 * Description: Description goes here.
 *
 * @author <a href="mailto:dushyant.shukla@senecaglobal.com@xxx">Dushyant
 *         Shukla</a>
 * @version $Revision$ $Date$
 * @since 0.1
 */
@Repository
public interface NotebookRepository
	extends PagingAndSortingRepository<Notebook, String>
{

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.springframework.data.repository.CrudRepository#findAll()
	 */
	@Override
	List<Notebook> findAll();
}
