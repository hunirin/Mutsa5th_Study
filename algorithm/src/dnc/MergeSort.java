package dnc;

public class MergeSort {
    public void sort(int[] arr) {
        // 비었거나 길이가 1 이하라면 정렬할 필요가 없다
        if (arr == null || arr.length <= 1) {
            return;
        }
    }

    private void mergeSort(
            // arr는 실제로 정렬할 배열
            int[] arr,
            // left: 왼쪽배열의 시작 index
            int left,
            // right: 오른쪽 배열의 끝 index
            int right
    ) {
        // left == right 라면 더이상 나누고 병합할 필요 없다
        if (left < right) {
            // 가운데 인덱스를 찾는다
            int mid = left + (right - left) / 2;

            // mid를 기준으로 반 나눠서 재귀호출
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
        }
    }

    // 분해된 배열을 병합하는 메소드


    public static void main(String[] args) {

    }
}
