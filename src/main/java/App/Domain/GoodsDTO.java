package App.Domain;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class GoodsDTO extends Goods {
    private JSONObject goodsInfJson;
}
