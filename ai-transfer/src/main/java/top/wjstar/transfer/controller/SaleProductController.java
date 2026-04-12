package top.wjstar.transfer.controller;

import com.alibaba.cloud.ai.graph.CompiledGraph;
import com.alibaba.cloud.ai.graph.OverAllState;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author wxvirus
 */
@RestController
@RequestMapping("/saleProduct")
public class SaleProductController {

    @Resource
    private CompiledGraph graph;

    @GetMapping("/sale")
    public Map<String, Object> sale(@RequestParam String productId) {
        OverAllState overAllState = graph.call(Map.of("productId", productId)).get();
        return overAllState.data();
    }
}
