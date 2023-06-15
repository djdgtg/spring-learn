import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Description
 *
 * @author djdgt
 * @since 2023/4/6 16:25
 */
@Slf4j
public class SimpleTest {

    public static void main(String[] args) {
        log.info(getNextCmdNumber("R20230515N0001", 1));
    }

    private static String getNextCmdNumber(String cmdNumber, Integer approvalType) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
        String format = LocalDate.now().format(dtf);
        if (StringUtils.hasLength(cmdNumber)) {
            // 先判断时间是否是今天（格式如R20230215N0001）
            String date = cmdNumber.substring(1, 9);
            if (format.equals(date)) {
                int number = Integer.parseInt(cmdNumber.substring(10));
                DecimalFormat df = new DecimalFormat("0000");
                return cmdNumber.substring(0, 10) + df.format(number + 1);
            } else {
                return cmdNumber.charAt(0) + format + "N0001";
            }
        } else {
            if (1 == approvalType) {
                return "R" + format + "N0001";
            } else if (2 == approvalType) {
                return "C" + format + "N0001";
            } else {
                throw new IllegalArgumentException("非法审批类型：" + approvalType);
            }
        }
    }

}
