package App.Service;

import App.Domain.GoodsEvaluation;
import App.Mapper.GoodsEvaluationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GoodsEvaluationService {
    @Autowired
    GoodsEvaluationMapper goodsEvaluationMapper;

    //评论查询
    public List<GoodsEvaluation> queryGoodsEvaluationByGoodsId(Integer goodsId){
        List<GoodsEvaluation> selectResult =goodsEvaluationMapper.queryGoodsEvaluationByGoodsId(goodsId);
        return selectResult;
    }
    //评论添加
    public Integer goodsEvaluationInsert(Integer goodsId,  Date evaluationTime, String evaluationType, String evaluationContent,String evaluationImg){
        Integer insertResult =goodsEvaluationMapper.goodsEvaluationInsert(goodsId, evaluationTime, evaluationType, evaluationContent, evaluationImg);
        return  insertResult;
    }
    //删除评论
    public Integer goodsEvaluationDeleteByGoodsEvalutionId( Integer goodsEvaluationId)throws Exception {
        Integer deleteResult = goodsEvaluationMapper.goodsEvaluationDeleteByGoodsEvalutionId(goodsEvaluationId);
        return deleteResult;
    }
}
