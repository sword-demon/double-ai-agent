package top.wjstar.transfer.service;

import top.wjstar.transfer.domain.vo.SaleRecordVo;

import java.util.List;

/**
 * @author wxvirus
 */
public interface SaleRecordService {
    List<SaleRecordVo> collectSaleRecordDataByProductId(Integer productId);
}