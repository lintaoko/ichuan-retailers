package App.Service;

import App.Domain.ShopCar;
import App.Mapper.ShopCarMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ShopCarService {

    @Autowired
    ShopCarMapper shopCarMapper;

    //购物车查询
    public List<ShopCar> queryShopCarByUserId(Integer userId){
        return shopCarMapper.queryShopCarByUserId(userId);
    }
    //购物车添加
    public Integer shopCarInsert (Integer userId,String goodsName,String goodsImg,Double goodsPrice, Integer purchaseQuantity){
        return shopCarMapper.shopCarInsert(userId, goodsName, goodsImg, goodsPrice, purchaseQuantity);
    }
    //购物车单项删除
    public Integer shopCarDeleteByShopCarId(Integer shopCarId){
        return shopCarMapper.shopCarDeleteByShopCarId(shopCarId);
    }
    //购物车清空
    public Integer shopCarDeleteByUserId(Integer userId){
        return shopCarMapper.shopCarDeleteByUserId(userId);
    }
}
