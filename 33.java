class Solution {
    public int search(int[] nums, int target) {
        int pivot = findPivotBinarySearch(nums);
        System.out.println("pivot: " + pivot);
        return findItemGivenPivot(nums, target, pivot);
    }

    public int findPivotBinarySearch(int[] array) {
 
        if (array == null || array.length == 0) {
            return -1;
        }
 
        if (array.length == 1 || array[0] < array[array.length - 1]) {
            return 0;
        }
 
        int start = 0, end = array.length - 1;
 
        while (start <= end) {
 
            int mid = (start + end) / 2;
            if (mid < array.length-1 && array[mid] > array[mid+1]) {
                return (mid + 1);
            } else if (array[start] <= array[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
 
        return 0;
    }

    public int findItemGivenPivot(int[] nums, int x, int pivot) {
        int arr1 = binarySearch(nums, x, 0, pivot - 1);
        int arr2 = binarySearch(nums, x, pivot, nums.length - 1);

        if (arr1 == -1 && arr2 == -1) {
            return -1;
        } else if (arr1 != -1) {
            return arr1;
        } else {
            return arr2;
        }
    }

    public int binarySearch(int[] arr, int x, int l, int r) {
        while (l <= r) {
            int m = l + (r - l) / 2;
 
            if (arr[m] == x)
                return m;
 
            if (arr[m] < x)
                l = m + 1;
 
            else
                r = m - 1;
        }
 
        return -1;
    }
}