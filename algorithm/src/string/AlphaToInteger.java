package string;

public class AlphaToInteger {
    // 숫자로만 이루어진 value 문자열에 대해서
    // 각 글자를 숫자 데이터로 해석한 뒤
    // - 48 하면 숫자가 됨
    public int atoi(String value) {
        int result = 0;
        // TODO 첫번째 문자를 사전에 확인 (마이너스 구분)
        boolean negative = false;
        int i = 0;
        if (value.charAt(i) == '-') {
            // 맞다면 미리 기록
            negative = true;
            // 두번째 글자부터 확인
            i++;
        }
//        negative = value.charAt(i) == '-';
        // TODO 문자열을 한글자(한 자리)씩 확인
        for (; i < value.length(); i++) {
            // TODO 자릿수 변환
            result *= 10;
            // TODO 글자를 숫자로 변환
            result += value.charAt(i) - 48;
        }
        if (negative) result *= -1;
        return result;
    }

    public static void main(String[] args) {
        AlphaToInteger atoi = new AlphaToInteger();
        System.out.println(atoi.atoi("12345") + atoi.atoi("-4291"));
        System.out.println(atoi.atoi("-4291"));
        
    }
}
