package services;

import models.entities.Test;
import models.dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Chirrag on 21/01/18.
 */
@Service("testService")
@Transactional
public class TestService extends BaseService<Test, TestDao>{

    @Autowired
    TestDao testDao;

}
