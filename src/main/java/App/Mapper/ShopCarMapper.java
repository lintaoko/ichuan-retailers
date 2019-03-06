package App.Mapper;

import App.Domain.ShopCar;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ShopCarMapper {
    //购物车查询
    @Select("select * form shopcar where UserId=#{UserId}")
    ShopCar queryShopCarByUserId(@Param("UserId")Integer userId);
    //购物车添加
    @Insert("insert into shopcar(UserId,GoodsName,GoodsImg,GoodsPrice,PurchaseQuantity) VALUES(#{UserId},#{GoodsName},#{GoodsImg},#{GoodsPrice},#{PurchaseQuantity})")
    Integer shopCarInsert (@Param("UserId") Integer userId,@Param("GoodsName")String goodsName,@Param("GoodsImg")String goodsImg,@Param("GoodsPrice")Double goodsPrice,@Param("PurchaseQuantity") Integer purchaseQuantity);
    //购物车单项删除
    @Delete("delete shopcar where ShopCarId=#{ShopCarId}")
    Integer shopCarDeleteByShopCarId(@Param("ShopCarId") Integer shopCarId);
    //购物车清空
    @Delete("delete shopcar where UserId=#{UserId}")
    Integer shopCarDeleteByUserId(@Param("UserId")Integer userId);
}
