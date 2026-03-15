package top.wjstar.transfer.service.base;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.wjstar.transfer.mapper.BbWarehouseMapper;
import top.wjstar.transfer.model.BbWarehouse;
import top.wjstar.transfer.service.base.impl.BbWarehouseService;

@Service
public class BbWarehouseServiceImpl extends ServiceImpl<BbWarehouseMapper, BbWarehouse> implements BbWarehouseService {

}
