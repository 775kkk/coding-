package policy;
import interfaces.PolicyInterface;

public class DefoultPolicy<Integer,ReactionsEnum> implements PolicyInterface<Integer,ReactionsEnum>{
    @Override
    public ReactionsEnum chekRule(Integer integer){
        if ((int)integer==5) {
            return (ReactionsEnum) dto.ReactionsEnum.VERY_GOOD;
        }
        if ((int)integer==4) {
            return (ReactionsEnum) dto.ReactionsEnum.GOOD;
        }
        return (ReactionsEnum) dto.ReactionsEnum.BAD;
    }
}
