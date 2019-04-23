package App.Service;

import App.Domain.GoodsEvaluation;
import App.Mapper.GoodsEvaluationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class GoodsEvaluationService {
    @Autowired
    GoodsEvaluationMapper goodsEvaluationMapper;

    //评论查询
    public List<GoodsEvaluation> queryGoodsEvaluationByGoodsId(Integer goodsId){
        return goodsEvaluationMapper.queryGoodsEvaluationByGoodsId(goodsId);
    }
    //评论添加
    public Integer goodsEvaluationInsert(Integer goodsId,  Date evaluationTime, String evaluationType, String evaluationContent,String evaluationImg){
        return goodsEvaluationMapper.goodsEvaluationInsert(goodsId, evaluationTime, evaluationType, evaluationContent, evaluationImg);
    }
    //删除评论
    public Integer goodsEvaluationDeleteByGoodsEvalutionId( Integer goodsEvaluationId)throws Exception {
        return goodsEvaluationMapper.goodsEvaluationDeleteByGoodsEvalutionId(goodsEvaluationId);
    }
}
