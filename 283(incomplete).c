#include <stdio.h>

int hasNonZeroes(int *nums, int start, int end);
void moveZeroes(int *nums, int size);

void moveZeroes(int *nums, int numsSize){
    int m = 0;
    while (m < numsSize) {
        if (nums[m] == 0 && hasNonZeroes(nums, m + 1, numsSize) == 1) {
            for (int j = m; j < numsSize - 1; j++) {
                printf("curr: %d\n", nums[j]);

                nums[j] = nums[j + 1];
                nums[numsSize - 1] = 0;
            }
        } else {
            m++;
        }
    }
}

int hasNonZeroes(int *nums, int start, int end) {
    if (start == end) {
        return 0;
    }
    for (int i = start; i < end; i++) {
        if (nums[i] != 0) {
            return 1;
        }
    }
    return 0;
}

int main(void) {
    int original[5] = {0,1,0,3,12};
    moveZeroes(&original[0], 5);
    printf("Array: \n");
    for (int i = 0; i < 5; i++) {     
        printf("%d ", original[i]);     
    }      
    printf("end \n"); 

    

}

