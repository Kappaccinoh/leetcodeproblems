#include<stdlib.h>
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
struct ListNode {
    int val;
    struct ListNode *next;
};

int main(int argc, char const *argv[])
{
    nodesBetweenCriticalPoints()
}


int* nodesBetweenCriticalPoints(struct ListNode* head, int* returnSize){
    long length = 0;
    struct ListNode *ptr = head;
    while (ptr != NULL) {
        ptr = ptr->next;
        length++;
    }
    if (length < 3) {
        int wer[2] = {-1,-1};
        int *ans = wer;
        return ans;
    }
    ptr = head;
    int listToArr[length];
    int critical[length];

    for (int i = 0; i < length; i++) {
        listToArr[i] = ptr->val;
        ptr = ptr->next;
        critical[i] = 0;
    }
    
    for (int i = 1; i < length - 1; i++) {
        if (listToArr[i - 1] > listToArr[i] && listToArr[i] < listToArr[i + 1]) {
            critical[i] = 1;
        }

        if (listToArr[i - 1] < listToArr[i] && listToArr[i] > listToArr[i + 1]) {
            critical[i] = 1;
        }
    }

    int maxDist0;
    int maxDist1;
    int minDist = 0;

    for (int i = 0; i < length; i++) {
        if (listToArr[i] == 1) {
            maxDist0 = i;
            break;
        }
    }

    for (int i = length; i >= 0; i--) {
        if (listToArr[i] == 1) {
            maxDist1 = i;
            break;
        }
    }

    int curr;

    for (int i = 0; i < length; i++) {
        if (listToArr[i] == 1){
            for (int j = i; j < length; j++) {
                if (listToArr[j] == 1) {
                    curr = i - j;
                    if (curr < minDist) {
                        minDist = curr;
                    }
                }
            }
        }
    }

    int arr[2];
    arr[0] = minDist;
    arr[1] = maxDist1 - maxDist0;
    int *ans = arr;
    return ans;
}