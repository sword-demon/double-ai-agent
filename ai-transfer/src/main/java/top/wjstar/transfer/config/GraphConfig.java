package top.wjstar.transfer.config;

import com.alibaba.cloud.ai.graph.CompiledGraph;
import com.alibaba.cloud.ai.graph.KeyStrategyFactory;
import com.alibaba.cloud.ai.graph.StateGraph;
import com.alibaba.cloud.ai.graph.action.AsyncNodeAction;
import com.alibaba.cloud.ai.graph.exception.GraphStateException;
import com.alibaba.cloud.ai.graph.state.strategy.ReplaceStrategy;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.wjstar.transfer.nodes.CollectInventoryOrderNode;
import top.wjstar.transfer.nodes.CollectSaleRecordNode;
import top.wjstar.transfer.service.InventoryOrderService;
import top.wjstar.transfer.service.SaleRecordService;
import top.wjstar.transfer.service.base.impl.BbInventoryService;

import java.util.Map;

/**
 * @author wxvirus
 */
@Configuration
public class GraphConfig {

    @Resource
    private SaleRecordService saleRecordService;
    @Resource
    private BbInventoryService bbInventoryService;
    private static final String SALE_RECORD_DATA_NODE = "saleRecordDataNode";
    private static final String INVENTORY_ORDER_DATA_NODE = "inventoryOrderDataNode";
    @Resource
    private InventoryOrderService inventoryOrderService;

    @Bean
    public CompiledGraph graph() throws GraphStateException {
        KeyStrategyFactory keyStrategyFactory = () -> Map.of("productId", new ReplaceStrategy(),
                "saleRecordData", new ReplaceStrategy(),
                "nowProductInventoryData", new ReplaceStrategy(),
                "inventoryOrderData", new ReplaceStrategy());

        StateGraph stateGraph = new StateGraph("inventoryTransferGraph", keyStrategyFactory);

        // 往图中定义节点
        stateGraph.addNode(SALE_RECORD_DATA_NODE,
                AsyncNodeAction.node_async(new CollectSaleRecordNode(saleRecordService, bbInventoryService)));
        stateGraph.addNode(INVENTORY_ORDER_DATA_NODE,
                AsyncNodeAction.node_async(new CollectInventoryOrderNode(inventoryOrderService)));
        // 往图中加边
        stateGraph.addEdge(StateGraph.START, SALE_RECORD_DATA_NODE);
        // 开始节点之后可以并行的查询销售数据和查询历史库存调拨数据
        stateGraph.addEdge(StateGraph.START, INVENTORY_ORDER_DATA_NODE);
        stateGraph.addEdge(SALE_RECORD_DATA_NODE, StateGraph.END);
        stateGraph.addEdge(INVENTORY_ORDER_DATA_NODE, StateGraph.END);

        return stateGraph.compile();
    }
}
