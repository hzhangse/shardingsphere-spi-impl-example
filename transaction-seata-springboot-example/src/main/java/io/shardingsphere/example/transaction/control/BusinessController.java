package io.shardingsphere.example.transaction.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.shardingsphere.example.transaction.base.seata.spring.boot.NoSeatsTransactionalService;
import io.shardingsphere.example.transaction.base.seata.spring.boot.SeataTransactionalService;

/**
 * @author jimin.jm@alibaba-inc.com
 * @date 2019/06/14
 */

@RestController
public class BusinessController {

	@Autowired
	private SeataTransactionalService transactionalService;
	
	@Autowired
	private NoSeatsTransactionalService noSeatstransactionalService;

	/**
	 * 购买下单，模拟全局事务提交
	 *
	 * @return
	 */
	@RequestMapping(value = "/seata/commit")
	public String purchaseCommit() {
		try {
			transactionalService.processSuccess();
		} catch (Exception exx) {
			//return exx.getMessage();
		}
		transactionalService.printData();
		return "/seata/commit";
	}
	
	@RequestMapping(value = "/noseata/commit")
	public String purchaseNoCommit() {
		try {
			noSeatstransactionalService.processSuccess();
		} catch (Exception exx) {
			//return exx.getMessage();
		}
		transactionalService.printData();
		return "/noseata/commit";
	}

	/**
	 * 购买下单，模拟全局事务回滚 账户或库存不足
	 *
	 * @return
	 */
	@RequestMapping("/seata/rollback")
	public String purchaseRollback() {
		try {
			transactionalService.processFailure();
		} catch (Exception exx) {

			//transactionalService.printData();

		}
		transactionalService.printData();
		return "/seata/rollback";
	}
	
	@RequestMapping("/noseata/rollback")
	public String purchaseNoRollback() {
		try {
			noSeatstransactionalService.processFailure();
		} catch (Exception exx) {

			//notransactionalService.printData();

		}
		transactionalService.printData();
		return "/noseata/rollback";
	}
}
