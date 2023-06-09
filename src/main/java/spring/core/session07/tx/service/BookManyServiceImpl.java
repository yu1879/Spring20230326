package spring.core.session07.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.core.session07.tx.exception.InsufficientAmount;
import spring.core.session07.tx.exception.InsufficientStock;

@Service
public class BookManyServiceImpl implements BookManyService {
	@Autowired
	private BookOneService bookOneService;

	@Transactional(rollbackFor = { InsufficientStock.class, InsufficientAmount.class }

	)
	@Override
	public void buyMany(String username, Integer... bookIds) throws InsufficientStock, InsufficientAmount {
		// TODO Auto-generated method stub
		for (Integer bookId : bookIds) {
			bookOneService.buyOne(username, bookId);
		}

	}

}
