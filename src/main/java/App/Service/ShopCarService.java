package App.Service;

import App.Domain.ShopCar;
import App.Mapper.ShopCarMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ShopCarService {

    @Autowired
    ShopCarMapper shopCarMapper;

    //购物车查询
    public List<ShopCar> queryShopCarByUserId(Integer userId){
       List<ShopCar> selectResult=shopCarMapper.queryShopCarByUserId(userId);
       return  selectResult;
    }
    //购物车添加
    public Integer shopCarInsert (Integer userId,String goodsName,String goodsImg,Double goodsPrice, Integer purchaseQuantity){
        Integer insertResult=shopCarMapper.shopCarInsert(userId, goodsName, goodsImg, goodsPrice, purchaseQuantity);
        return insertResult;
    }
    //购物车单项删除
    public Integer shopCarDeleteByShopCarId(Integer shopCarId){
        Integer deleteResult=shopCarMapper.shopCarDeleteByShopCarId(shopCarId);
        return deleteResult;
    }
    //购物车清空
    public Integer shopCarDeleteByUserId(Integer userId){
        Integer deleteResult=shopCarMapper.shopCarDeleteByUserId(userId);
        return deleteResult;
    }
}
