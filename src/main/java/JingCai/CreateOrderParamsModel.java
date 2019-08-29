package JingCai;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangnan01 on 2017/9/7.
 * 生成订单参数实体类（用于测试）
 */
public class CreateOrderParamsModel {
    private int oType;
    private String single;
    private int period;
    private int multiple;
    private int gold;
    private String useObject;
    private int playType;
    private int continuousTimes;
    private List<List<String>> betPlayTypeIds;
    private int stopFollow;
    private int submitSource;
    private static Gson gson = new Gson();

    public CreateOrderParamsModel(int oType, String single,
                                  int period, int multiple,
                                  int gold, String useObject,
                                  int playType, int continuousTimes,
                                  List<List<String>> betPlayTypeIds,
                                  int stopFollow, int submitSource) {
        this.oType = oType;
        this.single = single;
        this.period = period;
        this.multiple = multiple;
        this.gold = gold;
        this.useObject = useObject;
        this.playType = playType;
        this.continuousTimes = continuousTimes;
        this.betPlayTypeIds = betPlayTypeIds;
        this.stopFollow = stopFollow;
        this.submitSource = submitSource;
    }

    public int getoType() {
        return oType;
    }

    public void setoType(int oType) {
        this.oType = oType;
    }

    public String getSingle() {
        return single;
    }

    public void setSingle(String single) {
        this.single = single;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public int getMultiple() {
        return multiple;
    }

    public void setMultiple(int multiple) {
        this.multiple = multiple;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public String getUseObject() {
        return useObject;
    }

    public void setUseObject(String useObject) {
        this.useObject = useObject;
    }

    public int getPlayType() {
        return playType;
    }

    public void setPlayType(int playType) {
        this.playType = playType;
    }

    public int getContinuousTimes() {
        return continuousTimes;
    }

    public void setContinuousTimes(int continuousTimes) {
        this.continuousTimes = continuousTimes;
    }

    public List<List<String>> getBetPlayTypeIds() {
        return betPlayTypeIds;
    }

    public void setBetPlayTypeIds(List<List<String>> betPlayTypeIds) {
        this.betPlayTypeIds = betPlayTypeIds;
    }

    public int getStopFollow() {
        return stopFollow;
    }

    public void setStopFollow(int stopFollow) {
        this.stopFollow = stopFollow;
    }

    public int getSubmitSource() {
        return submitSource;
    }

    public void setSubmitSource(int submitSource) {
        this.submitSource = submitSource;
    }

    public static void main(String[] args) {
        List<String> betId = Arrays.asList("0","1","3","5","7","8","9","10");
        List<List<String>> betIdList = new ArrayList<>();
        betIdList.add(betId);
        CreateOrderParamsModel createOrderParamsModel = new CreateOrderParamsModel(504, "1000",
                2017090751, 1,0, "889,5;",1,1,betIdList, 0, 0);

        System.out.println();
        String caipiaos = gson.toJson(createOrderParamsModel);

        CreateOrderSubmitParams params = new CreateOrderSubmitParams(caipiaos);
    }
}
