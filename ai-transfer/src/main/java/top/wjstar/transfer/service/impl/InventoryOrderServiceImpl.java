package top.wjstar.transfer.service.impl;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.jvnet.hk2.annotations.Service;
import top.wjstar.transfer.dao.InventoryOrderDao;
import top.wjstar.transfer.domain.vo.InventoryOrderVO;
import top.wjstar.transfer.service.InventoryOrderService;

import java.util.List;

/**
 * @author wxvirus
 */
@Service
@Slf4j
public class InventoryOrderServiceImpl implements InventoryOrderService {

    @Resource
    private InventoryOrderDao inventoryOrderDao;

    @Override
    public List<InventoryOrderVO> collectInventoryOrderDataByProductId(Integer productId) {
        return inventoryOrderDao.collectInventoryOrderDataByProductId(productId);
    }
}
