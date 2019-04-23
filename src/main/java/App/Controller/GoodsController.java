package App.Controller;

import App.Domain.Goods;
import App.Domain.GoodsDTO;
import App.Service.GoodsService;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    //查询单件货物包括样式名
    @GetMapping("api/goods/{GoodsId}/goodsid/all/")
    public Goods queryGoodsAllInfByGoodsId (@PathVariable("GoodsId") Integer goodsId){
        return goodsService.queryGoodsAllInfByGoodsId(goodsId);
    }
    //查询单件货物不包括样式名
    @GetMapping("api/goods/{GoodsId}/goodsid")
    public Goods queryGoodsInfByGoodsId (@PathVariable("GoodsId") Integer goodsId){
        return goodsService.queryGoodsInfByGoodsId(goodsId);
    }
    //查询货物从样式
    @GetMapping("api/goods/{GoodsType}/goodstype/{pageNum}/{pageSize}")
    public Map queryGoodsInfByGoodsType(@PathVariable("GoodsType")Integer goodsType, @PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize) {
        PageInfo<GoodsDTO> goodsDto=goodsService.queryGoodsInfByGoodsType(goodsType,pageNum,pageSize);
        for (GoodsDTO g :goodsDto.getList()) {
            g.setGoodsInfJson(JSONObject.parseObject(g.getGoodsInf()));
        }
        Map<String,Object> map=new HashMap<>();
        map.put("list",goodsDto.getList());
        map.put("size",goodsDto.getTotal());
        return map;
    }
    //添加货物
    @PostMapping("api/goods")
    public Integer goodsInsert(String goodsName , String goodsImg , Integer goodsQuantity, String goodsInf, Integer goodsType){
        return goodsService.goodsInsert(goodsName, goodsImg, goodsQuantity, goodsInf, goodsType);
    }
    //删除货物
    @DeleteMapping("api/goods/{GoodsId}/goodsid")
    public Integer goodsDeleteByGoodsId (@PathVariable("GoodsId")Integer goodsId){
        return goodsService.goodsDeleteByGoodsId(goodsId);
    }
    //货物数量变更
    @PutMapping("api/goods/{GoodsQuantity}/goodsquantity")
    public Integer goodsUpdateGoodsQuantity (@PathVariable("GoodsQuantity")Integer goodsQuantity){
        return goodsService.goodsUpdateGoodsQuantity(goodsQuantity);
    }
}
