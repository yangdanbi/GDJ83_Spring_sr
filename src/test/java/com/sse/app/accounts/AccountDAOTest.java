package com.sse.app.accounts;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sse.app.DefaultTest;

public class AccountDAOTest extends DefaultTest {

	@Autowired
	private AccountDAO accountDAO;

	@Test
	public void detail() {
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setBank_id("1720399639825");
		accountDAO.detail(accountDTO);
		accountDTO.getProductDTO();

		assertNotNull(accountDTO.getProductDTO());

	}

}
