package top.wjstar.transfer.domain.vo;

import lombok.Data;

/**
 * @author wxvirus
 */
@Data
public class InventoryOrderVO {
    private Integer productId;
    private String productCode;
    private String productName;

    private String year;
    /**
     * 季度
     */
    private String quarter;

    /**
     * 总的调拨的数量
     */
    private Long totalTransferQty;

    /**
     * 从哪个仓库调出
     */
    private Integer sourceWarehouseId;
    private String sourceWarehouseCode;

    private String sourceWarehouseName;

    private Integer targetWarehouseId;
    private String targetWarehouseCode;
    private String targetWarehouseName;
}
