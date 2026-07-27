package top.wjstar.transfer.service;

import top.wjstar.transfer.domain.vo.InventoryOrderVO;

import java.util.List;

/**
 * @author wxvirus
 */
public interface InventoryOrderService {

    List<InventoryOrderVO> collectInventoryOrderDataByProductId(Integer productId);
}
