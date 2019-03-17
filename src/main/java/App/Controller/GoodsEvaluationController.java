package App.Controller;

import App.Domain.GoodsEvaluation;
import App.Service.GoodsEvaluationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@Slf4j
public class GoodsEvaluationController {
    @Autowired
    GoodsEvaluationService goodsEvaluationService;
    //评论查询
    @GetMapping("api/goodsevaluation/{GoodsID}/goodsid")
    public List<GoodsEvaluation> queryGoodsEvaluationByGoodsId(@PathVariable("GoodsID") Integer goodsId){
        List<GoodsEvaluation> result =goodsEvaluationService.queryGoodsEvaluationByGoodsId(goodsId);
        return result;
    }
    //评论添加
    @PostMapping(value = "api/goodsevaluation")
    public Integer goodsEvaluationInsert(Integer goodsId,String evaluationType, String evaluationContent,String evaluationImg){
        Date evaluationTime=new Date();
        Integer result =goodsEvaluationService.goodsEvaluationInsert(goodsId, evaluationTime, evaluationType, evaluationContent, evaluationImg);
        return  result;
}
    //删除评论
    @DeleteMapping("api/goodsevaluation/{GoodsEvaluationId}/goodsEvaluationId")
    public Integer goodsEvaluationDeleteByGoodsEvalutionId( @PathVariable("GoodsEvaluationId") Integer goodsEvaluationId)throws Exception{
        Integer result =goodsEvaluationService.goodsEvaluationDeleteByGoodsEvalutionId(goodsEvaluationId);
        return result;
    }

}
