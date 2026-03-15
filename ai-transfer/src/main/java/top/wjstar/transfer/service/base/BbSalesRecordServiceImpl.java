package top.wjstar.transfer.service.base;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.wjstar.transfer.mapper.BbSalesRecordMapper;
import top.wjstar.transfer.model.BbSalesRecord;
import top.wjstar.transfer.service.base.impl.BbSalesRecordService;

@Service
public class BbSalesRecordServiceImpl extends ServiceImpl<BbSalesRecordMapper, BbSalesRecord> implements BbSalesRecordService {

}
