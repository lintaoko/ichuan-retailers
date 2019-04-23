package App.Service;

import App.Domain.GoodsType;
import App.Mapper.GoodsTypeMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GoodsTypeService {
    @Autowired
    GoodsTypeMapper goodsTypeMapper;


    //查询类别
    public GoodsType queryGoodsTypeByTypeId( Integer typeid){
        return goodsTypeMapper.queryGoodsTypeByTypeId(typeid);
    }
    //增加类别
    public Integer goodsTypeInsert ( String typeName){
        return goodsTypeMapper.goodsTypeInsert(typeName);
    }
    //删除类别
    public Integer goodsTypeDeleteByTypeId(Integer typeId){
        return goodsTypeMapper.goodsTypeDeleteByTypeId(typeId);
    }
}
