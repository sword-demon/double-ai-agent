package top.wjstar.transfer.service.base;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.wjstar.transfer.mapper.BbTransferOrderMapper;
import top.wjstar.transfer.model.BbTransferOrder;
import top.wjstar.transfer.service.base.impl.BbTransferOrderService;

@Service
public class BbTransferOrderServiceImpl extends ServiceImpl<BbTransferOrderMapper, BbTransferOrder> implements BbTransferOrderService {

}
