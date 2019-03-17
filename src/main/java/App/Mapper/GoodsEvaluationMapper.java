package App.Mapper;

import App.Domain.GoodsEvaluation;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

public interface GoodsEvaluationMapper {
    //评论查询
    @Select("select * from goods_evaluation where GoodsId=#{GoodsId}")
    List<GoodsEvaluation> queryGoodsEvaluationByGoodsId(@Param("GoodsId")Integer goodsId);
    //评论添加
    @Insert("insert into goods_evaluation(GoodsId,EvaluationTime,EvaluationType,EvaluationContent,EvaluationImg) VALUES(#{GoodsId},#{EvaluationTime},#{EvaluationType},#{EvaluationContent},#{EvaluationImg})")
    Integer goodsEvaluationInsert(@Param("GoodsId")Integer goodsId, @Param("EvaluationTime")Date evaluationTime,@Param("EvaluationType") String evaluationType,@Param("EvaluationContent")String evaluationContent,@Param("EvaluationImg")String evaluationImg);
    //删除评论
    @Delete("delete from goods_evaluation where GoodsEvaluationId=#{GoodsEvaluationId}")
    Integer goodsEvaluationDeleteByGoodsEvalutionId(@Param("GoodsEvaluationId") Integer goodsEvaluationId);
}
