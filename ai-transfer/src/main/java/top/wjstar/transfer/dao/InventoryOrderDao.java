package top.wjstar.transfer.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import top.wjstar.transfer.domain.vo.InventoryOrderVO;

import java.util.List;

/**
 * @author wxvirus
 */
@Mapper
public interface InventoryOrderDao {

    @Select("""
            select 
            p.id as productId,
            p.product_code,
            p.product_name,
            YEAR(o.transfer_date) as year,
            QUARTER(o.transfer_date) as quarter,
            SUM(i.transfer_quantity) as totalTransferQty,
            o.source_warehouse_id,
            w.warehouse_code as sourceWarehouseCode,
            w.warehouse_name as sourceWarehouseName,
            o.target_warehouse_id,
            ww.warehouse_code as targetWarehouseCode,
            ww.warehouse_name as targetWarehouseName
                from bb_transfer_order o 
            join bb_transfer_order_item i on o.id = i.transfer_order_id
            join bb_product p on i.product_id = p.id 
            join bb_warehouse w on o.source_warehouse_id = w.id
            join bb_warehouse ww on o.target_warehouse_id = ww.id
            where p.id = #{productId} 
            and o.status = 3 
            group by p.id, YEAR(o.transfer_date), QUARTER(o.transfer_date), w.id, ww.id
            """)
    List<InventoryOrderVO> collectInventoryOrderDataByProductId(@Param("productId") Integer productId);
}
