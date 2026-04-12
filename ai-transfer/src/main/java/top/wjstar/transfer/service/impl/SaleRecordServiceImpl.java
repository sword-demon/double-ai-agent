package top.wjstar.transfer.service.impl;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.wjstar.transfer.dao.SaleRecordDao;
import top.wjstar.transfer.domain.vo.SaleRecordVo;
import top.wjstar.transfer.service.SaleRecordService;

import java.util.List;

/**
 * @author wxvirus
 */
@Service
@Slf4j
public class SaleRecordServiceImpl implements SaleRecordService {

    @Resource
    private SaleRecordDao saleRecordDao;

    @Override
    public List<SaleRecordVo> collectSaleRecordDataByProductId(Integer productId) {
        return saleRecordDao.collectSaleRecordDataByProductId(productId);
    }
}
