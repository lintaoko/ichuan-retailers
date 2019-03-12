package App.Service;

import App.Domain.GoodsType;
import App.Mapper.GoodsTypeMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsTypeService {
    @Autowired
    GoodsTypeMapper goodsTypeMapper;


    //查询类别
    public GoodsType queryGoodsTypeByTypeId( Integer typeid){
        GoodsType selectResult=goodsTypeMapper.queryGoodsTypeByTypeId(typeid);
        return selectResult;
    }
    //增加类别
    public Integer goodsTypeInsert ( String typeName){
        Integer insertResult =goodsTypeMapper.goodsTypeInsert(typeName);
        return insertResult;
    }
    //删除类别
    public Integer goodsTypeDeleteByTypeId(Integer typeId){
        Integer deleteResult =goodsTypeMapper.goodsTypeDeleteByTypeId(typeId);
        return deleteResult;
    }
}
