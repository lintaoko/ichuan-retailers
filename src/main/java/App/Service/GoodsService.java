package App.Service;

import App.Domain.Goods;
import App.Domain.GoodsDTO;
import App.Mapper.GoodsMapper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GoodsService {
    @Autowired
    GoodsMapper goodsMapper;

    //查询单件货物包括样式名
    public Goods queryGoodsAllInfByGoodsId(Integer goodsId) {
        return goodsMapper.queryGoodsAllInfByGoodsId(goodsId);
    }

    //查询单件货物不包括样式名
    public Goods queryGoodsInfByGoodsId(Integer goodsId) {
        return goodsMapper.queryGoodsInfByGoodsId(goodsId);
    }

    //查询货物从样式
    public PageInfo<GoodsDTO> queryGoodsInfByGoodsType(Integer goodsType, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<GoodsDTO> data =goodsMapper.queryGoodsInfByGoodsType(goodsType);
        return new PageInfo<>(data);
    }

    //添加货物
    public Integer goodsInsert(String goodsName , String goodsImg , Integer goodsQuantity, String goodsInf, Integer goodsType){
        return goodsMapper.goodsInsert(goodsName, goodsImg, goodsQuantity, goodsInf, goodsType);
    }
    //删除货物
    public Integer goodsDeleteByGoodsId (Integer goodsId){
        return goodsMapper.goodsDeleteByGoodsId(goodsId);
    }
    //货物数量变更
    public Integer goodsUpdateGoodsQuantity (Integer goodsQuantity){
        return goodsMapper.goodsUpdateGoodsQuantity(goodsQuantity);
    }


}
