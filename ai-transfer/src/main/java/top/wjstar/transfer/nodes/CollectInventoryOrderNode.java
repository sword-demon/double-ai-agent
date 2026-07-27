package top.wjstar.transfer.nodes;

import cn.hutool.json.JSONUtil;
import com.alibaba.cloud.ai.graph.OverAllState;
import com.alibaba.cloud.ai.graph.action.NodeAction;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import top.wjstar.transfer.domain.vo.InventoryOrderVO;
import top.wjstar.transfer.service.InventoryOrderService;

import java.util.List;
import java.util.Map;

/**
 * @author wxvirus
 */
@Slf4j
public class CollectInventoryOrderNode implements NodeAction {

    private final InventoryOrderService inventoryOrderService;

    public CollectInventoryOrderNode(InventoryOrderService inventoryOrderService) {
        this.inventoryOrderService = inventoryOrderService;
    }

    /**
     * 编写业务逻辑
     * 1. 从状态机获取 productId
     * 2. 写 sql 去查询这个商品对应的历史的调拨情况
     * <p>
     * 维度: 年份,季度,商品,仓库
     * </p>
     *
     * @param state 状态机
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, Object> apply(OverAllState state) throws Exception {
        String productId = state.value("productId", "");
        if (StringUtils.isBlank(productId)) {
            return Map.of();
        }
        List<InventoryOrderVO> inventoryOrderVOS = inventoryOrderService.collectInventoryOrderDataByProductId(Integer.parseInt(productId));
        String inventoryOrderData = JSONUtil.toJsonStr(inventoryOrderVOS);
        log.info("inventoryOrderData:{}", inventoryOrderData);
        return Map.of("inventoryOrderData", inventoryOrderData);
    }
}
