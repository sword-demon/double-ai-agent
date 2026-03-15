package top.wjstar.transfer.service.base;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.wjstar.transfer.mapper.BbTransferOrderItemMapper;
import top.wjstar.transfer.model.BbTransferOrderItem;
import top.wjstar.transfer.service.base.impl.BbTransferOrderItemService;

@Service
public class BbTransferOrderItemServiceImpl extends ServiceImpl<BbTransferOrderItemMapper, BbTransferOrderItem> implements BbTransferOrderItemService {

}
