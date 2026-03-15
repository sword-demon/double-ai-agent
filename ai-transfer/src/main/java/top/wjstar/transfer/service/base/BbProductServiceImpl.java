package top.wjstar.transfer.service.base;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.wjstar.transfer.mapper.BbProductMapper;
import top.wjstar.transfer.model.BbProduct;
import top.wjstar.transfer.service.base.impl.BbProductService;

@Service
public class BbProductServiceImpl extends ServiceImpl<BbProductMapper, BbProduct> implements BbProductService {

}
