import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

import java.math.BigDecimal;

/**
 * Created by wangnan01 on 2017/8/28.
 *
 */
@DataObject
public class SkuDeductAutumn {
    public String skuId;
    private int ruleId;
    private BigDecimal b1;
    private BigDecimal b2;
    private BigDecimal b3;

    public SkuDeductAutumn(){

    }

    public SkuDeductAutumn(String skuId, int ruleId){
        this.skuId = skuId;
        this.ruleId = ruleId;
    }

    public SkuDeductAutumn(JsonObject jsonObject){
        if(jsonObject.getValue("skuId") instanceof String){
            this.skuId = jsonObject.getString("skuId");
        }
        if(jsonObject.getValue("ruleId") instanceof Number){
            this.ruleId = jsonObject.getInteger("ruleId");
        }
    }

    public JsonObject toJson(){
        return new JsonObject().put("skuId",skuId).put("ruleId",ruleId);
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public int getRuleId() {
        return ruleId;
    }

    public void setRuleId(int ruleId) {
        this.ruleId = ruleId;
    }

    public BigDecimal getB1() {
        return b1;
    }

    public void setB1(BigDecimal b1) {
        this.b1 = b1;
    }

    public BigDecimal getB2() {
        return b2;
    }

    public void setB2(BigDecimal b2) {
        this.b2 = b2;
    }

    public BigDecimal getB3() {
        return this.b2.add(this.b1);
    }

    public void setB3(BigDecimal b3) {
        this.b3 = b3;
    }

    public String toString(){
        return this.toJson().toString();
    }
}
