package App.Service;

import App.Domain.Goods;
import App.Mapper.GoodsMapper;
import com.google.gson.JsonObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

@Service
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
    public List<Goods> queryGoodsInfByGoodsType(Integer goodsType) {
        return goodsMapper.queryGoodsInfByGoodsTyp(goodsType);
    }

    //添加货物
    public Integer goodsInsert(String goodsName ,String goodsImg , Integer goodsQuantity, JsonObject goodsinf,Integer goodsType){
        return goodsMapper.goodsInsert(goodsName, goodsImg, goodsQuantity, goodsinf, goodsType);
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
