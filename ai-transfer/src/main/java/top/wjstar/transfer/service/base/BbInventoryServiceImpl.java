package top.wjstar.transfer.service.base;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.wjstar.transfer.mapper.BbInventoryMapper;
import top.wjstar.transfer.model.BbInventory;
import top.wjstar.transfer.service.base.impl.BbInventoryService;

@Service
public class BbInventoryServiceImpl extends ServiceImpl<BbInventoryMapper, BbInventory> implements BbInventoryService {

}
