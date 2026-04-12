package top.wjstar.transfer.config;

import com.alibaba.cloud.ai.graph.CompiledGraph;
import com.alibaba.cloud.ai.graph.KeyStrategy;
import com.alibaba.cloud.ai.graph.KeyStrategyFactory;
import com.alibaba.cloud.ai.graph.StateGraph;
import com.alibaba.cloud.ai.graph.action.AsyncNodeAction;
import com.alibaba.cloud.ai.graph.exception.GraphStateException;
import com.alibaba.cloud.ai.graph.state.strategy.ReplaceStrategy;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.wjstar.transfer.nodes.CollectSaleRecordNode;
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

    @Bean
    public CompiledGraph graph() throws GraphStateException {
        KeyStrategyFactory keyStrategyFactory = new KeyStrategyFactory() {
            @Override
            public Map<String, KeyStrategy> apply() {
                return Map.of("productId", new ReplaceStrategy(),
                        "saleRecordData", new ReplaceStrategy(),
                        "nowProductInventoryData", new ReplaceStrategy());
            }
        };

        StateGraph stateGraph = new StateGraph("inventoryTransferGraph", keyStrategyFactory);

        // 往图中定义节点
        stateGraph.addNode("saleRecordDataNode",
                AsyncNodeAction.node_async(new CollectSaleRecordNode(saleRecordService, bbInventoryService)));
        // 往图中加边
        stateGraph.addEdge(StateGraph.START, "saleRecordDataNode");
        stateGraph.addEdge("saleRecordDataNode", StateGraph.END);

        return stateGraph.compile();
    }
}
