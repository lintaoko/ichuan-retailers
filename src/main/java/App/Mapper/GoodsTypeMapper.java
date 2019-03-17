package App.Mapper;

import App.Domain.GoodsType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface GoodsTypeMapper {

    //查询类别
    @Select("select * from goods_type where TypeId=#{TypeId}")
    GoodsType queryGoodsTypeByTypeId(@Param("TypeId") Integer typeid);
    //增加类别
    @Insert("insert into goods_type(TypeName) values(#{TypeName}")
    Integer goodsTypeInsert (@Param("TypeName") String typeName);
    //删除类别
    @Delete("delete from goods_type where TypeId=#{TypeId}")
    Integer goodsTypeDeleteByTypeId(@Param("TypeId") Integer typeId);
}
