package spring.core.session07.tx.service;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import spring.core.session07.tx.dao.BookDao;

@Service

public class BookOneServiceImpl implements BookOneService {
	@Autowired
	private BookDao bookDao;

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void buyOne(String username, Integer bookId) {
		Integer bookPrice = bookDao.getBookPrice(bookId);
		bookDao.updateBookStock(bookId);
		bookDao.updateWallet(username, bookPrice);
	}

}
