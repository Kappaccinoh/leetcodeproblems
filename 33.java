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
 
        // Case when array is not rotated. Then first index is the pivot
        if (array.length == 1 || array[0] < array[array.length - 1]) {
            return 0;
        }
 
        int start = 0, end = array.length - 1;
 
        while (start <= end) {
 
            int mid = (start + end) / 2;
            // check if mid+1 is pivot
            if (mid < array.length-1 && array[mid] > array[mid+1]) {
                return (mid + 1);
            } else if (array[start] <= array[mid]) {
                // If array[start] <= array[mid],
                // it means from start to mid, all elements are in sorted order,
                // so pivot will be in second half
                start = mid + 1;
            } else {
                // else pivot lies in first half, so we find the pivot in first half
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
 
            // Check if x is present at mid
            if (arr[m] == x)
                return m;
 
            // If x greater, ignore left half
            if (arr[m] < x)
                l = m + 1;
 
            // If x is smaller, ignore right half
            else
                r = m - 1;
        }
 
        // if we reach here, then element was
        // not present
        return -1;
    }
}