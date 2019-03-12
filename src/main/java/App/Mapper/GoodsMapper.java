package App.Mapper;

import App.Domain.Goods;
import com.google.gson.JsonObject;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

public interface GoodsMapper {
    //查询单件货物包括样式名
    @Select("select * from  goods,goods_type where GoodsId=#{GoodsId} and goods.GoodsType=goods_type.TypeId ")
    Goods queryGoodsAllInfByGoodsId (@Param("GoodsId") Integer goodsId);
    //查询单件货物不包括样式名
    @Select("select * from goods where GoodsId=#{GoodsId} ")
    Goods queryGoodsInfByGoodsId (@Param("GoodsId") Integer goodsId);
    //查询货物从样式
    @Select("select * from goods where GoodsType=#{GoodsType} ")
    ArrayList<Goods> queryGoodsInfByGoodsTyp(@Param("GoodsType") Integer goodsType);
    //添加货物
    @Insert("insert into goods(GoodsName,GoodsImg,GoodsQuantity,GoodsInf,GoodsType) values(#{GoodsName},#{GoodsImg},#{GoodsQuantity},#{GoodsInf},#{GoodsType})")
    Integer goodsInsert(@Param("GoodsName")String goodsName , @Param("GoodsImg")String goodsImg , @Param("GoodsQuantity") Integer goodsQuantity, @Param("GoodsInf")JsonObject goodsInf,@Param("GoodsType")Integer goodsType);
    //删除货物
    @Delete("delete goods where GoodsId=#{GoodsId}")
    Integer goodsDeleteByGoodsId (@Param("GoodsId") Integer goodsId);
    //货物数量变更
    @Update("update goods set GoodsQuantity=#{GoodsQuantity}")
    Integer goodsUpdateGoodsQuantity (@Param("GoodsQuantity") Integer goodsQuantity);
}
