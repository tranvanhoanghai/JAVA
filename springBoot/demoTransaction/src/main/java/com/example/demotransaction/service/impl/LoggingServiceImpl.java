package com.example.demotransaction.service.impl;

import com.example.demotransaction.entity.AllLog;
import com.example.demotransaction.exception.BankErrorCode;
import com.example.demotransaction.exception.BankException;
import com.example.demotransaction.repository.AllLogRepository;
import com.example.demotransaction.service.LoggingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

@Service
public class LoggingServiceImpl implements LoggingService {
    @Autowired
    private AllLogRepository allLogRepository;


    @Override
    @Transactional(value = TxType.REQUIRES_NEW, dontRollbackOn = {BankException.class})
    //@Transactional(value = TxType.NEVER)  //lưu được all log thành công vì tạo ra 2 transaction context khác nhau
    //@Transactional(value = TxType.REQUIRED) //Nằm trong transaction context của hàm gọi, nên không lưu được mọi log
    //@Transactional(value = TxType.REQUIRED, dontRollbackOn={ BankException.class })
    //@Transactional(value = TxType.SUPPORTS) //Không ghi được hết log
    //@Transactional(value = TxType.NOT_SUPPORTED) //Cũng ghi được nhiều log thành công
    //@Transactional(value = TxType.NEVER) //Báo lỗi Existing transaction found for transaction marked with propagation 'never'
    public void saveLog(long fromID, long toID, Long amount, BankErrorCode resultCode, String detail) {
        allLogRepository.save(new AllLog(fromID, toID, amount, resultCode, detail));
        System.out.println("==========================================================================================");
    }
}
